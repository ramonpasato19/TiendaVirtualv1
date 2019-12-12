package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.AccountItem;


@Stateless //ejb sin estado
public class AccountItemDAO {

	@Inject
	private EntityManager em;
	
	public void save(AccountItem p) {
		AccountItem a=leer(p.getAccountItemId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(AccountItem p){
		em.persist(p);
	}
	
	public void update(AccountItem p) {
		em.merge(p);
	}
	
	public void delete(int AccountItemId) {
		AccountItem p=leer(AccountItemId);
		em.remove(p);
	}
	
	public AccountItem leer(int AccountItemId) {
		AccountItem p=em.find(AccountItem.class, AccountItemId);
		return p;
	}
	
	
	public List<AccountItem> listAccountItem(){
		Query query=em.createQuery("SELECT p from AccountItem p ", AccountItem.class);
		List<AccountItem> list=query.getResultList();
		return list;
	}
	
}
