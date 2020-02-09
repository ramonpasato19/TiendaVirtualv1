package proyecto.ups.edu.ec.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.ups.edu.ec.model.Person;

@ManagedBean @SessionScoped
public class LoginController {
	private String name;
    private String password;
    private String userName;
    private static final String PERSISTENCE_UNIT_NAME = "JSFEntityManager";
    
	@Inject
	private EntityManager em;
 
    public LoginController() {}
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    // Method To Check User's Authentication Credentials
	  public String validateLoginCredentials() {
	  String validationResult = "";
	  //EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	  Query queryObj = em.createQuery("SELECT u FROM Person u WHERE u.email = :login AND u.password1 = :password");
	  queryObj.setParameter("login", userName);
	  queryObj.setParameter("password", password);
	  try {
	      Person userResultSetObj = (Person) queryObj.getSingleResult();                
	      if ((userResultSetObj != null) && (userName.equalsIgnoreCase(userResultSetObj.getEmail()) && password.equals(userResultSetObj.getPassword1()))) {
	          validationResult ="index.xhtml";
	          name = userResultSetObj.getPaternSurname();
	      } 
	  } catch(Exception exObj) {
	      validationResult = "login.xhtml";
	      FacesContext.getCurrentInstance().addMessage("loginForm:loginName", new FacesMessage("Username Or Password Is Incorrect"));         
	  }
	  return validationResult;
	}
    
    
    
	public List<Person> listPerson(){
		Query query=em.createQuery("SELECT p from Person p ", Person.class);
		@SuppressWarnings("unchecked")
		List<Person> list=query.getResultList();
		return list;
	}
	

}
