package Controlador;

import Modelo.cajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorCajero {

    private Connection connection;

    public ControladorCajero() {
        this.connection = Conexion.getInstance().getConnection();
    }

    // Método para insertar un cajero
    public boolean insertarCajero(cajero cajero) {
        String sql = "INSERT INTO cajeros (ID, Email, Contrasena, EmpleadoID) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, cajero.getID());
            pst.setString(2, cajero.getEmail());
            pst.setString(3, cajero.getContrasena());
            pst.setString(4, cajero.getEmpleadoID());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cajero: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un cajero
    public boolean actualizarCajero(cajero cajero) {
        String sql = "UPDATE cajeros SET Email = ?, Contrasena = ?, EmpleadoID = ? WHERE ID = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, cajero.getEmail());
            pst.setString(2, cajero.getContrasena());
            pst.setString(3, cajero.getEmpleadoID());
            pst.setInt(4, cajero.getID());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cajero: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un cajero
    public boolean eliminarCajero(int id) {
        String sql = "DELETE FROM cajeros WHERE ID = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cajero: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los cajeros
    public List<cajero> obtenerCajeros() {
        List<cajero> lista = new ArrayList<>();
        String sql = "SELECT * FROM cajeros";

        try (PreparedStatement pst = connection.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                cajero cajero = new cajero();
                cajero.setID(rs.getInt("ID"));
                cajero.setEmail(rs.getString("Email"));
                cajero.setContrasena(rs.getString("Contrasena"));
                cajero.setEmpleadoID(rs.getString("EmpleadoID"));

                lista.add(cajero);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cajeros: " + e.getMessage());
        }

        return lista;
    }

    // Método para buscar un cajero por su ID
    public cajero buscarCajeroPorID(int id) {
        String sql = "SELECT * FROM cajeros WHERE ID = ?";
        cajero cajero = null;

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    cajero = new cajero();
                    cajero.setID(rs.getInt("ID"));
                    cajero.setEmail(rs.getString("Email"));
                    cajero.setContrasena(rs.getString("Contrasena"));
                    cajero.setEmpleadoID(rs.getString("EmpleadoID"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cajero: " + e.getMessage());
        }

        return cajero;
    }
}
