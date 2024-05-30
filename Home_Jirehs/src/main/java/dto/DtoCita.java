package dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DtoCita implements Serializable{
        private static final long serialVersionUID = 4966509248143027994L;
    
    // Atributos de Citas
    
    private int idCita;
    private LocalDate fecha;
    private DtoCliente cliente;
    private DtoEmpleado telemarketing;  
    private boolean estado;

    // Getters y setters para los atributos
	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public DtoCliente getCliente() {
		return cliente;
	}

	public void setCliente(DtoCliente cliente) {
		this.cliente = cliente;
	}

	public DtoEmpleado getTelemarketing() {
		return telemarketing;
	}

	public void setTelemarketing(DtoEmpleado telemarketing) {
		this.telemarketing = telemarketing;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
  