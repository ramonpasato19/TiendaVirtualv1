package proyecto.ups.edu.ec.data;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Currency;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear el Currency del item
 */
@Stateless //ejb sin estado
public class CurrencyDAO {

	@Inject
	private EntityManager em;
	
	public void save(Currency g) {
		Currency a=leer(g.getCurrencyId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(Currency g){
		em.persist(g);
	}
	
	public void update(Currency g) {
		em.merge(g);
	}
	
	public void delete(int CurrencyId) {
		//Currency g=leer(CurrencyId);
		Currency g=em.find(Currency.class,CurrencyId);
		em.remove(g);
	}
	
	public Currency leer(int CurrencyId) {
		Currency g=em.find(Currency.class, CurrencyId);
		return g;
	}
	
	
	public List<Currency> listCurrency(){
		Query query=em.createQuery("SELECT g from Currency g ", Currency.class);
		List<Currency> list=query.getResultList();
		return list;
	}
	
}
