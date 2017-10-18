
package Control;

import Modelo.DetallePago;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetallePagoDAO {
    

     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarDetallePago(DetallePago detallePago)throws SQLException, ParseException{

     /*
        detallePago.setCodPago(2);
        detallePago.setTipoServicio("Cambio de pastillas delanteras");
        detallePago.setValorServicio(15_000);
        detallePago.setDescuentoServicio(validaciones.calcularDescuento(10,
                                         detallePago.getValorServicio()));
        */
        queryCodigo = "select MAX(cod_detalle_Pago) conteo from detalle_Pago";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        detallePago.setCodDetallePago(sentencia.contarCodigos(result));
        
        query = "INSERT INTO detalle_pago( " 
                +" cod_detalle_pago, cod_pago_d, tipo_servicio,"
                + " valor_servicio, descuento_servicio, descripcion, placa_p)" 
                +" VALUES ( "+detallePago.getCodDetallePago()+","
                + " "+detallePago.getCodPago()+",'"+detallePago.getTipoServicio()+"',"
                + " "+detallePago.getValorServicio()+","
                + " "+detallePago.getDescuentoServicio()+","
                + " '"+detallePago.getDescripcion()+"', "
                + " '"+detallePago.getPlaca()+"' "
                + " )";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarDetallePago(DetallePago detallePago) throws ParseException{
       /* 
        detallePago.setCodPago(2);
        detallePago.setTipoServicio("Cambio de pastillas traseras");
        detallePago.setValorServicio(35_357);
        detallePago.setDescuentoServicio(validaciones.calcularDescuento(10,
                                         detallePago.getValorServicio()));
        detallePago.setCodDetallePago(1);
    */
    query =    "UPDATE detalle_Pago " 
            + " SET  cod_pago_d="+detallePago.getCodPago()+","
            + " tipo_servicio='"+detallePago.getTipoServicio()+"',"
            + " valor_servicio="+detallePago.getValorServicio()+","
            + " descuento_servicio="+detallePago.getDescuentoServicio()+","
            + " descripcion = '"+detallePago.getDescripcion()+"' " 
            + " WHERE cod_detalle_Pago = "+detallePago.getCodDetallePago()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarDetallePago(Integer codDetallePago){
            
            query = "DELETE FROM detalle_Pago" +
                    " WHERE cod_detalle_Pago = "+codDetallePago+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <DetallePago> consultarDetallePago()throws SQLException{
        
        
        
            query =  "SELECT cod_detalle_pago, cod_pago_d, tipo_servicio,"
                    + " valor_servicio, descuento_servicio, descripcion " 
                    +" FROM detalle_pago ORDER BY cod_detalle_pago ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearDetallePagos(resultset);
    }
    
        public DetallePago consultarDetallePagoCodDetallePago(Integer codDetallePago){
            
            query =  "SELECT cod_detalle_pago, cod_pago_d, tipo_servicio,"
                    + " valor_servicio, descuento_servicio, pago_empleado.estado estdp, descripcion " 
                    +" FROM detalle_pago, pago_empleado WHERE cod_pago_d = cod_pago "
                    +" AND cod_detalle_pago = "+codDetallePago+" AND"
                    + " pago_empleado.estado = 'Activo' "
                    +" ORDER BY cod_detalle_Pago ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearDetallePago(resultset);
    }
        
        public List <DetallePago> mapearDetallePagos(ResultSet resultset){
            
                List <DetallePago> listadoDetallePagos = new ArrayList<>();
                DetallePago detallePago = new DetallePago();
                
            try {
                
              while(resultset.next()){
                
                detallePago.setCodDetallePago(resultset.getInt("cod_detalle_Pago"));
                detallePago.setCodPago(resultset.getInt("cod_pago_d"));
                detallePago.setTipoServicio(resultset.getString("tipo_servicio"));
                detallePago.setValorServicio(resultset.getDouble("valor_servicio"));
                detallePago.setDescuentoServicio(resultset.getDouble("descuento_servicio"));
      
               
                listadoDetallePagos.add(detallePago);

                System.out.println(" detallePago "+detallePago.getTipoServicio());
                System.out.println(" detallePago "+detallePago.getValorServicio());
                
                
            }
            } catch (Exception e) {
                System.out.println(e);
            }
      
        return listadoDetallePagos;
        
        }
    
                public DetallePago mapearDetallePago(ResultSet resultset){
                
                DetallePago detallePago = new DetallePago();
            try {
                    
              if(resultset.next()){
                  
                detallePago.setCodDetallePago(resultset.getInt("cod_detalle_Pago"));
                detallePago.setCodPago(resultset.getInt("cod_pago_d"));
                detallePago.setTipoServicio(resultset.getString("tipo_servicio"));
                detallePago.setValorServicio(resultset.getDouble("valor_servicio"));
                detallePago.setDescuentoServicio(resultset.getDouble("descuento_servicio"));

                System.out.println(" detallePago "+detallePago.getTipoServicio());
                System.out.println(" detallePago "+detallePago.getValorServicio());
                System.out.println(""+resultset.getString("estdp"));
                
            }
            } catch (Exception e) {
                 System.out.println(e);
            }
      
        return detallePago;
        }
                

    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        DetallePagoDAO d = new DetallePagoDAO();
        DetallePago detallePago = new DetallePago();
        
        //d.registrarDetallePago(detallePago);
        //d.consultarDetallePago();
        //d.modificarDetallePago(detallePago);
        //d.consultarDetallePagoCodDetallePago(1);
        //d.eliminarDetallePago(1);

    }

    
}
