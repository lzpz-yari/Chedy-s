/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author ep972
 */
public class Transacciones {
    int ID;
    String modelo;
    double precio;
    int cantidad;
    String forma_Pago;
    int id_cajero;
    Date fecha_Hora;
    double total;
    
    public Transacciones (){
        
    }

    public Transacciones(int ID, String modelo, double precio, int cantidad, String forma_Pago, int id_cajero, Date fecha_Hora, double total) {
        this.ID = ID;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.forma_Pago = forma_Pago;
        this.id_cajero = id_cajero;
        this.fecha_Hora = fecha_Hora;
        this.total = total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getForma_Pago() {
        return forma_Pago;
    }

    public void setForma_Pago(String forma_Pago) {
        this.forma_Pago = forma_Pago;
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    public Date getFecha_Hora() {
        return fecha_Hora;
    }

    public void setFecha_Hora(Date fecha_Hora) {
        this.fecha_Hora = fecha_Hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
