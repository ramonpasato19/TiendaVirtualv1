package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.City;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear la ciudad
 */
@Stateless //ejb sin estado
public class CityDAO {

	@Inject
	private EntityManager em;
	
	public void save(City g) {
		City a=leer(g.getCityId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(City g){
		em.persist(g);
	}
	
	public void update(City g) {
		em.merge(g);
	}
	
	public void delete(int CityId) {
		//City g=leer(CityId);
		City g=em.find(City.class,CityId);
		em.remove(g);
	}
	
	public City leer(int CityId) {
		City g=em.find(City.class, CityId);
		return g;
	}
	
	
	public List<City> listCity(){
		Query query=em.createQuery("SELECT g from City g ", City.class);
		List<City> list=query.getResultList();
		return list;
	}
	
}
