
package Facade;

import Control.UsuarioDAO;
import Modelo.Usuario;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeUsuario {
    
   public void registrarUsuario(Usuario usuario) throws SQLException, ParseException{
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       usuarioDAO.registrarUsuario(usuario);
   } 
   
    public String modificarUsuario(Usuario usuario) throws SQLException, ParseException{
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       return usuarioDAO.modificarUsuario(usuario);
   } 
      
    public Usuario consultarUsuario(Usuario usuario) throws SQLException, ParseException{
       UsuarioDAO usuarioDAO = new UsuarioDAO();
      return usuarioDAO.consultarUsuarioCodUsuario(usuario.getEmpleado().getPersona().getNumeroDocumento());
   }
    
    public Usuario consultarUsuarioNombreUsuario(String nombreUsuario) throws SQLException, ParseException{
       UsuarioDAO usuarioDAO = new UsuarioDAO();
      return usuarioDAO.consultarUsuarioNombreUsuario(nombreUsuario);
   }
    

}
