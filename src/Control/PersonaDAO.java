
package Control;

import Modelo.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jose luis Rodriguez
 */
public class PersonaDAO {
      SentenciaSQL sentencia = new SentenciaSQL();
     String query;
     Integer conteo = 0;
    public void registrarPersona(Persona persona)throws SQLException{
        persona.setNombres("juan");
        persona.setApellidos("cuadrado");
        persona.setDireccion("calle 5a");
        persona.setTelefono("3554545");
        persona.setCelular("3154554545");
        persona.setEmail("jcu@gmail.com");
        persona.setTipoDocumento("CC");
        persona.setNumeroDocumento("155555");
        
        
        ResultSet result = sentencia.gestionarConsulta("select count(cod_persona) conteo from persona");
      
        persona.setCodPersona(sentencia.contarCodigos(result));
        
        query = "insert into persona (cod_persona, nombres, apellidos, direccion,"
                + " telefono, celular, correo, tipo_documento, numero_documento)"
                + " values("+persona.getCodPersona()+",'"+persona.getNombres()+"',"
                + "'"+persona.getApellidos()+"','"+persona.getDireccion()+"',"
                + "'"+persona.getTelefono()+"','"+persona.getCelular()+"',"
                + "'"+persona.getEmail()+"','"+persona.getTipoDocumento()+"',"
                + "'"+persona.getNumeroDocumento()+"')";
    sentencia.gestionarRegistro(query);
    }
    
    
    
    
    public static void main(String[] args) throws SQLException {
        PersonaDAO p = new PersonaDAO();
        Persona persona = new Persona();
        
        p.registrarPersona(persona);
    }
    
}
