package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.Account;

@Stateless //ejb sin estado
public class AccountDAO {
	@Inject
	private EntityManager em;
	
	public void save(Account p) {
		Account a=leer(p.getAccountId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(Account p){
		em.persist(p);
	}
	
	public void update(Account p) {
		em.merge(p);
	}
	
	public void delete(int AccountId) {
		Account p=leer(AccountId);
		em.remove(p);
	}
	
	public Account leer(int AccountId) {
		Account p=em.find(Account.class, AccountId);
		return p;
	}
	
	
	public List<Account> listAccount(){
		Query query=em.createQuery("SELECT p from Account p ", Account.class);
		List<Account> list=query.getResultList();
		return list;
	}

}
