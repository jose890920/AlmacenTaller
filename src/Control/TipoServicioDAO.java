
package Control;

import Modelo.TipoServicio;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author jose luis Rodriguez
 */
public class TipoServicioDAO extends CatalogoDAO{
    
        public void registrarTipoServicio(TipoServicio tipoServicio) throws SQLException {
        
        queryCodigo = "select llave, valor from tipo_servicio"
                + " WHERE llave = '"+tipoServicio.getLlave()+"'";
        
        if (validaciones.validarExistenciaRegistro(sentencia.gestionarConsulta(queryCodigo))) {
            
            query =  "INSERT INTO tipo_servicio( " 
                    +"	llave, valor)\n" 
                    +"	VALUES ('"+tipoServicio.getLlave()+"',"
                    + " '"+tipoServicio.getValor()+"')";
            
            crearRegistro(query);
            
        }
    }
    
    public Map <String,String> consultarTiposServicio(){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_servicio";
        
        return consultaRegistros(query);
        
    }
    
        public Map <String,String> consultarTipoServicioLlave(String llave){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_servicio"
                + " WHERE llave = '"+llave+"'";
        
        return consultaRegistros(query);
        
    }
    
    public void eliminarTipoServicio(String llave){
    
        query =  " DELETE FROM tipo_servicio " 
                +" WHERE llave = '"+llave+"'";
        
        eliminarRegistro(query);
        
    }
    
    public void modificarTipoServicio(TipoServicio tiposervicio){
    
        
        query =  "UPDATE tipo_servicio "  
                +" SET valor = '"+tiposervicio.getValor()+"' " 
                +" WHERE llave = '"+tiposervicio.getLlave()+"'";
        
        modificarRegistro(query);
    
    }
    
    

    public static void main(String[] args) throws SQLException {
        TipoServicioDAO td = new TipoServicioDAO();
        TipoServicio t = new TipoServicio();
        
        t.setLlave("SCO");
        t.setValor("SCOOTER");
        //td.registrarTipoServicio(t);
        //td.consultarTiposServicio();
        //td.consultarTipoServicioLlave("sco".toUpperCase());
        //td.modificarTipoServicio(t);
        //td.eliminarTipoServicio("sco".toUpperCase());
    }



    
}
