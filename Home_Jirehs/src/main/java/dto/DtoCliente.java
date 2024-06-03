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
public class DtoCliente implements Serializable {
        private static final long serialVersionUID = 1L;

    
    // Atributos del producto
    private int id;
    private String nombre;
    private String email;
    private int telefono;
    private String direccion;
    private ArrayList<DtoCliente> referidos = new ArrayList<>();

    // Getters y setters para los atributos
    
        public String getDireccion(){
            return direccion;
        }
        
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    
        public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
        
	public String getNombre() {
		return nombre;
	}

        public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

    public ArrayList<DtoCliente> getReferidos() {
        return referidos;
    }

    public void setReferidos(ArrayList<DtoCliente> referidos) {
        this.referidos = referidos;
    }

    @Override
    public String toString() {
        return "DtoCliente{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", referidos=" + referidos + '}';
    }
         
    

    
}

