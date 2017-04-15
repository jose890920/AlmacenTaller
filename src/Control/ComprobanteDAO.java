
package Control;

import Modelo.Comprobante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class ComprobanteDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarComprobante(Comprobante comprobante)throws SQLException, ParseException{

     
        comprobante.setCodCompra(2);
        comprobante.setCodVenta(null);
        comprobante.setValor(50_000);
        comprobante.setDescuento(validaciones.calcularDescuento(5, comprobante.getValor()));
        comprobante.setIva(19);
        comprobante.setValorTotal(validaciones.calcularValorTotal(comprobante.getIva(),
                comprobante.getValor(),comprobante.getDescuento()));
        comprobante.setFechaComprobante(validaciones.transformarFecha("05-05-2017"));
        comprobante.setEstado("Activo");
        
        queryCodigo = "select MAX(cod_comprobante) conteo from comprobante";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        comprobante.setCodComprobante(sentencia.contarCodigos(result));
        
        query = "INSERT INTO public.comprobante( " 
                + " cod_comprobante, cod_compra_c, cod_venta_c,"
                + " valor, descuento, iva,"
                + " valor_total, fecha_comprobante, estado) " 
                + " VALUES ("+comprobante.getCodComprobante()+", "+comprobante.getCodCompra()+","
                + " "+comprobante.getCodVenta()+", "+comprobante.getValor()+","
                + " "+comprobante.getDescuento()+", "+comprobante.getIva()+","
                + " "+comprobante.getValorTotal()+",'"+comprobante.getFechaComprobante()+"',"
                + " '"+comprobante.getEstado()+"' )";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarComprobante(Comprobante comprobante) throws ParseException{
        
        comprobante.setCodCompra(null);
        comprobante.setCodVenta(2);
        comprobante.setValor(55_000);
        comprobante.setDescuento(validaciones.calcularDescuento(5, comprobante.getValor()));
        comprobante.setIva(19);
        comprobante.setValorTotal(validaciones.calcularValorTotal(comprobante.getIva(),
                comprobante.getValor(),comprobante.getDescuento()));
        comprobante.setFechaComprobante(validaciones.transformarFecha("05-05-2017"));
        comprobante.setEstado("inactivo");
        comprobante.setCodComprobante(1);
    
    query =   "UPDATE comprobante " 
            + " SET  cod_compra_c="+comprobante.getCodCompra()+","
            + " cod_venta_c="+comprobante.getCodVenta()+","
            + " valor="+comprobante.getValor()+","
            + " descuento="+comprobante.getDescuento()+"," 
            + " iva="+comprobante.getIva()+","
            + " valor_total="+comprobante.getValorTotal()+"," 
            + " fecha_comprobante='"+comprobante.getFechaComprobante()+"'," 
            + " estado='"+comprobante.getEstado()+"'" 
            + " WHERE cod_comprobante = "+comprobante.getCodComprobante()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarComprobante(Integer codComprobante){
            
            query = "DELETE FROM comprobante" +
                    " WHERE cod_comprobante = "+codComprobante+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Comprobante> consultarComprobante()throws SQLException{
        
        
        
            query =   "SELECT cod_comprobante, cod_compra_c, cod_venta_c,"
                    + " valor, descuento, iva, valor_total,"
                    + " fecha_comprobante, estado " 
                    +"	FROM comprobante WHERE"
                    + " estado = 'Activo' ORDER BY cod_comprobante ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearComprobantes(resultset);
    }
    
        public Comprobante consultarComprobanteCodComprobante(Integer codComprobante){
            
            query =   "SELECT distinct(cod_comprobante), cod_compra_c, cod_venta_c,"
                    + " valor, descuento, iva, comprobante.valor_total,"
                    + " fecha_comprobante, comprobante.estado " 
                    + "	FROM comprobante,venta, compra WHERE "
                    + " comprobante.estado = 'Activo' AND "
                    + " cod_comprobante = "+codComprobante+""
                    + " AND (cod_compra_c = cod_compra OR"
                    + " cod_venta_c = cod_venta) ORDER BY cod_comprobante ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearComprobante(resultset);
    }
        
        public List <Comprobante> mapearComprobantes(ResultSet resultset){
            
                List <Comprobante> listadoComprobantes = new ArrayList<>();
                Comprobante comprobante = new Comprobante();
                
            try {
                
              while(resultset.next()){
                
                comprobante.setCodComprobante(resultset.getInt("cod_comprobante"));
                comprobante.setCodCompra(resultset.getInt("cod_compra_c"));
                comprobante.setCodVenta(resultset.getInt("cod_venta_c"));
                comprobante.setValor(resultset.getDouble("valor"));
                comprobante.setDescuento(resultset.getDouble("descuento"));
                comprobante.setIva(resultset.getDouble("iva"));
                comprobante.setValorTotal(resultset.getDouble("valor_total"));
                comprobante.setFechaComprobante(resultset.getDate("fecha_comprobante"));
                comprobante.setEstado(resultset.getString("estado"));
               
                listadoComprobantes.add(comprobante);

                System.out.println(" comprobante "+comprobante.getFechaComprobante());
                System.out.println(" comprobante "+comprobante.getValorTotal());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoComprobantes;
        
        }
    
                public Comprobante mapearComprobante(ResultSet resultset){
                
                Comprobante comprobante = new Comprobante();
            try {
                    
              if(resultset.next()){
                comprobante.setCodComprobante(resultset.getInt("cod_comprobante"));
                comprobante.setCodCompra(resultset.getInt("cod_compra_c"));
                comprobante.setCodVenta(resultset.getInt("cod_venta_c"));
                comprobante.setValor(resultset.getDouble("valor"));
                comprobante.setDescuento(resultset.getDouble("descuento"));
                comprobante.setIva(resultset.getDouble("iva"));
                comprobante.setValorTotal(resultset.getDouble("valor_total"));
                comprobante.setFechaComprobante(resultset.getDate("fecha_comprobante"));
                comprobante.setEstado(resultset.getString("estado"));

                System.out.println(" comprobante "+comprobante.getFechaComprobante());
                System.out.println(" comprobante "+comprobante.getValorTotal());
                
                
            }
            } catch (Exception e) {
            }
      
        return comprobante;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        ComprobanteDAO c = new ComprobanteDAO();
        Comprobante comprobante = new Comprobante();
        
      //c.registrarComprobante(comprobante);
      //c.consultarComprobante();
      //c.modificarComprobante(comprobante);
      //c.consultarComprobanteCodComprobante(2);
      //c.eliminarComprobante(1);
    }    

    
}
