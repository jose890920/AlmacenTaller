/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jose luis Rodriguez
 */
public class Validaciones {
    
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
    
}
