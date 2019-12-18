package proyecto.ups.edu.ec.business;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.AccountItemDAO;
import proyecto.ups.edu.ec.model.AccountItem;

public class AccountItemON {
	@Inject
	private AccountItemDAO dao;
	

	
//	public void guardar(AccountItem p) throws Exception{
//		
//		if(p.getNombre().length()<5)
//			throw new Exception("Dimension corta");
//			dao.save(p);		
//	}
//	
//	public List<AccountItem> getListadoPersonas(){
//		return dao..getPersonas();
//	}
//	
//	public void borrar(int codigo) throws Exception {
//		try {
//			dao.delete(codigo);
//		}catch(Exception e) {
//			throw new Exception("Error al borrar " + e.getMessage());
//		}
//		
//	}
//	
//	public Persona getPersona(int codigo) {
//		Persona aux = dao.read(codigo);
//		
//		return aux;
//		
//	}
//	public TipoTelefono buscarTipoTelefono(int codigo) throws Exception {
//		try {
//			TipoTelefono tt = daoTipoTel.read(codigo);
//			return tt;
//		}catch(Exception e) {
//			throw new Exception("Código no corresponde a un TT");
//		}
//	}

}
