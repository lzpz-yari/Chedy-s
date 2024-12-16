/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author samya
 */
public class ModificacionEmpleado extends javax.swing.JFrame {
    // Declarar una variable para almacenar el puesto seleccionado

    Conexion con1 = Conexion.getInstance();
    Connection conet;
    private Administradorr admin;

    // Constructor que recibe la referencia de la tabla
    public ModificacionEmpleado(Administradorr admin, JTable tablaEmpleados) {
        this.admin = admin;
        this.tablaEmpleados = tablaEmpleados;
        initComponents();
        conet = con1.getConnection();
        configurarPuestos();
        jTextField6.setEditable(false);
        jTextField1.setEditable(false);
        jTextField4.setEditable(false);
        jTextField2.setEditable(false);
    }

    /**
     * Creates new form ModificacionEmpleado
     */
    public ModificacionEmpleado() {
        initComponents();
        conet = con1.getConnection();
        configurarPuestos();
    }

    private void configurarPuestos() {
        String[] puestos = {"Vendedor", "Cajero", "Encargado de tienda", "Encargado de inventario", "Vigilante"};
        Puestos.setModel(new DefaultComboBoxModel<>(puestos));
    }

    private void actualizarEmpleado() {
        String rfc = jTextField6.getText();
        String nombre = jTextField1.getText();
        String apellidoPaterno = jTextField4.getText();
        String apellidoMaterno = jTextField2.getText();
        String correo = jTextField3.getText();
        double salario;
        try {
            salario = Double.parseDouble(jTextField5.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Salario inválido. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<String> errores = new ArrayList<>();

        // Restricción 1: Validar que nombre, apellido paterno y apellido materno solo contengan letras y espacios
        if (!nombre.matches("[a-zA-Z\\s]+")) {
            errores.add("Nombre: " + nombre + " --- Debe contener solo letras y espacios.");
        }
        if (!apellidoPaterno.matches("[a-zA-ZñÑ\\s]+")) {
            errores.add("Apellido Paterno: " + apellidoPaterno + " --- Debe contener solo letras y espacios.");
        }
        if (!apellidoMaterno.matches("[a-zA-ZñÑ\\s]+")) {
            errores.add("Apellido Materno: " + apellidoMaterno + " --- Debe contener solo letras y espacios.");
        }
         if (salario < 1750) {

            JOptionPane.showMessageDialog(this, "Sueldo demasiado bajo. El mínimo permitido es 1750.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (salario > 5500) {

            JOptionPane.showMessageDialog(this, "Sueldo demasiado alto. El máximo permitido es 5500.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Restricción 2: Validar que el correo termine con @gmail.com, @outlook.com o @hotmail.com
        if (!correo.matches(".+@(gmail\\.com|outlook\\.com|hotmail\\.com)$")) {
            errores.add("Correo: " + correo + " --- Debe terminar con @gmail.com, @outlook.com o @hotmail.com.");
        } else if (!correo.endsWith("@gmail.com") && !correo.endsWith("@outlook.com") && !correo.endsWith("@hotmail.com")) {
            errores.add("Correo: " + correo + " --- La parte del dominio del correo es incorrecta.");
        }

        // Mostrar errores si hay alguno
        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron errores en los siguientes campos:\n\n");
            for (String error : errores) {
                mensajeError.append(error).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si no hay errores, continuar con la actualización en la base de datos
        String sql = "UPDATE Empleado SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Correo = ?, Salario = ?, Puesto = ? WHERE RFC = ?";

        try {
            PreparedStatement statement = conet.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellidoPaterno);
            statement.setString(3, apellidoMaterno);
            statement.setString(4, correo);
            statement.setDouble(5, salario);
            statement.setString(6, (String) Puestos.getSelectedItem());
            statement.setString(7, rfc);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                admin.consultar(); // Actualiza la tabla en la vista principal
                //this.dispose(); // Cierra la ventana actual
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ActualizarDatos = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Puestos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(31, 31, 31));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle 23.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle2.1.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle 23.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle2.1.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 0, -1, -1));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 371, 44));

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 363, 371, 44));

        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 419, 371, 44));

        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 371, 44));

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 478, 371, 44));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Apellido Paterno");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Apellido Materno");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 363, -1, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Correo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 419, 101, 44));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Sueldo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 475, 101, 44));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Puesto");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 534, 101, 44));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("RFC");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 100, 44));

        ActualizarDatos.setBackground(new java.awt.Color(83, 182, 81));
        ActualizarDatos.setForeground(new java.awt.Color(255, 255, 255));
        ActualizarDatos.setText("Actualizar Datos");
        ActualizarDatos.setBorder(null);
        ActualizarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ActualizarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarDatosMouseClicked(evt);
            }
        });
        ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarDatosActionPerformed(evt);
            }
        });
        jPanel2.add(ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 620, 130, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel15.setText("BIENVENIDO");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        Puestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Puestos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Puestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuestosActionPerformed(evt);
            }
        });
        jPanel2.add(Puestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 370, 40));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setText("Atras");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 110, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 254, 100, 44));

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 371, 44));

        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/empleadooo.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 520, 530));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)))
                .addContainerGap(786, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 780));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void ActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarDatosActionPerformed
        actualizarEmpleado();
    }//GEN-LAST:event_ActualizarDatosActionPerformed


    private void PuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuestosActionPerformed


    }//GEN-LAST:event_PuestosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Administradorr admi = new Administradorr();
        admi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ActualizarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarDatosMouseClicked


    }//GEN-LAST:event_ActualizarDatosMouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    // Método para establecer los datos del empleado a modificar en los campos de texto
    public void setDatos(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, double salario, String puesto) {
        // Establecer los datos en los campos correspondientes de la interfaz
        jTextField6.setText(rfc); // Establecer el RFC en el jTextField6
        jTextField1.setText(nombre);
        jTextField4.setText(apellidoPaterno);
        jTextField2.setText(apellidoMaterno);
        jTextField3.setText(correo);
        jTextField5.setText(String.valueOf(salario)); // Convertir el salario a String y establecerlo en el campo de texto
        Puestos.setSelectedItem(puesto);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificacionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificacionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificacionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificacionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificacionEmpleado().setVisible(true);
            }
        });
    }

    private JTable tablaEmpleados;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarDatos;
    private javax.swing.JComboBox<String> Puestos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
