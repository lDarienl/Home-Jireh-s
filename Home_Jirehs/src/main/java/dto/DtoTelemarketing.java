/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Darien
 */
public class DtoTelemarketing implements Serializable{
        private static final long serialVersionUID = 1L;

    
    // Atributos de Telemarketing
    private ArrayList<DtoCita> listaCitas;
    private DtoEmpleado empleado;

    public DtoTelemarketing() {
        listaCitas = new ArrayList<>();
    }

    public ArrayList<DtoCita> getListaCitas() {
        return listaCitas;
    }
    
    // Getters y setters para los atributos
    public DtoEmpleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(DtoEmpleado empleado) {
        this.empleado = empleado;
    }
    
    public void setListaCitas(ArrayList<DtoCita> listaCitas) {
        this.listaCitas = listaCitas;
    }

}
