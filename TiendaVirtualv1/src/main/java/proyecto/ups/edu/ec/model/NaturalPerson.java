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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import test.Tipo;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla natural person, mas 
 * caracteristicas sobre  la persona
 */
@Entity
@Table(name="natural_person")
public class NaturalPerson implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="natural_person_id")
	private Integer naturalPersonId;
		
	@NotNull
    @NotEmpty
	@Column(name = "first_name")
	private String firstName;

	@NotNull
    @NotEmpty
	@Column(name = "last_name")
	private String lastName;

	@NotNull
    @NotEmpty
	@Column(name = "patern_surname")
	private String paternSurname;

	@NotNull
    @NotEmpty
	@Column(name = "matern_surname")
	private String maternSurname;

	@NotNull
    @NotEmpty
	@Column(name = "home_main_street")
	private String homeMainStreet;

	@NotNull
    @NotEmpty
	@Column(name = "home_side_street")
	private String homeSideStreet;

	@NotNull
    @NotEmpty
	@Column(name = "code_postal")
	private String codePostal;

	@NotNull
    @NotEmpty
	@Column(name = "phone")
	private String phone;

	@NotNull
    @NotEmpty
	@Column(name = "mobile")
	private String mobile;

	@Temporal(value = TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	@OneToOne
	@JoinColumn(name="gender_id")
	private Gender gender;
	
	@OneToOne
	@JoinColumn(name="maritalstatus_id")
	private MaritalStatus maritalstatus;
	
	@OneToOne
	@JoinColumn(name="nationality_id")
	private Nationality nationality;

	public Integer getNaturalPersonId() {
		return naturalPersonId;
	}

	public void setNaturalPersonId(Integer naturalPersonId) {
		this.naturalPersonId = naturalPersonId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPaternSurname() {
		return paternSurname;
	}

	public void setPaternSurname(String paternSurname) {
		this.paternSurname = paternSurname;
	}

	public String getMaternSurname() {
		return maternSurname;
	}

	public void setMaternSurname(String maternSurname) {
		this.maternSurname = maternSurname;
	}

	public String getHomeMainStreet() {
		return homeMainStreet;
	}

	public void setHomeMainStreet(String homeMainStreet) {
		this.homeMainStreet = homeMainStreet;
	}

	public String getHomeSideStreet() {
		return homeSideStreet;
	}

	public void setHomeSideStreet(String homeSideStreet) {
		this.homeSideStreet = homeSideStreet;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	

}
