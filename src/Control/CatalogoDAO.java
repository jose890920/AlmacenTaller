
package Control;

import java.sql.ResultSet;

/**
 *
 * @author jose luis Rodriguez
 */

import Modelo.TipoDocumento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CatalogoDAO {

     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;

    public void crearRegistro(String query){
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void modificarRegistro(String query){
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarRegistro(String query){
    
    sentencia.gestionarRegistro(query);
    
    }
  
    public Map<String, String> consultaRegistros(String query){
    
        resultset = sentencia.gestionarConsulta(query);
        
        return mapearRegistros(resultset);
        
    }
    
    public Map<String, String> mapearRegistros (ResultSet resultset){
        
      Map <String, String>  registros = null ;
        registros = new LinkedHashMap<>();
        try {
            

    
        while (resultset.next()) {            
            registros.put(resultset.getString("llave"),
                         resultset.getString("valor"));
            
            
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
                 for (Map.Entry<String, String> mapeo : registros.entrySet()) {
                     
                     System.out.println(""+mapeo.getValue());

             
         }
        System.out.println(registros);
           
          return registros;
      
    }
    

}
