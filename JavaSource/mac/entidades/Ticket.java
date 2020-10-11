package mac.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sec_tickets")
	@SequenceGenerator(sequenceName = "sec_tickets", name = "sec_tickets", initialValue = 1, allocationSize = 1000)
	
	@Column(name = "id_tickets")
	private Integer id_tickets;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "prioridad")
	private String prioridad;
	
	@Column(name = "duenio_caso")
	private String duenio_caso;
	
	@Column(name = "fecha_vencimiento")
	private Date fecha_vencimiento;
	
	@Column(name = "ofertas")
	private String ofertas;

	public Integer getId_tickets() {
		return id_tickets;
	}

	public void setId_tickets(Integer id_tickets) {
		this.id_tickets = id_tickets;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getDuenio_caso() {
		return duenio_caso;
	}

	public void setDuenio_caso(String duenio_caso) {
		this.duenio_caso = duenio_caso;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getOfertas() {
		return ofertas;
	}

	public void setOfertas(String ofertas) {
		this.ofertas = ofertas;
	}
	
	

}
