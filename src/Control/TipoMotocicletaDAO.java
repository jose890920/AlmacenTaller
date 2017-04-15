
package Control;

import Modelo.TipoMotocicleta;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author jose luis Rodriguez
 */
public class TipoMotocicletaDAO extends CatalogoDAO{
    

        public void registrarTipoMotocicleta(TipoMotocicleta tipoMotocicleta) throws SQLException {
        
        queryCodigo = "select llave, valor from tipo_motocicleta"
                + " WHERE llave = '"+tipoMotocicleta.getLlave()+"'";
        
        if (validaciones.validarExistenciaRegistro(sentencia.gestionarConsulta(queryCodigo))) {
            
            query =  "INSERT INTO tipo_motocicleta( " 
                    +"	llave, valor)\n" 
                    +"	VALUES ('"+tipoMotocicleta.getLlave()+"',"
                    + " '"+tipoMotocicleta.getValor()+"')";
            
            crearRegistro(query);
            
        }
    }
    
    public Map <String,String> consultarTiposMotocicleta(){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_motocicleta";
        
        return consultaRegistros(query);
        
    }
    
        public Map <String,String> consultarTipoMotocicletaLlave(String llave){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_motocicleta"
                + " WHERE llave = '"+llave+"'";
        
        return consultaRegistros(query);
        
    }
    
    public void eliminarTipoMotocicleta(String llave){
    
        query =  " DELETE FROM tipo_motocicleta " 
                +" WHERE llave = '"+llave+"'";
        
        eliminarRegistro(query);
        
    }
    
    public void modificarTipoMotocicleta(TipoMotocicleta tipomotocicleta){
    
        query =  "UPDATE tipo_motocicleta " 
                +" SET valor = '"+tipomotocicleta.getValor()+"' " 
                +" WHERE llave = '"+tipomotocicleta.getLlave()+"'";
        
        modificarRegistro(query);
    
    }
    
    

    public static void main(String[] args) throws SQLException {
        TipoMotocicletaDAO td = new TipoMotocicletaDAO();
        TipoMotocicleta t = new TipoMotocicleta();
        
        t.setLlave("SCO");
        t.setValor("SCOOTER");
        //td.registrarTipoMotocicleta(t);
        //td.consultarTiposMotocicleta();
        //td.consultarTipoMotocicletaLlave("sco".toUpperCase());
        //td.modificarTipoMotocicleta(t);
        //td.eliminarTipoMotocicleta("sco".toUpperCase());
    }


    
}
