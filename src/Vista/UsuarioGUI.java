/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ConstantesAlmacenyTaller;

import Control.TipoUsuarioDAO;
import Control.Validaciones;

import Facade.FacadeEmpleado;

import Facade.FacadeUsuario;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Motocicleta;
import Modelo.Persona;
import Modelo.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author jose luis Rodriguez
 */
public class UsuarioGUI extends javax.swing.JDialog {
    
    Validaciones validaciones = new Validaciones();
    ConstantesAlmacenyTaller constantes = new ConstantesAlmacenyTaller();
    TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
    FacadeEmpleado facadeEmpleado = new FacadeEmpleado();
    FacadeUsuario facadeUsuario = new FacadeUsuario();
    Usuario usuario;
    Empleado empleado;
    Persona persona = new Persona();
    boolean flagModificarContrasenia;

  
    
    /**
     * Creates new form MotocicletaGUI
     */
    public UsuarioGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        validaciones.adicionarItems(tipoUsuarioCombo,
        tipoUsuarioDAO.consultarTiposUsuario());
        registrarBtn.setEnabled(true);
        this.setTitle("Gestion Usuarios");
        this.setLocationRelativeTo(null);
        confirmaContraseniaTxt.setVisible(false);
        modificarBtn.setEnabled(false);
        jLabeConfirmaContrasenia.setVisible(false);

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
        tipoUsuarioCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nombreUsuarioTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        registrarBtn = new javax.swing.JButton();
        numeroDocumentoTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nombresTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        consultarBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        contraseniaTxt = new javax.swing.JPasswordField();
        confirmaContraseniaTxt = new javax.swing.JPasswordField();
        jLabeConfirmaContrasenia = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mensajeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tipoUsuarioCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tipoUsuarioCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --" }));
        tipoUsuarioCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoUsuarioComboItemStateChanged(evt);
            }
        });
        tipoUsuarioCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipoUsuarioComboFocusLost(evt);
            }
        });
        tipoUsuarioCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoUsuarioComboActionPerformed(evt);
            }
        });
        jPanel1.add(tipoUsuarioCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, -1));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel10.setText("Tipo de Usuario");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 10));

        nombreUsuarioTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        nombreUsuarioTxt.setMaximumSize(new java.awt.Dimension(6, 10));
        nombreUsuarioTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreUsuarioTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreUsuarioTxtFocusLost(evt);
            }
        });
        nombreUsuarioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioTxtActionPerformed(evt);
            }
        });
        nombreUsuarioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreUsuarioTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreUsuarioTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreUsuarioTxtKeyTyped(evt);
            }
        });
        jPanel1.add(nombreUsuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, -1));

        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel21.setText("Nombre usuario");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 10));

        jLabel29.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel29.setText("Contraseña");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("*");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, 10));

        registrarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        registrarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        registrarBtn.setToolTipText("GUARDAR");
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 145, 55));

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
        jPanel1.add(numeroDocumentoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, -1));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setText("Documento Empleado");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        nombresTxt.setEditable(false);
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
        jPanel1.add(nombresTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 200, -1));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setText("Nombres");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        consultarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        consultarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        consultarBtn.setToolTipText("CONSULTAR");
        consultarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(consultarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 145, 60));

        modificarBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        modificarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        modificarBtn.setToolTipText("MODIFICAR");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(modificarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 145, 55));

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        jButton3.setToolTipText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 145, 55));

        contraseniaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contraseniaTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                contraseniaTxtFocusLost(evt);
            }
        });
        contraseniaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraseniaTxtKeyTyped(evt);
            }
        });
        jPanel1.add(contraseniaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 200, 26));

        confirmaContraseniaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmaContraseniaTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmaContraseniaTxtFocusLost(evt);
            }
        });
        confirmaContraseniaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confirmaContraseniaTxtKeyTyped(evt);
            }
        });
        jPanel1.add(confirmaContraseniaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 200, 26));

        jLabeConfirmaContrasenia.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabeConfirmaContrasenia.setText("Confirmar Contraseña");
        jPanel1.add(jLabeConfirmaContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("*");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, 10));

        jTabbedPane1.addTab("Datos del Usuario", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 320));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 100));

        mensajeLbl.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        mensajeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mensajeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 350, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreUsuarioTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioTxtFocusGained

        validaciones.validarEnfoque(nombreUsuarioTxt);
    }//GEN-LAST:event_nombreUsuarioTxtFocusGained

    private void nombreUsuarioTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioTxtFocusLost

        validarSonido(validaciones.validarCampoVacio(nombreUsuarioTxt));

  
        
    }//GEN-LAST:event_nombreUsuarioTxtFocusLost

    private void nombreUsuarioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioTxtActionPerformed

    private void nombreUsuarioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuarioTxtKeyPressed

    }//GEN-LAST:event_nombreUsuarioTxtKeyPressed

    private void nombreUsuarioTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuarioTxtKeyReleased

    }//GEN-LAST:event_nombreUsuarioTxtKeyReleased

    private void nombreUsuarioTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuarioTxtKeyTyped

        validaciones.minusculaToMayuscula(evt);
        validaciones.validarCantidadCaracteresTexto(evt, nombreUsuarioTxt,
            constantes.CONSTANTE_TEXTO_POR_DEFECTO);
    }//GEN-LAST:event_nombreUsuarioTxtKeyTyped

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed
        
        
        try {
            usuario = new Usuario();
            empleado = new Empleado();
            if (!validaciones.validarCampoVacio(numeroDocumentoTxt)) {
             persona.setNumeroDocumento(numeroDocumentoTxt.getText()); 
            }
            
            
            empleado.setPersona(persona);
            usuario.setEmpleado(empleado);
            if (validaciones.validarCamposUsuario(numeroDocumentoTxt, nombresTxt,
                nombreUsuarioTxt, contraseniaTxt,tipoUsuarioCombo).equals("") &&
                facadeEmpleado.consultarEmpleado(empleado) != null &&
                facadeUsuario.consultarUsuario(usuario) == null &&
                facadeUsuario.consultarUsuarioNombreUsuario(nombreUsuarioTxt.getText().trim()) == null &&
                validaciones.compararContrasenias(contraseniaTxt, confirmaContraseniaTxt)) {
                
                usuario = facadeUsuario.consultarUsuario(usuario);
                empleado = facadeEmpleado.consultarEmpleado(empleado);
                facadeUsuario.registrarUsuario(mapeoUsuario(usuario));
                    
        }else{
                if (!validaciones.validarCamposUsuario(numeroDocumentoTxt, nombresTxt,
                    nombreUsuarioTxt, contraseniaTxt, tipoUsuarioCombo).equals("")) {
                    mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_VALIDACION_POR_DEFECTO);
                }else if(facadeEmpleado.consultarEmpleado(empleado) == null){
                    mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_NO_EXISTE_REGISTRO);
                }else if(facadeUsuario.consultarUsuarioNombreUsuario(nombreUsuarioTxt.getText().trim()) != null){
                    mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_EXISTE_USUARIO);
                }else if(!validaciones.compararContrasenias(contraseniaTxt, confirmaContraseniaTxt)){
                    mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_CONTRASENIAS_DIFERENTES);
                }
                mensajeLbl.setForeground(Color.red);
                    
    }
            validaciones.notificarMensajeconTimer(mensajeLbl);

    }   catch (SQLException | ParseException ex) {
            Logger.getLogger(EmpleadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
          
    }//GEN-LAST:event_registrarBtnActionPerformed

    private void tipoUsuarioComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoUsuarioComboItemStateChanged
        validarSonido(validaciones.validaCombo(tipoUsuarioCombo));
    }//GEN-LAST:event_tipoUsuarioComboItemStateChanged

    private void tipoUsuarioComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoUsuarioComboFocusLost
        validarSonido(validaciones.validaCombo(tipoUsuarioCombo));
    }//GEN-LAST:event_tipoUsuarioComboFocusLost

    private void tipoUsuarioComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoUsuarioComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoUsuarioComboActionPerformed

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

    private void nombresTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombresTxtFocusGained

       
    }//GEN-LAST:event_nombresTxtFocusGained

    private void nombresTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombresTxtFocusLost

       
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

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        
        try {
            usuario = new Usuario();
            empleado = new Empleado();
            persona = new Persona();
            persona.setNumeroDocumento(numeroDocumentoTxt.getText());
            empleado.setPersona(persona);
            
            if (!validaciones.validarCampoVacio(numeroDocumentoTxt) &&
                facadeEmpleado.consultarEmpleado(empleado) != null ) {
                
                empleado = facadeEmpleado.consultarEmpleado(empleado);
                usuario.setEmpleado(empleado);
                nombresTxt.setText(empleado.getPersona().getNombres().trim()+
                        " "+empleado.getPersona().getApellidos().trim());
                if (facadeUsuario.consultarUsuario(usuario) != null) {
                    usuario = facadeUsuario.consultarUsuario(usuario);
                    validaciones.mapearUsuario(usuario, nombreUsuarioTxt,
                                               contraseniaTxt, tipoUsuarioCombo);
                    confirmaContraseniaTxt.setText(contraseniaTxt.getText());
                    confirmaContraseniaTxt.setVisible(false);
                    jLabeConfirmaContrasenia.setVisible(false);
                    modificarBtn.setEnabled(true);
                }
                
                


            }else{
                if (!validaciones.validarCampoVacio(numeroDocumentoTxt)) {
                    registrarBtn.setEnabled(false);
                    modificarBtn.setEnabled(false);

                }

            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(EmpleadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_consultarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        
        try {

            if (validaciones.validarCamposUsuario(numeroDocumentoTxt, nombresTxt,
                                                  nombreUsuarioTxt, contraseniaTxt,
                                                  tipoUsuarioCombo).equals("")){
                if (validaciones.compararContrasenias(contraseniaTxt, confirmaContraseniaTxt)) {
                    usuario.setEmpleado(empleado);
                    mensajeLbl.setForeground(Color.green);
                    mensajeLbl.setText(facadeUsuario.modificarUsuario(mapeoUsuario(usuario)));
                }else{
                    mensajeLbl.setForeground(Color.red);
                    mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_CONTRASENIAS_DIFERENTES);
                }
            

        }else{
            mensajeLbl.setForeground(Color.red);
            mensajeLbl.setText(constantes.CONSTANTE_MENSAJE_VALIDACION_POR_DEFECTO);
        }

        validaciones.notificarMensajeconTimer(mensajeLbl);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(ProductoGUIJF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        validaciones.limpiarCamposUsuario(nombreUsuarioTxt, contraseniaTxt,
                tipoUsuarioCombo, confirmaContraseniaTxt, nombresTxt, numeroDocumentoTxt);
        modificarBtn.setEnabled(false);
        registrarBtn.setEnabled(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void contraseniaTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contraseniaTxtFocusLost
        if (contraseniaTxt.getText().trim().equals("")) {
                   mensajeLbl.setText(constantes.CONSTANTE_CAMPO_CONTRASENIA);
                   mensajeLbl.setForeground(Color.red);
                   validaciones.notificarMensajeconTimer(mensajeLbl);
                   validarSonido(true);
                   confirmaContraseniaTxt.setVisible(false);
                   jLabeConfirmaContrasenia.setVisible(false);
                   confirmaContraseniaTxt.setText("");
        }else{
            confirmaContraseniaTxt.setVisible(true);
            jLabeConfirmaContrasenia.setVisible(true);
        }
        
        if (flagModificarContrasenia) {
            confirmaContraseniaTxt.setText("");
        }

    }//GEN-LAST:event_contraseniaTxtFocusLost

    private void contraseniaTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contraseniaTxtFocusGained
        
    }//GEN-LAST:event_contraseniaTxtFocusGained

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void confirmaContraseniaTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmaContraseniaTxtFocusGained

    }//GEN-LAST:event_confirmaContraseniaTxtFocusGained

    private void confirmaContraseniaTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmaContraseniaTxtFocusLost
        if (confirmaContraseniaTxt.getText().trim().equals("")) {
            mensajeLbl.setText(constantes.CONSTANTE_CAMPO_CONTRASENIA);
            mensajeLbl.setForeground(Color.red);
            validaciones.notificarMensajeconTimer(mensajeLbl);
            validarSonido(true);
        }
    }//GEN-LAST:event_confirmaContraseniaTxtFocusLost

    private void contraseniaTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseniaTxtKeyTyped
        validarSonido(validaciones.validarEspacioVacio(evt, contraseniaTxt));
        flagModificarContrasenia = true;
    }//GEN-LAST:event_contraseniaTxtKeyTyped

    private void confirmaContraseniaTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmaContraseniaTxtKeyTyped
     validarSonido(validaciones.validarEspacioVacio(evt, confirmaContraseniaTxt)); 
     flagModificarContrasenia = false;
    }//GEN-LAST:event_confirmaContraseniaTxtKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog.setDefaultLookAndFeelDecorated(true); 
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
                UsuarioGUI dialog = new UsuarioGUI(new javax.swing.JFrame(), true);
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
    private javax.swing.JPasswordField confirmaContraseniaTxt;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JPasswordField contraseniaTxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabeConfirmaContrasenia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel mensajeLbl;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField nombreUsuarioTxt;
    private javax.swing.JTextField nombresTxt;
    private javax.swing.JTextField numeroDocumentoTxt;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JComboBox<String> tipoUsuarioCombo;
    // End of variables declaration//GEN-END:variables

     public void validarSonido(boolean flag){
         if (flag) {
              getToolkit().beep();
             
         }else{
             
         }
     } 
     
     public Usuario mapeoUsuario(Usuario usuario){
         usuario = new Usuario();
         usuario.setCodEmpleado(empleado.getCodEmpleado());
         usuario.setContrasenia(contraseniaTxt.getText().trim().toUpperCase());
         usuario.setEmpleado(empleado);
         usuario.setEstado(constantes.CONSTANTE_ESTADO_POR_DEFECTO);
         usuario.setNombreUsuario(nombreUsuarioTxt.getText().trim());
         usuario.setTipoUsuario(tipoUsuarioCombo.getSelectedItem().toString().trim());
         
        return usuario;

     }

}
