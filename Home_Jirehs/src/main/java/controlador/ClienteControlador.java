/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.Cliente;
import dto.DtoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
/**
 *
 * @author juanes
 */
public class ClienteControlador implements ActionListener{
    private DtoCliente cliente;
    private Cliente_Detalle UICliente;
    private Cliente modelo;

    public ClienteControlador(Cliente_Detalle UICliente) {
        this.UICliente = UICliente;
        modelo = new Cliente();
        UICliente.botonCerrar.addActionListener(this);
    }
    //metodo para mostar los datos de un cliente
    public void mostar(){
        UICliente.setVisible(true);
        UICliente.textID.setText(String.valueOf(cliente.getId()));
        UICliente.textNombre.setText(cliente.getNombre());
        UICliente.textEmail.setText(cliente.getEmail());
        UICliente.textReferido.setText(String.valueOf(cliente.cantidadReferidos()));
        UICliente.textDireccion.setText(cliente.getDireccion());
    }
    
    //metodo para asignar un cliente
    public void setCliente(DtoCliente cliente){
        this.cliente = cliente;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(UICliente.botonCerrar.equals(e.getSource())){
            UICliente.setVisible(false);
        }
    }
    
}
