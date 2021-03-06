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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla de compañia como una persona juridica
 */
@Entity
@Table(name="company")
public class Company implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private int companyId;
		
	@NotNull
    @NotEmpty
	@Column(name = "name")
	private String name;

	@NotNull
    @NotEmpty
	@Column(name = "organization")
	private String organization;

	@NotNull
    @NotEmpty
	@Column(name = "logo")
	private String logo;

	@Temporal(value = TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

//	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
//	@JoinColumn(name="company")
//	private List<Product> products;
	
//	@ManyToOne
//	@JoinColumn(name="person_id", nullable=false)
//	private Person person;
	
	public String getName() {
		return name;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	
}
