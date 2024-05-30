/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Darien
 */
public class DtoVenta implements Serializable {
        private static final long serialVersionUID = 1539366525266020330L;

    
    // Atributos de Venta
    private int idVenta;
    private LocalDate fecha;
    private DtoCliente cliente;
    private ArrayList<DtoProducto> productos;
    private DtoEmpleado vendedor;
    private double total;

    // Método para calcular el total de la venta
    public double calcularTotal() {
        double total = 0;
        for (DtoProducto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
    
    // Getters y setters para los atributos
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public ArrayList<DtoProducto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<DtoProducto> productos) {
        this.productos = productos;
    }

    public DtoEmpleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(DtoEmpleado vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

}

