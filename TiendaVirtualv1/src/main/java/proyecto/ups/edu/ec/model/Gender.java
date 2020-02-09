package proyecto.ups.edu.ec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear una tabla genero de persona
 */
@Entity
@Table(name="gender")
public class Gender implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gender_id")
	private int genderId;
	
//	@NotNull
//    @NotEmpty
	@Column(name = "name")
	private String name;
	
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//tipo deletura que voy hacer, si leo head me traiga los hijos,
//	@JoinColumn(name = "gender_id",referencedColumnName = "gender_id")
//	private List<Person> person=new ArrayList<Person>();



	public String getName() {
		return name;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Person> getPerson() {
//		return person;
//	}
//
//	public void setPerson(List<Person> person) {
//		this.person = person;
//	}


	
	
}
