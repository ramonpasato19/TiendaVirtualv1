package proyecto.ups.edu.ec.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
//@Table(name="person")
@Table(name="person", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
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
	






	
	
}
