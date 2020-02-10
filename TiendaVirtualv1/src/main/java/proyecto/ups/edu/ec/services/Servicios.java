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
import proyecto.ups.edu.ec.data.PersonDAO;
import proyecto.ups.edu.ec.model.AccountInvoiceDetail;
import proyecto.ups.edu.ec.model.Person;



import javax.ws.rs.core.Response;

@Path("/persons")
public class Servicios {
	
	@Inject
	private AccountInvoiceDetailDAO accountinvoicedetaildao;
	@Inject
	private PersonDAO perdao;
	
	@GET
	@Path("/saludo")
	@Produces("application/json")
	public String saludo(@QueryParam ("s") String nombre) {
		return "hola "+ nombre;
	}
	
	
	
	@GET
	@Path("/listado")
	@Produces("application/json")
	public List<Person> listar(){
		return perdao.listPerson();
	}
	
	@GET
	@Path("/listadoitems")
	@Produces("application/json")
	public List<AccountInvoiceDetail> listar1(){
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
	@Path("/savePerson")
    @Consumes("application/json")
    @Produces("application/json")
	public Response createperson(Person person) {
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
	@Path("/savePerson1")
    @Produces("application/json")
    @Consumes("application/json")
	public Respuesta guardar(Person person) {
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

}
