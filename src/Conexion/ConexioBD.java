
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import Control.SentenciaSQL;


public class ConexioBD {
    public Connection connection;
    
    
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
          SentenciaSQL sentencia = new SentenciaSQL();
          String a="carlos sanchez", b="155";
         sentencia.gestionarRegistro("insert into EJEMPLO (nombre,cedula) "
                 + "values('"+a+"','"+b+"')");
        /* 
        try {
            
             ResultSet res = sentencia.gestionarConsulta("select count(cedula) conteo from ejemplo");
            while (res.next()) {             
                //System.out.println(res.getString("nombre"));
                System.out.println(res.getInt("conteo"));
         } 
         } catch (Exception e) {
         }
         */
         
    }
}
