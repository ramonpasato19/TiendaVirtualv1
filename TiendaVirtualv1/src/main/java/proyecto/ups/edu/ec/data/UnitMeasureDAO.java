package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.UnitMeasure;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear la unidad de medida del item
 */
@Stateless //ejb sin estado
public class UnitMeasureDAO {

	@Inject
	private EntityManager em;
	
	public void save(UnitMeasure g) {
		UnitMeasure a=leer(g.getUnitMeasure());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(UnitMeasure g){
		em.persist(g);
	}
	
	public void update(UnitMeasure g) {
		em.merge(g);
	}
	
	public void delete(int UnitMeasureId) {
		//UnitMeasure g=leer(UnitMeasureId);
		UnitMeasure g=em.find(UnitMeasure.class,UnitMeasureId);
		em.remove(g);
	}
	
	public UnitMeasure leer(int UnitMeasureId) {
		UnitMeasure g=em.find(UnitMeasure.class, UnitMeasureId);
		return g;
	}
	
	
	public List<UnitMeasure> listUnitMeasure(){
		Query query=em.createQuery("SELECT g from UnitMeasure g ", UnitMeasure.class);
		List<UnitMeasure> list=query.getResultList();
		return list;
	}
	
	
	
}
