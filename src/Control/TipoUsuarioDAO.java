
package Control;

import Modelo.TipoUsuario;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author jose luis Rodriguez
 */
public class TipoUsuarioDAO extends CatalogoDAO{
    
        
        
        public void registrarTipoUsuario(TipoUsuario tipoUsuario) throws SQLException {
        
        queryCodigo = "select llave, valor from tipo_usuario"
                + " WHERE llave = '"+tipoUsuario.getLlave()+"'";
        
        if (validaciones.validarExistenciaRegistro(sentencia.gestionarConsulta(queryCodigo))) {
            
            query =  "INSERT INTO tipo_usuario( " 
                    +"	llave, valor)\n" 
                    +"	VALUES ('"+tipoUsuario.getLlave()+"',"
                    + " '"+tipoUsuario.getValor()+"')";
            
            crearRegistro(query);
            
        }
    }
    
    public Map <String,String> consultarTiposUsuario(){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_usuario";
        
        return consultaRegistros(query);
        
    }
    
        public Map <String,String> consultarTipoUsuarioLlave(String llave){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_usuario"
                + " WHERE llave = '"+llave+"'";
        
        return consultaRegistros(query);
        
    }
    
    public void eliminarTipoUsuario(String llave){
    
        query =  " DELETE FROM tipo_usuario " 
                +" WHERE llave = '"+llave+"'";
        
        eliminarRegistro(query);
        
    }
    
    public void modificarTipoUsuario(TipoUsuario tipousuario){
    
        query =  "UPDATE tipo_usuario " 
                +" SET valor = '"+tipousuario.getValor()+"' " 
                +" WHERE llave = '"+tipousuario.getLlave()+"'";
        
        modificarRegistro(query);
    
    }
    
    

    public static void main(String[] args) throws SQLException {
        TipoUsuarioDAO td = new TipoUsuarioDAO();
        TipoUsuario t = new TipoUsuario();
        
        t.setLlave("MEC");
        t.setValor("MECANICO");
        //td.registrarTipoUsuario(t);
        td.consultarTiposUsuario();
        //td.consultarTipoUsuarioLlave("root".toUpperCase());
        //td.modificarTipoUsuario(t);
        //td.eliminarTipoUsuario("mec".toUpperCase());
    }


    
}
