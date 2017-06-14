/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Persona;
import Modelo.Producto;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author jose luis Rodriguez
 */
public class Validaciones extends ConstantesAlmacenyTaller{

             Timer t = new Timer(4000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          
      }
  });
    
    javax.swing.JComboBox combobox = null;
    public Date transformarFechatoDate(String fecha) throws ParseException{

        return new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        
    }
    
    public double calcularValorConjunto(double valorUnitario, double unidades){
        
                return valorUnitario * unidades;
    }
    
    public double calcularDescuento(double descuento, double valorConjunto){
    
     return(descuento * valorConjunto)/100;
    }
    
    public double calcularValorTotal(double iva, double valor, double descuento){
    
        return calcularIva(iva, calcularSubTotal(valor, descuento)) +
                calcularSubTotal(valor, descuento);
        
    }
    
    public double  calcularIva(double iva, double valor){
    
        return (valor * iva)/100;
        
    }
    
    public double calcularSubTotal(double valor, double descuento){
    
    return valor - descuento;
    }
    
        public boolean validarExistenciaRegistro(ResultSet resultSet) throws SQLException{
    
    
            if (!resultSet.next()) {
                return true;
            }
            
            return false;
    }
        
         public  boolean validarSoloLetras(KeyEvent ke, JTextField text) { 
             
             
             char c=ke.getKeyChar(); 
             boolean flag = false;
            
       
         
          if(Character.isDigit(c)) { 
              
              
              ke.consume(); 
               text.setText("Solo se permiten Letras");
               text.setBackground(Color.red);
               flag = true;
          }else{
              
              if(Character.isLetter(c)){
              
                     text.setBackground(Color.white);
                    if(text.getText().trim().equals("Solo se permiten Letras")){
                        text.setText("");
                    }
         
          String cadena = (""+c).toUpperCase();
              c = cadena.charAt(0);
              ke.setKeyChar(c);
          }else{
                  if (text.getText().trim().equals("Solo se permiten Letra") ||
                      text.getText().trim().equals("Solo se permiten Letras")) {
                      text.setBackground(Color.white);
                      text.setText("");
                  }
              
              }
              
              
              }
               
        
             
               
          
            return flag; 
                     
        }   
      
            public void minusculaToMayuscula(KeyEvent ke) { 
             
             
             char c=ke.getKeyChar(); 
             
         
          if(Character.isLowerCase(c)) { 
              String cadena = (""+c).toUpperCase();
              c = cadena.charAt(0);
              ke.setKeyChar(c);
               
             
               
          } 
             
                     
        } 
            
            
     public boolean validarSoloNumeros(KeyEvent ke, JTextField text) { 
             char c=ke.getKeyChar(); 
             boolean flag = false;
         
          if(Character.isLetter(c) ||
             Character.isSpace(c)     ) { 
              
              text.setBackground(Color.red);
              ke.consume(); 
              text.setText("Solo se permiten Numeros");
              flag = true;
          }else{
              
              if(text.getText().trim().equals("Solo se permiten Numero") ||
                      text.getText().trim().equals("Solo se permiten Numeros")){
                  text.setText("");
                  text.setBackground(Color.white);
              }
         
          String cadena = (""+c).toUpperCase();
              c = cadena.charAt(0);
              ke.setKeyChar(c);
          }
         return flag;
    } 
            
     
     
     
     public  boolean validarCampoVacio(JTextField text) { 
         
     
         if(text.getText().toString().trim().equalsIgnoreCase("") || text.getText().equals(null)){
             
             text.setText("Campo Obligatorio");
             text.setBackground(Color.red);
             return true;
         }
         
          if (text.getText().toString().trim().equalsIgnoreCase("Campo Obligatorio") ||
             text.getText().toString().trim().equalsIgnoreCase("Solo se permiten Letras") ||
             text.getText().toString().trim().equalsIgnoreCase("Solo se permiten Numeros")) {
              
                text.setBackground(Color.red);  
            return true;
          }
         
         text.setBackground(Color.white);
         return false;
          }
     
     public void validarEnfoque(JTextField text){
         if (text.getText().toString().trim().equalsIgnoreCase("Campo Obligatorio") ||
             text.getText().toString().trim().equalsIgnoreCase("Solo se permiten Letras") ||
             text.getText().toString().trim().equalsIgnoreCase("Solo se permiten Numeros")) {
             text.setBackground(Color.white);
             text.setText("");
         }
     }
    
     public void adicionarItems(JComboBox combo, Map<String, String>  map){

   
         for (Entry<String, String> mapeo : map.entrySet()) {
            
             combo.addItem(mapeo.getValue().trim());
            
         }
         
     }
     
     public boolean validaCombo(JComboBox combo){
         if (combo.getSelectedItem().equals("-- Select --")) {
             combo.setBackground(Color.red);
             return true;
         }else{
         combo.setBackground(Color.white);
         }
         return false;
     }
     

     public boolean validaTextArea(JTextArea textArea){
         if (textArea.getText().trim().equalsIgnoreCase("")) {
             textArea.setText("Campo Obligatorio");
             textArea.setBackground(Color.red);
             textArea.setColumns(12);
             return true;
         }
         return false;
     }
      
     
     public void validarEnfoque(JTextArea textArea){
        if (textArea.getText().toString().trim().equalsIgnoreCase("Campo Obligatorio") ||
            textArea.getText().toString().trim().equalsIgnoreCase("Solo se permiten Letras") ||
            textArea.getText().toString().trim().equalsIgnoreCase("Solo se permiten Numeros")) {
            textArea.setBackground(Color.white);
             textArea.setText("");
         }
     }
     

     

     
          public boolean ordenarValidaciones(boolean validacion1, boolean validacion2){
     
         if (validacion1 || validacion2) {
            return true; 
         }

     return false;
     }
    
          
          public void validarCantidadCaracteresTexto(KeyEvent ke, JTextField text,int cantidad) {
          if(text.getText().trim().length() > cantidad-1){
          
          ke.consume();
          }
          }
          
          public int validarSaltodeLinea(KeyEvent ke,JTextArea text,int cantidad){
              
          if(cantidad > 25){
          
          ke.consume();
          text.setText(text.getText()+"\n");
          cantidad=0;
          
          }
          return cantidad;
          }
          
          public boolean validarCantidadCaracteresTexto(KeyEvent ke, JTextArea text,int cantidad) {
          if(text.getText().trim().length() > cantidad-1){
          
          ke.consume();
          return true;
          }
          return false;
          }
          
          public String transformarFechatoString(Date fecha) throws ParseException{
              DateFormat formato = DateFormat.getDateInstance();
              return formato.format(fecha);
          }
          
          public void validarCampoFecha(KeyEvent ke){
               char c=ke.getKeyChar(); 
               System.out.println("entre");
          if(Character.isLetter(c)){
          ke.consume();
          }
          }
          
          public void mapearProductoVista(Producto producto,JTextField nombre,
                      JTextArea descripcion,JComboBox tipoProducto, JTextField cantidad,
                      JDateChooser fecha,JTextField valor,JTextField fabricante){
          nombre.setText(producto.getNombreProdcto().trim());
          descripcion.setText(producto.getDescripcion().trim());
          tipoProducto.setSelectedItem(producto.getTipoProducto().trim());
          cantidad.setText(producto.getCantidad().toString().trim());
          fecha.setDate(producto.getFechaIngreso());
          valor.setText(String.valueOf(producto.getValor()));
          fabricante.setText(producto.getFabricante().trim());
          }
          
          
          public void notificarMensajeconTimer(JLabel etiqueta){
             
              
        
         t = new Timer(2000, limpiarCampo(etiqueta));
        t.start();
          
          }
          
          public ActionListener limpiarCampo(JLabel etiqueta){
          
              return new ActionListener() {
                  
           @Override
           public void actionPerformed(ActionEvent e) {
               
           etiqueta.setText("");
              paraTimer();
           }
       };
          }
          
          public void paraTimer(){
          t.stop();
          }
          
          public void limpiarCamposProducto(JTextField nombre,JTextField valor,
                  JTextField fabricante,JTextField cantidad,JTextArea descripcion,
                  JDateChooser fecha, JComboBox tipo){
              
            nombre.setText("");
            descripcion.setText("");
            valor.setText("");
            cantidad.setText("");tipo.setSelectedItem("-- Select --");
            fabricante.setText("");
            fecha.setDate(null);
            
            
          
          
          }
          
          public String validarCamposProducto(JTextField nombre,JTextField valor,
                  JTextField fabricante,JTextField cantidad,JTextArea descripcion,
                  JDateChooser fecha, JComboBox tipo){
              if (nombre.getText().trim().equals("") || nombre.getText()== null ||
                  fabricante.getText().trim().equals("") || fabricante.getText() == null ||
                  descripcion.getText().trim().equals("") || descripcion.getText().trim() == null ||
                  valor.getText().trim().equals("") || valor.getText().trim() == null ||
                  cantidad.getText().trim().equals("") || cantidad.getText().trim() == null ||
                  fecha.getDate() == null || fecha.getDate().compareTo(new Date()) != -1 ||
                  tipo.getSelectedItem().equals("-- Select --")) {
                  
                    return "Valide los Campos Obligatorios";   
              }
                    return "";   

          }
          
          public void ocultarCampo(JTextField campo, JComboBox combo,JLabel etiqueta){
          
             if (combo.getSelectedItem().equals("OTRA")) {
                    
                    campo.setBackground(Color.white);
                    campo.setVisible(true);
                    etiqueta.setVisible(true);            
            }else{
                    campo.setText("");
                    campo.setVisible(false);
                    etiqueta.setVisible(false);
        }
          
          }
          
          
                    public String validarCamposEmpleado(JTextField nombres,JTextField apellidos,
                  JComboBox tipoDocumento,JTextField numeroDocumento,JTextField direccion,
                  JRadioButton femenino,JRadioButton masculino,JDateChooser fechaIngreso,
                  JDateChooser fechaNacimiento, JComboBox estadoCivil, JComboBox ciudad,
                  JTextField otraCiudad){
              if (nombres.getText().trim().equals("") || nombres.getText()== null ||
                  apellidos.getText().trim().equals("") || apellidos.getText() == null ||
                  tipoDocumento.getSelectedItem().equals("-- Select --")||
                  estadoCivil.getSelectedItem().equals("-- Select --")||
                  ciudad.getSelectedItem().equals("-- Select --")||
                  numeroDocumento.getText().trim().equals("") || numeroDocumento.getText().trim() == null ||
                  direccion.getText().trim().equals("") || direccion.getText().trim() == null ||
                      (!femenino.isSelected() && !masculino.isSelected())||
                  fechaIngreso.getDate() == null || fechaIngreso.getDate().compareTo(new Date()) != -1 ||
                  fechaNacimiento.getDate() == null  
                  ) {

                  
                    return "Valide los Campos Obligatorios";   
              }
                    if (!compararFechas(fechaIngreso.getDate(), fechaNacimiento.getDate()).equals("")) {
                            return compararFechas(fechaIngreso.getDate(), fechaNacimiento.getDate());
                        }
                       
                    return "";   

          }
                    
                    public String validarEleccionGenero(JRadioButton femenino, JRadioButton masculino){
                        if (femenino.isSelected()) {
                            return CONSTANTE_GENERO_FEMENINO;
                        } else {
                             if (masculino.isSelected()) {
                            return CONSTANTE_GENERO_MASCULINO;
                             }
                        }
                    return "";
                    }
                    
                    public String obtenerCiudadEmpleado(JTextField ciudad, JComboBox combo){
                        
                        if (combo.getSelectedItem().toString().equals("OTRA")) {
                            return ciudad.getText();
                        }
                    return combo.getSelectedItem().toString();
                    }
                    
                    public String compararFechas(Date fecha1, Date fecha2){

                    double anios = ((fecha1.getTime()-fecha2.getTime())/(1000*60*60*24))/365;
                        if (anios >= 18) {
                            return "";
                        }
                    
                    
                    return "El Empleado Debe Ser Mayor de Edad";
                    }
                    
                    public void mapearEmpleado(Empleado empleado, JTextField nombres,JTextField apellidos,
                  JComboBox tipoDocumento,JTextField numeroDocumento,JTextField direccion,
                  JTextField telefono, JTextField celular,
                  JRadioButton femenino,JRadioButton masculino,JDateChooser fechaIngreso,
                  JDateChooser fechaNacimiento, JComboBox estadoCivil, JComboBox ciudad,
                  JTextField otraCiudad){
                    
                       
                        
                        nombres.setText(empleado.getPersona().getNombres().trim());
                        apellidos.setText(empleado.getPersona().getApellidos().trim());
                        if (validarCiudad(ciudad, otraCiudad, empleado.getCiudad())) {
                            ciudad.setSelectedItem(empleado.getCiudad().trim());
                            otraCiudad.setVisible(false);
                        }else{
                            otraCiudad.setVisible(true);
                            otraCiudad.setText(empleado.getCiudad().trim());
                            ciudad.setSelectedItem("OTRA");
                        }
                        tipoDocumento.setSelectedItem(empleado.getPersona().getTipoDocumento().trim());
                        numeroDocumento.setText(empleado.getPersona().getNumeroDocumento().trim());
                        direccion.setText(empleado.getPersona().getDireccion().trim());
                        telefono.setText(empleado.getPersona().getTelefono().trim());
                        celular.setText(empleado.getPersona().getCelular().trim());
                        if (mapearGenero(empleado.getSexo()).equals(CONSTANTE_GENERO_FEMENINO)) {
                            femenino.setSelected(true);
                        }else{
                            masculino.setSelected(true);
                        }
                        fechaIngreso.setDate(empleado.getFechaIngreso());
                        fechaNacimiento.setDate(empleado.getFechaNacimiento());
                        estadoCivil.setSelectedItem(empleado.getEstadoCivil().trim());
                    }
                    
                    public boolean validarCiudad(JComboBox ciudad, JTextField otraCiudad,String valor){
                        
                          
                        for (int i = 1; i < ciudad.getItemCount()-1; i++) {
                            System.out.println(" "+ciudad.getItemAt(i));
                            if (valor.trim().equals(ciudad.getItemAt(i))) {
                                return true;
                            }
                        }
                    return false;
                    }
                    
                    public String mapearGenero(String genero){
                    
                        if (genero.equals(CONSTANTE_GENERO_FEMENINO)) {
                            return CONSTANTE_GENERO_FEMENINO;
                        }
                        return CONSTANTE_GENERO_MASCULINO;
                    
                    }
                   

                    
                    
        public void limpiarCamposEmpleado(JTextField nombres,JTextField apellidos,
                  JComboBox tipoDocumento,JTextField numeroDocumento,JTextField direccion,
                  JTextField telefono, JTextField celular,
                  ButtonGroup buttonGroupGenero,JDateChooser fechaIngreso,
                  JDateChooser fechaNacimiento, JComboBox estadoCivil, JComboBox ciudad,
                  JTextField otraCiudad){
                        
                        nombres.setText("");
                        apellidos.setText("");
                        numeroDocumento.setText("");
                        direccion.setText("");
                        telefono.setText("");
                        celular.setText("");
                        otraCiudad.setText("");
                        tipoDocumento.setSelectedItem("-- Select --");
                        buttonGroupGenero.clearSelection();
                        fechaIngreso.setDate(null);
                        fechaNacimiento.setDate(null);
                        estadoCivil.setSelectedItem("-- Select --");
                        ciudad.setSelectedItem("-- Select --");
                        
                    
                    
         }
                    
                    
                    
         public String validarCamposCliente(JTextField nombres,JTextField apellidos,
                  JComboBox tipoDocumento,JTextField numeroDocumento,JTextField direccion,
                  JTextField telefono, JTextField celular, JDateChooser fechaNacimiento,
                  JComboBox tieneMotocicleta, JTextField barrio, JRadioButton femenino,
                  JRadioButton masculino){
                        
                        if (nombres.getText().equals("") || nombres.getText() == null  ||
                            apellidos.getText().equals("") || 
                            apellidos.getText() == null ||
                            numeroDocumento.getText().equals("") || 
                            numeroDocumento.getText() == null ||
                            direccion.getText().equals("") ||
                            direccion.getText() == null ||
                            (!femenino.isSelected() && !masculino.isSelected())||
                            tipoDocumento.getSelectedItem().equals(CONSTANTE_COMBO_POR_DEFECTO) ||
                            tieneMotocicleta.getSelectedItem().equals(CONSTANTE_COMBO_POR_DEFECTO)) {
                            
                            return CONSTANTE_MENSAJE_VALIDACION_POR_DEFECTO;
                            
                        }
                    
                    return "";
                    
                    
        }
                    
                    
        public String validarTieneMotocicleta(String seleccion){
                        if (seleccion.equals("SI")) {
                            return CONSTANTE_SELECCION_SI_POR_DEFECTO;
                        } else {
                             if (seleccion.equals("NO")) {
                            return CONSTANTE_SELECCION_NO_POR_DEFECTO;
                             }
                        }
                    return "";
        }
      
        
        
        public void mapearCliente(Cliente cliente, JTextField nombres,JTextField apellidos,
                  JComboBox tipoDocumento,JTextField numeroDocumento,JTextField direccion,
                  JTextField telefono, JTextField celular,JRadioButton femenino,
                  JRadioButton masculino,JDateChooser fechaNacimiento, JComboBox tieneMotocicleta,
                  JTextField barrio){
                    
                       
                        
                        nombres.setText(cliente.getPersona().getNombres().trim());
                        apellidos.setText(cliente.getPersona().getApellidos().trim());

                        tipoDocumento.setSelectedItem(cliente.getPersona().getTipoDocumento().trim());
                        numeroDocumento.setText(cliente.getPersona().getNumeroDocumento().trim());
                        direccion.setText(cliente.getPersona().getDireccion().trim());
                        telefono.setText(cliente.getPersona().getTelefono().trim());
                        celular.setText(cliente.getPersona().getCelular().trim());
                        if (mapearGenero(cliente.getSexo()).equals(CONSTANTE_GENERO_FEMENINO)) {
                            femenino.setSelected(true);
                        }else{
                            masculino.setSelected(true);
                        }
                        fechaNacimiento.setDate(cliente.getFechaNacimiento());
                        if (cliente.getTieneMotocicleta().trim().equals(CONSTANTE_SELECCION_SI_POR_DEFECTO)) {
                            tieneMotocicleta.setSelectedItem("SI");
                        }else{
                            tieneMotocicleta.setSelectedItem("NO");
                        }
                        barrio.setText(cliente.getBarrio().trim());
        
        }
        
        
        public void limpiarCamposCliente(JTextField nombres,JTextField apellidos,
                  JComboBox tipoDocumento,JTextField numeroDocumento,JTextField direccion,
                  JTextField telefono, JTextField celular,ButtonGroup buttonGroupGenero,
                  JDateChooser fechaNacimiento, JComboBox tieneMotocicleta,
                  JTextField barrio){
                        
                        nombres.setText("");
                        apellidos.setText("");
                        numeroDocumento.setText("");
                        direccion.setText("");
                        telefono.setText("");
                        celular.setText("");
                        barrio.setText("");
                        tipoDocumento.setSelectedItem("-- Select --");
                        buttonGroupGenero.clearSelection();
                        fechaNacimiento.setDate(null);
                        tieneMotocicleta.setSelectedItem(CONSTANTE_COMBO_POR_DEFECTO);
                        
                        
                    
                    
         }    
        
        
        
        
        
     }

    
