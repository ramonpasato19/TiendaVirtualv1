package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.IdentificationTypeDAO;
import proyecto.ups.edu.ec.model.IdentificationType;

@ManagedBean
@SessionScoped
public class IdentificationTypeController {
	
	@Inject
	private IdentificationTypeDAO perdao;
	private IdentificationType per=null;
	private List<IdentificationType> pers;
	private int id;
	
	@PostConstruct
	public void init() {
		per=new IdentificationType();
		loadpers();
	}
	
	public void loadpers() {
		pers=perdao.listIdentificationType();
	}
	
	public String loadDataEdit(int perId) {
		System.out.println("Cargando datos");
		per =perdao.leer(perId);
		return "create-per";
	}
	public String save() {
		System.out.println(per);
		perdao.save(per);
		loadpers();
		return "list-identification-type";
	}

	public void del(int id) throws Exception {
		IdentificationType aux = perdao.leer(id);
	if(aux==null) 
		throw new Exception("tipo de identificacion no existe");
		else
	perdao.delete(id);
	}
	
	
	public String borrar(int  codigo) {
		System.out.println("codigo borrar " + codigo);
		
		try {
			del(codigo);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		perdao.delete(id);
		loadpers();
		return "list-identification-type";
	}

	public IdentificationTypeDAO getPerdao() {
		return perdao;
	}

	public void setPerdao(IdentificationTypeDAO perdao) {
		this.perdao = perdao;
	}

	public IdentificationType getPer() {
		return per;
	}

	public void setPer(IdentificationType per) {
		this.per = per;
	}

	public List<IdentificationType> getPers() {
		return pers;
	}

	public void setPers(List<IdentificationType> pers) {
		this.pers = pers;
	}
	
	

}
