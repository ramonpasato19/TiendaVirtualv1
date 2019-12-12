package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.Company;


@Stateless //ejb sin estado
public class CompanyDAO {

	@Inject
	private EntityManager em;
	
	public void save(Company p) {
		Company a=leer(p.getCompanyId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(Company p){
		em.persist(p);
	}
	
	public void update(Company p) {
		em.merge(p);
	}
	
	public void delete(int CompanyId) {
		Company p=leer(CompanyId);
		em.remove(p);
	}
	
	public Company leer(int CompanyId) {
		Company p=em.find(Company.class, CompanyId);
		return p;
	}
	
	
	public List<Company> listCompany(){
		Query query=em.createQuery("SELECT p from Company p ", Company.class);
		List<Company> list=query.getResultList();
		return list;
	}
	
}
