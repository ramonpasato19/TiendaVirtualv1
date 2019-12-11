package proyecto.ups.edu.ec.data;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.Category;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear la categoria del item
 */
@Stateless //ejb sin estado
public class CategoryDAO {

	@Inject
	private EntityManager em;
	
	public void save(Category g) {
		Category a=leer(g.getCategoryId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(Category g){
		em.persist(g);
	}
	
	public void update(Category g) {
		em.merge(g);
	}
	
	public void delete(int CategoryId) {
		//Category g=leer(CategoryId);
		Category g=em.find(Category.class,CategoryId);
		em.remove(g);
	}
	
	public Category leer(int CategoryId) {
		Category g=em.find(Category.class, CategoryId);
		return g;
	}
	
	
	public List<Category> listCategory(){
		Query query=em.createQuery("SELECT g from Category g ", Category.class);
		List<Category> list=query.getResultList();
		return list;
	}
	
}
