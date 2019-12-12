package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.District;


@Stateless //ejb sin estado
public class DistrictDAO {

	@Inject
	private EntityManager em;
	
	public void save(District p) {
		District a=leer(p.getDistrictId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(District p){
		em.persist(p);
	}
	
	public void update(District p) {
		em.merge(p);
	}
	
	public void delete(int DistrictId) {
		District p=leer(DistrictId);
		em.remove(p);
	}
	
	public District leer(int DistrictId) {
		District p=em.find(District.class, DistrictId);
		return p;
	}
	
	
	public List<District> listDistrict(){
		Query query=em.createQuery("SELECT p from District p ", District.class);
		List<District> list=query.getResultList();
		return list;
	}
	
}
