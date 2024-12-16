package Controlador;

import Modelo.administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorAdministrador {

    private Connection connection;

    public ControladorAdministrador() {
        this.connection = Conexion.getInstance().getConnection();
    }

    // Método para insertar un administrador
    public boolean insertarAdministrador(administrador administrador) {
        String sql = "INSERT INTO administrador (ID, Email, Contraseña) VALUES (?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, administrador.getID());
            pst.setString(2, administrador.getEmail());
            pst.setString(3, administrador.getContrasena());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar administrador: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un administrador
    public boolean actualizarAdministrador(administrador administrador) {
        String sql = "UPDATE administrador SET Email = ?, Contraseña = ? WHERE ID = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, administrador.getEmail());
            pst.setString(2, administrador.getContrasena());
            pst.setInt(3, administrador.getID());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar administrador: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un administrador
    public boolean eliminarAdministrador(int id) {
        String sql = "DELETE FROM administrador WHERE ID = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar administrador: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los administradores
    public List<administrador> obtenerAdministradores() {
        List<administrador> lista = new ArrayList<>();
        String sql = "SELECT * FROM administrador";

        try (PreparedStatement pst = connection.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                administrador administrador = new administrador();
                administrador.setID(rs.getInt("ID"));
                administrador.setEmail(rs.getString("Email"));
                administrador.setContrasena(rs.getString("Contraseña"));

                lista.add(administrador);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener administradores: " + e.getMessage());
        }

        return lista;
    }

    // Método para buscar un administrador por su ID
    public administrador buscarAdministradorPorID(int id) {
        String sql = "SELECT * FROM administrador WHERE ID = ?";
        administrador administrador = null;

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    administrador = new administrador();
                    administrador.setID(rs.getInt("ID"));
                    administrador.setEmail(rs.getString("Email"));
                    administrador.setContrasena(rs.getString("Contraseña"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar administrador: " + e.getMessage());
        }

        return administrador;
    }
}

