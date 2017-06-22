
package Facade;

import Control.MotocicletaDAO;
import Modelo.Motocicleta;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeMotociccleta {
    
   public void registrarMotocicleta(Motocicleta motocicleta) throws SQLException, ParseException{
       MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
       motocicletaDAO.registrarMotocicleta(motocicleta);
   } 
   
    public String modificarMotocicleta(Motocicleta motocicleta) throws SQLException, ParseException{
       MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
       return motocicletaDAO.modificarMotocicleta(motocicleta);
   } 
      
    public Motocicleta consultarMotocicleta(Motocicleta motocicleta) throws SQLException, ParseException{
       MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
      return motocicletaDAO.consultarMotocicletaCodMotocicleta(motocicleta.getPlaca());
   }
    
    public List<Motocicleta> consultarMotocicletasPorCliente(String numeroDocumento) throws SQLException, ParseException{
       MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
      return motocicletaDAO.consultarMotocicleta(numeroDocumento);
   } 
}
