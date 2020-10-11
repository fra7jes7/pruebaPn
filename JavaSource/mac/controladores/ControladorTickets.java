package mac.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

import mac.entidades.Ticket;
import mac.servicios.ServicioTickets;

@ViewScoped
@ManagedBean
public class ControladorTickets {

	@EJB
	ServicioTickets srvTickets;

	private Ticket objTicketIngreso;
	private List<Ticket> lstTicket;
	private String filtro;

	public ControladorTickets() {
		objTicketIngreso = new Ticket();
		lstTicket = new ArrayList<Ticket>();
		filtro = new String();
	}

	public void guardarTicket() {
		System.out.println("guardar ticket");
		objTicketIngreso.setEstado("Abierto");
		srvTickets.insertar(objTicketIngreso);
		objTicketIngreso = new Ticket();
		PrimeFaces.current().executeScript("PF('dlgModReg').hide();");

	}

	public void eliminarRegistro(Ticket obj) {
		System.out.println("eliminar registro");
		srvTickets.eliminar(obj);
		lstTicket = new ArrayList<Ticket>();
		lstTicket = srvTickets.recuperaTicket();

	}

	public void onRowEdit(RowEditEvent<Ticket> event) {
		System.out.println("modificar");
		srvTickets.editarTicket(event.getObject());
		lstTicket = new ArrayList<Ticket>();
		lstTicket = srvTickets.recuperaTicket();
	}

	public void filtroTickets() {
		System.out.println("filtro");
		lstTicket = new ArrayList<Ticket>();

		if (filtro.equals("All tickets")) {
			lstTicket = srvTickets.recuperaTicket();
		} else if (filtro.equals("Open tickets")) {
			lstTicket = srvTickets.openTicket();

		} else if (filtro.equals("Closed tickets")) {
			lstTicket = srvTickets.closedTicket();

		} else if (filtro.equals("Overdue tickets")) {
			lstTicket = srvTickets.vencidoTicket();

		} else if (filtro.equals("Escalated Tickets")) {
			lstTicket = srvTickets.escaladoTicket();

		} else if (filtro.equals("High Priority Tickets")) {
			lstTicket = srvTickets.prioridadTicket();

		}
	}

	public void onRowCancel(RowEditEvent<Ticket> event) {
		System.out.println("onRowCancel");
	}

	public void allTicket() {
		lstTicket = srvTickets.recuperaTicket();
	}

	public Ticket getObjTicketIngreso() {
		return objTicketIngreso;
	}

	public void setObjTicketIngreso(Ticket objTicketIngreso) {
		this.objTicketIngreso = objTicketIngreso;
	}

	public List<Ticket> getLstTicket() {
		return lstTicket;
	}

	public void setLstTicket(List<Ticket> lstTicket) {
		this.lstTicket = lstTicket;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
