package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.AccountItemDAO;
import proyecto.ups.edu.ec.model.AccountItem;
import proyecto.ups.edu.ec.model.Category;
import proyecto.ups.edu.ec.model.UnitMeasure;

@ManagedBean
@SessionScoped
public class AccountItemController {
	

	@Inject
	private AccountItemDAO accountitemdao;
	private AccountItem accountitem=null;
	private List<AccountItem> accountitems;
	private int id;
	
	@PostConstruct
	public void init() {
		accountitem=new AccountItem();
//		accountitem.addUnitMeasure(new UnitMeasure());
//		accountitem.addCategory(new Category());
		loadAccountItems();
	}
	
	public void loadAccountItems() {
		accountitems=accountitemdao.listAccountItem();
	}
	
	public String loadDataEdit(int accountitemId) {
		System.out.println("Cargando datos");
		accountitem =accountitemdao.leer(accountitemId);
		return "create-accountitem";
	}
	public String save() {
		System.out.println(accountitem);
		accountitemdao.save(accountitem);
		loadAccountItems();
		return "list-accountitems";
	}

	public void del(int id) throws Exception {
		AccountItem aux = accountitemdao.leer(id);
	if(aux==null) 
		throw new Exception("item no existe");
		else
	accountitemdao.delete(id);
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
		accountitemdao.delete(id);
		loadAccountItems();
		return "list-accountitems";
	}
	

//	public String addUnitMeasure() {
//		accountitem.addUnitMeasure(new UnitMeasure());
//		return null;
//	}
//
//	public String addCategory() {
//		accountitem.addCategory(new Category());
//		return null;
//	}

	public AccountItemDAO getAccountitemdao() {
		return accountitemdao;
	}

	public void setAccountitemdao(AccountItemDAO accountitemdao) {
		this.accountitemdao = accountitemdao;
	}

	public AccountItem getAccountitem() {
		return accountitem;
	}

	public void setAccountitem(AccountItem accountitem) {
		this.accountitem = accountitem;
	}

	public List<AccountItem> getAccountitems() {
		return accountitems;
	}

	public void setAccountitems(List<AccountItem> accountitems) {
		this.accountitems = accountitems;
	}
	
	
	
		
}
