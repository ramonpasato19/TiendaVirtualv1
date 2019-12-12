package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.NaturalPerson;


@Stateless //ejb sin estado
public class NaturalPersonDAO {

	@Inject
	private EntityManager em;
	
	public void save(NaturalPerson p) {
		NaturalPerson a=leer(p.getNaturalPersonId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(NaturalPerson p){
		em.persist(p);
	}
	
	public void update(NaturalPerson p) {
		em.merge(p);
	}
	
	public void delete(int NaturalPersonId) {
		NaturalPerson p=leer(NaturalPersonId);
		em.remove(p);
	}
	
	public NaturalPerson leer(int NaturalPersonId) {
		NaturalPerson p=em.find(NaturalPerson.class, NaturalPersonId);
		return p;
	}
	
	
	public List<NaturalPerson> listNaturalPerson(){
		Query query=em.createQuery("SELECT p from NaturalPerson p ", NaturalPerson.class);
		List<NaturalPerson> list=query.getResultList();
		return list;
	}
	
}
