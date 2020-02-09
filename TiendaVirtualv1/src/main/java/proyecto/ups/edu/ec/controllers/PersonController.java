package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proyecto.ups.edu.ec.data.PersonDAO;
import proyecto.ups.edu.ec.model.Gender;
import proyecto.ups.edu.ec.model.MaritalStatus;
import proyecto.ups.edu.ec.model.Person;

@ManagedBean
//@SessionScoped
@ViewScoped
public class PersonController {
	

	@Inject
	private PersonDAO persondao;
	private Person person;
	private List<Person> persons;
	private int id;
	
	
    private static final String PERSISTENCE_UNIT_NAME = "JSFEntityManager";
    private String name;
    private String password;
    private String userName;
	
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
		return "register.xhtml";
	}
	public String save() {
		System.out.println(person);
		persondao.save(person);
		loadPersons();
		return "login.xhtml";
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
	//EntityManager named JSFEntityManager
    // Method To Check User's Authentication Credentials
//    public String validateLoginCredentials() {
//        String validationResult = "";
//        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
//        Query queryObj = entityMgrObj.createQuery("SELECT u FROM Person u WHERE u.email = :login AND u.password1 = :password");
//        queryObj.setParameter("login", userName);
//        queryObj.setParameter("password", password);
//        try {
//            Person userResultSetObj = (Person) queryObj.getSingleResult();                
//            if ((userResultSetObj != null) && (userName.equalsIgnoreCase(userResultSetObj.getEmail()) && password.equals(userResultSetObj.getPassword1()))) {
//                validationResult ="index.xhtml";
//                name = userResultSetObj.getPaternSurname();
//            } 
//        } catch(Exception exObj) {
//            validationResult = "index.html";
//            FacesContext.getCurrentInstance().addMessage("loginForm:loginName", new FacesMessage("Username Or Password Is Incorrect"));         
//        }
//        return validationResult;
//    }
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
    
    
    
    
}
