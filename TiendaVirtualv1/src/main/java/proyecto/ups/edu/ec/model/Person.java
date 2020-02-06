package proyecto.ups.edu.ec.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
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
	private Integer personId;
	
	@NotNull
    @NotEmpty
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "activity")
	private String activity;
	
	@NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
	@Digits(fraction = 0, integer = 12)
	@Column(name = "identification")
	private String identification;
	
	@NotNull
    @NotEmpty
    @Size(min = 10, max = 30)
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "name")
	private String name;
	
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
	@Column(name = "password2")
	private String password2;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;
	
	//add new 04 02 2020 ##########################################################################################################################################################################
	@NotNull
    @NotEmpty
	@Column(name = "first_name")
	@Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	private String firstName;

	@NotNull
    @NotEmpty
	@Column(name = "last_name")
	@Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	private String lastName;

	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "patern_surname")
	private String paternSurname;

	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "matern_surname")
	private String maternSurname;

	@NotNull
    @NotEmpty
    @Column(name = "home_main_street")
	private String homeMainStreet;

	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "home_side_street")
	private String homeSideStreet;

	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^a-z]*", message = "No puede contener letras")
	@Column(name = "code_postal")
	private String codePostal;

	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^a-z]*", message = "No puede contener letras")
	@Column(name = "phone")
	private String phone;

	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^a-z]*", message = "No puede contener letras")
	@Column(name = "mobile")
	private String mobile;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
    @Column(name = "city")
	private String city;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
    @Column(name = "country")
	private String country;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
    @Column(name = "state")
	private String state;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
    @Column(name = "district")
	private String district;
	

	@OneToOne
	@JoinColumn(name="gender_id")
	private Gender gender;
	
	@OneToOne
	@JoinColumn(name="marital_status_id")
	private MaritalStatus maritalStatus;
	
	@OneToOne
	@JoinColumn(name="nationality_id")
	private Nationality nationality;
	
	
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
		
}
