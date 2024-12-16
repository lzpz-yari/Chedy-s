/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ep972
 */
public class Cliente {

    private int ID;
    private String Nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String Numero_Telefono;

    public Cliente() {

    }

    public Cliente(int ID, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Numero_Telefono) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido_Paterno = Apellido_Paterno;
        this.Apellido_Materno = Apellido_Materno;
        this.Numero_Telefono = Numero_Telefono;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
}
