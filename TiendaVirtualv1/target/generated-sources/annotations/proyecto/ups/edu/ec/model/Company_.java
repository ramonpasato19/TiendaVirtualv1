package proyecto.ups.edu.ec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, Integer> companyId;
	public static volatile SingularAttribute<Company, String> organization;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile SingularAttribute<Company, Date> registrationDate;
	public static volatile SingularAttribute<Company, String> logo;

}

