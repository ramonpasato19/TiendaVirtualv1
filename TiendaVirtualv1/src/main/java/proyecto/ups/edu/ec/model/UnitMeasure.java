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
 * La entidad sirve para crear una tabla unidad de medida del item
 */
@Entity
@Table(name="unit_measure")
public class UnitMeasure implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	@Column(name="unit_measure")
	private Integer unitMeasure;
	
	@NotNull
    	@NotEmpty
	@Column(name = "name")
	private String name;

	public Integer getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(Integer unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
