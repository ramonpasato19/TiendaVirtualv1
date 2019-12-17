package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.CategoryDAO;
import proyecto.ups.edu.ec.model.Category;

@ManagedBean
@SessionScoped
public class CategoryController {
	

	@Inject
	private CategoryDAO categorydao;
	private Category category=null;
	private List<Category> categorys;
	private int id;
	
	@PostConstruct
	public void init() {
		category=new Category();
		loadCategorys();
	}
	
	public void loadCategorys() {
		categorys=categorydao.listCategory();
	}
	
	public String loadDataEdit(int categoryId) {
		System.out.println("Cargando datos");
		category =categorydao.leer(categoryId);
		return "create-category";
	}
	public String save() {
		System.out.println(category);
		categorydao.save(category);
		loadCategorys();
		return "list-categorys";
	}

	public void del(int id) throws Exception {
		Category aux = categorydao.leer(id);
	if(aux==null) 
		throw new Exception("categorya no existe");
		else
	categorydao.delete(id);
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
	
	
	
	


	public CategoryDAO getCategorydao() {
		return categorydao;
	}

	public void setCategorydao(CategoryDAO categorydao) {
		this.categorydao = categorydao;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDataEdit(id);
	}
	
	public String delete(int id) {
		categorydao.delete(id);
		loadCategorys();
		return "list-categorys";
	}
	
	
		
}
