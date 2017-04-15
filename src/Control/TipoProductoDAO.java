
package Control;

import Modelo.TipoProducto;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author jose luis Rodriguez
 */
public class TipoProductoDAO extends CatalogoDAO{
    

        public void registrarTipoProducto(TipoProducto tipoProducto) throws SQLException {
        
        queryCodigo = "select llave, valor from tipo_producto"
                + " WHERE llave = '"+tipoProducto.getLlave()+"'";
        
        if (validaciones.validarExistenciaRegistro(sentencia.gestionarConsulta(queryCodigo))) {
            
            query =  "INSERT INTO tipo_producto( " 
                    +"	llave, valor)\n" 
                    +"	VALUES ('"+tipoProducto.getLlave()+"',"
                    + " '"+tipoProducto.getValor()+"')";
            
            crearRegistro(query);
            
        }
    }
    
    public Map <String,String> consultarTiposProducto(){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_producto";
        
        return consultaRegistros(query);
        
    }
    
        public Map <String,String> consultarTipoProductoLlave(String llave){
    
    
        query =  "SELECT llave, valor " 
                +" FROM tipo_producto"
                + " WHERE llave = '"+llave+"'";
        
        return consultaRegistros(query);
        
    }
    
    public void eliminarTipoProducto(String llave){
    
        query =  " DELETE FROM tipo_producto " 
                +" WHERE llave = '"+llave+"'";
        
        eliminarRegistro(query);
        
    }
    
    public void modificarTipoProducto(TipoProducto tipoproducto){
    
        query =  "UPDATE tipo_producto " 
                +" SET valor = '"+tipoproducto.getValor()+"' " 
                +" WHERE llave = '"+tipoproducto.getLlave()+"'";
        
        modificarRegistro(query);
    
    }
    
    

    public static void main(String[] args) throws SQLException {
        TipoProductoDAO td = new TipoProductoDAO();
        TipoProducto t = new TipoProducto();
        
        t.setLlave("BOM");
        t.setValor("BOMBILLA");
        //td.registrarTipoProducto(t);
        //td.consultarTiposProducto();
        //td.consultarTipoProductoLlave("bom".toUpperCase());
        //td.modificarTipoProducto(t);
        //td.eliminarTipoProducto("bom".toUpperCase());
    }


    
}
