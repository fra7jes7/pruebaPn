package mac.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mac.entidades.Ticket;

@Stateless
public class ServicioTickets {
	@PersistenceContext
	private EntityManager em;

	public void insertar(Ticket obj) {
		em.persist(obj);
	}

	public void eliminar(Ticket obj) {
		em.remove(em.merge(obj));
	}
	
	public void editarTicket(Ticket obj) {
		em.merge(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> recuperaTicket() {
		String sql = "SELECT * FROM tickets";
		System.out.println("---query: " + sql);
		Query q = em.createNativeQuery(sql, Ticket.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> openTicket() {
		String sql = "SELECT * FROM tickets where estado='Abierto'";
		System.out.println("---query: " + sql);
		Query q = em.createNativeQuery(sql, Ticket.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> closedTicket() {
		String sql = "SELECT * FROM tickets where estado='Cerrado'";
		System.out.println("---query: " + sql);
		Query q = em.createNativeQuery(sql, Ticket.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> escaladoTicket() {
		String sql = "SELECT * FROM tickets where estado='Escalado'";
		System.out.println("---query: " + sql);
		Query q = em.createNativeQuery(sql, Ticket.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> prioridadTicket() {
		String sql = "SELECT * FROM tickets where prioridad='Alta'";
		System.out.println("---query: " + sql);
		Query q = em.createNativeQuery(sql, Ticket.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> vencidoTicket() {
		String sql = "SELECT * FROM tickets where fecha_vencimiento <= sysdate";
		System.out.println("---query: " + sql);
		Query q = em.createNativeQuery(sql, Ticket.class);
		return q.getResultList();
	}

}
