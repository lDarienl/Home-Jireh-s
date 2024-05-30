/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.TelemarketingDao;
import dto.DtoCita;
import dto.DtoCliente;
import dto.DtoEmpleado;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Darie
 */
public class TelemarketingControlador {
 
    public TelemarketingDao telemarketingDao;

    public TelemarketingControlador() {
        telemarketingDao = new TelemarketingDao();
    }
    
    public void agendarCita(int idCita, LocalDate fecha, DtoCliente cliente, DtoEmpleado telemarketing) {
        DtoCita nuevaCita = new DtoCita();
        nuevaCita.setIdCita(idCita);
        nuevaCita.setFecha(fecha);
        nuevaCita.setCliente(cliente);
        nuevaCita.setTelemarketing(telemarketing);
        nuevaCita.setEstado(false); // Estado false indica que la cita no ha sido realizada
        telemarketingDao.agregarCita(nuevaCita);
    }

    public void modificarCita(DtoCita cita) {
        telemarketingDao.modificarCita(cita);
    }

    public void eliminarCita(int idCita) {
        telemarketingDao.eliminarCita(idCita);
    }

    public List<DtoCita> verCitas() {
        return telemarketingDao.todasLasCitas();
    }

    public List<DtoCita> buscarCitasPorEmpleado(DtoEmpleado empleado) {
        return telemarketingDao.citasPorEmpleado(empleado);
    }

}