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
 * La entidad sirve para crear una tabla moneda de valor del producto
 */
@Entity
@Table(name="currency")
public class Currency implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	@Column(name="currency_id")
	private Integer currencyId;
	
	
	@NotNull
    	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotNull
    @NotEmpty
    @Column(name = "sign")
	private String sign;

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	
	
}
