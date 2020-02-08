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
		
	@NotNull
    @Column(name = "code")
	private String code;	
	
	@NotNull
    @Column(name = "name")
	private String name;

	@NotNull
    @Column(name = "description")
	private String description;

	@NotNull
    @Column(name = "cost")
	private double cost;

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
    @Column(name = "vattax")
	private String vattax;

	@NotNull
    @Column(name = "image1")
	private String image1;

	@Column(name = "image2")
	//private byte[] image2;
	private String image2;

	@NotNull
    @Column(name = "image3")
	private String image3;

	@Temporal(value = TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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

	public String getVattax() {
		return vattax;
	}

	public void setVattax(String vattax) {
		this.vattax = vattax;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public int getAccountInvoiceDetailId() {
		return accountInvoiceDetailId;
	}

	public void setAccountInvoiceDetailId(int accountInvoiceDetailId) {
		this.accountInvoiceDetailId = accountInvoiceDetailId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}