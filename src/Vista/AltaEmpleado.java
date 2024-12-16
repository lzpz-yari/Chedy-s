/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Conexion;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author samya
 */
public class AltaEmpleado extends javax.swing.JFrame {

    Conexion con1 = Conexion.getInstance();
    Connection conet;

    /**
     * Creates new form AltaEmpleado
     */
    public AltaEmpleado() {
        initComponents();
        conet = con1.getConnection();
        String[] puestos = {" ", "Vendedor", "Cajero", "Encargado de tienda", "Encargado de inventario", "Vigilante"};
        Puestos.setModel(new DefaultComboBoxModel<>(puestos));
        // Añadir DocumentListener a los campos de texto
        addDocumentListeners();
        jTextField6.setEditable(false);
    }

    private void addDocumentListeners() {
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateRFC();
            }

            public void removeUpdate(DocumentEvent e) {
                updateRFC();
            }

            public void insertUpdate(DocumentEvent e) {
                updateRFC();
            }
        });
        jTextField4.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateRFC();
            }

            public void removeUpdate(DocumentEvent e) {
                updateRFC();
            }

            public void insertUpdate(DocumentEvent e) {
                updateRFC();
            }
        });
        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateRFC();
            }

            public void removeUpdate(DocumentEvent e) {
                updateRFC();
            }

            public void insertUpdate(DocumentEvent e) {
                updateRFC();
            }
        });
        jDateChooser2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    updateRFC();
                }
            }
        });
    }

    private void updateRFC() {
        String nombre = jTextField1.getText();
        String apellidoPaterno = jTextField4.getText();
        String apellidoMaterno = jTextField2.getText();
        Date fechaNacimiento = jDateChooser2.getDate();

        if (!nombre.isEmpty() && !apellidoPaterno.isEmpty() && !apellidoMaterno.isEmpty() && fechaNacimiento != null) {
            String rfc = generarRFC(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
            jTextField6.setText(rfc);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
        Agregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Puestos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(31, 31, 31));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle 23.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, -1, -1));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 371, 44));

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 371, 44));

        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 371, 44));

        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 371, 44));

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 371, 44));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Apellido Paterno");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Apellido Materno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Correo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 101, 44));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Salario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 101, 44));

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Puesto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 101, 44));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("RFC");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, 44));

        Agregar.setBackground(new java.awt.Color(83, 182, 81));
        Agregar.setForeground(new java.awt.Color(255, 255, 255));
        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/nuevo.GIF"))); // NOI18N
        Agregar.setText("AGREGAR");
        Agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 130, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/empleadooo.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        Puestos.setForeground(new java.awt.Color(102, 102, 102));
        Puestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Puestos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Puestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuestosActionPerformed(evt);
            }
        });
        jPanel1.add(Puestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 370, 40));

        jButton1.setBackground(new java.awt.Color(83, 182, 81));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Atras");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, 120, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Nombre");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 100, 44));

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 371, 44));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Serif", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bienvenido al registro de Empleados");
        jPanel2.add(jLabel12);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 800, 80));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jDateChooser2.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 370, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 780));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // Obtener el puesto seleccionado del JComboBox
        String puestoSeleccionado = Puestos.getSelectedItem().toString();

        // Establecer el texto del JTextField con el puesto seleccionado
        jTextField2.setText(puestoSeleccionado);

        // Deshabilitar la edición del campo
        jTextField2.setEditable(false);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        // TODO add your handling code here:
        // Obtener el puesto seleccionado
        String puestoSeleccionado = (String) Puestos.getSelectedItem();

        // Verificar si se ha seleccionado un puesto
        if (puestoSeleccionado != null) {
            // Llamar al método agregarEmpleado y pasarle el puesto seleccionado
            agregarEmpleado(puestoSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Error: Debes seleccionar un puesto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_AgregarActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void PuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuestosActionPerformed

    }//GEN-LAST:event_PuestosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Administradorr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void agregarEmpleado(String puestoSeleccionado) {
        String nombre = jTextField1.getText();
        String apellidoPaterno = jTextField4.getText();
        String apellidoMaterno = jTextField2.getText();
        String correo = jTextField3.getText();
        Date fechaNacimiento = jDateChooser2.getDate();
        double salario;

        try {
            salario = Double.parseDouble(jTextField5.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salario inválido. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el salario esté dentro del rango permitido y mostrar mensajes específicos
        if (salario < 1750) {

            JOptionPane.showMessageDialog(this, "Sueldo demasiado bajo. El mínimo permitido es 1750.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (salario > 5500) {

            JOptionPane.showMessageDialog(this, "Sueldo demasiado alto. El máximo permitido es 5500.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generar RFC automáticamente
        String rfc = generarRFC(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);

        // Asignar el RFC generado al campo de texto
        jTextField6.setText(rfc);

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

        // Restricción 2: Validar que el correo termine con @gmail.com, @outlook.com o @hotmail.com
        if (!correo.matches(".+@(gmail\\.com|outlook\\.com|hotmail\\.com)$")) {
            errores.add("Correo: " + correo + " --- Debe terminar con @gmail.com, @outlook.com o @hotmail.com.");
        }

        // Restricción 3: Validar que el RFC tenga el formato correcto (mínimo hasta la fecha de nacimiento y máximo 13 caracteres alfanuméricos)
        String rfcRegex = "[A-Z0-9]{6,13}";
        if (!rfc.matches(rfcRegex)) {
            errores.add("RFC: " + rfc + " ");
        }

        // Restricción 4: Validar que la fecha de nacimiento sea igual o mayor de 18 años
        if (fechaNacimiento == null) {
            errores.add("Por favor, seleccione una fecha de nacimiento.");
        } else {
            Calendar fechaNacimientoCalendar = Calendar.getInstance();
            fechaNacimientoCalendar.setTime(fechaNacimiento);
            Calendar ahora = Calendar.getInstance();
            ahora.add(Calendar.YEAR, -18); // Restar 18 años a la fecha actual
            if (fechaNacimientoCalendar.after(ahora)) {

                errores.add("El empleado debe tener 18 años.");
            }
        }

        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron errores en los siguientes campos:\n\n");
            for (String error : errores) {
                mensajeError.append(error).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensajeError.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Continuar con la inserción en la base de datos
        Connection conet = null;
        try {
            conet = con1.getConnection();

            // Verificar si ya existe un empleado con el mismo RFC
            String sqlVerificarRfc = "SELECT COUNT(*) FROM Empleado WHERE RFC = ?";
            PreparedStatement statementVerificarRfc = conet.prepareStatement(sqlVerificarRfc);
            statementVerificarRfc.setString(1, rfc);

            ResultSet resultSet = statementVerificarRfc.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Ya existe un registro con el mismo RFC.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Si no existe, proceder con la inserción
            String sqlEmpleado = "INSERT INTO Empleado (RFC, Nombre, Apellido_Paterno, Apellido_Materno, Correo, Salario, Puesto, FechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statementEmpleado = conet.prepareStatement(sqlEmpleado);
            statementEmpleado.setString(1, rfc);
            statementEmpleado.setString(2, nombre);
            statementEmpleado.setString(3, apellidoPaterno);
            statementEmpleado.setString(4, apellidoMaterno);
            statementEmpleado.setString(5, correo);
            statementEmpleado.setDouble(6, salario);
            statementEmpleado.setString(7, puestoSeleccionado);
            statementEmpleado.setDate(8, new java.sql.Date(fechaNacimiento.getTime())); // Convertir java.util.Date a java.sql.Date

            int rowsEmpleado = statementEmpleado.executeUpdate();

            if (rowsEmpleado > 0) {
                JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar empleado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar empleado: " + e.getMessage());
        } finally {
            // No cerrar la conexión aquí para mantenerla abierta
        }
    }

    private String generarRFC(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento) {
        // Obtener las primeras letras del nombre, apellido paterno y apellido materno
        String primerasLetrasNombre = nombre.substring(0, 1);
        String primerasLetrasApellidoPaterno = apellidoPaterno.substring(0, 2);
        String primerasLetrasApellidoMaterno = apellidoMaterno.substring(0, 1);

        // Obtener los dos últimos dígitos del año de nacimiento
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaNacimiento);
        int año = calendar.get(Calendar.YEAR) % 100;
        String añoStr = String.format("%02d", año);

        // Obtener los dos dígitos correspondientes al mes de nacimiento
        int mes = calendar.get(Calendar.MONTH) + 1; // Sumar 1 porque los meses van de 0 a 11
        String mesStr = String.format("%02d", mes);

        // Obtener los dos dígitos correspondientes al día de nacimiento
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        String diaStr = String.format("%02d", dia);

        // Concatenar los valores para formar el RFC
        String rfc = primerasLetrasApellidoPaterno.toUpperCase() + primerasLetrasApellidoMaterno.toUpperCase() + primerasLetrasNombre.toUpperCase() + añoStr + mesStr + diaStr;

        return rfc;
    }

    private void limpiarCampos() {
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jDateChooser2.setDate(null);
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
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JComboBox<String> Puestos;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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