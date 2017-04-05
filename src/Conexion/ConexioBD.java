
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Control.SentenciaSQL;


public class ConexioBD {
    public Connection connection;
    SentenciaSQL sentencia = new SentenciaSQL();
    
      public Connection conectar(){
        try {
            String clase;
            
             clase="org.postgresql.Driver";
            //clase="com.mysql.jdbc.Driver";
            String url="jdbc:postgresql://localhost:5432/almacentaller";
             //String url="jdbc:mysql://localhost:3306/springbd";
            //String user="root";
             String user="postgres";
            //Class.forName("com.mysql.jdbc.Driver");
             Class.forName(clase);
           // con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springbd","root","j3184813390");
           connection=DriverManager.getConnection(url,user,"almacentaller"); 
           if (connection!=null) {
                System.out.println("conectado");
            }else{
                System.out.println("error al conectar");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
     public static void main(String[] args) {
         ConexioBD conector = new ConexioBD();
         conector.conectar();
         
         conector.sentencia.gestionarRegistro("INSERT INTO EJEMPLO VALUES('JUAN CUADRADO','12345')");
    }
}
