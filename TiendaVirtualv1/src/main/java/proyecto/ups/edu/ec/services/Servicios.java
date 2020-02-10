package proyecto.ups.edu.ec.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import proyecto.ups.edu.ec.data.AccountInvoiceDetailDAO;
import proyecto.ups.edu.ec.data.CategoryDAO;
import proyecto.ups.edu.ec.data.PersonDAO;
import proyecto.ups.edu.ec.model.AccountInvoiceDetail;
import proyecto.ups.edu.ec.model.Category;
import proyecto.ups.edu.ec.model.Person;



import javax.ws.rs.core.Response;

@Path("/persons")
public class Servicios {
	
	@Inject
	private AccountInvoiceDetailDAO accountinvoicedetaildao;
	@Inject
	private PersonDAO perdao;
	
	@Inject
	private CategoryDAO catdao;
	
	@GET
	@Path("/saludo")
	@Produces("application/json")
	public String saludo(@QueryParam ("s") String nombre) {
		return "hola "+ nombre;
	}
	
	
	
	@GET
	@Path("/listPerson")
	@Produces("application/json")
	public List<Person> listPerson(){
		return perdao.listPerson();
	}
	
	@GET
	@Path("/listDetails")
	@Produces("application/json")
	public List<AccountInvoiceDetail> listDetails(){
		return accountinvoicedetaildao.listAccountInvoiceDetail();
	}
	
	
	
//	@GET
//	@Path("consultar")
//	@Produces("application/json")
//	public List<Libro> getLibros(){
//		
//		
//		return gl.getLibros();
//	}
//	
//	
//	@POST
//	@Produces("application/json")
//	@Consumes("application/json")
//	public Respuesta createLibro(Libro libro) {
//		Respuesta r = new Respuesta();
//		try {
//			
//			gl.guardarLibro(libro.getCodigo(), libro.getTitulo());
//			r.setCodigo(0);
//			r.setMensaje("OK");
//		}catch(Exception e) {
//			r.setCodigo(99);
//			r.setMensaje("Error al insertar");
//		}
//		return r;
//	}
	
	
	@POST
	@Path("/createPerson")
    @Consumes("application/json")
    @Produces("application/json")
	public Response createPerson(Person person) {
		Response.ResponseBuilder builder =null;
		try {
			perdao.save(person);
			builder = Response.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.build();
	}
	
//	@POST
//	@Path("/guardaraccount")
//	@Produces("application/json")
//	@Consumes("application/json")
//	public Respuesta saveAccount(Account acc){
//	Respuesta resp=new Respuesta();
//	try{
//		dao.insert(acc);
//		resp.setCodigo(1);
//		resp.setMensaje("Registro Satisfactorio");
//
//	}catch(Exception e)
//		resp.setCodigo(-1);
//		resp.setMensaje("Error de registro");
//	}
//
//
//
//	@GET
//	@Path("/account")
//	@Produces("application/json")
//	public List<Accountp> getAccounts(){
//		List<Account> accounts=dao.getAccounts();
//		List<AccountTemp> accs=new ArrayList();
//		for(Account acc: accounts){
//			Accountp tmp=new Accountp();
//			tmp.setAccountId(acc.getAccountId());
//			tmp.setName(acc.getName());
//			accs.add(tmp);
//		}
//		return accs
//	}
	
	
	@POST
	@Path("/createPerson1")
    @Produces("application/json")
    @Consumes("application/json")
	public Respuesta createPerson1(Person person) {
		Respuesta res=new Respuesta();
		try {
			perdao.save(person);
			res.setCodigo(1);
			res.setMensaje("ok");
			return res;
		} catch (Exception e) {
			res.setCodigo(99);
			res.setMensaje("error general");
			return res;
		}
	}
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Person> Login(Person a){
		//return asidao.login(a.getEmail(), a.getPassword());
		return perdao.login(a.getEmail(), a.getPassword1());
	}
	
	
	@GET
	@Path("/listCategory")
	@Produces("application/json")
	public List<Category> listCategory(){
		return catdao.listCategory();
	}

}
