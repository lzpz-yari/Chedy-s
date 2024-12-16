/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ep972
 */
public class Devoluciones {

    private int id;
    private int id_transaccion;
    private String modelo;
    private int cantidad;
    private double precio;
    private Timestamp fecha_hora;

    public Devoluciones() {

    }

    public Devoluciones(int id, int id_transaccion, String modelo, int cantidad, double precio, Timestamp fecha_hora) {
        this.id = id;
        this.id_transaccion = id_transaccion;
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha_hora = fecha_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

}