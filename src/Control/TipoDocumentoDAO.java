
package Control;

/**
 *
 * @author jose luis Rodriguez
 */


import Modelo.TipoDocumento;
import java.sql.SQLException;
import java.util.Map;

public class TipoDocumentoDAO extends CatalogoDAO{

    
    public void registrarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException {
        
        queryCodigo = "select llave, valor from tipo_documento"
                + " WHERE llave = '"+tipoDocumento.getLlave()+"'";
        
        if (validaciones.validarExistenciaRegistro(sentencia.gestionarConsulta(queryCodigo))) {
            
            query =  "INSERT INTO tipo_documento( " 
                    +"	llave, valor)\n" 
                    +"	VALUES ('"+tipoDocumento.getLlave()+"',"
                    + " '"+tipoDocumento.getValor()+"')";
            
            crearRegistro(query);
            
        }
    }
    
    public Map <String,String> consultarTiposDocumento(){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_documento";
        
        return consultaRegistros(query);
        
    }
    
        public Map <String,String> consultarTipoDocumentoLlave(String llave){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_documento"
                + " WHERE llave = '"+llave+"'";
        
        return consultaRegistros(query);
        
    }
    
    public void eliminarTipoDocumento(String llave){
    
        query =  " DELETE FROM tipo_documento " 
                +" WHERE llave = '"+llave+"'";
        
        eliminarRegistro(query);
        
    }
    
    public void modificarTipoDocumento(TipoDocumento tipodocumento){
    
        query =  "UPDATE tipo_documento " 
                +" SET valor = '"+tipodocumento.getValor()+"' " 
                +" WHERE llave = '"+tipodocumento.getLlave()+"'";
        
        modificarRegistro(query);
    
    }
    
    

    public static void main(String[] args) throws SQLException {
        TipoDocumentoDAO td = new TipoDocumentoDAO();
        TipoDocumento t = new TipoDocumento();
        
        t.setLlave("TI");
        t.setValor("Tarjeta de identidad");
        //td.registrarTipoDocumento(t);
        //td.consultarTiposDocumento();
        //td.consultarTipoDocumentoLlave("TI");
        //td.modificarTipoDocumento(t);
        //td.eliminarTipoDocumento("TI");
    }

     

}
