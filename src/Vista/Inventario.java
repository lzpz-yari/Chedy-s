package Vista;

import Controlador.Conexion;
import Controlador.ControladorInventario;
import Modelo.Zapato;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Inventario extends javax.swing.JFrame {

    //private Altaproducto producto;
    private final ControladorInventario controlador;
    Conexion con1 = Conexion.getInstance();

    public Inventario() {
        initComponents();
        // Obtener la conexión de la instancia de Conexion
        controlador = new ControladorInventario(this);
        controlador.consultarZapatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        altaproducto = new javax.swing.JButton();
        bajaproducto = new javax.swing.JButton();
        proveedor = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaZapatos = new javax.swing.JTable();
        Buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(482, 745));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle2.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Rectangle3.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 55)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chedy's");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/clic.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/rectangulo.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(240, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(103, 103, 103)
                .addComponent(jLabel3)
                .addGap(57, 57, 57))
        );

        altaproducto.setBackground(new java.awt.Color(0, 0, 0));
        altaproducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        altaproducto.setForeground(new java.awt.Color(255, 255, 255));
        altaproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/nuevo.GIF"))); // NOI18N
        altaproducto.setText("Alta de Producto");
        altaproducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        altaproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaproductoActionPerformed(evt);
            }
        });

        bajaproducto.setBackground(new java.awt.Color(0, 0, 0));
        bajaproducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bajaproducto.setForeground(new java.awt.Color(255, 255, 255));
        bajaproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/eliminar.png"))); // NOI18N
        bajaproducto.setText("Baja de Producto");
        bajaproducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 51)));
        bajaproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaproductoActionPerformed(evt);
            }
        });

        proveedor.setBackground(new java.awt.Color(0, 0, 0));
        proveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proveedor.setForeground(new java.awt.Color(255, 255, 255));
        proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Reservas.png"))); // NOI18N
        proveedor.setText("Datos Proveedor");
        proveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedorActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Serif", 0, 48)); // NOI18N
        jLabel6.setText("INVENTARIO");

        TablaZapatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Modelo", "Marca", "Color", "Talla", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaZapatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaZapatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaZapatos);

        Buscar.setBackground(new java.awt.Color(0, 0, 0));
        Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Buscar_1.png"))); // NOI18N
        Buscar.setText("Buscar");
        Buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(83, 182, 81));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Tabla de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(altaproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bajaproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addComponent(proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altaproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bajaproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proveedor)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void altaproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaproductoActionPerformed
        this.dispose();
        Altaproducto producto = new Altaproducto();
        producto.setVisible(true);
    }//GEN-LAST:event_altaproductoActionPerformed

    public void actualizarTabla() {
        controlador.consultarZapatos();
    }
    // Método para obtener la tabla de zapatos

    public javax.swing.JTable getTablaZapatos() {
        return TablaZapatos;
    }

    public void mostrarZapatos(List<Zapato> zapatos) {
        DefaultTableModel modelo = (DefaultTableModel) TablaZapatos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de mostrar los nuevos datos

        for (Zapato zapato : zapatos) {
            Object[] row = {
                zapato.getEstilo(),
                zapato.getModelo(),
                zapato.getMarca(),
                zapato.getColor(),
                zapato.getTalla(),
                zapato.getCantidad(),
                zapato.getPrecio(),
                zapato.getTipo()
            };
            modelo.addRow(row);
        }
    }

    private void proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorActionPerformed
        // TODO add your handling code here:
        Proveedor proveedor = new Proveedor();
        proveedor.setVisible(true);
    }//GEN-LAST:event_proveedorActionPerformed

    private void TablaZapatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaZapatosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaZapatosMouseClicked


    private void bajaproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaproductoActionPerformed

        // Obtener la fila seleccionada en la tabla de zapatos
        int filaSeleccionada = TablaZapatos.getSelectedRow();

        // Verificar si se ha seleccionado una fila válida
        if (filaSeleccionada != -1) {
            // Obtener el estilo y la cantidad del zapato seleccionado
            int estiloZapato = (Integer) TablaZapatos.getValueAt(filaSeleccionada, 0); // Obtener como entero
            Object cantidadObj = TablaZapatos.getValueAt(filaSeleccionada, 5);
            int cantidadZapato = 0;
            if (cantidadObj instanceof Double) {
                cantidadZapato = ((Double) cantidadObj).intValue(); // Convertir de Double a int
            } else if (cantidadObj instanceof Integer) {
                cantidadZapato = (Integer) cantidadObj; // Ya es int, lo tomamos directamente
            }
            // Verificar si la cantidad es 0 para permitir la eliminación
            if (cantidadZapato == 0) {
                // Construir un mensaje de confirmación
                String mensajeConfirmacion = "¿Estás seguro de que deseas eliminar el zapato con el codigo: " + estiloZapato + "?";

                // Mostrar un cuadro de diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(null, mensajeConfirmacion, "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                // Si el usuario confirma la eliminación, proceder con la eliminación del registro
                if (confirmacion == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM Zapato WHERE Estilo = ?";

                    try {
                        // Obtener la conexión a la base de datos
                        Connection conet = con1.getConnection();
                        PreparedStatement statement = conet.prepareStatement(sql);
                        statement.setInt(1, estiloZapato); // Usar setInt para estilos como entero

                        // Ejecutar la consulta de eliminación
                        int filasAfectadas = statement.executeUpdate();

                        if (filasAfectadas > 0) {
                            // Mostrar mensaje de éxito
                            JOptionPane.showMessageDialog(null, "Zapato eliminado correctamente.");
                            // Eliminar la fila de la tabla
                            ((DefaultTableModel) TablaZapatos.getModel()).removeRow(filaSeleccionada);
                        } else {
                            // Si no se puede eliminar
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el zapato.");
                        }
                    } catch (SQLException e) {
                        // Manejo de errores al eliminar el zapato
                        JOptionPane.showMessageDialog(null, "Error al eliminar el zapato: " + e.getMessage());
                    }
                }
            } else {
                // Si la cantidad es mayor que 0
                JOptionPane.showMessageDialog(null, "No se puede eliminar el zapato porque hay más de 1 pieza.");
            }
        } else {
            // Si no se seleccionó ninguna fila
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un zapato para eliminar.");
        }


    }//GEN-LAST:event_bajaproductoActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        BuscarProducto buscar = new BuscarProducto();
        buscar.setVisible(true);
    }//GEN-LAST:event_BuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Administradorr admi = new Administradorr();
        admi.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JTable TablaZapatos;
    private javax.swing.JButton altaproducto;
    private javax.swing.JButton bajaproducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proveedor;
    // End of variables declaration//GEN-END:variables
}
