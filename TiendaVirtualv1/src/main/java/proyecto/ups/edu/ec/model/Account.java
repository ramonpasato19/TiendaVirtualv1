package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla cuenta con persona y factura(item)
 */
@Entity
@Table(name="account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;
		
	@Column(name="name")
	private String name;
	
	@NotNull
    @Column(name = "code")
	private String code;
	
	@NotNull
    @Column(name = "product")
	private String product;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//tipo deletura que voy hacer, si leo head me traiga los hijos,
//	@JoinColumn(name = "account",referencedColumnName = "person_id")
//	private List<Person> person=new ArrayList<Person>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//tipo de lectura que voy hacer, si leo head me traiga los hijos,
	@JoinColumn(name = "account",referencedColumnName = "account_invoice_id")
	private List<AccountInvoice> accountInvoice=new ArrayList<AccountInvoice>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public List<AccountInvoice> getAccountInvoice() {
		return accountInvoice;
	}

	public void setAccountInvoice(List<AccountInvoice> accountInvoice) {
		this.accountInvoice = accountInvoice;
	}
	

}
