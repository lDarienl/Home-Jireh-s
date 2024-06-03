/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.DtoCliente;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author juanes
 */
public class Cliente {
    private ArrayList<DtoCliente> listaClientes;
    private static final String CLIENTES_FILE = "clientes.dat";

    public Cliente() {
        listaClientes = new ArrayList<>();
        cargarArchivo();
    }
    
    //metodo para añadir cliente
    //@param cliente es el cliente a añadir
    //@return un boolean para confirmar la agregacion de un cliente
    public boolean crearCliente(DtoCliente cliente){
        listaClientes.add(cliente);
        return true;
    }
    
    //metodo buscar un cliente
    //@param id es el identidficador de un cliente
    //@return un objeto DtoCliente o null si no existe
    public DtoCliente buscarCliente (int id){
        for (DtoCliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    
    //metodo para eliminar a un cliente
    //@param id es el identificador de un cliente
    //@return true si se elimina un cliente o false si no existe
    public boolean eliminarCliente (int id){
        for (DtoCliente cliente : listaClientes) {
            if (cliente.getId() == id){
                listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }
    
    //metodo para crear instancias de tipo DtoCliente
    /**@param id es el identificador del cliente
     * nombre es el nombre del cliente
     * email es el correo del cliente
     * telefono es el numero celular del cliente
     * direccion es el direccion de la vivienda del cliente
     * @return objeto de tipo DtoCliente
     */
    public DtoCliente crearCliente(int id, String nombre, String email, int telefono, String direccion){
        DtoCliente cliente = new DtoCliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        return cliente;
    }
    
    /**metodo para agrega un referido que ya es un cliente
     * @param idReferido es el identificador del referido
     * idCliente es el id del cliente al que se le agregar el referido
     * @return es true si se agregaun referido
     * es false si el referido no es un cliente
     */
    public boolean agregarReferido (int idCliente,int idReferido){
        int referido = -2;
        int clienteAgregar = -2;
        for (DtoCliente cliente : listaClientes) {
            if (cliente.getId() == idReferido){
                referido = listaClientes.indexOf(cliente);
            }
            if (cliente.getId() == idCliente){
                clienteAgregar = listaClientes.indexOf(cliente);
            }
        }
        if (referido != clienteAgregar){
            listaClientes.get(clienteAgregar).getReferidos().add(listaClientes.get(referido));
            return true;
        }
        return false;
    }
    private void cargarArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CLIENTES_FILE))) {
        listaClientes = (ArrayList<DtoCliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, inicializa la lista de citas
            listaClientes = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
