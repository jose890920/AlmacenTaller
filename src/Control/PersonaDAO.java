
package Control;

import Modelo.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class PersonaDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public int registrarPersona(Persona persona)throws SQLException{
     /*
        persona.setNombres("juan");
        persona.setApellidos("cuadrado");
        persona.setDireccion("calle 5a");
        persona.setTelefono("3554545");
        persona.setCelular("3154554545");
        persona.setEmail("jcu@gmail.com");
        persona.setTipoDocumento("CEDULA DE CIUDADANIA");
        persona.setNumeroDocumento("155555");
       */ 
        queryCodigo = "select MAX(cod_persona) conteo from persona";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        persona.setCodPersona(sentencia.contarCodigos(result));
        
        query = "insert into persona (cod_persona, nombres, apellidos, direccion,"
                + " telefono, celular, correo, tipo_documento, numero_documento)"
                + " values("+persona.getCodPersona()+",'"+persona.getNombres()+"',"
                + "'"+persona.getApellidos()+"','"+persona.getDireccion()+"',"
                + "'"+persona.getTelefono()+"','"+persona.getCelular()+"',"
                + "'"+persona.getEmail()+"','"+persona.getTipoDocumento()+"',"
                + "'"+persona.getNumeroDocumento()+"')";
    sentencia.gestionarRegistro(query);
    return persona.getCodPersona();
    }
    
    public void modificarPersona(Persona persona){
        
                persona.setNombres("juangui");
        persona.setApellidos("cuadradosqui");
        persona.setDireccion("calle 5aa");
        persona.setTelefono("3555545");
        persona.setCelular("3154555545");
        persona.setEmail("jc@gmail.com");
        persona.setTipoDocumento("CEDULA DE CIUDADANIA");
        persona.setNumeroDocumento("155555");
    
    query =    "UPDATE persona" +
        "	SET  nombres='"+persona.getNombres()+"', apellidos='"+persona.getApellidos()+"',"
            + " direccion='"+persona.getDireccion()+"', telefono='"+persona.getTelefono()+"',"
            + " celular='"+persona.getCelular()+"', correo='"+persona.getEmail()+"',"
            + " tipo_documento='"+persona.getTipoDocumento()+"',"
            + " numero_documento = '"+persona.getNumeroDocumento()+"' " +
        "	WHERE numero_documento = '"+persona.getNumeroDocumento()+"'";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarPersona(String numeroDocumento){
            
            query = "DELETE FROM persona " +
                    "WHERE numero_documento = '"+numeroDocumento+"'";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Persona> consultarPersona()throws SQLException{
        
        
        
            query = "SELECT cod_persona, nombres, apellidos, direccion, telefono,"
            + " celular, correo, tipo_documento, numero_documento " +
              " FROM persona ORDER BY cod_persona ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearPersonas(resultset);
    }
    
        public Persona consultarPersonaNumeroDocumento(String numeroDocumento){
            query = "SELECT cod_persona, nombres, apellidos, direccion, telefono,"
            + " celular, correo, tipo_documento, numero_documento " +
              " FROM persona WHERE numero_documento = '"+numeroDocumento+"'"
                    + "  ORDER BY cod_persona ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearPersona(resultset);
    }
        
        public List <Persona> mapearPersonas(ResultSet resultset){
            
                List <Persona> listadoPersonas = new ArrayList<>();
                Persona persona = new Persona();
                
            try {
                
              while(resultset.next()){
                
                persona.setCodPersona(resultset.getInt("cod_persona"));
                persona.setNombres(resultset.getString("nombres"));
                persona.setApellidos(resultset.getString("apellidos"));
                persona.setDireccion(resultset.getString("direccion"));
                persona.setTelefono(resultset.getString("telefono"));
                persona.setCelular(resultset.getString("celular"));
                persona.setEmail(resultset.getString("correo"));
                persona.setTipoDocumento(resultset.getString("tipo_documento"));
                persona.setNumeroDocumento(resultset.getString("numero_documento"));
                
                listadoPersonas.add(persona);
                System.out.println(" persona "+persona.getNombres());
                
            }
            } catch (Exception e) {
            }
      
        return listadoPersonas;
        
        }
    
                public Persona mapearPersona(ResultSet resultset){
                
                Persona persona = new Persona();
            try {
                    
              if(resultset.next()){
                
                persona.setCodPersona(resultset.getInt("cod_persona"));
                persona.setNombres(resultset.getString("nombres"));
                persona.setApellidos(resultset.getString("apellidos"));
                persona.setDireccion(resultset.getString("direccion"));
                persona.setTelefono(resultset.getString("telefono"));
                persona.setCelular(resultset.getString("celular"));
                persona.setEmail(resultset.getString("correo"));
                persona.setTipoDocumento(resultset.getString("tipo_documento"));
                persona.setNumeroDocumento(resultset.getString("numero_documento"));
                                
                System.out.println(" persona "+persona.getNombres());
                
            }
            } catch (Exception e) {
            }
      
        return persona;
        }
    
    
    
    public static void main(String[] args) throws SQLException {
        PersonaDAO p = new PersonaDAO();
        Persona persona = new Persona();
        
      p.registrarPersona(persona);
        //p.modificarPersona(persona);
        //p.eliminarPersona("155555");
        //p.consultarPersona();
        //p.consultarPersonaNumeroDocumento("12345");
    }
    
}
