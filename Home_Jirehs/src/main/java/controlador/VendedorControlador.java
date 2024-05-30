/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import dao.VentaDao;
import dto.DtoVenta;
import dto.DtoCliente;
import dto.DtoEmpleado;
import dto.DtoProducto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author Darien
 */
public class VendedorControlador {
 
    // Instancia de VentaDao
    public VentaDao ventaDao;

    // Constructor que inicializa la instancia de VentaDao
    public VendedorControlador() {
        ventaDao = new VentaDao();
    }

    // Método para registrar una nueva venta
    public void registrarVenta(int idVenta, LocalDate fecha, DtoCliente cliente, ArrayList<DtoProducto> productos, DtoEmpleado vendedor) {
        DtoVenta nuevaVenta = new DtoVenta();
        nuevaVenta.setIdVenta(idVenta);
        nuevaVenta.setFecha(fecha);
        nuevaVenta.setCliente(cliente);
        nuevaVenta.setProductos(productos);
        nuevaVenta.setVendedor(vendedor);
        nuevaVenta.calcularTotal();
        ventaDao.crearVenta(nuevaVenta);
    }

    // Método para modificar una venta
    public void modificarVenta(DtoVenta venta) {
        ventaDao.modificarVenta(venta);
    }

    // Método para eliminar una venta
    public void eliminarVenta(int idVenta) {
        ventaDao.eliminarVenta(idVenta);
    }

    // Método para ver todas las ventas
    public List<DtoVenta> verVentas() {
        return ventaDao.todasLasVentas();
    }

    // Método para buscar una venta por cliente
    public List<DtoVenta> buscarVentasPorCliente(String nombreCliente) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getCliente().getNombre().equalsIgnoreCase(nombreCliente))
                .collect(Collectors.toList());
    }

    // Método para buscar una venta por ID
    public List<DtoVenta> buscarVentasPorId(int idVenta) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getIdVenta() == idVenta)
                .collect(Collectors.toList());
    }

    // Método para buscar una venta por producto
    public List<DtoVenta> buscarVentasPorProducto(String nombreProducto) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getProductos().stream()
                        .anyMatch(producto -> producto.getNombreProducto().equalsIgnoreCase(nombreProducto)))
                .collect(Collectors.toList());
    }

    // Método para buscar una venta por fecha
    public List<DtoVenta> buscarVentasPorFecha(LocalDate fecha) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getFecha().isEqual(fecha))
                .collect(Collectors.toList());
    }
    
    // Método para buscar una venta por vendedor
    public List<DtoVenta> buscarVentasPorVendedor(String nombreVendedor) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getVendedor().getNombre().equalsIgnoreCase(nombreVendedor))
                .collect(Collectors.toList());
    }
}

