package proyecto.ups.edu.ec.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Person;


@Stateless //ejb sin estado
public class PersonDAO {

	@Inject
	private EntityManager em;
	
	public void save(Person p) {
		Person a=leer(p.getPersonId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(Person p){
		em.persist(p);
	}
	
	public void update(Person p) {
		em.merge(p);
	}
	
	public void delete(int personId) {
		Person p=leer(personId);
		em.remove(p);
	}
	
	public Person leer(int personId) {
		Person p=em.find(Person.class, personId);
		return p;
	}
	
	
	public List<Person> listPerson(){
		Query query=em.createQuery("SELECT p from Person p ", Person.class);
		@SuppressWarnings("unchecked")
		List<Person> list=query.getResultList();
		return list;
	}
	
}
