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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="account_item")
public class AccountItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	@Column(name="account_item_id")
	private Integer accountItemId;
		
	@NotNull
    	@NotEmpty
	@Column(name = "code")
	private String code;	
	
	@NotNull
    	@NotEmpty
	@Column(name = "name")
	private String name;

	@NotNull
    	@NotEmpty
	@Column(name = "description")
	private String description;

	@NotNull
    	@NotEmpty
	@Column(name = "cost")
	private double cost;

	@NotNull
    	@NotEmpty
	@Column(name = "price")
	private Double price;

	@NotNull
    	@NotEmpty
	@Column(name = "color")
	private String color;
	
	@NotNull
    	@NotEmpty
	@Column(name = "size")
	private String size;

	@NotNull
    	@NotEmpty
	@Column(name = "vattax")
	private String vattax;

	@NotNull
    	@NotEmpty
	@Column(name = "image1")
	private String image1;

	@NotNull
    	@NotEmpty
	@Column(name = "image2")
	private String image2;

	@NotNull
    	@NotEmpty
	@Column(name = "image3")
	private String image3;

	@NotNull
    	@NotEmpty
	@Column(name = "new_used")
	private String newUsed;

	@Temporal(value = TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

//	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
//	@JoinColumn(name="accountItemId", referencedColumnName="account_item_id")
//	private List<UnitMeasure> unitmeasures;
//
//	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
//	@JoinColumn(name="accountItemId", referencedColumnName="account_item_id")
//	private List<Category> categorys;
//	
//	public void addUnitMeasure(UnitMeasure unitmeasure) {
//		if(unitmeasures ==null)
//		unitmeasures = new ArrayList<>();
//		unitmeasures.add(unitmeasure);
//	}
//
//	public void addCategory(Category category) {
//		if(categorys ==null)
//		categorys = new ArrayList<>();
//		categorys.add(category);
//	}

	public Integer getAccountItemId() {
		return accountItemId;
	}

	public void setAccountItemId(Integer accountItemId) {
		this.accountItemId = accountItemId;
	}

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

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getNewUsed() {
		return newUsed;
	}

	public void setNewUsed(String newUsed) {
		this.newUsed = newUsed;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

//	public List<UnitMeasure> getUnitmeasures() {
//		return unitmeasures;
//	}
//
//	public void setUnitmeasures(List<UnitMeasure> unitmeasures) {
//		this.unitmeasures = unitmeasures;
//	}
//
//	public List<Category> getCategorys() {
//		return categorys;
//	}
//
//	public void setCategorys(List<Category> categorys) {
//		this.categorys = categorys;
//	}
	
	

}
