package proyecto.ups.edu.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla persona, intermedia de muchas cuentas de item y natural person
 */
@Entity
@Table(name="identification_type")
public class IdentificationType implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="identification_type_id")
	private Integer identificationTypeId;
	
	@NotNull
    @NotEmpty
    @Size(min = 1, max = 3, message = "ejemplo CI DNI PAS")
    @Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "name")
	private String name;

	public Integer getIdentificationTypeId() {
		return identificationTypeId;
	}

	public void setIdentificationTypeId(Integer identificationTypeId) {
		this.identificationTypeId = identificationTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
