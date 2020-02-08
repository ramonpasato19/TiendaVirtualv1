package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.PersonDAO;
import proyecto.ups.edu.ec.model.Gender;
import proyecto.ups.edu.ec.model.MaritalStatus;
import proyecto.ups.edu.ec.model.Person;

@ManagedBean
@SessionScoped
public class PersonController {
	

	@Inject
	private PersonDAO persondao;
	private Person person;
	private List<Person> persons;
	private int id;
	
	@PostConstruct
	public void init() {
		person=new Person();

		loadPersons();
	}
	
	public void loadPersons() {
		persons=persondao.listPerson();
	}
	
	public String loadDataEdit(int personId) {
		System.out.println("Cargando datos");
		person =persondao.leer(personId);
		return "create-person";
	}
	public String save() {
		System.out.println(person);
		persondao.save(person);
		loadPersons();
		return "list-persons";
	}

	public void del(int id) throws Exception {
		Person aux = persondao.leer(id);
	if(aux==null) 
		throw new Exception("Persona no existe");
		else
	persondao.delete(id);
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
	
	
	
	
	public PersonDAO getPersondao() {
		return persondao;
	}

	public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDataEdit(id);
	}
	
	public String delete(int id) {
		persondao.delete(id);
		loadPersons();
		return "list-persons";
	}
	
	
//	public String addGender() {
//		person.addTelefono(telefono);.addGender(new Gender());
//		return null;
//	}
		
}
