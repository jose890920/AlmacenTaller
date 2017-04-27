
package Control;

import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class UsuarioDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarUsuario(Usuario usuario)throws SQLException, ParseException{

     
        usuario.setCodEmpleado(2);
        usuario.setNombreUsuario("admin1");
        usuario.setContrasenia("12345");
        usuario.setTipoUsuario("root");
        usuario.setEstado("Activo");
        
        queryCodigo = "select MAX(cod_usuario) conteo from usuario";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        usuario.setCodUsuario(sentencia.contarCodigos(result));
        
        query = "INSERT INTO public.usuario( " 
                + " cod_usuario, cod_empleado_u, nombre_usuario,"
                + " contrasenia, tipo_usuario, estado) " 
                + " VALUES ("+usuario.getCodUsuario()+", "+usuario.getCodEmpleado()+","
                + " '"+usuario.getNombreUsuario()+"', '"+usuario.getContrasenia()+"',"
                + " '"+usuario.getTipoUsuario()+"', '"+usuario.getEstado()+"' )";
        
         sentencia.gestionarRegistro(query);
    }
    
    public void modificarUsuario(Usuario usuario) throws ParseException{
        
        usuario.setCodEmpleado(2);
        usuario.setNombreUsuario("admin2");
        usuario.setContrasenia("1255");
        usuario.setTipoUsuario("root");
        usuario.setEstado("inactivo");
        usuario.setCodUsuario(1);
    
    query =    "UPDATE usuario " 
            + " SET  cod_empleado_u="+usuario.getCodEmpleado()+","
            + " nombre_usuario='"+usuario.getNombreUsuario()+"',"
            + " contrasenia='"+usuario.getContrasenia()+"',"
            + " tipo_usuario='"+usuario.getTipoUsuario()+"',"
            + " estado='"+usuario.getEstado()+"'"
            + " WHERE cod_usuario = "+usuario.getCodUsuario()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarUsuario(Integer codUsuario){
            
            query = "DELETE FROM usuario " +
                    "WHERE cod_usuario = "+codUsuario+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Usuario> consultarUsuario()throws SQLException{
        
        
        
            query =  "SELECT cod_usuario, cod_empleado_u, nombre_usuario,"
                    + " contrasenia, tipo_usuario, estado " 
                    +"	FROM usuario WHERE estado = 'Activo' ORDER BY cod_usuario ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearUsuarios(resultset);
    }
    
        public Usuario consultarUsuarioCodUsuario(Integer codUsuario){
            
            query =  "SELECT cod_usuario, cod_empleado_u, nombre_usuario,"
                    + " contrasenia, tipo_usuario, usuario.estado, estado_civil " 
                    +"	FROM usuario, empleado  WHERE cod_empleado_u = cod_empleado"
                    + " AND usuario.estado = 'Activo' "
                    + " AND cod_usuario = "+codUsuario+" ORDER BY cod_usuario ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearUsuario(resultset);
    }
        
        public List <Usuario> mapearUsuarios(ResultSet resultset){
            
                List <Usuario> listadoUsuarios = new ArrayList<>();
                Usuario usuario = new Usuario();
                
            try {
                
              while(resultset.next()){
                
                usuario.setCodUsuario(resultset.getInt("cod_usuario"));
                usuario.setCodEmpleado(resultset.getInt("cod_empleado_u"));
                usuario.setNombreUsuario(resultset.getString("nombre_usuario"));
                usuario.setContrasenia(resultset.getString("contrasenia"));
                usuario.setTipoUsuario(resultset.getString("tipo_usuario"));
                usuario.setEstado(resultset.getString("estado"));
               
                listadoUsuarios.add(usuario);

                System.out.println(" usuario "+usuario.getNombreUsuario());
                System.out.println(" usuario "+usuario.getContrasenia());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoUsuarios;
        
        }
    
                public Usuario mapearUsuario(ResultSet resultset){
                
                Usuario usuario = new Usuario();
            try {
                    
              if(resultset.next()){
                
           
                
                usuario.setCodUsuario(resultset.getInt("cod_usuario"));
                usuario.setCodEmpleado(resultset.getInt("cod_empleado_u"));
                usuario.setNombreUsuario(resultset.getString("nombre_usuario"));
                usuario.setContrasenia(resultset.getString("contrasenia"));
                usuario.setTipoUsuario(resultset.getString("tipo_usuario"));
                usuario.setEstado(resultset.getString("estado"));

                System.out.println(" usuario "+usuario.getNombreUsuario());
                System.out.println(" usuario "+usuario.getContrasenia());
                System.out.println(""+resultset.getString("estado_civil"));
                
              }
            } catch (Exception e) {
            }
      
        return usuario;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        UsuarioDAO u = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
          u.registrarUsuario(usuario);
          //u.modificarUsuario(usuario);
          //u.consultarUsuario();
          //u.consultarUsuarioCodUsuario(2);
          //u.eliminarUsuario(1);
          

    }

    
}
