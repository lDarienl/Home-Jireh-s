/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.home_jirehs;


import controlador.VendedorControlador;
import controlador.TelemarketingControlador;
import dto.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Darien
 */


public class Home_Jirehs {

    public static void main(String[] args) {
        
        // Controladores
        VendedorControlador vendedorControlador = new VendedorControlador();
        TelemarketingControlador telemarketingControlador = new TelemarketingControlador();

        // Crear cliente y productos
        DtoCliente cliente = new DtoCliente();
        cliente.setId(1);
        cliente.setNombre("Juan Perez");
        cliente.setDireccion("Av. Siempre Viva 742");

        DtoProducto producto1 = new DtoProducto();
        producto1.setIdProducto(1);
        producto1.setNombreProducto("Producto 1");
        producto1.setPrecio(100.0);
        producto1.setCantidad(2);

        DtoProducto producto2 = new DtoProducto();
        producto2.setIdProducto(2);
        producto2.setNombreProducto("Producto 2");
        producto2.setPrecio(50.0);
        producto2.setCantidad(1);

        ArrayList<DtoProducto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        // Crear empleado
        DtoEmpleado vendedor = new DtoEmpleado();
        vendedor.setId(1);
        vendedor.setNombre("Vendedor 1");

        // Registrar venta
        vendedorControlador.registrarVenta(1, LocalDate.now(), cliente, productos, vendedor);

        // Mostrar ventas
        System.out.println("Ventas registradas:");
        for (DtoVenta venta : vendedorControlador.verVentas()) {
            System.out.println("ID Venta: " + venta.getIdVenta() + ", Cliente: " + venta.getCliente().getNombre() + ", Total: " + venta.getTotal());
        }

        // Agendar cita
        DtoEmpleado telemarketer = new DtoEmpleado();
        telemarketer.setId(2);
        telemarketer.setNombre("Telemarketer 1");

        telemarketingControlador.agendarCita(1, LocalDate.now().plusDays(1), cliente, telemarketer);

        // Mostrar citas
        System.out.println("Citas agendadas:");
        for (DtoCita cita : telemarketingControlador.verCitas()) {
            System.out.println("ID Cita: " + cita.getIdCita() + ", Cliente: " + cita.getCliente().getNombre() + ", Fecha: " + cita.getFecha());
        }
    }
}