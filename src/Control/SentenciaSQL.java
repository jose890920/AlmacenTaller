
package Control;

/**
 *
 * @author jose luis Rodriguez
 */

import Conexion.ConexioBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SentenciaSQL {
   
    ConexioBD conector = new ConexioBD();
    Connection conexionBd;
    ResultSet query;
    Statement statement;
    PreparedStatement preparedStatement;
    
    public String gestionarRegistro(String sentenciaSql){
    
        try {
            conexionBd = conector.conectar();
            preparedStatement = conexionBd.prepareStatement(sentenciaSql);
            if (preparedStatement.executeUpdate() > 0) {
                return("Se modifico la tabla");
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
          return("No se modifico la tabla");
    }
    
    public ResultSet gestionarConsulta(String sentenciaSql){
        
        try {
            conexionBd = conector.conectar();
            statement = conexionBd.createStatement();
            query = statement.executeQuery(sentenciaSql);
        } catch (Exception e) {
            System.out.println(e);
        }
            return query;
    }
    
    public Integer contarCodigos(ResultSet result){
        Integer conteo =0;
        try {
                    
        if (result.next()) {
            conteo = result.getInt("conteo")+1;
        }
        } catch (Exception e) {
        }
        return conteo;
    }

}
