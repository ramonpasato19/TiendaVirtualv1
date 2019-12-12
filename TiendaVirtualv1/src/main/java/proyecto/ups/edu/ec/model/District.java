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
 * La entidad sirve para crear una tabla de distrito con estado, pais y ciudad
 */
@Entity
@Table(name="district")
public class District implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	@Column(name="category_id")
	private Integer districtId;
		
	@NotNull
    	@NotEmpty
	@Column(name = "name")
	private String name;

	@Temporal(value = TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="districtId", referencedColumnName="category_id")
	private List<City> citys;

	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="districtId", referencedColumnName="category_id")
	private List<State> states;

	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="districtId", referencedColumnName="category_id")
	private List<Country> countrys;
	
	public void addCity(City city) {
		if(citys ==null)
		citys = new ArrayList<>();
		citys.add(city);
	}
	public void addState(State state) {
		if(states ==null)
		states = new ArrayList<>();
		states.add(state);
	}
	public void addCountry(Country country) {
		if(countrys ==null)
		countrys = new ArrayList<>();
		countrys.add(country);
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public List<Country> getCountrys() {
		return countrys;
	}
	public void setCountrys(List<Country> countrys) {
		this.countrys = countrys;
	}
	
	
}
