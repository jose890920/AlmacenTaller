
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
public class ProductoDAO extends ConstantesAlmacenyTaller{
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarProducto(Producto producto)throws SQLException, ParseException{

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
    
    public String modificarProducto(Producto producto) throws ParseException{

    query =    "UPDATE producto " 
            + " SET  nombre_producto='"+producto.getNombreProdcto()+"',"
            + " descripcion='"+producto.getDescripcion()+"',"
            + " tipo_producto='"+producto.getTipoProducto()+"',"
            + " cantidad="+producto.getCantidad()+","
            + " fabricante='"+producto.getFabricante()+"',"
            + " fecha_ingreso='"+producto.getFechaIngreso()+"',"
            + " valor="+producto.getValor()+","
            + " estado='"+producto.getEstado()+"'" 
            + " WHERE nombre_producto = '"+producto.getNombreProdcto()+"'";
    
   return sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarProducto(Integer codProducto){
            
            query = "DELETE FROM producto " +
                    "WHERE cod_producto = "+codProducto+"";
            sentencia.gestionarRegistro(query);
    }
    
        public List <Producto> consultarProducto(String nombreProducto)throws SQLException{
        
        
        
            query = "SELECT cod_producto, nombre_producto, descripcion,"
                    + " tipo_producto, cantidad, fabricante, fecha_ingreso,"
                    + " valor, estado " 
                    +" FROM producto WHERE estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"'"
                    + " AND nombre_producto LIKE '%"+nombreProducto+"%' ORDER BY nombre_producto ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
            if (!resultset.next()) {
                return null;
            }
            resultset = sentencia.gestionarConsulta(query);
          
         return mapearProductos(resultset);
    }
    
        public Producto consultarProductoCodProducto(String nombreProducto){
            
            query = "SELECT cod_producto, nombre_producto, descripcion,"
                    + " tipo_producto, cantidad, fabricante, fecha_ingreso,"
                    + " valor, estado " 
                    + " FROM producto WHERE nombre_producto = '"+nombreProducto+"'"
                    + " AND estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' "
                    + " ORDER BY cod_producto ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearProducto(resultset);
    }
        
        public List <Producto> mapearProductos(ResultSet resultset){
            
                List <Producto> listadoProductos = new ArrayList<>();
                
                
            try {
                
              while(resultset.next()){
                Producto producto = new Producto();
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
                
            }else{return null;}
            } catch (Exception e) {
            }
      
        return producto;
        }
                
                
                    public String actualizarStock(Producto producto,String parametro) throws ParseException{

    query =    "UPDATE producto " 
            + " SET "
            + " cantidad = cantidad"+parametro
            + " WHERE cod_producto = "+producto.getCodProducto()+"";
    
   return sentencia.gestionarRegistro(query);
    
    }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        ProductoDAO p = new ProductoDAO();
        Producto producto = new Producto();
        
        //p.registrarProducto(producto);
        //p.consultarProducto();
        //p.consultarProductoCodProducto(1);
        //p.modificarProducto(producto);
        //p.eliminarProducto(3);

    }

    
}
