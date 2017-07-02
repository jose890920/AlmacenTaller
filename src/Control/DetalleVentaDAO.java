/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.DetalleAjuste;
import Modelo.DetalleVenta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleVentaDAO {
    
         SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarDetalleVenta(DetalleVenta detalleVenta)throws SQLException, ParseException{

     /*
        detalleVenta.setCodVenta(2);
        detalleVenta.setCodProducto(1);
        detalleVenta.setCantidadProducto(5);
        detalleVenta.setValorUnitario(11_000);
        detalleVenta.setValorConjunto(
                validaciones.calcularValorConjunto(detalleVenta.getValorUnitario(),
                detalleVenta.getCantidadProducto()));
        detalleVenta.setDescuento(
                validaciones.calcularDescuento(10, detalleVenta.getValorConjunto()));
       */ 
        queryCodigo = "select MAX(cod_detalle_Venta) conteo from detalle_Venta";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        detalleVenta.setCodDetalleVenta(sentencia.contarCodigos(result));
        
        query = "INSERT INTO detalle_venta( " +
                " cod_detalle_venta, cod_venta_d, cod_producto_dv,"
                + " cantidad_producto, valor_unitario, valor_conjunto, descuento)" 
                +" VALUES ( "+detalleVenta.getCodDetalleVenta()+","
                + " "+detalleVenta.getCodVenta()+","+detalleVenta.getCodProducto()+","
                + " "+detalleVenta.getCantidadProducto()+","
                + " "+detalleVenta.getValorUnitario()+", "+detalleVenta.getValorConjunto()+","
                + " "+detalleVenta.getDescuento()+" )";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarDetalleVenta(DetalleVenta detalleVenta) throws ParseException{
        
        detalleVenta.setCodVenta(2);
        detalleVenta.setCodProducto(1);
        detalleVenta.setCantidadProducto(50);
        detalleVenta.setValorUnitario(15_000);
        detalleVenta.setValorConjunto(
                validaciones.calcularValorConjunto(detalleVenta.getValorUnitario(),
                detalleVenta.getCantidadProducto()));
        detalleVenta.setDescuento(
                validaciones.calcularDescuento(10, detalleVenta.getValorConjunto()));
        detalleVenta.setCodDetalleVenta(1);
    
    query =    "UPDATE detalle_Venta " 
            + " SET  cod_venta_d="+detalleVenta.getCodVenta()+","
            + " cod_producto_dv="+detalleVenta.getCodProducto()+","
            + " cantidad_producto="+detalleVenta.getCantidadProducto()+","
            + " valor_unitario="+detalleVenta.getValorUnitario()+"," 
            + " valor_conjunto="+detalleVenta.getValorConjunto()+","
            + " descuento="+detalleVenta.getDescuento()+""
            + " WHERE cod_detalle_Venta = "+detalleVenta.getCodDetalleVenta()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarDetalleVenta(Integer codDetalleVenta){
            
            query = "DELETE FROM detalle_Venta" +
                    " WHERE cod_detalle_Venta = "+codDetalleVenta+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <DetalleVenta> consultarDetalleVenta()throws SQLException{
        
        
        
            query = "SELECT cod_detalle_venta, cod_venta_d, cod_producto_dv,"
                    + " cantidad_producto, valor_unitario, valor_conjunto, descuento " 
                    + " FROM detalle_venta ORDER BY cod_detalle_Venta ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearDetalleVentas(resultset);
    }
    
        public DetalleVenta consultarDetalleVentaCodDetalleVenta(Integer codDetalleVenta){
            
            query = "SELECT cod_detalle_venta, cod_venta_d, cod_producto_dv,"
                    + " cantidad_producto, valor_unitario, valor_conjunto,"
                    + " descuento, venta.estado estdv " 
                    +" FROM detalle_venta, venta WHERE cod_venta_d = cod_venta "
                    +" AND cod_detalle_venta = "+codDetalleVenta+" AND venta.estado = 'Activo' "
                    +" ORDER BY cod_detalle_Venta ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearDetalleVenta(resultset);
    }
        
        public List <DetalleVenta> mapearDetalleVentas(ResultSet resultset){
            
                List <DetalleVenta> listadoDetalleVentas = new ArrayList<>();
                DetalleVenta detalleVenta = new DetalleVenta();
                
            try {
                
              while(resultset.next()){
                
                detalleVenta.setCodDetalleVenta(resultset.getInt("cod_detalle_Venta"));
                detalleVenta.setCodVenta(resultset.getInt("cod_venta_d"));
                detalleVenta.setCodProducto(resultset.getInt("cod_producto_dv"));
                detalleVenta.setCantidadProducto(resultset.getInt("cantidad_producto"));
                detalleVenta.setValorUnitario(resultset.getDouble("valor_unitario"));
                detalleVenta.setValorConjunto(resultset.getDouble("valor_conjunto"));
                detalleVenta.setDescuento(resultset.getDouble("descuento"));
               
                listadoDetalleVentas.add(detalleVenta);

                System.out.println(" detalleVenta "+detalleVenta.getCantidadProducto());
                System.out.println(" detalleVenta "+detalleVenta.getValorConjunto());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoDetalleVentas;
        
        }
    
                public DetalleVenta mapearDetalleVenta(ResultSet resultset){
                
                DetalleVenta detalleVenta = new DetalleVenta();
            try {
                    
              if(resultset.next()){
                  
                detalleVenta.setCodDetalleVenta(resultset.getInt("cod_detalle_Venta"));
                detalleVenta.setCodVenta(resultset.getInt("cod_venta_d"));
                detalleVenta.setCodProducto(resultset.getInt("cod_producto_dv"));
                detalleVenta.setCantidadProducto(resultset.getInt("cantidad_producto"));
                detalleVenta.setValorUnitario(resultset.getDouble("valor_unitario"));
                detalleVenta.setValorConjunto(resultset.getDouble("valor_conjunto"));
                detalleVenta.setDescuento(resultset.getDouble("descuento"));

                System.out.println(" detalleVenta "+detalleVenta.getCantidadProducto());
                System.out.println(" detalleVenta "+detalleVenta.getValorConjunto());              
                System.out.println(""+resultset.getString("estdv"));
                
            }
            } catch (Exception e) {
            }
      
        return detalleVenta;
        }
                

    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        DetalleVentaDAO d = new DetalleVentaDAO();
        DetalleVenta detalleVenta = new DetalleVenta();
        
        //d.registrarDetalleVenta(detalleVenta);
        //d.consultarDetalleVenta();
        //d.modificarDetalleVenta(detalleVenta);
        //d.consultarDetalleVentaCodDetalleVenta(2);
        //d.eliminarDetalleVenta(1);

    }
    
}
