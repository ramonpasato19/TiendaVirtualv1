package proyecto.ups.edu.ec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountInvoice.class)
public abstract class AccountInvoice_ {

	public static volatile SingularAttribute<AccountInvoice, Integer> establishmentCode;
	public static volatile SingularAttribute<AccountInvoice, Integer> authorizationCode;
	public static volatile SingularAttribute<AccountInvoice, Integer> emissionCode;
	public static volatile SingularAttribute<AccountInvoice, AccountInvoiceDetail> accountInvoiceDetail;
	public static volatile SingularAttribute<AccountInvoice, String> remark;
	public static volatile SingularAttribute<AccountInvoice, Company> company;
	public static volatile SingularAttribute<AccountInvoice, Date> issueDate;
	public static volatile SingularAttribute<AccountInvoice, Integer> accountInvoiceId;

}

