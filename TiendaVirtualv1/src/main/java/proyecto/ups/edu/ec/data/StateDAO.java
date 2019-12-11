package proyecto.ups.edu.ec.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import proyecto.ups.edu.ec.model.State;

/**
 * @author Luis Ramon
 * @version 1.0.0
 * La entidad sirve para crear el estado o estados (provincias) del pais
 */
@Stateless //ejb sin estado
public class StateDAO {

	@Inject
	private EntityManager em;
	
	public void save(State g) {
		State a=leer(g.getStateId());
		if(a!=null) {
			update(g);
		}else {
			insert(g);
		}
	}
	
	public void insert(State g){
		em.persist(g);
	}
	
	public void update(State g) {
		em.merge(g);
	}
	
	public void delete(int StateId) {
		//State g=leer(StateId);
		State g=em.find(State.class,StateId);
		em.remove(g);
	}
	
	public State leer(int StateId) {
		State g=em.find(State.class, StateId);
		return g;
	}
	
	
	public List<State> listState(){
		Query query=em.createQuery("SELECT g from State g ", State.class);
		List<State> list=query.getResultList();
		return list;
	}
	
}
