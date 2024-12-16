package Controlador;

import Modelo.Transacciones;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorTransacciones {

    private Connection connection;

    public ControladorTransacciones() {
        this.connection = Conexion.getInstance().getConnection();
    }

    // Método para insertar una nueva transacción
    public boolean insertarTransaccion(Transacciones transaccion) {
        String sql = "INSERT INTO transacciones (modelo, precio, cantidad, forma_pago, id_cajero, fecha_hora, total) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, transaccion.getModelo());
            pst.setDouble(2, transaccion.getPrecio());
            pst.setInt(3, transaccion.getCantidad());
            pst.setString(4, transaccion.getForma_Pago());
            pst.setInt(5, transaccion.getId_cajero());
            pst.setTimestamp(6, new Timestamp(transaccion.getFecha_Hora().getTime())); // Convertir java.util.Date a Timestamp
            pst.setDouble(7, transaccion.getTotal());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar una transacción existente
    public boolean actualizarTransaccion(Transacciones transaccion) {
        String sql = "UPDATE transacciones SET modelo = ?, precio = ?, cantidad = ?, forma_pago = ?, id_cajero = ?, fecha_hora = ?, total = ? "
                   + "WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, transaccion.getModelo());
            pst.setDouble(2, transaccion.getPrecio());
            pst.setInt(3, transaccion.getCantidad());
            pst.setString(4, transaccion.getForma_Pago());
            pst.setInt(5, transaccion.getId_cajero());
            pst.setTimestamp(6, new Timestamp(transaccion.getFecha_Hora().getTime())); // Convertir java.util.Date a Timestamp
            pst.setDouble(7, transaccion.getTotal());
            pst.setInt(8, transaccion.getID());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una transacción
    public boolean eliminarTransaccion(int id) {
        String sql = "DELETE FROM transacciones WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todas las transacciones
    public List<Transacciones> obtenerTransacciones() {
        List<Transacciones> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacciones";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Transacciones transaccion = new Transacciones();
                transaccion.setID(rs.getInt("id"));
                transaccion.setModelo(rs.getString("modelo"));
                transaccion.setPrecio(rs.getDouble("precio"));
                transaccion.setCantidad(rs.getInt("cantidad"));
                transaccion.setForma_Pago(rs.getString("forma_pago"));
                transaccion.setId_cajero(rs.getInt("id_cajero"));

                // Convertir Timestamp a Date
                Timestamp timestamp = rs.getTimestamp("fecha_hora");
                transaccion.setFecha_Hora((Date) new java.util.Date(timestamp.getTime()));

                transaccion.setTotal(rs.getDouble("total"));

                lista.add(transaccion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener transacciones: " + e.getMessage());
        }

        return lista;
    }
}
