package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Country;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear el pais
 */
@Stateless //ejb sin estado
public class CountryDAO {

	@Inject
	private EntityManager em;
	
	public void save(Country g) {
		Country a=leer(g.getCountryId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(Country g){
		em.persist(g);
	}
	
	public void update(Country g) {
		em.merge(g);
	}
	
	public void delete(int CountryId) {
		//Country g=leer(CountryId);
		Country g=em.find(Country.class,CountryId);
		em.remove(g);
	}
	
	public Country leer(int CountryId) {
		Country g=em.find(Country.class, CountryId);
		return g;
	}
	
	
	public List<Country> listCountry(){
		Query query=em.createQuery("SELECT g from Country g ", Country.class);
		List<Country> list=query.getResultList();
		return list;
	}
	
}
