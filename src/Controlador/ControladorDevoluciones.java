package Controlador;

import Modelo.Devoluciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.swing.JOptionPane;

public class ControladorDevoluciones {

    private Connection connection;

    public ControladorDevoluciones() {
        this.connection = Conexion.getInstance().getConnection();
    }

    // Método para insertar una devolución
    public boolean insertarDevolucion(Devoluciones devolucion) {
        String sql = "INSERT INTO devoluciones (id, id_transaccion, modelo, cantidad, precio, fecha_hora) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, devolucion.getId());
            pst.setInt(2, devolucion.getId_transaccion());
            pst.setString(3, devolucion.getModelo());
            pst.setInt(4, devolucion.getCantidad());
            pst.setDouble(5, devolucion.getPrecio());
            pst.setTimestamp(6, new java.sql.Timestamp(devolucion.getFecha_hora().getTime())); // Convierte Date a Timestamp

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar devolución: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar una devolución
    public boolean actualizarDevolucion(Devoluciones devolucion) {
        String sql = "UPDATE devoluciones SET id_transaccion = ?, modelo = ?, cantidad = ?, precio = ?, fecha_hora = ? WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, devolucion.getId_transaccion());
            pst.setString(2, devolucion.getModelo());
            pst.setInt(3, devolucion.getCantidad());
            pst.setDouble(4, devolucion.getPrecio());
            pst.setTimestamp(5, new java.sql.Timestamp(devolucion.getFecha_hora().getTime())); // Convierte Date a Timestamp
            pst.setInt(6, devolucion.getId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar devolución: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una devolución
    public boolean eliminarDevolucion(int id) {
        String sql = "DELETE FROM devoluciones WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar devolución: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todas las devoluciones
    public List<Devoluciones> obtenerDevoluciones() {
        List<Devoluciones> lista = new ArrayList<>();
        String sql = "SELECT * FROM devoluciones";

        try (PreparedStatement pst = connection.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Devoluciones devolucion = new Devoluciones();
                devolucion.setId(rs.getInt("id"));
                devolucion.setId_transaccion(rs.getInt("id_transaccion"));
                devolucion.setModelo(rs.getString("modelo"));
                devolucion.setCantidad(rs.getInt("cantidad"));
                devolucion.setPrecio(rs.getDouble("precio"));
                devolucion.setFecha_hora(rs.getTimestamp("fecha_hora")); // Obtiene Timestamp y lo asigna

                lista.add(devolucion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener devoluciones: " + e.getMessage());
        }

        return lista;
    }

    // Método para buscar una devolución por ID
    public Devoluciones buscarDevolucionPorID(int id) {
        String sql = "SELECT * FROM devoluciones WHERE id = ?";
        Devoluciones devolucion = null;

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    devolucion = new Devoluciones();
                    devolucion.setId(rs.getInt("id"));
                    devolucion.setId_transaccion(rs.getInt("id_transaccion"));
                    devolucion.setModelo(rs.getString("modelo"));
                    devolucion.setCantidad(rs.getInt("cantidad"));
                    devolucion.setPrecio(rs.getDouble("precio"));
                    devolucion.setFecha_hora(rs.getTimestamp("fecha_hora")); // Obtiene Timestamp y lo asigna
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar devolución: " + e.getMessage());
        }

        return devolucion;
    }
}
