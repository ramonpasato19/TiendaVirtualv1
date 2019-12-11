package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Gender;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear el dao de genero
 */
@Stateless //ejb sin estado
public class GenderDAO {

	@Inject
	private EntityManager em;
	
	public void save(Gender g) {
		Gender a=leer(g.getGenderId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(Gender g){
		em.persist(g);
	}
	
	public void update(Gender g) {
		em.merge(g);
	}
	
	public void delete(int GenderId) {
		Gender g=leer(GenderId);
		em.remove(g);
	}
	
	public Gender leer(int GenderId) {
		Gender g=em.find(Gender.class, GenderId);
		return g;
	}
	
	
	public List<Gender> listGender(){
		Query query=em.createQuery("SELECT g from Gender g ", Gender.class);
		List<Gender> list=query.getResultList();
		return list;
	}
	
}
