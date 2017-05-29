
package Facade;

import Control.EmpleadoDAO;
import Control.PersonaDAO;
import Modelo.Empleado;
import Modelo.Persona;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeEmpleado {
    
   
    PersonaDAO personaDAO = new PersonaDAO();
    
       public void registrarEmpleado(Empleado empleado) throws SQLException, ParseException{
       EmpleadoDAO empleadoDAO = new EmpleadoDAO();
       empleado.setCodPersona(personaDAO.registrarPersona(empleado.getPersona()));
       empleadoDAO.registrarEmpleado(empleado);
   } 
   
    public String modificarEmpleado(Empleado empleado) throws SQLException, ParseException{
       EmpleadoDAO empleadoDAO = new EmpleadoDAO();
       personaDAO.modificarPersona(empleado.getPersona());
       return empleadoDAO.modificarEmpleado(empleado);
   } 
      
    public Empleado consultarEmpleado(Empleado empleado) throws SQLException, ParseException{
       EmpleadoDAO empleadoDAO = new EmpleadoDAO();
       return empleadoDAO.consultarEmpleadoCodEmpleado(empleado.getPersona().getNumeroDocumento());
   } 
    
}
