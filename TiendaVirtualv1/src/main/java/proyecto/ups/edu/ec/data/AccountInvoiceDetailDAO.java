package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.AccountInvoiceDetail;


@Stateless //ejb sin estado
public class AccountInvoiceDetailDAO {

	@Inject
	private EntityManager em;
	
	public void save(AccountInvoiceDetail p) {
		AccountInvoiceDetail a=leer(p.getAccountInvoiceDetailId());
		if(a!=null) {
			update(p);
		}else {
			insert(p);
		}
	}
	
	public void insert(AccountInvoiceDetail p){
		em.persist(p);
	}
	
	public void update(AccountInvoiceDetail p) {
		em.merge(p);
	}
	
	public void delete(int AccountInvoiceDetailId) {
		AccountInvoiceDetail p=leer(AccountInvoiceDetailId);
		em.remove(p);
	}
	
	public AccountInvoiceDetail leer(int AccountInvoiceDetailId) {
		AccountInvoiceDetail p=em.find(AccountInvoiceDetail.class, AccountInvoiceDetailId);
		return p;
	}
	
	
	public List<AccountInvoiceDetail> listAccountInvoiceDetail(){
		Query query=em.createQuery("SELECT p from AccountInvoiceDetail p ", AccountInvoiceDetail.class);
		List<AccountInvoiceDetail> list=query.getResultList();
		return list;
	}
	
}
