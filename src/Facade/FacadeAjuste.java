
package Facade;

import Control.AjusteDAO;
import Modelo.Ajuste;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeAjuste {
    
   public int registrarAjuste(Ajuste ajuste) throws SQLException, ParseException{
       AjusteDAO ajusteDAO = new AjusteDAO();
      return ajusteDAO.registrarAjuste(ajuste);
   } 
   
    public String modificarAjuste(Ajuste ajuste) throws SQLException, ParseException{
       AjusteDAO ajusteDAO = new AjusteDAO();
       return ajusteDAO.modificarAjuste(ajuste);
   } 
      
    public List<Ajuste> consultarAjuste(Ajuste ajuste) throws SQLException, ParseException{
       AjusteDAO ajusteDAO = new AjusteDAO();
      return ajusteDAO.consultarAjusteCodAjuste(ajuste.getEmpleado().getPersona().getNumeroDocumento());
   } 
}
