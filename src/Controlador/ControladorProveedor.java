/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ep972
 */
public class ControladorProveedor {
      private Connection con = Conexion.getInstance().getConnection();
      
       public boolean agregarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (RFC, Nombre, Apellido_Paterno, Apellido_Materno, Numero_Telefono, Correo, Numero_Lote, Fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, proveedor.getRFC());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getApellido_Paterno());
            ps.setString(4, proveedor.getApellido_Materno());
            ps.setString(5, proveedor.getNumero_Telefono());
            ps.setString(6, proveedor.getEmail());
            ps.setString(7, proveedor.getNumero_Lote());
            ps.setString(8, proveedor.getFecha());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar proveedor: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los proveedores
    public List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try (Connection con = Conexion.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setRFC(rs.getString("RFC"));
                proveedor.setNombre(rs.getString("Nombre"));
                proveedor.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                proveedor.setApellido_Materno(rs.getString("Apellido_Materno"));
                proveedor.setNumero_Telefono(rs.getString("Numero_Telefono"));
                proveedor.setEmail(rs.getString("Correo"));
                proveedor.setNumero_Lote(rs.getString("Numero_Lote"));
                proveedor.setFecha(rs.getString("Fecha"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los proveedores: " + e.getMessage());
        }
        return proveedores;
    }

    // Método para actualizar un proveedor en la base de datos
    public boolean actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Numero_Telefono = ?, Correo = ?, Numero_Lote = ?, Fecha = ? WHERE RFC = ?";
        try (Connection con = Conexion.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getApellido_Paterno());
            ps.setString(3, proveedor.getApellido_Materno());
            ps.setString(4, proveedor.getNumero_Telefono());
            ps.setString(5, proveedor.getEmail());
            ps.setString(6, proveedor.getNumero_Lote());
            ps.setString(7, proveedor.getFecha());
            ps.setString(8, proveedor.getRFC());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar proveedor: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un proveedor de la base de datos
    public boolean eliminarProveedor(String RFC) {
        String sql = "DELETE FROM proveedor WHERE RFC = ?";
        try (Connection con = Conexion.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, RFC);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar proveedor: " + e.getMessage());
            return false;
        }
    }

      
}
