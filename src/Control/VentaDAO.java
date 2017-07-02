
package Control;

import Modelo.Venta;
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
public class VentaDAO extends ConstantesAlmacenyTaller{

     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public int registrarVenta(Venta venta)throws SQLException, ParseException{

     /*
        venta.setCodEmpleado(2);
        venta.setCodCliente(2);
        venta.setValorTotal(50_000);
        venta.setFechaVenta(validaciones.transformarFechatoDate("05-05-2017"));
        venta.setEstado("Activo");
       */ 
        queryCodigo = "select MAX(cod_venta) conteo from venta";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        venta.setCodVenta(sentencia.contarCodigos(result));
        
        query = "INSERT INTO venta( " 
                +" cod_venta, cod_empleado_v, cod_cliente_v,"
                + " fecha_venta, valor_venta, estado) " 
                +" VALUES ("+venta.getCodVenta()+", "+venta.getCodEmpleado()+","
                + " "+venta.getCodCliente()+", '"+venta.getFechaVenta()+"',"
                + " "+venta.getValorTotal()+", '"+venta.getEstado()+"')";
        
         sentencia.gestionarRegistro(query);
         return venta.getCodVenta();
    }
    
    public String modificarVenta(Venta venta) throws ParseException{
        /*
        venta.setCodEmpleado(2);
        venta.setCodCliente(2);
        venta.setValorTotal(55_000);
        venta.setFechaVenta(validaciones.transformarFechatoDate("01-05-2017"));
        venta.setEstado("inactivo");
        venta.setCodVenta(1);
    */
    query =    "UPDATE venta " 
            + " SET"
            + " valor_venta="+venta.getValorTotal()+" " 
            + " WHERE cod_venta = "+venta.getCodVenta()+"";
    
    return sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarVenta(Integer codVenta){
            
            query = "DELETE FROM venta" +
                    " WHERE cod_venta = "+codVenta+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Venta> consultarVenta()throws SQLException{
        
        
        
            query = "SELECT cod_venta, cod_cliente_v, cod_empleado_v,"
                    + " fecha_venta, valor_venta, estado " 
                    +" FROM venta WHERE estado = 'Activo' ORDER BY cod_venta ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearVentas(resultset);
    }
    
        public List<Venta> consultarVentaCodVenta(String numeroDocumento){
            
            query = "SELECT cod_venta, cod_cliente_v, cod_empleado_v,"
                    + " fecha_venta, valor_venta, venta.estado, barrio " 
                    +" FROM venta,cliente, empleado, persona WHERE "
                    + " venta.estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' AND "
                    + " numero_documento = '"+numeroDocumento+"'"
                    + " AND cod_cliente_v = cod_cliente AND"
                    + " cod_persona_c = cod_persona AND"
                    + " cod_empleado_v= cod_empleado ORDER BY cod_venta ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearVenta(resultset);
    }
        
        public List <Venta> mapearVentas(ResultSet resultset){
            
                List <Venta> listadoVentas = new ArrayList<>();
                Venta venta = new Venta();
                
            try {
                
              while(resultset.next()){
                
                venta.setCodVenta(resultset.getInt("cod_venta"));
                venta.setCodCliente(resultset.getInt("cod_cliente_v"));
                venta.setCodEmpleado(resultset.getInt("cod_empleado_v"));
                venta.setFechaVenta(resultset.getDate("fecha_venta"));
                venta.setValorTotal(resultset.getInt("valor_venta"));
                venta.setEstado(resultset.getString("estado"));
               
                listadoVentas.add(venta);

                System.out.println(" venta "+venta.getFechaVenta());
                System.out.println(" venta "+venta.getValorTotal());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoVentas;
        
        }
    
                public List<Venta> mapearVenta(ResultSet resultset){
                
                List <Venta> listadoVentas = new ArrayList<>();
            try {
                    
              while(resultset.next()){
                  Venta venta = new Venta();
                venta.setCodVenta(resultset.getInt("cod_venta"));
                venta.setCodCliente(resultset.getInt("cod_cliente_v"));
                venta.setCodEmpleado(resultset.getInt("cod_empleado_v"));
                venta.setFechaVenta(resultset.getDate("fecha_venta"));
                venta.setValorTotal(resultset.getInt("valor_venta"));
                venta.setEstado(resultset.getString("estado"));


                System.out.println(" venta "+venta.getFechaVenta());
                System.out.println(" venta "+venta.getValorTotal()); 
                System.out.println(""+resultset.getString("barrio"));
                listadoVentas.add(venta);
            }
            } catch (Exception e) {
            }
      
        return listadoVentas ;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        VentaDAO v = new VentaDAO();
        Venta venta = new Venta();
        
      //v.registrarVenta(venta);
      //v.consultarVenta();
      //v.modificarVenta(venta);
      //v.consultarVentaCodVenta(3);
      //v.eliminarVenta(1);
    }    
}
