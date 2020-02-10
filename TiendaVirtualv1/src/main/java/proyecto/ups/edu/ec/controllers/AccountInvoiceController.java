package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import proyecto.ups.edu.ec.data.AccountInvoiceDAO;
import proyecto.ups.edu.ec.data.CategoryDAO;
import proyecto.ups.edu.ec.model.AccountInvoice;
import proyecto.ups.edu.ec.model.AccountInvoiceDetail;
import proyecto.ups.edu.ec.model.Category;



@ManagedBean
//@SessionScoped
@ViewScoped
public class AccountInvoiceController {
	
	@Inject
	private AccountInvoiceDAO accountinvoicedao;
	private AccountInvoice accountinvoice=null;
	private List<AccountInvoice> accountinvoices;
	private int id;
	
	@Inject
	private CategoryDAO categorydao;
	
	@PostConstruct
	public void init() {
		accountinvoice=new AccountInvoice();
		accountinvoice.getAccountinvoicedetails().add(new AccountInvoiceDetail());  //agregadno a una cabcera un nuevo detalle
		//accountinvoice.getAccountinvoicedetails().add(new AccountInvoiceDetail());
//		accountinvoices=accountinvoicedao
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
	
	public String addAccountInvoiceDetail() {
		System.out.println("add detalle de head");
		accountinvoice.addCategory(new AccountInvoiceDetail());
		
		System.out.println("size 2: " + accountinvoice.getAccountinvoicedetails().size());
		
		return null;
	}
	
	public String buscarTelefono(AccountInvoiceDetail telefono) {
		System.out.println("buscando telefono " + telefono);
		try {
			Category tt = buscarTipoTelefono(telefono.getCodigoTipoTemporal());
			System.out.println(tt);
			telefono.setCategory(tt);// .setTipo(tt);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, 
					e.getMessage(), "Error");
			//fc.addMessage(null, msg);
		}
		
		return null;
	}
	
	public Category buscarTipoTelefono(int codigo) throws Exception {
		try {
			Category tt = categorydao.leer(codigo);
			return tt;
		}catch(Exception e) {
			throw new Exception("Código no corresponde a un TT");
		}
	}

}
