package proyecto.ups.edu.ec.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import proyecto.ups.edu.ec.data.AccountItemDAO;
import proyecto.ups.edu.ec.data.PersonDAO;
import proyecto.ups.edu.ec.model.Person;

@Path("/persons")
public class Servicios {
	
	@Inject
	private AccountItemDAO asidao;
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

}
