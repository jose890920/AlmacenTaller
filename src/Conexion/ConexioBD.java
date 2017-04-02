
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexioBD {
    public Connection connection;
      public Connection conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
    connection=DriverManager.getConnection("jdbc:oracle:thin:@181.48.204.174:XE","JMARUU","ADMIN");
            if (connection!=null) {
                System.out.println("conectado");
            } else {
                System.out.println("sin conexion");
            }
        } catch (Exception e) {
        }
      
    return connection;
    }
}
