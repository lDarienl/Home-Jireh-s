/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.DtoCita;
import dto.DtoEmpleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darie
 */
public class TelemarketingDao {
    
    private List<DtoCita> citas;
    private static final String CITAS_FILE = "citas.dat";

    public TelemarketingDao() {
        citas = new ArrayList<>();
        cargarArchivo();
    }

    public void agregarCita(DtoCita cita) {
        citas.add(cita);
        guardarArchivo();
    }

    public DtoCita obtenerCita(int idCita) {
        for (DtoCita cita : citas) {
            if (cita.getIdCita() == idCita) {
                return cita;
            }
        }
        return null;
    }

    public void modificarCita(DtoCita updatedCita) {
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getIdCita() == updatedCita.getIdCita()) {
                citas.set(i, updatedCita);
                guardarArchivo();
                return;
            }
        }
    }

    public void eliminarCita(int idCita) {
        citas.removeIf(cita -> cita.getIdCita() == idCita);
        guardarArchivo();
    }

    public List<DtoCita> citasPorEmpleado(DtoEmpleado empleado) {
        List<DtoCita> citasEmpleado = new ArrayList<>();
        for (DtoCita cita : citas) {
            if (cita.getTelemarketing().getId() == empleado.getId()) {
                citasEmpleado.add(cita);
            }
        }
        return citasEmpleado;
    }

    public List<DtoCita> todasLasCitas() {
        return citas;
    }

    private void cargarArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CITAS_FILE))) {
        citas = (ArrayList<DtoCita>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, inicializa la lista de citas
            citas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CITAS_FILE))) {
            oos.writeObject(citas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
