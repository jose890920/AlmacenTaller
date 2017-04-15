
package Control;

import Modelo.PagoEmpleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class PagoEmpleadoDAO {
    

     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarPagoEmpleado(PagoEmpleado pagoEmpleado)throws SQLException, ParseException{

     
        pagoEmpleado.setCodEmpleado(2);
        pagoEmpleado.setDescuento(100_000);
        pagoEmpleado.setValorPago(850_000 - pagoEmpleado.getDescuento());
        pagoEmpleado.setFechaPago(validaciones.transformarFecha("05-05-2017"));
        pagoEmpleado.setEstado("Activo");
        
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
    }
    
    public void modificarPagoEmpleado(PagoEmpleado pagoEmpleado) throws ParseException{
        
        pagoEmpleado.setCodEmpleado(2);
        pagoEmpleado.setDescuento(200_000);
        pagoEmpleado.setValorPago(750_000 - pagoEmpleado.getDescuento());
        pagoEmpleado.setFechaPago(validaciones.transformarFecha("01-05-2017"));
        pagoEmpleado.setEstado("inactivo");
        pagoEmpleado.setCodPago(1);
    
    query =    "UPDATE pago_Empleado " 
            + " SET  cod_empleado_pe="+pagoEmpleado.getCodEmpleado()+","
            + " valor_pago="+pagoEmpleado.getValorPago()+","
            + " descuento="+pagoEmpleado.getDescuento()+","
            + " fecha_pago='"+pagoEmpleado.getFechaPago()+"'," 
            + " estado='"+pagoEmpleado.getEstado()+"'"
            + " WHERE cod_pago = "+pagoEmpleado.getCodPago()+"";
    
    sentencia.gestionarRegistro(query);
    
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
    
        public PagoEmpleado consultarPagoEmpleadoCodPagoEmpleado(Integer codPagoEmpleado){
            
            query = "SELECT cod_pago, cod_empleado_pe, valor_pago,"
                    +" descuento, fecha_pago, pago_empleado.estado, ciudad " 
                    +" FROM pago_empleado, empleado WHERE "
                    + " pago_Empleado.estado = 'Activo' AND "
                    + " cod_pago = "+codPagoEmpleado+""
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
    
                public PagoEmpleado mapearPagoEmpleado(ResultSet resultset){
                
                PagoEmpleado pagoEmpleado = new PagoEmpleado();
            try {
                    
              if(resultset.next()){
                  
                pagoEmpleado.setCodPago(resultset.getInt("cod_pago"));
                pagoEmpleado.setCodEmpleado(resultset.getInt("cod_empleado_pe"));
                pagoEmpleado.setValorPago(resultset.getDouble("valor_pago"));
                pagoEmpleado.setDescuento(resultset.getDouble("descuento"));
                pagoEmpleado.setFechaPago(resultset.getDate("fecha_pago"));
                pagoEmpleado.setEstado(resultset.getString("estado"));


                System.out.println(" pagoEmpleado "+pagoEmpleado.getValorPago());
                System.out.println(" pagoEmpleado "+pagoEmpleado.getDescuento());               
                System.out.println(""+resultset.getString("ciudad"));
                
            }
            } catch (Exception e) {
            }
      
        return pagoEmpleado;
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
