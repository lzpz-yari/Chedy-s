/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ep972
 */
public class cajero {

    private int ID;
    private String Email;
    private String Contrasena;
    private String EmpleadoID;
    
    public cajero(){
        
    }

    public cajero(int ID, String Email, String Contrasena, String EmpleadoID) {
        this.ID = ID;
        this.Email = Email;
        this.Contrasena = Contrasena;
        this.EmpleadoID = EmpleadoID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(String EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

}
