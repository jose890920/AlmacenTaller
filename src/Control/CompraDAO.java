
package Control;

import Modelo.Compra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class CompraDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarCompra(Compra compra)throws SQLException, ParseException{

     
        compra.setCodEmpleado(2);
        compra.setCodProveedor(2);
        compra.setValorTotal(50_000);
        compra.setFechaCompra(validaciones.transformarFechatoDate("05-05-2017"));
        compra.setEstado("Activo");
        
        queryCodigo = "select MAX(cod_compra) conteo from compra";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        compra.setCodCompra(sentencia.contarCodigos(result));
        
        query = "INSERT INTO compra( " 
                +" cod_compra, cod_proveedor_c, cod_empleado_c,"
                + " fecha_compra, valor_total, estado) " 
                +" VALUES ("+compra.getCodCompra()+", "+compra.getCodProveedor()+","
                + " "+compra.getCodEmpleado()+", '"+compra.getFechaCompra()+"',"
                + " "+compra.getValorTotal()+", '"+compra.getEstado()+"')";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarCompra(Compra compra) throws ParseException{
        
        compra.setCodEmpleado(2);
        compra.setCodProveedor(2);
        compra.setValorTotal(55_000);
        compra.setFechaCompra(validaciones.transformarFechatoDate("01-05-2017"));
        compra.setEstado("inactivo");
        compra.setCodCompra(1);
    
    query =    "UPDATE compra " 
            + " SET  cod_proveedor_c="+compra.getCodProveedor()+","
            + " cod_empleado_c='"+compra.getCodEmpleado()+"',"
            + " fecha_compra='"+compra.getFechaCompra()+"',"
            + " valor_total="+compra.getValorTotal()+"," 
            + " estado='"+compra.getEstado()+"'"
            + " WHERE cod_compra = "+compra.getCodCompra()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarCompra(Integer codCompra){
            
            query = "DELETE FROM compra" +
                    " WHERE cod_compra = "+codCompra+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Compra> consultarCompra()throws SQLException{
        
        
        
            query = "SELECT cod_compra, cod_proveedor_c, cod_empleado_c,"
                    + " fecha_compra, valor_total, estado " 
                    +" FROM compra WHERE estado = 'Activo' ORDER BY cod_compra ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearCompras(resultset);
    }
    
        public Compra consultarCompraCodCompra(Integer codCompra){
            
            query = "SELECT cod_compra, cod_proveedor_c, cod_empleado_c,"
                    + " fecha_compra, valor_total, compra.estado, razon_social " 
                    +" FROM compra,proveedor, empleado WHERE "
                    + " compra.estado = 'Activo' AND "
                    + " cod_compra = "+codCompra+""
                    + " AND cod_proveedor_c = cod_proveedor AND"
                    + " cod_empleado_c= cod_empleado ORDER BY cod_compra ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearCompra(resultset);
    }
        
        public List <Compra> mapearCompras(ResultSet resultset){
            
                List <Compra> listadoCompras = new ArrayList<>();
                Compra compra = new Compra();
                
            try {
                
              while(resultset.next()){
                
                compra.setCodCompra(resultset.getInt("cod_compra"));
                compra.setCodProveedor(resultset.getInt("cod_proveedor_c"));
                compra.setCodEmpleado(resultset.getInt("cod_empleado_c"));
                compra.setFechaCompra(resultset.getDate("fecha_compra"));
                compra.setValorTotal(resultset.getInt("valor_total"));
                compra.setEstado(resultset.getString("estado"));
               
                listadoCompras.add(compra);

                System.out.println(" compra "+compra.getFechaCompra());
                System.out.println(" compra "+compra.getValorTotal());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoCompras;
        
        }
    
                public Compra mapearCompra(ResultSet resultset){
                
                Compra compra = new Compra();
            try {
                    
              if(resultset.next()){
                compra.setCodCompra(resultset.getInt("cod_compra"));
                compra.setCodProveedor(resultset.getInt("cod_proveedor_c"));
                compra.setCodEmpleado(resultset.getInt("cod_empleado_c"));
                compra.setFechaCompra(resultset.getDate("fecha_compra"));
                compra.setValorTotal(resultset.getInt("valor_total"));
                compra.setEstado(resultset.getString("estado"));

                System.out.println(" compra "+compra.getFechaCompra());
                System.out.println(" compra "+compra.getValorTotal());                
                System.out.println(""+resultset.getString("razon_social"));
                
            }
            } catch (Exception e) {
            }
      
        return compra;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        CompraDAO c = new CompraDAO();
        Compra compra = new Compra();
        
        //c.registrarCompra(compra);
        //c.consultarCompra();
        //c.modificarCompra(compra);
        //c.consultarCompraCodCompra(2);
        //c.eliminarCompra(1);

    }
}
