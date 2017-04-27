/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author jose luis Rodriguez
 */
public class Validaciones {
    javax.swing.JComboBox combobox = null;
    public Date transformarFecha(String fecha) throws ParseException{

        return new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
        
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
         
          if(Character.isLetter(c)) { 
              
              text.setBackground(Color.red);
              ke.consume(); 
              text.setText("Solo se permiten Numeros");
              flag = true;
          }else{
              text.setBackground(Color.red);
              if(text.getText().trim().equals("Solo se permiten Numeros")){
                  text.setText("");
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
      
     }
    
