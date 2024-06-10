/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.Cliente;
import dto.DtoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Cliente_Detalle;
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
    
    public void mostar(DtoCliente clien){
        UICliente.setVisible(true);
        UICliente.botonCerrar.addActionListener(this);
        UICliente.textID.setText(String.valueOf(clien.getId()));
        UICliente.textNombre.setText(clien.getNombre());
        UICliente.textEmail.setText(clien.getEmail());
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
