
package Control;

import Modelo.DetalleCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleCompraDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarDetalleCompra(DetalleCompra detalleCompra)throws SQLException, ParseException{

     
        detalleCompra.setCodCompra(2);
        detalleCompra.setCodProducto(1);
        detalleCompra.setCantidadProducto(5);
        detalleCompra.setValorUnitario(11_000);
        detalleCompra.setValorConjunto(
                validaciones.calcularValorConjunto(detalleCompra.getValorUnitario(),
                detalleCompra.getCantidadProducto()));
        detalleCompra.setDescuento(
                validaciones.calcularDescuento(10, detalleCompra.getValorConjunto()));
        
        queryCodigo = "select MAX(cod_detalle_Compra) conteo from detalle_Compra";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        detalleCompra.setCodDetalleCompra(sentencia.contarCodigos(result));
        
        query = "INSERT INTO detalle_compra( " +
                " cod_detalle_compra, cod_compra_dc, cod_producto_dc,"
                + " cantidad_producto, valor_unitario, valor_conjunto, descuento)" 
                +" VALUES ( "+detalleCompra.getCodDetalleCompra()+","
                + " "+detalleCompra.getCodCompra()+","+detalleCompra.getCodProducto()+","
                + " "+detalleCompra.getCantidadProducto()+","
                + " "+detalleCompra.getValorUnitario()+", "+detalleCompra.getValorConjunto()+","
                + " "+detalleCompra.getDescuento()+" )";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarDetalleCompra(DetalleCompra detalleCompra) throws ParseException{
        
        detalleCompra.setCodCompra(2);
        detalleCompra.setCodProducto(1);
        detalleCompra.setCantidadProducto(50);
        detalleCompra.setValorUnitario(15_000);
        detalleCompra.setValorConjunto(
                validaciones.calcularValorConjunto(detalleCompra.getValorUnitario(),
                detalleCompra.getCantidadProducto()));
        detalleCompra.setDescuento(
                validaciones.calcularDescuento(10, detalleCompra.getValorConjunto()));
        detalleCompra.setCodDetalleCompra(1);
    
    query =    "UPDATE detalle_Compra " 
            + " SET  cod_compra_dc="+detalleCompra.getCodCompra()+","
            + " cod_producto_dc="+detalleCompra.getCodProducto()+","
            + " cantidad_producto="+detalleCompra.getCantidadProducto()+","
            + " valor_unitario="+detalleCompra.getValorUnitario()+"," 
            + " valor_conjunto="+detalleCompra.getValorConjunto()+","
            + " descuento="+detalleCompra.getDescuento()+""
            + " WHERE cod_detalle_Compra = "+detalleCompra.getCodDetalleCompra()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarDetalleCompra(Integer codDetalleCompra){
            
            query = "DELETE FROM detalle_Compra" +
                    " WHERE cod_detalle_Compra = "+codDetalleCompra+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <DetalleCompra> consultarDetalleCompra()throws SQLException{
        
        
        
            query = "SELECT cod_detalle_compra, cod_compra_dc, cod_producto_dc,"
                    + " cantidad_producto, valor_unitario, valor_conjunto, descuento " +
                    " FROM detalle_compra ORDER BY cod_detalle_Compra ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearDetalleCompras(resultset);
    }
    
        public DetalleCompra consultarDetalleCompraCodDetalleCompra(Integer codDetalleCompra){
            
            query = "SELECT cod_detalle_compra, cod_compra_dc, cod_producto_dc,"
                    +" cantidad_producto, valor_unitario, valor_conjunto, descuento, " 
                    +" compra.estado estdc FROM detalle_compra, compra WHERE cod_compra_dc = cod_compra"
                    +" AND cod_detalle_compra = "+codDetalleCompra+" AND compra.estado = 'Activo' "
                    + "ORDER BY cod_detalle_Compra ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearDetalleCompra(resultset);
    }
        
        public List <DetalleCompra> mapearDetalleCompras(ResultSet resultset){
            
                List <DetalleCompra> listadoDetalleCompras = new ArrayList<>();
                DetalleCompra detalleCompra = new DetalleCompra();
                
            try {
                
              while(resultset.next()){
                
                detalleCompra.setCodDetalleCompra(resultset.getInt("cod_detalle_Compra"));
                detalleCompra.setCodCompra(resultset.getInt("cod_compra_dc"));
                detalleCompra.setCodProducto(resultset.getInt("cod_producto_dc"));
                detalleCompra.setCantidadProducto(resultset.getInt("cantidad_producto"));
                detalleCompra.setValorUnitario(resultset.getDouble("valor_unitario"));
                detalleCompra.setValorConjunto(resultset.getDouble("valor_conjunto"));
                detalleCompra.setDescuento(resultset.getDouble("descuento"));
               
                listadoDetalleCompras.add(detalleCompra);

                System.out.println(" detalleCompra "+detalleCompra.getCantidadProducto());
                System.out.println(" detalleCompra "+detalleCompra.getValorConjunto());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoDetalleCompras;
        
        }
    
                public DetalleCompra mapearDetalleCompra(ResultSet resultset){
                
                DetalleCompra detalleCompra = new DetalleCompra();
            try {
                    
              if(resultset.next()){
                  
                detalleCompra.setCodDetalleCompra(resultset.getInt("cod_detalle_Compra"));
                detalleCompra.setCodCompra(resultset.getInt("cod_compra_dc"));
                detalleCompra.setCodProducto(resultset.getInt("cod_producto_dc"));
                detalleCompra.setCantidadProducto(resultset.getInt("cantidad_producto"));
                detalleCompra.setValorUnitario(resultset.getDouble("valor_unitario"));
                detalleCompra.setValorConjunto(resultset.getDouble("valor_conjunto"));
                detalleCompra.setDescuento(resultset.getDouble("descuento"));


                System.out.println(" detalleCompra "+detalleCompra.getCantidadProducto());
                System.out.println(" detalleCompra "+detalleCompra.getValorConjunto());              
                System.out.println(""+resultset.getString("estdc"));
                
            }
            } catch (Exception e) {
            }
      
        return detalleCompra;
        }
                

    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        DetalleCompraDAO d = new DetalleCompraDAO();
        DetalleCompra detalleCompra = new DetalleCompra();
        
        //d.registrarDetalleCompra(detalleCompra);
        //d.consultarDetalleCompra();
        //d.modificarDetalleCompra(detalleCompra);
        //d.consultarDetalleCompraCodDetalleCompra(2);
        d.eliminarDetalleCompra(1);

    }
}
