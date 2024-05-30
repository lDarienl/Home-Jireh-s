/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.VendedorControlador;
import dto.DtoVenta;
import dto.DtoCliente;
import dto.DtoEmpleado;
import dto.DtoProducto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Darien
 * IGNORAR ESTE CODIGO ES DE PRUEBA NO ES NINGUNA VISTA NI NADA
 */
public class PruebaParaVentasSinVista {
    
    public static void main(String[] args) {
        // Crear una instancia del controlador
        VendedorControlador controlador = new VendedorControlador();

        // Crear algunos objetos de cliente, productos y vendedor para las pruebas
        DtoCliente cliente = new DtoCliente();
        cliente.setNombre("Juan Perez");
        cliente.setEmail("juan.perez@example.com");
        cliente.setTelefono("123456789");

        DtoProducto producto1 = new DtoProducto();
        producto1.setIdProducto(1);
        producto1.setNombreProducto("Producto 1");
        producto1.setDescripcion("Descripción del Producto 1");
        producto1.setPrecio(100.0);
        producto1.setCantidad(2);

        DtoProducto producto2 = new DtoProducto();
        producto2.setIdProducto(2);
        producto2.setNombreProducto("Producto 2");
        producto2.setDescripcion("Descripción del Producto 2");
        producto2.setPrecio(200.0);
        producto2.setCantidad(1);

        ArrayList<DtoProducto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        DtoEmpleado vendedor = new DtoEmpleado();
        vendedor.setId(1);
        vendedor.setNombre("Carlos Lopez");
        vendedor.setEmail("carlos.lopez@example.com");
        vendedor.setRol("Vendedor");
        vendedor.setPassword("password123");

        // Registrar una nueva venta
        controlador.registrarVenta(1, LocalDate.now(), cliente, productos, vendedor);

        // Ver todas las ventas
        List<DtoVenta> ventas = controlador.verVentas();
        System.out.println("Todas las ventas:");
        for (DtoVenta venta : ventas) {
            System.out.println(venta);
        }

        // Buscar una venta por ID
        DtoVenta ventaBuscada = controlador.ventaDao.leerVenta(1);
        System.out.println("Venta buscada por ID 1:");
        if (ventaBuscada != null) {
            System.out.println(ventaBuscada);
        } else {
            System.out.println("Venta no encontrada.");
        }

        // Modificar una venta
        DtoProducto producto3 = new DtoProducto();
        producto3.setIdProducto(3);
        producto3.setNombreProducto("Producto 3");
        producto3.setDescripcion("Descripción del Producto 3");
        producto3.setPrecio(150.0);
        producto3.setCantidad(1);

        productos.add(producto3);
        DtoVenta ventaModificada = ventaBuscada;
        ventaModificada.setProductos(productos);
        ventaModificada.calcularTotal();
        controlador.modificarVenta(ventaModificada);

        // Verificar la modificación
        ventas = controlador.verVentas();
        System.out.println("Ventas después de la modificación:");
        for (DtoVenta venta : ventas) {
            System.out.println(venta);
        }

        // Eliminar una venta
        controlador.eliminarVenta(1);

        // Verificar la eliminación
        ventas = controlador.verVentas();
        System.out.println("Ventas después de la eliminación:");
        for (DtoVenta venta : ventas) {
            System.out.println(venta);
        }
    }
}
