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
    private panel_control_admin UIAdmin;
    private panel_control_tele UITele;
    private panel_control_vendedor UIVendedor;
    private Agregar_Cliente UIAgregarCliente;
    private Cliente modelo;

    public ClienteControlador(Agregar_Cliente UIAgregarCliente) {
        this.UIAgregarCliente = UIAgregarCliente;
        modelo = new Cliente();
        this.UIAgregarCliente.jButton1.addActionListener(this);
    }

    
    
    public ClienteControlador(panel_control_admin UIAdmin) {
        this.UIAdmin = UIAdmin;
        this.UIAdmin.jButton3.addActionListener(this);
        modelo = new Cliente();
    }

    public ClienteControlador(panel_control_tele UITele) {
        this.UITele = UITele;
        this.UITele.jButton3.addActionListener(this);
        modelo = new Cliente();
    }

    public ClienteControlador(panel_control_vendedor UIVendedor) {
        this.UIVendedor = UIVendedor;
        this.UIVendedor.jButton3.addActionListener(this);
        modelo = new Cliente();
    }
    
    
    
    
    public ClienteControlador(Cliente_Detalle UICliente) {
        this.UICliente = UICliente;
        modelo = new Cliente();
        mostar();
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
        if(UIAdmin.jButton3.equals(e.getSource())){
            UIAgregarCliente.setVisible(true);
        }
        if(UIAgregarCliente.jButton1.equals(e.getSource())){
            modelo.crearCliente(Integer.valueOf(UIAgregarCliente.textID.getText()), UIAgregarCliente.textNombre.getText(), UIAgregarCliente.textEmail.getText(), Integer.valueOf(UIAgregarCliente.textTelefono.getText()), UIAgregarCliente.textDireccion.getText()); 
        }
        if(UIAgregarCliente.botonCerrar.equals(e.getSource())){
            UIAgregarCliente.setVisible(false);
        }
        if(UITele.jButton3.equals(e.getSource())){
            UIAgregarCliente.setVisible(true);
        }
        if(UIVendedor.jButton3.equals(e.getSource())){
            UIAgregarCliente.setVisible(true);
        }
    }
    
}

