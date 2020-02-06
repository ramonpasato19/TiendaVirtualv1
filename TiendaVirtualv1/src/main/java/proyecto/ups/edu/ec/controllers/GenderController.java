package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.GenderDAO;
import proyecto.ups.edu.ec.model.Category;
import proyecto.ups.edu.ec.model.Gender;



@ManagedBean
//@SessionScoped
@ViewScoped
public class GenderController {
	
	@Inject
	private GenderDAO genderdao;
	private Gender gender=null;
	private List<Gender> genders;
	private int id;
	
	@PostConstruct
	public void init() {
		gender=new Gender();
		loadGenders();
	}
	
	public void loadGenders() {
		genders=genderdao.listGender();
	}
	
	public String loadDataEdit(int categoryId) {
		System.out.println("Cargando datos");
		gender =genderdao.leer(categoryId);
		return "create-gender";
	}
	public String save() {
		System.out.println(gender);
		genderdao.save(gender);
		loadGenders();
		return "list-genders";
	}

	public void del(int id) throws Exception {
		Gender aux = genderdao.leer(id);
	if(aux==null) 
		throw new Exception("gender no existe");
		else
	genderdao.delete(id);
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
		
	public GenderDAO getGenderdao() {
		return genderdao;
	}

	public void setGenderdao(GenderDAO genderdao) {
		this.genderdao = genderdao;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDataEdit(id);
	}
	
	public String delete(int id) {
		genderdao.delete(id);
		loadGenders();
		return "list-genders";
	}
	
	

}
