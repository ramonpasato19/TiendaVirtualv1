package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.Tax;


@Stateless //ejb sin estado
public class TaxDAO {

	@Inject
	private EntityManager em;
	
	public void save(Tax p) {
		Tax a=leer(p.getTaxId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(Tax p){
		em.persist(p);
	}
	
	public void update(Tax p) {
		em.merge(p);
	}
	
	public void delete(int TaxId) {
		Tax p=leer(TaxId);
		em.remove(p);
	}
	
	public Tax leer(int TaxId) {
		Tax p=em.find(Tax.class, TaxId);
		return p;
	}
	
	
	public List<Tax> listTax(){
		Query query=em.createQuery("SELECT p from Tax p ", Tax.class);
		List<Tax> list=query.getResultList();
		return list;
	}
	
}
