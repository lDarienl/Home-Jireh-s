/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.DtoVenta;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darien
 */
public class VentaDao {
    
    // Lista de ventas
    private List<DtoVenta> ventas;
    private static final String VENTAS_FILE = "ventas.dat";

    // Constructor que carga las ventas desde un archivo
    public VentaDao() {
        ventas = new ArrayList<>();
        cargarArchivo();
    }

    // Método para crear una nueva venta
    public void crearVenta(DtoVenta venta) {
        ventas.add(venta);
        guardarArchivo();
    }

    // Método para leer una venta por ID
    public DtoVenta leerVenta(int idVenta) {
        for (DtoVenta venta : ventas) {
            if (venta.getIdVenta() == idVenta) {
                return venta;
            }
        }
        return null;
    }

    // Método para modificar una venta
    public void modificarVenta(DtoVenta updatedVenta) {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getIdVenta() == updatedVenta.getIdVenta()) {
                ventas.set(i, updatedVenta);
                guardarArchivo();
                return;
            }
        }
    }

    // Método para eliminar una venta
    public void eliminarVenta(int idVenta) {
        ventas.removeIf(venta -> venta.getIdVenta() == idVenta);
        guardarArchivo();
    }
    
    // Método para obtener todas las ventas
    public List<DtoVenta> todasLasVentas() {
        return ventas;
    }

    // Método para cargar las ventas desde un archivo
    private void cargarArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(VENTAS_FILE))) {
        ventas = (ArrayList<DtoVenta>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, inicializa la lista de citas
            ventas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar las ventas en un archivo
    private void guardarArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VENTAS_FILE))) {
            oos.writeObject(ventas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}