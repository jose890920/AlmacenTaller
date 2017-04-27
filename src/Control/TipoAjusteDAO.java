
package Control;

import Modelo.TipoAjuste;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author jose luis Rodriguez
 */
public class TipoAjusteDAO extends CatalogoDAO{
    

    
        public void registrarTipoAjuste(TipoAjuste tipoAjuste) throws SQLException {
        
        queryCodigo = "select llave, valor from tipo_ajuste"
                + " WHERE llave = '"+tipoAjuste.getLlave()+"'";
        
        if (validaciones.validarExistenciaRegistro(sentencia.gestionarConsulta(queryCodigo))) {
            
            query =  "INSERT INTO tipo_ajuste( " 
                    +"	llave, valor)\n" 
                    +"	VALUES ('"+tipoAjuste.getLlave()+"',"
                    + " '"+tipoAjuste.getValor()+"')";
            
            crearRegistro(query);
            
        }
    }
    
    public Map <String,String> consultarTiposAjuste(){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_ajuste";
        
        return consultaRegistros(query);
        
    }
    
        public Map <String,String> consultarTipoAjusteLlave(String llave){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_ajuste"
                + " WHERE llave = '"+llave+"'";
        
        return consultaRegistros(query);
        
    }
    
    public void eliminarTipoAjuste(String llave){
    
        query =  " DELETE FROM tipo_ajuste " 
                +" WHERE llave = '"+llave+"'";
        
        eliminarRegistro(query);
        
    }
    
    public void modificarTipoAjuste(TipoAjuste tipoajuste){
    
        query =  "UPDATE tipo_ajuste " 
                +" SET valor = '"+tipoajuste.getValor()+"' " 
                +" WHERE llave = '"+tipoajuste.getLlave()+"'";
        
        modificarRegistro(query);
    
    }
    
    

    public static void main(String[] args) throws SQLException {
        TipoAjusteDAO td = new TipoAjusteDAO();
        TipoAjuste t = new TipoAjuste();
        
        t.setLlave("DEV");
        t.setValor("Devolucion");
        td.registrarTipoAjuste(t);
        //td.consultarTiposAjuste();
        //td.consultarTipoAjusteLlave("dev".toUpperCase());
        //td.modificarTipoAjuste(t);
        //td.eliminarTipoAjuste("dev".toUpperCase());
    }

    
        
}
