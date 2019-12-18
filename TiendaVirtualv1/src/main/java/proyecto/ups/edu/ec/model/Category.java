package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla de categoria del item
 */
@Entity
@Table(name="category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name="CATEGORYID_SEQ", sequenceName="CATEGORYID_SEQ",initialValue=1,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORYID_SEQ")
	@Column(name="category_id")
	private int categoryId;
	
	@NotNull(message="Please select a password")
	@Size(max = 20, min = 3, message = "{No puede ir vacion el nombre}")
//    @NotEmpty(message = "{category.name.empty}")
	//@Length(min=5, max=20, message="Password should be between 5 - 10 charactes")
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "categorys")
	private List<AccountItem> accountitems;

	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<AccountItem> getAccountitems() {
		return accountitems;
	}


	public void setAccountitems(List<AccountItem> accountitems) {
		this.accountitems = accountitems;
	}
	
	
	
	
}
