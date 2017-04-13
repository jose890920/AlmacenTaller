/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
    
}
