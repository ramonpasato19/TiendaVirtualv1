package proyecto.ups.edu.ec.data;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Product;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear el producto del item
 */
@Stateless //ejb sin estado
public class ProductDAO {

	@Inject
	private EntityManager em;
	
	public void save(Product g) {
		Product a=leer(g.getProductId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(Product g){
		em.persist(g);
	}
	
	public void update(Product g) {
		em.merge(g);
	}
	
	public void delete(int ProductId) {
		//Product g=leer(ProductId);
		Product g=em.find(Product.class,ProductId);
		em.remove(g);
	}
	
	public Product leer(int ProductId) {
		Product g=em.find(Product.class, ProductId);
		return g;
	}
	
	
	public List<Product> listProduct(){
		Query query=em.createQuery("SELECT g from Product g ", Product.class);
		List<Product> list=query.getResultList();
		return list;
	}
	
}
