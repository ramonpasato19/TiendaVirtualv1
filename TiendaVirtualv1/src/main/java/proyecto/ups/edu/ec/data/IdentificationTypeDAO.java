package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.IdentificationType;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una el dao de tipo de identificacion de persona
 */
@Stateless //ejb sin estado
public class IdentificationTypeDAO {

	@Inject
	private EntityManager em;
	
	public void save(IdentificationType g) {
		IdentificationType a=leer(g.getIdentificationTypeId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(IdentificationType g){
		em.persist(g);
	}
	
	public void update(IdentificationType g) {
		em.merge(g);
	}
	
	public void delete(int IdentificationTypeId) {
		//IdentificationType g=leer(IdentificationTypeId);
		IdentificationType g=em.find(IdentificationType.class,IdentificationTypeId);
		em.remove(g);
	}
	
	public IdentificationType leer(int IdentificationTypeId) {
		IdentificationType g=em.find(IdentificationType.class, IdentificationTypeId);
		return g;
	}
	
	
	public List<IdentificationType> listIdentificationType(){
		Query query=em.createQuery("SELECT g from IdentificationType g ", IdentificationType.class);
		List<IdentificationType> list=query.getResultList();
		return list;
	}
	
}
