
package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * La entidad sirve para crear el estado civil de la persona
 */
@Entity
@Table(name="marital_status")
public class MaritalStatus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="marital_status_id")
	private Integer maritalStatusId;
	
	@NotNull
    @NotEmpty
	@Column(name = "name")
	private String name;

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
