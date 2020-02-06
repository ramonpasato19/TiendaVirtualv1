package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import proyecto.ups.edu.ec.data.NationalityDAO;
import proyecto.ups.edu.ec.model.Nationality;


@ManagedBean
//@SessionScoped
@ViewScoped
public class NationalityController {
	
	@Inject
	private NationalityDAO nationalitydao;
	private Nationality nationality=null;
	private List<Nationality> nationalitys;
	private int id;
	
	@PostConstruct
	public void init() {
		nationality=new Nationality();
		loadnationalitys();
	}
	
	public void loadnationalitys() {
		nationalitys=nationalitydao.listNationality();
	}
	
	public String loadDataEdit(int nationalityId) {
		System.out.println("Cargando datos");
		nationality =nationalitydao.leer(nationalityId);
		return "create-nationality";
	}
	public String save() {
		System.out.println(nationality);
		nationalitydao.save(nationality);
		loadnationalitys();
		return "list-nationalitys";
	}

	public void del(int id) throws Exception {
		Nationality aux = nationalitydao.leer(id);
	if(aux==null) 
		throw new Exception("nationality no existe");
		else
	nationalitydao.delete(id);
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
		nationalitydao.delete(id);
		loadnationalitys();
		return "list-nationalitys";
	}

	public NationalityDAO getNationalitydao() {
		return nationalitydao;
	}

	public void setNationalitydao(NationalityDAO nationalitydao) {
		this.nationalitydao = nationalitydao;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public List<Nationality> getNationalitys() {
		return nationalitys;
	}

	public void setNationalitys(List<Nationality> nationalitys) {
		this.nationalitys = nationalitys;
	}
	
	

}
