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
 * La entidad sirve para crear una tabla de impuestos de item
 */
@Entity
@Table(name="tax")
public class Tax implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	@Column(name="tax_id")
	private Integer taxId;
		
	@NotNull
    	@NotEmpty
	@Column(name = "name")
	private String name;

	@NotNull
    	@NotEmpty
	@Column(name = "percentaje")
	private String percentaje;

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPercentaje() {
		return percentaje;
	}

	public void setPercentaje(String percentaje) {
		this.percentaje = percentaje;
	}


}
