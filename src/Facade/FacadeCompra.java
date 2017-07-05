
package Facade;

import Control.CompraDAO;
import Modelo.Compra;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeCompra {
    
   public int registrarCompra(Compra compra) throws SQLException, ParseException{
       CompraDAO compraDAO = new CompraDAO();
      return compraDAO.registrarCompra(compra);
   } 
   
    public String modificarCompra(Compra compra) throws SQLException, ParseException{
       CompraDAO compraDAO = new CompraDAO();
       return compraDAO.modificarCompra(compra);
   } 
      
    public List<Compra> consultarCompra(Compra compra) throws SQLException, ParseException{
       CompraDAO compraDAO = new CompraDAO();
      return compraDAO.consultarCompraCodCompra(compra.getProveedor().getPersona().getNumeroDocumento());
   } 
}
