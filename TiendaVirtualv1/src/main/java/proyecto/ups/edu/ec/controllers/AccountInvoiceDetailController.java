package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.AccountInvoiceDetailDAO;
import proyecto.ups.edu.ec.model.AccountInvoiceDetail;

@ManagedBean
//@SessionScoped
@ViewScoped
public class AccountInvoiceDetailController {
	

	@Inject
	private AccountInvoiceDetailDAO accountinvoicedetaildao;
	private AccountInvoiceDetail accountinvoicedetail=null;
	private List<AccountInvoiceDetail> accountitemdetails;
	private int id;
	
	@PostConstruct
	public void init() {
		accountinvoicedetail=new AccountInvoiceDetail();
		loadaccountinvoicedetails();
		accountitemdetails=accountinvoicedetaildao.listAccountInvoiceDetail();
	}
	
	public void loadaccountinvoicedetails() {
		accountitemdetails=accountinvoicedetaildao.listAccountInvoiceDetail();
	}
	
	public String loadDataEdit(int accountitemdetailpojoId) {
		System.out.println("Cargando datos");
		accountinvoicedetail =accountinvoicedetaildao.leer(accountitemdetailpojoId);
		return "create-accountinvoicedetail";
	}
	public String save() {
		System.out.println(accountinvoicedetail);
		accountinvoicedetaildao.save(accountinvoicedetail);
		loadaccountinvoicedetails();
		return "list-accountinvoicedetails";
	}

	public void del(int id) throws Exception {
		AccountInvoiceDetail aux = accountinvoicedetaildao.leer(id);
	if(aux==null) 
		throw new Exception("accountinvoicedetail no existe");
		else
			accountinvoicedetaildao.delete(id);
	}
	
	
	public String borrar(int  codigo) {
		System.out.println("codigo borrar " + codigo);
		
		try {
			del(codigo);
			init();
		} catch (Exception e) {
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
		accountinvoicedetaildao.delete(id);
		loadaccountinvoicedetails();
		return "list-accountinvoicedetails";
	}

	public AccountInvoiceDetailDAO getAccountinvoicedetaildao() {
		return accountinvoicedetaildao;
	}

	public void setAccountinvoicedetaildao(AccountInvoiceDetailDAO accountinvoicedetaildao) {
		this.accountinvoicedetaildao = accountinvoicedetaildao;
	}

	public AccountInvoiceDetail getAccountinvoicedetail() {
		return accountinvoicedetail;
	}

	public void setAccountinvoicedetail(AccountInvoiceDetail accountinvoicedetail) {
		this.accountinvoicedetail = accountinvoicedetail;
	}

	public List<AccountInvoiceDetail> getAccountitemdetails() {
		return accountitemdetails;
	}

	public void setAccountitemdetails(List<AccountInvoiceDetail> accountitemdetails) {
		this.accountitemdetails = accountitemdetails;
	}
	
	
			
}
