
package Control;

import Modelo.Cliente;
import Modelo.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class ClienteDAO extends ConstantesAlmacenyTaller{
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public int registrarCliente(Cliente cliente)throws SQLException, ParseException{
        int codigoCliente = 0;
     /*
        cliente.setCodPersona(1);
        cliente.setFechaNacimiento(validaciones.transformarFechatoDate("05-05-2017"));
        cliente.setSexo("M");
        cliente.setBarrio("Napoles");
        cliente.setTieneMotocicleta("S");
        cliente.setEstado("Activo");
       */ 
        queryCodigo = "select MAX(cod_cliente) conteo from cliente";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
        codigoCliente = sentencia.contarCodigos(result);
        cliente.setCodCliente(codigoCliente);
        
        query = "INSERT INTO cliente (" +
                " cod_cliente, cod_persona_c, fecha_nacimiento,"
                + " sexo, barrio, tiene_motocicleta,"
                + " estado) " 
                +" VALUES ("+cliente.getCodCliente()+", "+cliente.getCodPersona()+","
                + " '"+cliente.getFechaNacimiento()+"', '"+cliente.getSexo()+"',"
                + " '"+cliente.getBarrio()+"', '"+cliente.getTieneMotocicleta()+"',"
                + " '"+cliente.getEstado()+"')";
        
        sentencia.gestionarRegistro(query);
        return codigoCliente;
    }
    
    public String modificarCliente(Cliente cliente) throws ParseException{
      /*  
        cliente.setCodPersona(1);
        cliente.setFechaNacimiento(validaciones.transformarFechatoDate("05-01-2017"));
        cliente.setSexo("F");
        cliente.setBarrio("Alto Napoles");
        cliente.setTieneMotocicleta("N");
        cliente.setEstado("Activo");
        cliente.setCodCliente(1);
    */
    query =    "UPDATE cliente SET" 
            + " fecha_nacimiento='"+cliente.getFechaNacimiento()+"',"
            + " sexo ='"+cliente.getSexo()+"',"
            + " barrio ='"+cliente.getBarrio()+"',"
            + " tiene_motocicleta = '"+cliente.getTieneMotocicleta()+"' "
            + " from persona  WHERE cod_persona_c = cod_persona and "
            + " numero_documento = '"+cliente.getPersona().getNumeroDocumento()+"'";
    
    return sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarCliente(Integer codCliente){
            
            query = "DELETE FROM cliente " +
                    "WHERE cod_cliente = "+codCliente+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Cliente> consultarCliente()throws SQLException{
        
        
        
            query = "SELECT cod_cliente, cod_persona_c, fecha_nacimiento,"
                    + " sexo, barrio, tiene_motocicleta,"
                    + " estado " 
                    + "	FROM cliente WHERE estado = 'Activo' ORDER BY cod_cliente ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearClientes(resultset);
    }
    
        public Cliente consultarClienteCodCliente(String numeroDocumento) throws SQLException{
            
            query = "SELECT cod_cliente, cod_persona_c,"
                    + "fecha_nacimiento, sexo,tiene_motocicleta,"
                    + " barrio, estado, nombres, apellidos,direccion, telefono,"
                    + " celular, tipo_documento, numero_documento " 
                    +" FROM cliente, persona WHERE cod_persona_c = cod_persona"
                    + " AND estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' "
                    + " AND numero_documento = '"+numeroDocumento+"' ORDER BY cod_cliente ASC";          
            resultset = sentencia.gestionarConsulta(query);
            
            if (!resultset.next()) {
               
                return null;
            }
            resultset = sentencia.gestionarConsulta(query);
            return  mapearCliente(resultset);
           
    }
        
        public List <Cliente> mapearClientes(ResultSet resultset){
            
                List <Cliente> listadoClientes = new ArrayList<>();
                Cliente cliente = new Cliente();
                
            try {
                
              while(resultset.next()){
                
                cliente.setCodCliente(resultset.getInt("cod_cliente"));
                cliente.setCodPersona(resultset.getInt("cod_persona_c"));
                cliente.setFechaNacimiento(resultset.getDate("fecha_nacimiento"));
                cliente.setSexo(resultset.getString("sexo"));
                cliente.setBarrio(resultset.getString("barrio"));
                cliente.setTieneMotocicleta(resultset.getString("tiene_motocicleta"));
                cliente.setEstado(resultset.getString("estado"));
               
                listadoClientes.add(cliente);

                System.out.println(" cliente "+cliente.getBarrio());
                System.out.println(" cliente "+cliente.getTieneMotocicleta());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoClientes;
        
        }
    
                public Cliente mapearCliente(ResultSet resultset){
               
                Cliente cliente = new Cliente();
                Persona persona = new Persona();
            try {
                    
              if(resultset.next()){
                
                cliente.setCodCliente(resultset.getInt("cod_cliente"));
                cliente.setCodPersona(resultset.getInt("cod_persona_c"));
                cliente.setFechaNacimiento(resultset.getDate("fecha_nacimiento"));
                cliente.setSexo(resultset.getString("sexo"));
                cliente.setBarrio(resultset.getString("barrio"));
                cliente.setEstado(resultset.getString("estado"));
                cliente.setTieneMotocicleta(resultset.getString("tiene_motocicleta"));
                persona.setNombres(resultset.getString("nombres"));
                persona.setApellidos(resultset.getString("apellidos"));
                persona.setDireccion(resultset.getString("direccion"));
                persona.setTelefono(resultset.getString("telefono"));
                persona.setCelular(resultset.getString("celular"));
                persona.setTipoDocumento(resultset.getString("tipo_documento"));
                persona.setNumeroDocumento(resultset.getString("numero_documento"));
                cliente.setPersona(persona);

                System.out.println(" empleado "+cliente.getBarrio());
                System.out.println(" empleado "+cliente.getTieneMotocicleta());
                System.out.println(""+resultset.getString("nombres"));
                
            }
            } catch (Exception e) {
                System.out.println(e);
            }
      
        return cliente;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        ClienteDAO c = new ClienteDAO();
        Cliente cliente = new Cliente();
        
          c.registrarCliente(cliente);
          //c.modificarCliente(cliente);
          //c.consultarCliente();
          //c.consultarClienteCodCliente(1);
          //c.eliminarCliente(2);

    }

    

}
