package asd;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Telefono {

	@Id
	@GeneratedValue
	private int codigo;
	private String numero;
	
	@OneToOne
	@JoinColumn(name="tipo_telefono")
	private TipoTelefono tipo;
	
	@OneToOne
	private Persona persona;
	
	
	@Transient
	private int codigoTipoTemporal;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoTelefono getTipo() {
		return tipo;
	}
	public void setTipo(TipoTelefono tipo) {
		this.tipo = tipo;
	}
	public int getCodigoTipoTemporal() {
		if(tipo==null)
			return this.codigoTipoTemporal;
		if(this.codigoTipoTemporal == 0)
			return tipo.getCodigo();
		return codigoTipoTemporal;
	}
	public void setCodigoTipoTemporal(int codigoTipoTemporal) {
		this.codigoTipoTemporal = codigoTipoTemporal;
	}
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", codigoTipoTemporal="
				+ codigoTipoTemporal + "]";
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
