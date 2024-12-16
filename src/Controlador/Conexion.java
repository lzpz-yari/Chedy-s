package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Conexion instance;
    private Connection con;

    Conexion() {
        connect(); // Llama al método connect para establecer la conexión inicial.
    }

    private void connect() {
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/luis", "root", "pl04");
            System.err.println("Se ha accedido a la base de datos.");
       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos. Verifica los datos de conexión. Error: " + e.getMessage());
            e.printStackTrace();
            con = null;
        }
    }

    public static synchronized Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        } else {
            try {
                // Verifica si la conexión está cerrada y reconecta si es necesario
                if (instance.con == null || instance.con.isClosed()) {
                    instance.connect();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al verificar el estado de la conexión: " + e);
                instance.connect(); // Intenta reconectar si falla la comprobación del estado
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return con; // Devuelve la conexión
    }

    public void reconnect() {
        try {
            close(); // Cierra la conexión actual si está abierta
            connect(); // Crea una nueva conexión
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al reconectar a la base de datos: " + e.getMessage());
        }
    }

    public void close() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
            System.err.println("Conexión a la base de datos cerrada.");
        }
    }
}
