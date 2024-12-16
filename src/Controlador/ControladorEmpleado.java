/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ep972
 */
public class ControladorEmpleado {
   
    private Connection con = Conexion.getInstance().getConnection(); // Obtener la conexión única

    public boolean insertarEmpleado(Empleado empleado) {
        String sSQL = "INSERT INTO empleado (RFC, Nombre, Apellido_Paterno, Apellido_Materno, Correo, Salario, Usuario, Puesto, Fecha_Nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, empleado.getRFC());
            pst.setString(2, empleado.getNombre());
            pst.setString(3, empleado.getApellido_Paterno());
            pst.setString(4, empleado.getApellido_Materno());
            pst.setString(5, empleado.getCorreo());
            pst.setDouble(6, empleado.getSalario());
            pst.setString(7, empleado.getUsuario());
            pst.setString(8, empleado.getPuesto());
            pst.setString(9, empleado.getFecha_Nacimiento());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        String sSQL = "UPDATE empleado SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Correo = ?, Salario = ?, Usuario = ?, Puesto = ?, Fecha_Nacimiento = ? WHERE RFC = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellido_Paterno());
            pst.setString(3, empleado.getApellido_Materno());
            pst.setString(4, empleado.getCorreo());
            pst.setDouble(5, empleado.getSalario());
            pst.setString(6, empleado.getUsuario());
            pst.setString(7, empleado.getPuesto());
            pst.setString(8, empleado.getFecha_Nacimiento());
            pst.setString(9, empleado.getRFC());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEmpleado(String rfc) {
        String sSQL = "DELETE FROM empleado WHERE RFC = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, rfc);

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Empleado> listarEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        String sSQL = "SELECT * FROM empleado";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setRFC(rs.getString("RFC"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                empleado.setApellido_Materno(rs.getString("Apellido_Materno"));
                empleado.setCorreo(rs.getString("Correo"));
                empleado.setSalario(rs.getDouble("Salario"));
                empleado.setUsuario(rs.getString("Usuario"));
                empleado.setPuesto(rs.getString("Puesto"));
                empleado.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));

                lista.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }

        return lista;
    }
}
