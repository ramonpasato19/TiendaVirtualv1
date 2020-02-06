package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.AccountInvoiceDAO;
import proyecto.ups.edu.ec.model.AccountInvoice;



@ManagedBean
//@SessionScoped
@ViewScoped
public class AccountInvoiceController {
	
	@Inject
	private AccountInvoiceDAO accountinvoicedao;
	private AccountInvoice accountinvoice=null;
	private List<AccountInvoice> accountinvoices;
	private int id;
	
	@PostConstruct
	public void init() {
		accountinvoice=new AccountInvoice();
		loadaccountinvoices();
	}
	
	public void loadaccountinvoices() {
		accountinvoices=accountinvoicedao.listAccountInvoice();
	}
	
	public String loadDataEdit(int accountinvoiceId) {
		System.out.println("Cargando datos");
		accountinvoice =accountinvoicedao.leer(accountinvoiceId);
		return "create-accountinvoice";
	}
	public String save() {
		System.out.println(accountinvoice);
		accountinvoicedao.save(accountinvoice);
		loadaccountinvoices();
		return "list-accountinvoices";
	}

	public void del(int id) throws Exception {
		AccountInvoice aux = accountinvoicedao.leer(id);
	if(aux==null) 
		throw new Exception("accountinvoice no existe");
		else
	accountinvoicedao.delete(id);
	}
	
	
	public String borrar(int  codigo) {
		System.out.println("codigo borrar " + codigo);
		
		try {
			del(codigo);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDataEdit(id);
	}
	
	public String delete(int id) {
		accountinvoicedao.delete(id);
		loadaccountinvoices();
		return "list-accountinvoices";
	}

	public AccountInvoiceDAO getAccountinvoicedao() {
		return accountinvoicedao;
	}

	public void setAccountinvoicedao(AccountInvoiceDAO accountinvoicedao) {
		this.accountinvoicedao = accountinvoicedao;
	}

	public AccountInvoice getAccountinvoice() {
		return accountinvoice;
	}

	public void setAccountinvoice(AccountInvoice accountinvoice) {
		this.accountinvoice = accountinvoice;
	}

	public List<AccountInvoice> getAccountinvoices() {
		return accountinvoices;
	}

	public void setAccountinvoices(List<AccountInvoice> accountinvoices) {
		this.accountinvoices = accountinvoices;
	}
	
	

}
