package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import proyecto.ups.edu.ec.data.PersonDAO;
import proyecto.ups.edu.ec.model.Person;

@ManagedBean
public class PersonController {
	

	@Inject
	private PersonDAO persondao;
	private Person person=null;
	private List<Person> persons;
	
	@PostConstruct
	public void init() {
		person=new Person();
		loadPersons();
	}
	
	public void loadPersons() {
		persons=persondao.listPerson();
	}
	
	public String loadDataEditar(int personId) {
		System.out.println("Cargando datos");
		person =persondao.leer(personId);
		return "create-person";
	}
	public String save() {
		System.out.println(person);
		persondao.guardar(person);
		loadPersons();
		return "list-persons";
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
		
}
