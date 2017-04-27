
package Control;


import Modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;


/**
 *
 * @author jose luis Rodriguez
 */
public class ProductoDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarProducto(Producto producto)throws SQLException, ParseException{

     
        producto.setNombreProdcto("Bandas");
        producto.setDescripcion("compatibles con eco deluxe y splendor");
        producto.setTipoProducto("frenos");
        producto.setCantidad(15);
        producto.setFabricante("Japan");
        producto.setFechaIngreso(validaciones.transformarFecha("05-05-2017"));
        producto.setValor(10000);
        producto.setEstado("Activo");
        
        queryCodigo = "select MAX(cod_producto) conteo from producto";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        producto.setCodProducto(sentencia.contarCodigos(result));
        
        query = "INSERT INTO producto( " +
                  " cod_producto, nombre_producto, descripcion,"
                + " tipo_producto, cantidad, fabricante,"
                + " fecha_ingreso, valor,"
                + " estado) " 
                +" VALUES ("+producto.getCodProducto()+", '"+producto.getNombreProdcto()+"',"
                + " '"+producto.getDescripcion()+"', '"+producto.getTipoProducto()+"',"
                + " "+producto.getCantidad()+", '"+producto.getFabricante()+"',"
                + " '"+producto.getFechaIngreso()+"', "+producto.getValor()+","
                + " '"+producto.getEstado()+"')";
        
        sentencia.gestionarRegistro(query);
    }
    
    public void modificarProducto(Producto producto) throws ParseException{
        
        producto.setNombreProdcto("pastillas");
        producto.setDescripcion("compatibles con wave y splendor");
        producto.setTipoProducto("frenos");
        producto.setCantidad(5);
        producto.setFabricante("honda");
        producto.setFechaIngreso(validaciones.transformarFecha("01-05-2015"));
        producto.setValor(10000);
        producto.setEstado("Activo");
        producto.setCodProducto(1);
    
    query =    "UPDATE producto " 
            + " SET  nombre_producto='"+producto.getNombreProdcto()+"',"
            + " descripcion='"+producto.getDescripcion()+"',"
            + " tipo_producto='"+producto.getTipoProducto()+"',"
            + " cantidad="+producto.getCantidad()+","
            + " fabricante='"+producto.getFabricante()+"',"
            + " fecha_ingreso='"+producto.getFechaIngreso()+"',"
            + " valor="+producto.getValor()+","
            + " estado='"+producto.getEstado()+"'" 
            + " WHERE cod_producto = "+producto.getCodProducto()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarProducto(Integer codProducto){
            
            query = "DELETE FROM producto " +
                    "WHERE cod_producto = "+codProducto+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Producto> consultarProducto()throws SQLException{
        
        
        
            query = "SELECT cod_producto, nombre_producto, descripcion,"
                    + " tipo_producto, cantidad, fabricante, fecha_ingreso,"
                    + " valor, estado " 
                    +" FROM producto WHERE estado = 'Activo'"
                    + " ORDER BY cod_producto ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearProductos(resultset);
    }
    
        public Producto consultarProductoCodProducto(Integer codProducto){
            
            query = "SELECT cod_producto, nombre_producto, descripcion,"
                    + " tipo_producto, cantidad, fabricante, fecha_ingreso,"
                    + " valor, estado " 
                    + " FROM producto WHERE cod_producto = "+codProducto+""
                    + " AND estado = 'Activo' "
                    + " ORDER BY cod_producto ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearProducto(resultset);
    }
        
        public List <Producto> mapearProductos(ResultSet resultset){
            
                List <Producto> listadoProductos = new ArrayList<>();
                Producto producto = new Producto();
                
            try {
                
              while(resultset.next()){
                
                producto.setCodProducto(resultset.getInt("cod_producto"));
                producto.setNombreProdcto(resultset.getString("nombre_producto"));
                producto.setDescripcion(resultset.getString("descripcion"));
                producto.setTipoProducto(resultset.getString("tipo_producto"));
                producto.setCantidad(resultset.getInt("cantidad"));
                producto.setFabricante(resultset.getString("fabricante"));
                producto.setFechaIngreso(resultset.getDate("fecha_ingreso"));
                producto.setValor(resultset.getInt("valor"));
                producto.setEstado(resultset.getString("estado"));                
                listadoProductos.add(producto);

                System.out.println(" Producto "+producto.getNombreProdcto());
                System.out.println(" Producto "+producto.getFechaIngreso());
                
            }
            } catch (Exception e) {
            }
      
        return listadoProductos;
        
        }
    
                public Producto mapearProducto(ResultSet resultset){
                
                Producto producto = new Producto();
            try {
                    
              if(resultset.next()){
                
                producto.setCodProducto(resultset.getInt("cod_producto"));
                producto.setNombreProdcto(resultset.getString("nombre_producto"));
                producto.setDescripcion(resultset.getString("descripcion"));
                producto.setTipoProducto(resultset.getString("tipo_producto"));
                producto.setCantidad(resultset.getInt("cantidad"));
                producto.setFabricante(resultset.getString("fabricante"));
                producto.setFechaIngreso(resultset.getDate("fecha_ingreso"));
                producto.setValor(resultset.getInt("valor"));
                producto.setEstado(resultset.getString("estado"));                
                                               
                System.out.println(" producto "+producto.getNombreProdcto());
                System.out.println(" Producto "+producto.getFechaIngreso());
                
            }
            } catch (Exception e) {
            }
      
        return producto;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        ProductoDAO p = new ProductoDAO();
        Producto producto = new Producto();
        
        p.registrarProducto(producto);
        //p.consultarProducto();
        //p.consultarProductoCodProducto(1);
        //p.modificarProducto(producto);
        //p.eliminarProducto(3);

    }

    
}
