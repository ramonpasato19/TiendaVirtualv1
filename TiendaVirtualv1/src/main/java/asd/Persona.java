package asd;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {

	@Id
	@Column(name="per_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="per_nombre")
	@Size(min = 10, max = 25)
	private String nombre;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_persona")
	private List<Telefono> telefonos;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	
	public void addTelefono(Telefono telefono) {
		if(telefonos==null)
			telefonos = new ArrayList<>();
		
		telefonos.add(telefono);
		System.out.println("tele size "+ telefonos.size());
	}
	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", telefonos=" + telefonos + "]";
	}
	
	
	
	
}
