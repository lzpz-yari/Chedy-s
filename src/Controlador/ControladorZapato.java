package Controlador;

import Modelo.Zapato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorZapato {

    private Connection connection;

    public ControladorZapato() {
        this.connection = Conexion.getInstance().getConnection();
    }

    // Método para insertar un zapato
    public boolean insertarZapato(Zapato zapato) {
        String sql = "INSERT INTO zapato (estilo, modelo, marca, color, talla, cantidad, precio, tipo) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, zapato.getEstilo());
            pst.setString(2, zapato.getModelo());
            pst.setString(3, zapato.getMarca());
            pst.setString(4, zapato.getColor());
            pst.setDouble(5, zapato.getTalla());
            pst.setInt(6, zapato.getCantidad());
            pst.setDouble(7, zapato.getPrecio());
            pst.setString(8, zapato.getTipo());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar zapato: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un zapato
    public boolean actualizarZapato(Zapato zapato) {
        String sql = "UPDATE zapato SET modelo = ?, marca = ?, color = ?, talla = ?, cantidad = ?, precio = ?, tipo = ? "
                   + "WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, zapato.getModelo());
            pst.setString(2, zapato.getMarca());
            pst.setString(3, zapato.getColor());
            pst.setDouble(4, zapato.getTalla());
            pst.setInt(5, zapato.getCantidad());
            pst.setDouble(6, zapato.getPrecio());
            pst.setString(7, zapato.getTipo());
            pst.setInt(8, zapato.getEstilo());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar zapato: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un zapato
    public boolean eliminarZapato(int estilo) {
        String sql = "DELETE FROM zapato WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, estilo);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar zapato: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los zapatos
    public List<Zapato> obtenerZapatos() {
        List<Zapato> lista = new ArrayList<>();
        String sql = "SELECT * FROM zapato";

        try (PreparedStatement pst = connection.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Zapato zapato = new Zapato();
                zapato.setEstilo(rs.getInt("estilo"));
                zapato.setModelo(rs.getString("modelo"));
                zapato.setMarca(rs.getString("marca"));
                zapato.setColor(rs.getString("color"));
                zapato.setTalla(rs.getDouble("talla"));
                zapato.setCantidad(rs.getInt("cantidad"));
                zapato.setPrecio(rs.getDouble("precio"));
                zapato.setTipo(rs.getString("tipo"));

                lista.add(zapato);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener zapatos: " + e.getMessage());
        }

        return lista;
    }

    // Método para buscar un zapato por su estilo (ID)
    public Zapato buscarZapatoPorEstilo(int estilo) {
        String sql = "SELECT * FROM zapato WHERE estilo = ?";
        Zapato zapato = null;

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, estilo);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    zapato = new Zapato();
                    zapato.setEstilo(rs.getInt("estilo"));
                    zapato.setModelo(rs.getString("modelo"));
                    zapato.setMarca(rs.getString("marca"));
                    zapato.setColor(rs.getString("color"));
                    zapato.setTalla(rs.getDouble("talla"));
                    zapato.setCantidad(rs.getInt("cantidad"));
                    zapato.setPrecio(rs.getDouble("precio"));
                    zapato.setTipo(rs.getString("tipo"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar zapato: " + e.getMessage());
        }

        return zapato;
    }
}
