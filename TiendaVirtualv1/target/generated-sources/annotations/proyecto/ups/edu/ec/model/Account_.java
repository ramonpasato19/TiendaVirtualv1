package proyecto.ups.edu.ec.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, AccountInvoice> accountInvoice;
	public static volatile SingularAttribute<Account, Integer> accountId;
	public static volatile SingularAttribute<Account, String> product;
	public static volatile SingularAttribute<Account, String> code;
	public static volatile SingularAttribute<Account, Person> person;
	public static volatile SingularAttribute<Account, String> name;

}

