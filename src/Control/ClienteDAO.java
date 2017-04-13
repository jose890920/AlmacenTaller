
package Control;

import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class ClienteDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarCliente(Cliente cliente)throws SQLException, ParseException{

     
        cliente.setCodPersona(1);
        cliente.setFechaNacimiento(validaciones.transformarFecha("05-05-2017"));
        cliente.setSexo("M");
        cliente.setBarrio("Napoles");
        cliente.setTieneMotocicleta("S");
        cliente.setEstado("Activo");
        
        queryCodigo = "select MAX(cod_cliente) conteo from cliente";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        cliente.setCodCliente(sentencia.contarCodigos(result));
        
        query = "INSERT INTO cliente (" +
                " cod_cliente, cod_persona_c, fecha_nacimiento,"
                + " sexo, barrio, tiene_motocicleta,"
                + " estado) " 
                +" VALUES ("+cliente.getCodCliente()+", "+cliente.getCodPersona()+","
                + " '"+cliente.getFechaNacimiento()+"', '"+cliente.getSexo()+"',"
                + " '"+cliente.getBarrio()+"', '"+cliente.getTieneMotocicleta()+"',"
                + " '"+cliente.getEstado()+"')";
        
        sentencia.gestionarRegistro(query);
    }
    
    public void modificarCliente(Cliente cliente) throws ParseException{
        
        cliente.setCodPersona(1);
        cliente.setFechaNacimiento(validaciones.transformarFecha("05-01-2017"));
        cliente.setSexo("F");
        cliente.setBarrio("Alto Napoles");
        cliente.setTieneMotocicleta("N");
        cliente.setEstado("Activo");
        cliente.setCodCliente(1);
    
    query =    "UPDATE cliente " 
            + " SET  cod_persona_c="+cliente.getCodPersona()+","
            + " fecha_nacimiento='"+cliente.getFechaNacimiento()+"',"
            + " sexo='"+cliente.getSexo()+"',"
            + " barrio='"+cliente.getBarrio()+"',"
            + " tiene_motocicleta='"+cliente.getTieneMotocicleta()+"',"
            + " estado='"+cliente.getEstado()+"'" 
            + " WHERE cod_cliente = "+cliente.getCodCliente()+"";
    
    sentencia.gestionarRegistro(query);
    
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
    
        public Cliente consultarClienteCodCliente(Integer codCliente){
            
            query = "SELECT cod_cliente, cod_persona_c, fecha_nacimiento,"
                    + " sexo, barrio, tiene_motocicleta,"
                    + " estado, nombres " 
                    + "	FROM cliente, persona WHERE cod_persona_c = cod_persona"
                    + " AND estado = 'Activo' "
                    + " AND cod_cliente = "+codCliente+" ORDER BY cod_cliente ASC";            
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
            try {
                    
              if(resultset.next()){
                
                cliente.setCodCliente(resultset.getInt("cod_cliente"));
                cliente.setCodPersona(resultset.getInt("cod_persona_c"));
                cliente.setFechaNacimiento(resultset.getDate("fecha_nacimiento"));
                cliente.setSexo(resultset.getString("sexo"));
                cliente.setBarrio(resultset.getString("barrio"));
                cliente.setTieneMotocicleta(resultset.getString("tiene_motocicleta"));
                cliente.setEstado(resultset.getString("estado"));
                
                System.out.println(" cliente "+cliente.getBarrio());
                System.out.println(" cliente "+cliente.getTieneMotocicleta());
                System.out.println(""+resultset.getString("nombres"));
                
            }
            } catch (Exception e) {
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
