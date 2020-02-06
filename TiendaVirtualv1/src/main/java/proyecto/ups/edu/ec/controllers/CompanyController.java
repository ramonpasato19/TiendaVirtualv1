package proyecto.ups.edu.ec.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import proyecto.ups.edu.ec.data.CompanyDAO;
import proyecto.ups.edu.ec.model.Company;

@ManagedBean
//@SessionScoped
@ViewScoped
public class CompanyController {
	
	@Inject
	private CompanyDAO companydao;
	private Company company=null;
	private List<Company> companys;
	private int id;
	
	@PostConstruct
	public void init() {
		company=new Company();
		loadCategorys();
	}
	
	public void loadCategorys() {
		companys=companydao.listCompany();
	}
	
	public String loadDataEdit(int categoryId) {
		System.out.println("Cargando datos");
		company =companydao.leer(categoryId);
		return "create-company";
	}
	public String save() {
		System.out.println(company);
		companydao.save(company);
		loadCategorys();
		return "list-companys";
	}

	public void del(int id) throws Exception {
		Company aux = companydao.leer(id);
	if(aux==null) 
		throw new Exception("company no existe");
		else
			companydao.delete(id);
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
	
	
	public CompanyDAO getCompanydao() {
		return companydao;
	}

	public void setCompanydao(CompanyDAO companydao) {
		this.companydao = companydao;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDataEdit(id);
	}
	
	public String delete(int id) {
		companydao.delete(id);
		loadCategorys();
		return "list-companys";
	}

}
