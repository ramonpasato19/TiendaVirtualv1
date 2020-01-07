package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Luis Ramón
 * @version 1.0
 * Esta clase defien el tipo de persona CI o PASS o DNI
 */
@Entity
public class Tipo implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="name")
	private String name;
	
//	@OneToOne
//	private Persona persona;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	
	
	
}
