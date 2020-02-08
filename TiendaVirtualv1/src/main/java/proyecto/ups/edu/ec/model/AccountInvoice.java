package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla item o producto
 */
@Entity
@Table(name="account_invoice")
public class AccountInvoice implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_invoice_id")
	private int accountInvoiceId;
		
	@NotNull
    @Column(name = "remark")
	private String remark;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;
	
	@NotNull
	@Column(name="authorization_code")
	private int authorizationCode;
	
	@NotNull
	@Column(name="establishment_code")
	private int establishmentCode;
	
	@NotNull
	@Column(name="emission_code")
	private int emissionCode;
	
	@OneToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="account_invoice_detail_id")
	private AccountInvoiceDetail accountInvoiceDetail;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//tipo deletura que voy hacer, si leo head me traiga los hijos,
//	@JoinColumn(name = "accountInvoice",referencedColumnName = "account_invoice_detail_id")
//	private List<AccountInvoiceDetail> accountinvoicedetail=new ArrayList<AccountInvoiceDetail>();
	
//	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//tipo deletura que voy hacer, si leo head me traiga los hijos,
//	@JoinColumn(name = "account_invoice_detail_id")
//	private List<AccountInvoiceDetail> accountinvoicedetail;
//	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "codigo_persona")
//	private List<Telefono> telefonos;

	public int getAccountInvoiceId() {
		return accountInvoiceId;
	}

	public void setAccountInvoiceId(int accountInvoiceId) {
		this.accountInvoiceId = accountInvoiceId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(int authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public int getEstablishmentCode() {
		return establishmentCode;
	}

	public void setEstablishmentCode(int establishmentCode) {
		this.establishmentCode = establishmentCode;
	}

	public int getEmissionCode() {
		return emissionCode;
	}

	public void setEmissionCode(int emissionCode) {
		this.emissionCode = emissionCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public AccountInvoiceDetail getAccountInvoiceDetail() {
		return accountInvoiceDetail;
	}

	public void setAccountInvoiceDetail(AccountInvoiceDetail accountInvoiceDetail) {
		this.accountInvoiceDetail = accountInvoiceDetail;
	}
	
	

//	public List<AccountInvoiceDetail> getAccountinvoicedetail() {
//		return accountinvoicedetail;
//	}
//
//	public void setAccountinvoicedetail(List<AccountInvoiceDetail> accountinvoicedetail) {
//		this.accountinvoicedetail = accountinvoicedetail;
//	}


	
	
}
