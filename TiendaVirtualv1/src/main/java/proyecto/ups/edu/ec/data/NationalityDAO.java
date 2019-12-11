package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Nationality;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una el dao de nacionalidad de persona
 */
@Stateless //ejb sin estado
public class NationalityDAO {

	@Inject
	private EntityManager em;
	
	public void save(Nationality g) {
		Nationality a=leer(g.getNationalityId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(Nationality g){
		em.persist(g);
	}
	
	public void update(Nationality g) {
		em.merge(g);
	}
	
	public void delete(int NationalityId) {
		//Nationality g=leer(NationalityId);
		Nationality g=em.find(Nationality.class,NationalityId);
		em.remove(g);
	}
	
	public Nationality leer(int NationalityId) {
		Nationality g=em.find(Nationality.class, NationalityId);
		return g;
	}
	
	
	public List<Nationality> listNationality(){
		Query query=em.createQuery("SELECT g from Nationality g ", Nationality.class);
		List<Nationality> list=query.getResultList();
		return list;
	}
	
}
