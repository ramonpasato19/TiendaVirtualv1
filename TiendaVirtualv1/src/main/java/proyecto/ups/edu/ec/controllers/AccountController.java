package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.AccountDAO;
import proyecto.ups.edu.ec.model.Account;



@ManagedBean
//@SessionScoped
@ViewScoped
public class AccountController {
	@Inject
	private AccountDAO accountdao;
	private Account account=null;
	private List<Account> accounts;
	private int id;
	
	@PostConstruct
	public void init() {
		account=new Account();
		loadaccounts();
	}
	
	public void loadaccounts() {
		accounts=accountdao.listAccount();
	}
	
	public String loadDataEdit(int accountId) {
		System.out.println("Cargando datos");
		account =accountdao.leer(accountId);
		return "create-account";
	}
	public String save() {
		System.out.println(account);
		accountdao.save(account);
		loadaccounts();
		return "list-accounts";
	}

	public void del(int id) throws Exception {
		Account aux = accountdao.leer(id);
	if(aux==null) 
		throw new Exception("accounta no existe");
		else
	accountdao.delete(id);
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
		accountdao.delete(id);
		loadaccounts();
		return "list-accounts";
	}

	public AccountDAO getAccountdao() {
		return accountdao;
	}

	public void setAccountdao(AccountDAO accountdao) {
		this.accountdao = accountdao;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
