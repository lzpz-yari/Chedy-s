
package Modelo;

public class Zapato {
    int estilo;
    String modelo;
    String marca;
    String color;
    Double talla;
    int cantidad;
    Double precio;
    String tipo;
    
    public Zapato(){
        
    }

    public Zapato(int estilo, String modelo, String marca, String color, Double talla, int cantidad, Double precio, String tipo) {
        this.estilo = estilo;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
