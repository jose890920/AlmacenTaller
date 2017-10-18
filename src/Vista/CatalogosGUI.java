/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ConstantesAlmacenyTaller;
import Control.Validaciones;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import org.jvnet.substance.SubstanceLookAndFeel;
import Control.CatalogoDAO;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author jose luis Rodriguez
 */
public class CatalogosGUI extends javax.swing.JDialog {
Validaciones validaciones = new Validaciones();
ConstantesAlmacenyTaller constantes = new ConstantesAlmacenyTaller();
CatalogoDAO catalogoDao = new CatalogoDAO();
 DefaultTableModel modelo = new DefaultTableModel();


    /**
     * Creates new form CatalogosGUI
     */
    public CatalogosGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("CATALOGOS");
        this.setLocationRelativeTo(null);
        String columnasTablaProductos[] = {"LLAVE","VALOR"};
       
        modelo.setColumnIdentifiers(columnasTablaProductos);
         tablaCatalogos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        catalogoCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCatalogos = new javax.swing.JTable();
        consultarBtn = new javax.swing.JButton();
        valorTxt = new javax.swing.JTextField();
        llaveTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        registrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        catalogoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIPO_AJUSTE", "TIPO_DOCUMENTO", "TIPO_PRODUCTO", "TIPO_SERVICIO", "TIPO_USUARIO" }));
        catalogoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoComboActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setText("Valor");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, 20));

        tablaCatalogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCatalogos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 330, 80));

        consultarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        consultarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        consultarBtn.setToolTipText("CONSULTAR");
        consultarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(consultarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 145, 60));

        valorTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        valorTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        valorTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorTxtFocusLost(evt);
            }
        });
        valorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTxtActionPerformed(evt);
            }
        });
        valorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorTxtKeyTyped(evt);
            }
        });
        jPanel1.add(valorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 110, -1));

        llaveTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        llaveTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        llaveTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                llaveTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                llaveTxtFocusLost(evt);
            }
        });
        llaveTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llaveTxtActionPerformed(evt);
            }
        });
        llaveTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                llaveTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                llaveTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                llaveTxtKeyTyped(evt);
            }
        });
        jPanel1.add(llaveTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel10.setText("Catalogo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel11.setText("Llave");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        registrarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        registrarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        registrarBtn.setToolTipText("GUARDAR");
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 145, 55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void catalogoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catalogoComboActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        String query = "SELECT * FROM "+catalogoCombo.getSelectedItem().toString();
        //System.out.println("catalogos   "+catalogoDao.consultaRegistros(query));
        Map<String, String>  llaveValor;
        llaveValor = catalogoDao.consultaRegistros(query);
      
        
        modelo = new DefaultTableModel();
        String columnasTablaProductos[] = {"LLAVE","VALOR"};
        modelo.setColumnIdentifiers(columnasTablaProductos);
            for (Map.Entry<String, String> entry : llaveValor.entrySet()) {
          //  String key = entry.getKey();
            //String value = entry.getValue();
            
            String[] a = new String[2];
            a[0] = entry.getKey().toString().trim();
            a[1] = entry.getValue().toString().trim();
            modelo.addRow(a);
            
            
        }
            tablaCatalogos.setModel(modelo);

    }//GEN-LAST:event_consultarBtnActionPerformed

    private void valorTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTxtFocusGained

        validaciones.validarEnfoque(valorTxt);
    }//GEN-LAST:event_valorTxtFocusGained

    private void valorTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTxtFocusLost

        validarSonido(validaciones.validarCampoVacio(valorTxt));

    }//GEN-LAST:event_valorTxtFocusLost

    private void valorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTxtActionPerformed

    private void valorTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTxtKeyPressed

    }//GEN-LAST:event_valorTxtKeyPressed

    private void valorTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTxtKeyReleased

    }//GEN-LAST:event_valorTxtKeyReleased

    private void valorTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTxtKeyTyped

        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, valorTxt,
            constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_valorTxtKeyTyped

    private void llaveTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_llaveTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveTxtFocusGained

    private void llaveTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_llaveTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveTxtFocusLost

    private void llaveTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llaveTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveTxtActionPerformed

    private void llaveTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_llaveTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveTxtKeyPressed

    private void llaveTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_llaveTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveTxtKeyReleased

    private void llaveTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_llaveTxtKeyTyped
        validaciones.minusculaToMayuscula(evt);
                validaciones.validarCantidadCaracteresTexto(evt, llaveTxt,
            5);
    }//GEN-LAST:event_llaveTxtKeyTyped

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed

       String query = "INSERT INTO "+catalogoCombo.getSelectedItem().toString()
                      +"(LLAVE,VALOR)  VALUES('"+llaveTxt.getText().trim()+"','"
                      +valorTxt.getText().trim()+"')";
       catalogoDao.crearRegistro(query);

    }//GEN-LAST:event_registrarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CatalogosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog.setDefaultLookAndFeelDecorated(true); 
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
                CatalogosGUI dialog = new CatalogosGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> catalogoCombo;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField llaveTxt;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JTable tablaCatalogos;
    private javax.swing.JTextField valorTxt;
    // End of variables declaration//GEN-END:variables


     public void validarSonido(boolean flag){
         if (flag) {
              getToolkit().beep();
             
         }else{
             
         }
     } 

}