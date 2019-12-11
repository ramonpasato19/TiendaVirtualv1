package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.MaritalStatus;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear el dao del estado civil de la persona
 */
@Stateless //ejb sin estado
public class MaritalStatusDAO {

	@Inject
	private EntityManager em;
	
	public void save(MaritalStatus g) {
		MaritalStatus a=leer(g.getMaritalStatusId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(MaritalStatus g){
		em.persist(g);
	}
	
	public void update(MaritalStatus g) {
		em.merge(g);
	}
	
	public void delete(int MaritalStatusId) {
		//MaritalStatus g=leer(MaritalStatusId);
		MaritalStatus g=em.find(MaritalStatus.class,MaritalStatusId);
		em.remove(g);
	}
	
	public MaritalStatus leer(int MaritalStatusId) {
		MaritalStatus g=em.find(MaritalStatus.class, MaritalStatusId);
		return g;
	}
	
	
	public List<MaritalStatus> listMaritalStatus(){
		Query query=em.createQuery("SELECT g from MaritalStatus g ", MaritalStatus.class);
		List<MaritalStatus> list=query.getResultList();
		return list;
	}
	
}
