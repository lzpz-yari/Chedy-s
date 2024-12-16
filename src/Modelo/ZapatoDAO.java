package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ZapatoDAO {
    private Connection con;

    public ZapatoDAO() {
        con = Conexion.getInstance().getConnection(); // Se asume que tienes la clase Conexion para gestionar la conexión a DB
    }

    public boolean actualizarZapato(Zapato zapato) {
        String sql = "UPDATE zapato SET modelo = ?, marca = ?, talla = ?, cantidad = ?, precio = ? WHERE modelo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, zapato.getModelo());
            ps.setString(2, zapato.getMarca());
            ps.setDouble(3, zapato.getTalla());
            ps.setInt(4, zapato.getCantidad());
            ps.setDouble(5, zapato.getPrecio());
            ps.setString(6, zapato.getModelo()); // Suponemos que el modelo es único

            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0; // Retorna true si al menos una fila fue actualizada
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }
}
