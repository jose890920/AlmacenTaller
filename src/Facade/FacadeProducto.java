
package Facade;

import Control.ProductoDAO;
import Modelo.Producto;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeProducto {
    
   public void registrarProducto(Producto producto) throws SQLException, ParseException{
       ProductoDAO productoDAO = new ProductoDAO();
       productoDAO.registrarProducto(producto);
   } 
   
    public String modificarProducto(Producto producto) throws SQLException, ParseException{
       ProductoDAO productoDAO = new ProductoDAO();
       return productoDAO.modificarProducto(producto);
   } 
      
    public Producto consultarProducto(Producto producto) throws SQLException, ParseException{
       ProductoDAO productoDAO = new ProductoDAO();
      return productoDAO.consultarProductoCodProducto(producto.getNombreProdcto());
   } 
}
