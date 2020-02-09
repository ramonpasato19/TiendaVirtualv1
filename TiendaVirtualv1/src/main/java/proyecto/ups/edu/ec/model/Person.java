package proyecto.ups.edu.ec.model;

import java.io.Serializable;

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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla persona, intermedia de muchas cuentas de item y natural person
 */
@Entity
@Table(name="person", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private int personId;
	
	@NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
	@Digits(fraction = 0, integer = 12)
	@Column(name = "identification")
	private String identification;
	
	@NotNull
    @NotEmpty
    @Email
    @Column(name = "email")
	private String email;
	
	@NotNull
    @NotEmpty
	@Column(name = "password1")
	private String password1;
	
	@NotNull
    @NotEmpty
    @Size(min = 4, max = 30)
	@Column(name = "first_name")
	@Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	private String firstName;

	@NotNull
    @NotEmpty
    @Size(min = 4, max = 30)
	@Column(name = "last_name")
	@Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	private String lastName;

	@NotNull
    @NotEmpty
    @Size(min = 4, max = 30)
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "patern_surname")
	private String paternSurname;

	@NotNull
    @NotEmpty
    @Size(min = 4, max = 30)
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "matern_surname")
	private String maternSurname;

	@NotNull
    @NotEmpty
    @Size(min = 4, max = 40)
    @Column(name = "home_main_street")
	private String homeMainStreet;

	@NotNull
    @NotEmpty
    @Size(min = 6, max = 6)
    @Pattern(regexp = "[^a-z]*", message = "No puede contener letras")
	@Column(name = "code_postal")
	private String codePostal;

	@NotNull
    @NotEmpty
    @Size(min = 7, max = 10)
    @Pattern(regexp = "[^a-z]*", message = "No puede contener letras")
	@Column(name = "phone")
	private String phone;

	@NotNull
    @NotEmpty
    @Size(min = 5, max = 15)
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
    @Column(name = "city")
	private String city;
	
	@NotNull
    @NotEmpty
    @Size(min = 5, max = 15)
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
    @Column(name = "country")
	private String country;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
		
}
