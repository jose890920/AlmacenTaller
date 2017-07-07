
package Control;

import Modelo.DetalleAjuste;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleAjusteDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarDetalleAjuste(DetalleAjuste detalleAjuste)throws SQLException, ParseException{

     /*
        detalleAjuste.setCodAjuste(2);
        detalleAjuste.setCodProducto(1);
        detalleAjuste.setCantidadProducto(5);
        detalleAjuste.setValorUnitario(11_000);
        detalleAjuste.setValorConjunto(
                validaciones.calcularValorConjunto(detalleAjuste.getValorUnitario(),
                detalleAjuste.getCantidadProducto()));
        detalleAjuste.setDescuento(
                validaciones.calcularDescuento(10, detalleAjuste.getValorConjunto()));
       */ 
        queryCodigo = "select MAX(cod_detalle_Ajuste) conteo from detalle_Ajuste";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        detalleAjuste.setCodDetalleAjuste(sentencia.contarCodigos(result));
        
        query = "INSERT INTO public.detalle_ajuste( " +
                " cod_detalle_ajuste, cod_ajuste_d, cod_producto_da,"
                + " cantidad_productos, valor_unitario, valor_conjunto, descuento)" 
                +" VALUES ( "+detalleAjuste.getCodDetalleAjuste()+","
                + " "+detalleAjuste.getCodAjuste()+","+detalleAjuste.getCodProducto()+","
                + " "+detalleAjuste.getCantidadProducto()+","
                + " "+detalleAjuste.getValorUnitario()+", "+detalleAjuste.getValorConjunto()+","
                + " "+detalleAjuste.getDescuento()+" )";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarDetalleAjuste(DetalleAjuste detalleAjuste) throws ParseException{
        
        detalleAjuste.setCodAjuste(2);
        detalleAjuste.setCodProducto(1);
        detalleAjuste.setCantidadProducto(50);
        detalleAjuste.setValorUnitario(15_000);
        detalleAjuste.setValorConjunto(
                validaciones.calcularValorConjunto(detalleAjuste.getValorUnitario(),
                detalleAjuste.getCantidadProducto()));
        detalleAjuste.setDescuento(
                validaciones.calcularDescuento(10, detalleAjuste.getValorConjunto()));
        detalleAjuste.setCodDetalleAjuste(1);
    
    query =    "UPDATE detalle_Ajuste " 
            + " SET  cod_ajuste_d="+detalleAjuste.getCodAjuste()+","
            + " cod_producto_da="+detalleAjuste.getCodProducto()+","
            + " cantidad_productos="+detalleAjuste.getCantidadProducto()+","
            + " valor_unitario="+detalleAjuste.getValorUnitario()+"," 
            + " valor_conjunto="+detalleAjuste.getValorConjunto()+","
            + " descuento="+detalleAjuste.getDescuento()+""
            + " WHERE cod_detalle_Ajuste = "+detalleAjuste.getCodDetalleAjuste()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarDetalleAjuste(Integer codDetalleAjuste){
            
            query = "DELETE FROM detalle_Ajuste" +
                    " WHERE cod_detalle_Ajuste = "+codDetalleAjuste+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <DetalleAjuste> consultarDetalleAjuste()throws SQLException{
        
        
        
            query = "SELECT cod_detalle_ajuste, cod_ajuste_d, cod_producto_da,"
                    + " cantidad_productos, valor_unitario, valor_conjunto, descuento " 
                    + " FROM detalle_ajuste ORDER BY cod_detalle_Ajuste ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearDetalleAjustes(resultset);
    }
    
        public DetalleAjuste consultarDetalleAjusteCodDetalleAjuste(Integer codDetalleAjuste){
            
            query = "SELECT cod_detalle_ajuste, cod_ajuste_d, cod_producto_da,"
                    + " cantidad_productos, valor_unitario, valor_conjunto,"
                    + " descuento, ajuste.estado estdc " 
                    +" FROM detalle_ajuste, ajuste WHERE cod_ajuste_d = cod_ajuste "
                    +" AND cod_detalle_ajuste = "+codDetalleAjuste+" AND ajuste.estado = 'Activo' "
                    +" ORDER BY cod_detalle_Ajuste ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearDetalleAjuste(resultset);
    }
        
        public List <DetalleAjuste> mapearDetalleAjustes(ResultSet resultset){
            
                List <DetalleAjuste> listadoDetalleAjustes = new ArrayList<>();
                DetalleAjuste detalleAjuste = new DetalleAjuste();
                
            try {
                
              while(resultset.next()){
                
                detalleAjuste.setCodDetalleAjuste(resultset.getInt("cod_detalle_Ajuste"));
                detalleAjuste.setCodAjuste(resultset.getInt("cod_ajuste_d"));
                detalleAjuste.setCodProducto(resultset.getInt("cod_producto_da"));
                detalleAjuste.setCantidadProducto(resultset.getInt("cantidad_productos"));
                detalleAjuste.setValorUnitario(resultset.getDouble("valor_unitario"));
                detalleAjuste.setValorConjunto(resultset.getDouble("valor_conjunto"));
                detalleAjuste.setDescuento(resultset.getDouble("descuento"));
               
                listadoDetalleAjustes.add(detalleAjuste);

                System.out.println(" detalleAjuste "+detalleAjuste.getCantidadProducto());
                System.out.println(" detalleAjuste "+detalleAjuste.getValorConjunto());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoDetalleAjustes;
        
        }
    
                public DetalleAjuste mapearDetalleAjuste(ResultSet resultset){
                
                DetalleAjuste detalleAjuste = new DetalleAjuste();
            try {
                    
              if(resultset.next()){
                  
                detalleAjuste.setCodDetalleAjuste(resultset.getInt("cod_detalle_Ajuste"));
                detalleAjuste.setCodAjuste(resultset.getInt("cod_ajuste_d"));
                detalleAjuste.setCodProducto(resultset.getInt("cod_producto_da"));
                detalleAjuste.setCantidadProducto(resultset.getInt("cantidad_productos"));
                detalleAjuste.setValorUnitario(resultset.getDouble("valor_unitario"));
                detalleAjuste.setValorConjunto(resultset.getDouble("valor_conjunto"));
                detalleAjuste.setDescuento(resultset.getDouble("descuento"));

                System.out.println(" detalleAjuste "+detalleAjuste.getCantidadProducto());
                System.out.println(" detalleAjuste "+detalleAjuste.getValorConjunto());              
                System.out.println(""+resultset.getString("estdc"));
                
            }
            } catch (Exception e) {
            }
      
        return detalleAjuste;
        }
                

    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        DetalleAjusteDAO d = new DetalleAjusteDAO();
        DetalleAjuste detalleAjuste = new DetalleAjuste();
        
        //d.registrarDetalleAjuste(detalleAjuste);
        //d.consultarDetalleAjuste();
        //d.modificarDetalleAjuste(detalleAjuste);
        //d.consultarDetalleAjusteCodDetalleAjuste(2);
        //d.eliminarDetalleAjuste(1);

    }
    
}
