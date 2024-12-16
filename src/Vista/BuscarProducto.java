/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class BuscarProducto extends javax.swing.JFrame {

    Conexion con1 = Conexion.getInstance();
    java.sql.Connection conet;
    DefaultTableModel modelo;

    /**
     * Creates new form BuscarProducto
     */
    public BuscarProducto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BuscarZapato = new javax.swing.JTable();
        Modelo = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(1366, 768, 768, 768));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        BuscarZapato.setBackground(new java.awt.Color(204, 204, 204));
        BuscarZapato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 204), new java.awt.Color(0, 51, 51), null, null));
        BuscarZapato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Modelo", "Marca", "Color", "Talla", "Cantidad", "Precio", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BuscarZapato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarZapatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BuscarZapato);

        Modelo.setBackground(new java.awt.Color(0, 0, 0));
        Modelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Modelo.setForeground(new java.awt.Color(255, 255, 255));
        Modelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Buscar_1.png"))); // NOI18N
        Modelo.setText("Buscar Modelo");
        Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeloActionPerformed(evt);
            }
        });

        Regresar.setBackground(new java.awt.Color(83, 182, 81));
        Regresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Regresar.png"))); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/buscar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(Modelo)
                .addGap(732, 732, 732)
                .addComponent(Regresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Modelo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(Regresar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarZapatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarZapatoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarZapatoMouseClicked

    private void ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModeloActionPerformed
        // Obtener el modelo ingresado por el usuario
        String modeloBusqueda = JOptionPane.showInputDialog(this, "Ingrese el modelo a buscar:", "Buscar Zapato", JOptionPane.QUESTION_MESSAGE);

// Verificar si se ingresó un modelo
        if (modeloBusqueda != null && !modeloBusqueda.isEmpty()) {
            // Realizar la búsqueda en la base de datos y mostrar los resultados en la tabla
            try {
                // Establecer la conexión a la base de datos
                conet = con1.getConnection();

                // Consulta SQL para buscar los zapatos por modelo
                String sql = "SELECT Modelo, Marca, Color, Talla, Cantidad, Precio, Tipo FROM Zapato WHERE Modelo = ?";

                // Preparar la declaración SQL
                PreparedStatement statement = conet.prepareStatement(sql);
                statement.setString(1, modeloBusqueda);

                // Ejecutar la consulta
                ResultSet rs = statement.executeQuery();

                // Crear un modelo de tabla para almacenar los resultados
                DefaultTableModel modeloTabla = new DefaultTableModel();
                modeloTabla.addColumn("Modelo");
                modeloTabla.addColumn("Marca");
                modeloTabla.addColumn("Color");
                modeloTabla.addColumn("Talla");
                modeloTabla.addColumn("Cantidad");
                modeloTabla.addColumn("Precio");
                modeloTabla.addColumn("Tipo");

                // Recorrer los resultados y agregarlos al modelo de tabla
                boolean encontrado = false; // Variable para indicar si se encontraron resultados
                while (rs.next()) {
                    Object[] fila = new Object[7];
                    fila[0] = rs.getString("Modelo");
                    fila[1] = rs.getString("Marca");
                    fila[2] = rs.getString("Color");
                    fila[3] = rs.getDouble("Talla");
                    fila[4] = rs.getInt("Cantidad");
                    fila[5] = rs.getDouble("Precio");
                    fila[6] = rs.getString("Tipo");
                    modeloTabla.addRow(fila);
                    encontrado = true; // Se encontraron resultados
                }

                // Asignar el modelo de tabla a la tabla BuscarZapato
                BuscarZapato.setModel(modeloTabla);

                // Si no se encontraron resultados, mostrar un mensaje
                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "No se encontraron zapatos con el modelo ingresado.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al buscar Zapato: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un modelo válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ModeloActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
        Inventario inventario = new Inventario();
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BuscarZapato;
    private javax.swing.JButton Modelo;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
