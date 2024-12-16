package Controlador;

import Modelo.Zapato;
import Vista.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorInventario {

    private Connection connection;
    private Inventario vista;
    private ControladorZapato modelo;
    Conexion con1 = Conexion.getInstance();

    public ControladorInventario(Inventario vista) {
        this.vista = vista;
        this.modelo = new ControladorZapato();
    }

    public void consultarZapatos() {
        // Obtener la conexión directamente desde la clase Conexion
        Connection conet = Conexion.getInstance().getConnection();

        String sql = "SELECT estilo, modelo, marca, color, talla, cantidad, precio, tipo FROM zapato";

        try (PreparedStatement statement = conet.prepareStatement(sql); ResultSet result = statement.executeQuery()) {

            DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTablaZapatos().getModel(); // Asegúrate de que la tabla sea correcta
            modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while (result.next()) {
                Object[] row = {
                    result.getInt("estilo"),
                    result.getString("modelo"),
                    result.getString("marca"),
                    result.getString("color"),
                    result.getString("talla"),
                    result.getDouble("cantidad"),
                    result.getDouble("precio")
                };
                modeloTabla.addRow(row);
            }
            modeloTabla.fireTableDataChanged();  // Notificar que los datos han cambiado

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener zapatos: " + e.getMessage());
        }
    }

    public void eliminarZapato(int estiloZapato) {
        String sql = "DELETE FROM Zapato WHERE Estilo = ?"; // Sentencia SQL para eliminar el zapato

        try (Connection conet = con1.getConnection()) {  // Conexión automática cerrada al final
            PreparedStatement statement = conet.prepareStatement(sql);
            statement.setInt(1, estiloZapato); // Usamos el estilo como parámetro para la eliminación

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Zapato eliminado correctamente de la base de datos.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el zapato de la base de datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el zapato: " + e.getMessage());
        }
    }

    }

