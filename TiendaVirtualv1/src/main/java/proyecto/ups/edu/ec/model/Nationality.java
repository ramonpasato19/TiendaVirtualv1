package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla de nacionalidad o nacionalidades de persona
 */
@Entity
@Table(name="nationality")
public class Nationality implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	@Column(name="nationality_id")
	private Integer nationalityId;
	
	@NotNull
    	@NotEmpty	
	@Column(name = "name")
	private String name;

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
