
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
    Connection conexionBd = conector.conectar();
    ResultSet query;
    Statement statement;
    PreparedStatement preparedStatement;
    
    public void gestionarRegistro(String sentenciaSql){
    
        try {
            preparedStatement = conexionBd.prepareStatement(sentenciaSql);
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Se modifico la tabla");
                
            }else{
                    System.out.println("No se modifico la tabla");
                }
        } catch (Exception e) {
        }
    }
}
