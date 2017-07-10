
package Facade;

import Control.PagoEmpleadoDAO;
import Modelo.PagoEmpleado;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadePagoEmpleado {
    
   public int registrarPagoEmpleado(PagoEmpleado pagoEmpleado) throws SQLException, ParseException{
       PagoEmpleadoDAO pagoEmpleadoDAO = new PagoEmpleadoDAO();
      return pagoEmpleadoDAO.registrarPagoEmpleado(pagoEmpleado);
   } 
   
    public String modificarPagoEmpleado(PagoEmpleado pagoEmpleado) throws SQLException, ParseException{
       PagoEmpleadoDAO pagoEmpleadoDAO = new PagoEmpleadoDAO();
       return pagoEmpleadoDAO.modificarPagoEmpleado(pagoEmpleado);
   } 
      
    public List<PagoEmpleado> consultarPagoEmpleado(PagoEmpleado pagoEmpleado) throws SQLException, ParseException{
       PagoEmpleadoDAO pagoEmpleadoDAO = new PagoEmpleadoDAO();
      return pagoEmpleadoDAO.consultarPagoEmpleadoCodPagoEmpleado(pagoEmpleado.getEmpleado().getPersona().getNumeroDocumento());
   } 
}
