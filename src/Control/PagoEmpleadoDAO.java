
package Control;

import Modelo.PagoEmpleado;
import Modelo.ParametrosPagoEmpleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class PagoEmpleadoDAO extends ConstantesAlmacenyTaller{
    

     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public int registrarPagoEmpleado(PagoEmpleado pagoEmpleado)throws SQLException, ParseException{

     /*
        pagoEmpleado.setCodEmpleado(2);
        pagoEmpleado.setDescuento(100_000);
        pagoEmpleado.setValorPago(850_000 - pagoEmpleado.getDescuento());
        pagoEmpleado.setFechaPago(validaciones.transformarFechatoDate("05-05-2017"));
        pagoEmpleado.setEstado("Activo");
       */ 
        queryCodigo = "select MAX(cod_pago) conteo from pago_Empleado";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        pagoEmpleado.setCodPago(sentencia.contarCodigos(result));
        
        query = "INSERT INTO pago_empleado( " 
                + " cod_pago, cod_empleado_pe, valor_pago,"
                + " descuento, fecha_pago, estado) " 
                + " VALUES ("+pagoEmpleado.getCodPago()+","
                + " "+pagoEmpleado.getCodEmpleado()+","+pagoEmpleado.getValorPago()+","
                + " "+pagoEmpleado.getDescuento()+","
                + " '"+pagoEmpleado.getFechaPago()+"', '"+pagoEmpleado.getEstado()+"')";
        
         sentencia.gestionarRegistro(query);
         return pagoEmpleado.getCodPago();
    }
    
    public String modificarPagoEmpleado(PagoEmpleado pagoEmpleado) throws ParseException{
        /*
        pagoEmpleado.setCodEmpleado(2);
        pagoEmpleado.setDescuento(200_000);
        pagoEmpleado.setValorPago(750_000 - pagoEmpleado.getDescuento());
        pagoEmpleado.setFechaPago(validaciones.transformarFechatoDate("01-05-2017"));
        pagoEmpleado.setEstado("inactivo");
        pagoEmpleado.setCodPago(1);
    */
    query =    "UPDATE pago_Empleado " 
            + " SET "
            + " valor_pago = "+pagoEmpleado.getValorPago()+" "
            + " WHERE cod_pago = "+pagoEmpleado.getCodPago()+"";
    
    return sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarPagoEmpleado(Integer codPagoEmpleado){
            
            query = "DELETE FROM pago_Empleado" +
                    " WHERE cod_pago = "+codPagoEmpleado+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <PagoEmpleado> consultarPagoEmpleado()throws SQLException{
        
        
        
            query = "SELECT cod_pago, cod_empleado_pe, valor_pago,"
                    +" descuento, fecha_pago, estado " 
                    +" FROM pago_empleado WHERE"
                    + " estado = 'Activo' ORDER BY cod_pago ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearPagoEmpleados(resultset);
    }
    
        public List<PagoEmpleado> consultarPagoEmpleadoCodPagoEmpleado(String numeroDocumento){
            
            query = "SELECT cod_pago, cod_empleado_pe, valor_pago,"
                    +" descuento, fecha_pago, pago_empleado.estado, ciudad " 
                    +" FROM pago_empleado, empleado, persona WHERE "
                    + " pago_Empleado.estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' AND "
                    + " numero_documento = '"+numeroDocumento+"' "
                    + " AND cod_persona_e = cod_persona  "
                    + " AND cod_empleado_pe = cod_empleado ORDER BY cod_pago ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearPagoEmpleado(resultset);
    }
        
        public List <PagoEmpleado> mapearPagoEmpleados(ResultSet resultset){
            
                List <PagoEmpleado> listadoPagoEmpleados = new ArrayList<>();
                PagoEmpleado pagoEmpleado = new PagoEmpleado();
                
            try {
                
              while(resultset.next()){
                
                pagoEmpleado.setCodPago(resultset.getInt("cod_pago"));
                pagoEmpleado.setCodEmpleado(resultset.getInt("cod_empleado_pe"));
                pagoEmpleado.setValorPago(resultset.getDouble("valor_pago"));
                pagoEmpleado.setDescuento(resultset.getDouble("descuento"));
                pagoEmpleado.setFechaPago(resultset.getDate("fecha_pago"));
                pagoEmpleado.setEstado(resultset.getString("estado"));
               
                listadoPagoEmpleados.add(pagoEmpleado);

                System.out.println(" pagoEmpleado "+pagoEmpleado.getValorPago());
                System.out.println(" pagoEmpleado "+pagoEmpleado.getDescuento());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoPagoEmpleados;
        
        }
    
                public List<PagoEmpleado> mapearPagoEmpleado(ResultSet resultset){
                
                List <PagoEmpleado> listadoPagoEmpleados = new ArrayList<>(); 
            try {
                    
              while(resultset.next()){
                PagoEmpleado pagoEmpleado = new PagoEmpleado();
                pagoEmpleado.setCodPago(resultset.getInt("cod_pago"));
                pagoEmpleado.setCodEmpleado(resultset.getInt("cod_empleado_pe"));
                pagoEmpleado.setValorPago(resultset.getDouble("valor_pago"));
                pagoEmpleado.setDescuento(resultset.getDouble("descuento"));
                pagoEmpleado.setFechaPago(resultset.getDate("fecha_pago"));
                pagoEmpleado.setEstado(resultset.getString("estado"));


                System.out.println(" pagoEmpleado "+pagoEmpleado.getValorPago());
                System.out.println(" pagoEmpleado "+pagoEmpleado.getDescuento());               
                System.out.println(""+resultset.getString("ciudad"));
                listadoPagoEmpleados.add(pagoEmpleado);
            }
            } catch (Exception e) {
            }
      
        return listadoPagoEmpleados;
        }
                
        
                
                
                 public List<ParametrosPagoEmpleado> consultarServiciosPagoEmpleadonumeroDocumento
                (String numeroDocumento,Date fechaInicial, Date fechaFinal){
            
            query = "select tipo_servicio,descripcion,valor_servicio,descuento_servicio,"
                    +" fecha_pago from pago_empleado,detalle_pago,empleado,persona " 
                    +" where cod_pago = cod_pago_d and cod_empleado_pe = cod_empleado and"
                    +" cod_persona_e = cod_persona and pago_empleado.estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"'" 
                    +" and numero_documento = '"+numeroDocumento+"' "
                    +" and fecha_pago >= '"+fechaInicial+"' and fecha_pago <= '"+fechaFinal+"'";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearPagoServicios(resultset);
    }
                
                
    public List<ParametrosPagoEmpleado> mapearPagoServicios(ResultSet resultset){
                
                List <ParametrosPagoEmpleado> listadoPagoEmpleados = new ArrayList<>(); 
            try {
                    
              while(resultset.next()){
                ParametrosPagoEmpleado pagoEmpleado = new ParametrosPagoEmpleado();
                pagoEmpleado.setServicio(resultset.getString("tipo_servicio"));
                pagoEmpleado.setDescripcion(resultset.getString("descripcion"));
                pagoEmpleado.setValorServicio(resultset.getDouble("valor_servicio"));
                pagoEmpleado.setDescuentoServicio(resultset.getDouble("descuento_servicio"));
                pagoEmpleado.setFechaServicio(resultset.getDate("fecha_pago"));
                



                listadoPagoEmpleados.add(pagoEmpleado);
            }
            } catch (Exception e) {
            }
      
        return listadoPagoEmpleados;
        }
    
    
     public List<Double> consultarTotalesPago
                (String numeroDocumento,Date fechaInicial, Date fechaFinal){
            
            query = "select sum(descuento) as sumatoriaDescuento,sum(valor_pago) as sumatoriaPago from "
                    +" pago_empleado,empleado,persona " 
                    +" where cod_empleado_pe = cod_empleado and cod_persona_e = cod_persona"
                    +" and pago_empleado.estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"'" 
                    +" and numero_documento = '"+numeroDocumento+"' "
                    +" and fecha_pago >= '"+fechaInicial+"' and fecha_pago <= '"+fechaFinal+"'";            
            resultset = sentencia.gestionarConsulta(query);
           
            return mapearTotalesPago(resultset);
    }
                
                
    public List<Double> mapearTotalesPago(ResultSet resultset){
                
                List <Double> listadoTotales = new ArrayList<>(); 
            try {
                    
              if(resultset.next()){
                listadoTotales.add(resultset.getDouble("sumatoriaDescuento"));
                listadoTotales.add(resultset.getDouble("sumatoriaPago"));     
            }
            } catch (Exception e) {
            }
      
        return listadoTotales;
        }
    
    public String actualizarPago(String numeroDocumentoEmpleadoPagoTxt,Date fechaInicioDate,Date fechaFinDate){
    
     query =    " update pago_empleado set estado = '"+CONSTANTE_ESTADO_PAGO+"' from empleado,persona " 
                +" where cod_empleado_pe = cod_empleado and cod_persona_e = cod_persona " 
                +" and numero_documento = '"+numeroDocumentoEmpleadoPagoTxt+"' and "
                +" fecha_pago >= '"+fechaInicioDate+"' and fecha_pago <= '"+fechaFinDate+"' "
                +" and pago_empleado.estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"'";
    
    return sentencia.gestionarRegistro(query);
    
    }
    
    public static void main(String[] args) throws SQLException, ParseException {
        PagoEmpleadoDAO p = new PagoEmpleadoDAO();
        PagoEmpleado pagoEmpleado = new PagoEmpleado();
        
        //p.registrarPagoEmpleado(pagoEmpleado);
       //p.consultarPagoEmpleado();
        //p.modificarPagoEmpleado(pagoEmpleado);
        //p.consultarPagoEmpleadoCodPagoEmpleado(2);
        //p.eliminarPagoEmpleado(1);

    }

    
}
