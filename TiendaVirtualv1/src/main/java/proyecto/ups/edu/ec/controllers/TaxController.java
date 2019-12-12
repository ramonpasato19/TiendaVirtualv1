package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.TaxDAO;
import proyecto.ups.edu.ec.model.Tax;

@ManagedBean
@SessionScoped
public class TaxController {
	

	@Inject
	private TaxDAO taxdao;
	private Tax tax=null;
	private List<Tax> taxs;
	private int id;
	
	@PostConstruct
	public void init() {
		tax=new Tax();
		loadTaxs();
	}
	
	public void loadTaxs() {
		taxs=taxdao.listTax();
	}
	
	public String loadDataEdit(int taxId) {
		System.out.println("Cargando datos");
		tax =taxdao.leer(taxId);
		return "create-tax";
	}
	public String save() {
		System.out.println(tax);
		taxdao.save(tax);
		loadTaxs();
		return "list-taxs";
	}

	public void del(int id) throws Exception {
		Tax aux = taxdao.leer(id);
	if(aux==null) 
		throw new Exception("tax no existe");
		else
	taxdao.delete(id);
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
		taxdao.delete(id);
		loadTaxs();
		return "list-taxs";
	}
	
	
	
	
		
}
