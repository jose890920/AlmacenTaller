
package Facade;

import Control.VentaDAO;
import Modelo.Venta;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeVenta {
    
   public int registrarVenta(Venta venta) throws SQLException, ParseException{
       VentaDAO ventaDAO = new VentaDAO();
       return ventaDAO.registrarVenta(venta);
   } 
   
    public String modificarVenta(Venta venta) throws SQLException, ParseException{
       VentaDAO ventaDAO = new VentaDAO();
       return ventaDAO.modificarVenta(venta);
   } 
      
    public List<Venta> consultarVenta(Venta venta) throws SQLException, ParseException{
       VentaDAO ventaDAO = new VentaDAO();
      return ventaDAO.consultarVentaCodVenta(venta.getCliente().getPersona().getNumeroDocumento());
   } 
}
