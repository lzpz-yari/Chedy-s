package Controlador;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorCliente {

    private Connection connection;

    public ControladorCliente() {
        this.connection = Conexion.getInstance().getConnection();
    }

    // Método para insertar un cliente
    public boolean insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (ID, Nombre, Apellido_Paterno, Apellido_Materno, Numero_Telefono) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, cliente.getID());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido_Paterno());
            pst.setString(4, cliente.getApellido_Materno());
            pst.setString(5, cliente.getNumero_Telefono());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un cliente
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Numero_Telefono = ? WHERE ID = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido_Paterno());
            pst.setString(3, cliente.getApellido_Materno());
            pst.setString(4, cliente.getNumero_Telefono());
            pst.setInt(5, cliente.getID());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un cliente
    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM cliente WHERE ID = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (PreparedStatement pst = connection.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("ID"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                cliente.setApellido_Materno(rs.getString("Apellido_Materno"));
                cliente.setNumero_Telefono(rs.getString("Numero_Telefono"));

                lista.add(cliente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.getMessage());
        }

        return lista;
    }

    // Método para buscar un cliente por su ID
    public Cliente buscarClientePorID(int id) {
        String sql = "SELECT * FROM cliente WHERE ID = ?";
        Cliente cliente = null;

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setID(rs.getInt("ID"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                    cliente.setApellido_Materno(rs.getString("Apellido_Materno"));
                    cliente.setNumero_Telefono(rs.getString("Numero_Telefono"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente: " + e.getMessage());
        }

        return cliente;
    }
}
