package proyecto.ups.edu.ec.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import proyecto.ups.edu.ec.data.MaritalStatusDAO;
import proyecto.ups.edu.ec.model.MaritalStatus;

@ManagedBean
//@SessionScoped
@ViewScoped
public class MaritalStatusController {


	@Inject
	private MaritalStatusDAO maritalstatusdao;
	private MaritalStatus maritalstatus=null;
	private List<MaritalStatus> accountitemdetails;
	private int id;
	
	@PostConstruct
	public void init() {
		maritalstatus=new MaritalStatus();
		loadmaritalstatuss();
		accountitemdetails=maritalstatusdao.listMaritalStatus();
	}
	
	public void loadmaritalstatuss() {
		accountitemdetails=maritalstatusdao.listMaritalStatus();
	}
	
	public String loadDataEdit(int maritalstatusId) {
		System.out.println("Cargando datos");
		maritalstatus =maritalstatusdao.leer(maritalstatusId);
		return "create-maritalstatus";
	}
	public String save() {
		System.out.println(maritalstatus);
		maritalstatusdao.save(maritalstatus);
		loadmaritalstatuss();
		return "list-maritalstatus";
	}

	public void del(int id) throws Exception {
		MaritalStatus aux = maritalstatusdao.leer(id);
	if(aux==null) 
		throw new Exception("maritalstatus no existe");
		else
			maritalstatusdao.delete(id);
	}
	
	
	public String borrar(int  codigo) {
		System.out.println("codigo borrar " + codigo);
		
		try {
			del(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDataEdit(id);
	}
	
	public String delete(int id) {
		maritalstatusdao.delete(id);
		loadmaritalstatuss();
		return "list-maritalstatus";
	}

}
