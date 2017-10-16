/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ConstantesAlmacenyTaller;
import Control.TipoProductoDAO;
import Control.Validaciones;
import Facade.FacadeProducto;
import Modelo.Producto;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author jose luis Rodriguez
 */
public class ProductoGUI extends javax.swing.JDialog {

    Validaciones validaciones = new Validaciones();
    TipoProductoDAO tipoProductoDAO = new TipoProductoDAO();
    ConstantesAlmacenyTaller constantes = new ConstantesAlmacenyTaller();
    FacadeProducto facadeProducto = new FacadeProducto();
    Producto producto = new Producto();
    int contador = 0;

    /**
     * Creates new form ProductoGUI2
     */
    public ProductoGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        validaciones.adicionarItems(tipoProductoCombo,
                tipoProductoDAO.consultarTiposProducto());
        this.setLocationRelativeTo(null);
        this.setTitle("Gestion Productos");
        modificarBtn.setEnabled(false);
        fechaIngresoDate.setEnabled(false);
        fechaIngresoDate.setDate(new Date());
        jButton1.setEnabled(false);
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
        nombreProductoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionTxtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tipoProductoCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidadProductoTxt = new javax.swing.JTextField();
        fabricanteTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaIngresoDate = new com.toedter.calendar.JDateChooser();
        valorProductoTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        consultarBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        mensajeLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreProductoTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        nombreProductoTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        nombreProductoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreProductoTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreProductoTxtFocusLost(evt);
            }
        });
        nombreProductoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProductoTxtActionPerformed(evt);
            }
        });
        nombreProductoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreProductoTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreProductoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreProductoTxtKeyTyped(evt);
            }
        });
        jPanel1.add(nombreProductoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, -1));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        descripcionTxtArea.setColumns(20);
        descripcionTxtArea.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        descripcionTxtArea.setRows(5);
        descripcionTxtArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descripcionTxtAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                descripcionTxtAreaFocusLost(evt);
            }
        });
        descripcionTxtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionTxtAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(descripcionTxtArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 230, 110));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setText("Descripción del Prodcuto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        tipoProductoCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tipoProductoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --" }));
        tipoProductoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoProductoComboItemStateChanged(evt);
            }
        });
        tipoProductoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipoProductoComboFocusLost(evt);
            }
        });
        tipoProductoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoProductoComboActionPerformed(evt);
            }
        });
        jPanel1.add(tipoProductoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 180, -1));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel3.setText("Valor del Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de Ingreso");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        cantidadProductoTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cantidadProductoTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        cantidadProductoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantidadProductoTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidadProductoTxtFocusLost(evt);
            }
        });
        cantidadProductoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadProductoTxtActionPerformed(evt);
            }
        });
        cantidadProductoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadProductoTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidadProductoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadProductoTxtKeyTyped(evt);
            }
        });
        jPanel1.add(cantidadProductoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, -1));

        fabricanteTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        fabricanteTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        fabricanteTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fabricanteTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fabricanteTxtFocusLost(evt);
            }
        });
        fabricanteTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabricanteTxtActionPerformed(evt);
            }
        });
        fabricanteTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fabricanteTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fabricanteTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fabricanteTxtKeyTyped(evt);
            }
        });
        jPanel1.add(fabricanteTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel5.setText("Nombre de Producto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        fechaIngresoDate.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        fechaIngresoDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaIngresoDateKeyTyped(evt);
            }
        });
        jPanel1.add(fechaIngresoDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 180, 24));

        valorProductoTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        valorProductoTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        valorProductoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorProductoTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorProductoTxtFocusLost(evt);
            }
        });
        valorProductoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorProductoTxtActionPerformed(evt);
            }
        });
        valorProductoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorProductoTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorProductoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorProductoTxtKeyTyped(evt);
            }
        });
        jPanel1.add(valorProductoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 180, -1));

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad de Producto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        consultarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        consultarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        consultarBtn.setText("Consultar");
        consultarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBtnActionPerformed(evt);
            }
        });

        modificarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        modificarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(consultarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(modificarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(consultarBtn)
                .addGap(18, 18, 18)
                .addComponent(modificarBtn)
                .addGap(22, 22, 22)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 150, 290));

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoMoto.png"))); // NOI18N
        jLabel8.setText("MOTOREPUESTOS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 410, 80));

        mensajeLbl.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        mensajeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(mensajeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 350, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, 10));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel11.setText("Fabricante");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 10));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, 10));

        jTabbedPane1.addTab("Gestion Producto", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreProductoTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreProductoTxtFocusGained

        validaciones.validarEnfoque(nombreProductoTxt);
    }//GEN-LAST:event_nombreProductoTxtFocusGained

    private void nombreProductoTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreProductoTxtFocusLost

        validarSonido(validaciones.validarCampoVacio(nombreProductoTxt));
    }//GEN-LAST:event_nombreProductoTxtFocusLost

    private void nombreProductoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProductoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProductoTxtActionPerformed

    private void nombreProductoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoTxtKeyPressed

    }//GEN-LAST:event_nombreProductoTxtKeyPressed

    private void nombreProductoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoTxtKeyReleased

    }//GEN-LAST:event_nombreProductoTxtKeyReleased

    private void nombreProductoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoTxtKeyTyped

        validarSonido(validaciones.validarSoloLetras(evt, nombreProductoTxt));
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, nombreProductoTxt,
                constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_nombreProductoTxtKeyTyped

    private void descripcionTxtAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcionTxtAreaFocusGained
        validaciones.validarEnfoque(descripcionTxtArea);
    }//GEN-LAST:event_descripcionTxtAreaFocusGained

    private void descripcionTxtAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcionTxtAreaFocusLost

    }//GEN-LAST:event_descripcionTxtAreaFocusLost

    private void descripcionTxtAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionTxtAreaKeyTyped
        contador++;
        if (!validaciones.validarCantidadCaracteresTexto(evt, descripcionTxtArea,
                constantes.CONSTANTE_TOTAL_DESCRIPCION)) {
            validaciones.minusculaToMayuscula(evt);
            contador = validaciones.validarSaltodeLinea(evt, descripcionTxtArea, contador);
        } else {
            contador = 0;
        }

    }//GEN-LAST:event_descripcionTxtAreaKeyTyped

    private void tipoProductoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoProductoComboItemStateChanged
        validarSonido(validaciones.validaCombo(tipoProductoCombo));
    }//GEN-LAST:event_tipoProductoComboItemStateChanged

    private void tipoProductoComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoProductoComboFocusLost
        validarSonido(validaciones.validaCombo(tipoProductoCombo));
    }//GEN-LAST:event_tipoProductoComboFocusLost

    private void tipoProductoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoProductoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoProductoComboActionPerformed

    private void cantidadProductoTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadProductoTxtFocusGained
        validaciones.validarEnfoque(cantidadProductoTxt);
    }//GEN-LAST:event_cantidadProductoTxtFocusGained

    private void cantidadProductoTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadProductoTxtFocusLost
        validarSonido(validaciones.validarCampoVacio(cantidadProductoTxt));
    }//GEN-LAST:event_cantidadProductoTxtFocusLost

    private void cantidadProductoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadProductoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProductoTxtActionPerformed

    private void cantidadProductoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadProductoTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProductoTxtKeyPressed

    private void cantidadProductoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadProductoTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProductoTxtKeyReleased

    private void cantidadProductoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadProductoTxtKeyTyped
        validarSonido(validaciones.validarSoloNumeros(evt, cantidadProductoTxt));
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, cantidadProductoTxt,
                constantes.CONSTANTE_CANTIDAD_POR_DEFECTO);
    }//GEN-LAST:event_cantidadProductoTxtKeyTyped

    private void fabricanteTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fabricanteTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteTxtFocusGained

    private void fabricanteTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fabricanteTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteTxtFocusLost

    private void fabricanteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fabricanteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteTxtActionPerformed

    private void fabricanteTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fabricanteTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteTxtKeyPressed

    private void fabricanteTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fabricanteTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteTxtKeyReleased

    private void fabricanteTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fabricanteTxtKeyTyped
        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, fabricanteTxt,
                constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_fabricanteTxtKeyTyped

    private void fechaIngresoDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaIngresoDateKeyTyped

    }//GEN-LAST:event_fechaIngresoDateKeyTyped

    private void valorProductoTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorProductoTxtFocusGained
        validaciones.validarEnfoque(valorProductoTxt);
    }//GEN-LAST:event_valorProductoTxtFocusGained

    private void valorProductoTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorProductoTxtFocusLost
        validarSonido(validaciones.validarCampoVacio(valorProductoTxt));
    }//GEN-LAST:event_valorProductoTxtFocusLost

    private void valorProductoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorProductoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProductoTxtActionPerformed

    private void valorProductoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorProductoTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProductoTxtKeyPressed

    private void valorProductoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorProductoTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProductoTxtKeyReleased

    private void valorProductoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorProductoTxtKeyTyped
        validarSonido(validaciones.validarSoloNumeros(evt, valorProductoTxt));
        validaciones.validarCantidadCaracteresTexto(evt, valorProductoTxt,
                constantes.CONSTANTE_VALOR_POR_DEFECTO);
    }//GEN-LAST:event_valorProductoTxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if (!validaciones.validarCampoVacio(nombreProductoTxt)) {
                producto = new Producto();
                producto.setNombreProdcto(nombreProductoTxt.getText().trim());
            
            
            if (validaciones.validarCamposProducto(nombreProductoTxt, valorProductoTxt,
                    fabricanteTxt, cantidadProductoTxt, descripcionTxtArea, fechaIngresoDate,
                    tipoProductoCombo).equals("") && 
                    facadeProducto.consultarProducto(producto) == null) {
                facadeProducto.registrarProducto(mapearProducto());
                mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_REGISTRO_EXITOSO);
                
                jButton1.setEnabled(false);
                modificarBtn.setEnabled(false);
                
                mensajeLbl.setForeground(Color.green);
                validaciones.limpiarCamposProducto(nombreProductoTxt, valorProductoTxt,
                                                   fabricanteTxt, cantidadProductoTxt,
                                                   descripcionTxtArea, fechaIngresoDate,
                                                   tipoProductoCombo);

                
            } else {
                mensajeLbl.setText(validaciones.validarCamposProducto(nombreProductoTxt, valorProductoTxt,
                        fabricanteTxt, cantidadProductoTxt, descripcionTxtArea, fechaIngresoDate,
                        tipoProductoCombo));
                validaciones.notificarMensajeconTimer(mensajeLbl);
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        try {
            producto = new Producto();
            producto.setNombreProdcto(nombreProductoTxt.getText());
            if (!validaciones.validarCampoVacio(nombreProductoTxt)
                    && facadeProducto.consultarProducto(producto) != null) {

                validaciones.mapearProductoVista(facadeProducto.consultarProducto(producto),
                        nombreProductoTxt, descripcionTxtArea, tipoProductoCombo,
                        cantidadProductoTxt, fechaIngresoDate,
                        valorProductoTxt, fabricanteTxt);
                jButton1.setEnabled(false);
                modificarBtn.setEnabled(true);
                mensajeLbl.setForeground(Color.green);
                mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_PRODUCTO_ENCONTRADO);
                cantidadProductoTxt.setEnabled(false);
            } else {
                modificarBtn.setEnabled(false);
                jButton1.setEnabled(true);
                mensajeLbl.setForeground(Color.red);
                mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_PRODUCTO_NO_ENCONTRADO);
                cantidadProductoTxt.setEnabled(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        }
        validaciones.notificarMensajeconTimer(mensajeLbl);
    }//GEN-LAST:event_consultarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        try {
            if (validaciones.validarCamposProducto(nombreProductoTxt, valorProductoTxt,
                    fabricanteTxt, cantidadProductoTxt, descripcionTxtArea, fechaIngresoDate,
                    tipoProductoCombo).equals("")) {

                mensajeLbl.setText(facadeProducto.modificarProducto(mapearProducto()));

            } else {
                mensajeLbl.setText(validaciones.validarCamposProducto(nombreProductoTxt, valorProductoTxt,
                        fabricanteTxt, cantidadProductoTxt, descripcionTxtArea, fechaIngresoDate,
                        tipoProductoCombo));

            }
            validaciones.notificarMensajeconTimer(mensajeLbl);

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        validaciones.limpiarCamposProducto(nombreProductoTxt, valorProductoTxt, fabricanteTxt, cantidadProductoTxt, descripcionTxtArea, fechaIngresoDate, tipoProductoCombo);
        modificarBtn.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog.setDefaultLookAndFeelDecorated(true);
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
                ProductoGUI dialog = new ProductoGUI(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField cantidadProductoTxt;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JTextArea descripcionTxtArea;
    private javax.swing.JTextField fabricanteTxt;
    private com.toedter.calendar.JDateChooser fechaIngresoDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel mensajeLbl;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField nombreProductoTxt;
    private javax.swing.JComboBox<String> tipoProductoCombo;
    private javax.swing.JTextField valorProductoTxt;
    // End of variables declaration//GEN-END:variables

    public void validarSonido(boolean flag) {
        if (flag) {
            getToolkit().beep();

        } else {

        }
    }

    public Producto mapearProducto() {
        producto.setNombreProdcto(nombreProductoTxt.getText());
        producto.setDescripcion(descripcionTxtArea.getText());
        producto.setTipoProducto(tipoProductoCombo.getSelectedItem().toString());
        producto.setFabricante(fabricanteTxt.getText());
        producto.setCantidad(Integer.parseInt(cantidadProductoTxt.getText()));
        producto.setFechaIngreso(fechaIngresoDate.getDate());
        producto.setValor(Double.parseDouble(valorProductoTxt.getText()));
        producto.setEstado(constantes.CONSTANTE_ESTADO_POR_DEFECTO);
        return producto;
    }

}
