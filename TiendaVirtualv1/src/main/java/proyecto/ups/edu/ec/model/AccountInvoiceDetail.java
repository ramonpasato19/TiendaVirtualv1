package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Stereotype;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla item o producto
 */
@Entity
@Table(name="account_invoice_detail")
public class AccountInvoiceDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_invoice_detail_id")
	private int accountInvoiceDetailId;
		
	//JPA inplicitamente agrega el campo al padre
	
	@NotNull
    @Column(name = "code")
	private String code;	
	
	@NotNull
    @Column(name = "name")
	private String name;

	@NotNull
    @Column(name = "price")
	private Double price;

	@NotNull
    @Column(name = "color")
	private String color;
	
	@NotNull
    @Column(name = "size")
	private String size;

	@NotNull
    @Column(name = "image1")
	private String image1;


	@Column(name="issue_date")
	private String issueDate;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Transient
	private int codigoTipoTemporal;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public int getAccountInvoiceDetailId() {
		return accountInvoiceDetailId;
	}

	public void setAccountInvoiceDetailId(int accountInvoiceDetailId) {
		this.accountInvoiceDetailId = accountInvoiceDetailId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCodigoTipoTemporal() {
		if(category==null)
			return this.codigoTipoTemporal;
		if(this.codigoTipoTemporal == 0)
			return category.getCategoryId();
		return codigoTipoTemporal;
	}

	public void setCodigoTipoTemporal(int codigoTipoTemporal) {
		this.codigoTipoTemporal = codigoTipoTemporal;
	}
	
	
	
}