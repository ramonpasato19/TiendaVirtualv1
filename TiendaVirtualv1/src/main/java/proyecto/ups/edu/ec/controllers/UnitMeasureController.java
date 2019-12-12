package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.UnitMeasureDAO;
import proyecto.ups.edu.ec.model.UnitMeasure;

@ManagedBean
@SessionScoped
public class UnitMeasureController {
	

	@Inject
	private UnitMeasureDAO unitmeasuredao;
	private UnitMeasure unitmeasure=null;
	private List<UnitMeasure> unitmeasures;
	private int id;
	
	@PostConstruct
	public void init() {
		unitmeasure=new UnitMeasure();
		loadUnitMeasures();
	}
	
	public void loadUnitMeasures() {
		unitmeasure=unitmeasuredao.listUnitMeasure();
	}
	
	public String loadDataEdit(int unitmeasureId) {
		System.out.println("Cargando datos");
		unitmeasure =unitmeasuredao.leer(unitmeasureId);
		return "create-unitmeasure";
	}
	public String save() {
		System.out.println(unitmeasure);
		unitmeasuredao.save(unitmeasure);
		loadUnitMeasures();
		return "list-UnitMeasures";
	}

	public void del(int id) throws Exception {
		UnitMeasure aux = unitmeasuredao.leer(id);
	if(aux==null) 
		throw new Exception("UnitMeasure no existe");
		else
	unitmeasuredao.delete(id);
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
		unitmeasuredao.delete(id);
		loadUnitMeasures();
		return "list-unitmeasures";
	}
	
	
		
}
