/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ConstantesAlmacenyTaller;
import Control.TipoDocumentoDAO;
import Control.Validaciones;
import javax.swing.JDialog;
import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author jose luis Rodriguez
 */
public class EmpleadoGUI extends javax.swing.JDialog {
    
    Validaciones validaciones = new Validaciones();
    TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
    ConstantesAlmacenyTaller constantes = new ConstantesAlmacenyTaller();
    
    
    /**
     * Creates new form EmpleadoGUI
     */
    public EmpleadoGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        validaciones.adicionarItems(tipoDocumentoCombo,
        tipoDocumentoDAO.consultarTiposDocumento());
        this.setTitle("Gestion Empleados");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        nombresTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        telefonoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        apellidosTxt = new javax.swing.JTextField();
        direccionTxt = new javax.swing.JTextField();
        tipoDocumentoCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        numeroDocumentoTxt = new javax.swing.JTextField();
        celularTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombresTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        nombresTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        nombresTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombresTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombresTxtFocusLost(evt);
            }
        });
        nombresTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombresTxtActionPerformed(evt);
            }
        });
        nombresTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombresTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombresTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombresTxtKeyTyped(evt);
            }
        });
        jPanel1.add(nombresTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel5.setText("Apellidos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 10));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setText("Nombres");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 10));

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel7.setText("Dirección");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, 10));

        telefonoTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        telefonoTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        telefonoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonoTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonoTxtFocusLost(evt);
            }
        });
        telefonoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoTxtActionPerformed(evt);
            }
        });
        telefonoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefonoTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoTxtKeyTyped(evt);
            }
        });
        jPanel1.add(telefonoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel8.setText("Celular");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        apellidosTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        apellidosTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        apellidosTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellidosTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidosTxtFocusLost(evt);
            }
        });
        apellidosTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosTxtActionPerformed(evt);
            }
        });
        apellidosTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidosTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                apellidosTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidosTxtKeyTyped(evt);
            }
        });
        jPanel1.add(apellidosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 180, -1));

        direccionTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        direccionTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        direccionTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                direccionTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                direccionTxtFocusLost(evt);
            }
        });
        direccionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionTxtActionPerformed(evt);
            }
        });
        direccionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                direccionTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionTxtKeyTyped(evt);
            }
        });
        jPanel1.add(direccionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 180, -1));

        tipoDocumentoCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tipoDocumentoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --" }));
        tipoDocumentoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoDocumentoComboItemStateChanged(evt);
            }
        });
        tipoDocumentoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipoDocumentoComboFocusLost(evt);
            }
        });
        tipoDocumentoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDocumentoComboActionPerformed(evt);
            }
        });
        jPanel1.add(tipoDocumentoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 180, -1));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setText("Numero de Documento");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, 10));

        numeroDocumentoTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        numeroDocumentoTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        numeroDocumentoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numeroDocumentoTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numeroDocumentoTxtFocusLost(evt);
            }
        });
        numeroDocumentoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroDocumentoTxtActionPerformed(evt);
            }
        });
        numeroDocumentoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroDocumentoTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numeroDocumentoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroDocumentoTxtKeyTyped(evt);
            }
        });
        jPanel1.add(numeroDocumentoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 180, -1));

        celularTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        celularTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        celularTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                celularTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                celularTxtFocusLost(evt);
            }
        });
        celularTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celularTxtActionPerformed(evt);
            }
        });
        celularTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                celularTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                celularTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                celularTxtKeyTyped(evt);
            }
        });
        jPanel1.add(celularTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 180, -1));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel10.setText("Tipo de Documento");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel11.setText("Telefono");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, 10));

        jLabel12.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleados.png"))); // NOI18N
        jLabel12.setText("Empleados");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 270, 80));

        jTabbedPane1.addTab("Información Personal", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombresTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombresTxtFocusGained

        validaciones.validarEnfoque(nombresTxt);
    }//GEN-LAST:event_nombresTxtFocusGained

    private void nombresTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombresTxtFocusLost

        validarSonido(validaciones.validarCampoVacio(nombresTxt));
    }//GEN-LAST:event_nombresTxtFocusLost

    private void nombresTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombresTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombresTxtActionPerformed

    private void nombresTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresTxtKeyPressed

    }//GEN-LAST:event_nombresTxtKeyPressed

    private void nombresTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresTxtKeyReleased

    }//GEN-LAST:event_nombresTxtKeyReleased

    private void nombresTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresTxtKeyTyped

        validarSonido(validaciones.validarSoloLetras(evt, nombresTxt));
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, nombresTxt,
            constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_nombresTxtKeyTyped

    private void telefonoTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoTxtFocusGained
        validaciones.validarEnfoque(telefonoTxt);
    }//GEN-LAST:event_telefonoTxtFocusGained

    private void telefonoTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoTxtFocusLost
        
    }//GEN-LAST:event_telefonoTxtFocusLost

    private void telefonoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoTxtActionPerformed

    private void telefonoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoTxtKeyPressed

    private void telefonoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoTxtKeyReleased

    private void telefonoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoTxtKeyTyped
        validarSonido(validaciones.validarSoloNumeros(evt, telefonoTxt));
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, telefonoTxt,
            constantes.CONSTANTE_VALOR_POR_DEFECTO);
    }//GEN-LAST:event_telefonoTxtKeyTyped

    private void apellidosTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosTxtFocusGained

        validaciones.validarEnfoque(apellidosTxt);
    }//GEN-LAST:event_apellidosTxtFocusGained

    private void apellidosTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosTxtFocusLost

        validarSonido(validaciones.validarCampoVacio(apellidosTxt));
    }//GEN-LAST:event_apellidosTxtFocusLost

    private void apellidosTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosTxtActionPerformed

    private void apellidosTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosTxtKeyPressed

    }//GEN-LAST:event_apellidosTxtKeyPressed

    private void apellidosTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosTxtKeyReleased

    }//GEN-LAST:event_apellidosTxtKeyReleased

    private void apellidosTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosTxtKeyTyped

        validarSonido(validaciones.validarSoloLetras(evt, apellidosTxt));
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, apellidosTxt,
            constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_apellidosTxtKeyTyped

    private void direccionTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionTxtFocusGained

        validaciones.validarEnfoque(direccionTxt);
    }//GEN-LAST:event_direccionTxtFocusGained

    private void direccionTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionTxtFocusLost

        validarSonido(validaciones.validarCampoVacio(direccionTxt));
    }//GEN-LAST:event_direccionTxtFocusLost

    private void direccionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionTxtActionPerformed

    private void direccionTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionTxtKeyPressed

    }//GEN-LAST:event_direccionTxtKeyPressed

    private void direccionTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionTxtKeyReleased

    }//GEN-LAST:event_direccionTxtKeyReleased

    private void direccionTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionTxtKeyTyped

        
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, direccionTxt,
            constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_direccionTxtKeyTyped

    private void tipoDocumentoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoDocumentoComboItemStateChanged
        validarSonido(validaciones.validaCombo(tipoDocumentoCombo));
    }//GEN-LAST:event_tipoDocumentoComboItemStateChanged

    private void tipoDocumentoComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoDocumentoComboFocusLost
        validarSonido(validaciones.validaCombo(tipoDocumentoCombo));
    }//GEN-LAST:event_tipoDocumentoComboFocusLost

    private void tipoDocumentoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocumentoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoDocumentoComboActionPerformed

    private void numeroDocumentoTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroDocumentoTxtFocusGained
        validaciones.validarEnfoque(numeroDocumentoTxt);
    }//GEN-LAST:event_numeroDocumentoTxtFocusGained

    private void numeroDocumentoTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroDocumentoTxtFocusLost
        validarSonido(validaciones.validarCampoVacio(numeroDocumentoTxt));
    }//GEN-LAST:event_numeroDocumentoTxtFocusLost

    private void numeroDocumentoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroDocumentoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroDocumentoTxtActionPerformed

    private void numeroDocumentoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroDocumentoTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroDocumentoTxtKeyPressed

    private void numeroDocumentoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroDocumentoTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroDocumentoTxtKeyReleased

    private void numeroDocumentoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroDocumentoTxtKeyTyped
        validarSonido(validaciones.validarSoloNumeros(evt, numeroDocumentoTxt));
        validaciones.validarCantidadCaracteresTexto(evt, numeroDocumentoTxt,
            constantes.CONSTANTE_CARACTERES_POR_LINEA);
    }//GEN-LAST:event_numeroDocumentoTxtKeyTyped

    private void celularTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_celularTxtFocusGained
        validaciones.validarEnfoque(celularTxt);
    }//GEN-LAST:event_celularTxtFocusGained

    private void celularTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_celularTxtFocusLost
       
    }//GEN-LAST:event_celularTxtFocusLost

    private void celularTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celularTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularTxtActionPerformed

    private void celularTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularTxtKeyPressed

    private void celularTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_celularTxtKeyReleased

    private void celularTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularTxtKeyTyped
        validarSonido(validaciones.validarSoloNumeros(evt, celularTxt));
        validaciones.validarCantidadCaracteresTexto(evt, celularTxt,
            constantes.CONSTANTE_VALOR_POR_DEFECTO);
    }//GEN-LAST:event_celularTxtKeyTyped

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
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog.setDefaultLookAndFeelDecorated(true); 
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
                EmpleadoGUI dialog = new EmpleadoGUI(new javax.swing.JFrame(), true);
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
    
         public void validarSonido(boolean flag){
         if (flag) {
              getToolkit().beep();
             
         }else{
             
         }
     } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosTxt;
    private javax.swing.JTextField celularTxt;
    private javax.swing.JTextField direccionTxt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nombresTxt;
    private javax.swing.JTextField numeroDocumentoTxt;
    private javax.swing.JTextField telefonoTxt;
    private javax.swing.JComboBox<String> tipoDocumentoCombo;
    // End of variables declaration//GEN-END:variables
}
