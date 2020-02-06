package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.AccountInvoice;

@Stateless //ejb sin estado
public class AccountInvoiceDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(AccountInvoice p) {
		AccountInvoice a=leer(p.getAccountInvoiceId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(AccountInvoice p){
		em.persist(p);
	}
	
	public void update(AccountInvoice p) {
		em.merge(p);
	}
	
	public void delete(int AccountInvoiceId) {
		AccountInvoice p=leer(AccountInvoiceId);
		em.remove(p);
	}
	
	public AccountInvoice leer(int AccountInvoiceId) {
		AccountInvoice p=em.find(AccountInvoice.class, AccountInvoiceId);
		return p;
	}
	
	
	public List<AccountInvoice> listAccountInvoice(){
		Query query=em.createQuery("SELECT p from AccountInvoice p ", AccountInvoice.class);
		List<AccountInvoice> list=query.getResultList();
		return list;
	}

}
