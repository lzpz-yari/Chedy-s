/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ep972
 */
public class Proveedor {
    String RFC;
    String Nombre;
    String Apellido_Paterno;
    String Apellido_Materno;
    String Numero_Telefono;
    String Email;
    String Numero_Lote;
    String fecha;
    
    public Proveedor(){
        
    }

    public Proveedor(String RFC, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Numero_Telefono, String Email, String Numero_Lote, String fecha) {
        this.RFC = RFC;
        this.Nombre = Nombre;
        this.Apellido_Paterno = Apellido_Paterno;
        this.Apellido_Materno = Apellido_Materno;
        this.Numero_Telefono = Numero_Telefono;
        this.Email = Email;
        this.Numero_Lote = Numero_Lote;
        this.fecha = fecha;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }

    public String getNumero_Telefono() {
        return Numero_Telefono;
    }

    public void setNumero_Telefono(String Numero_Telefono) {
        this.Numero_Telefono = Numero_Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNumero_Lote() {
        return Numero_Lote;
    }

    public void setNumero_Lote(String Numero_Lote) {
        this.Numero_Lote = Numero_Lote;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
