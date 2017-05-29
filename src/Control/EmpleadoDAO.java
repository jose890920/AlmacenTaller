
package Control;

import Modelo.Empleado;
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
public class EmpleadoDAO extends ConstantesAlmacenyTaller{
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarEmpleado(Empleado empleado)throws SQLException, ParseException{

     /*
        empleado.setCodPersona(1);
        empleado.setFechaIngreso(validaciones.transformarFechatoDate("05-05-2017"));
        empleado.setEstadoCivil("Soltero");
        empleado.setFechaNacimiento(validaciones.transformarFechatoDate("05-05-1995"));
        empleado.setSexo("M");
        empleado.setCiudad("Cali");
        empleado.setEstado("Activo");
       */ 
        queryCodigo = "select MAX(cod_empleado) conteo from empleado";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        empleado.setCodEmpleado(sentencia.contarCodigos(result));
        
        query = "INSERT INTO empleado( " 
                +" cod_empleado, cod_persona_e, fecha_ingreso,"
                + " estado_civil, fecha_nacimiento, sexo,"
                + " ciudad, estado) " 
                +" VALUES ("+empleado.getCodEmpleado()+", "+empleado.getCodPersona()+","
                + " '"+empleado.getFechaIngreso()+"', '"+empleado.getEstadoCivil()+"',"
                + " '"+empleado.getFechaNacimiento()+"', '"+empleado.getSexo()+"',"
                + " '"+empleado.getCiudad()+"','"+empleado.getEstado()+"')";
        
         sentencia.gestionarRegistro(query);
    }
    
    public String modificarEmpleado(Empleado empleado) throws ParseException{
       /* 
        empleado.setCodPersona(1);
        empleado.setFechaIngreso(validaciones.transformarFechatoDate("05-01-2017"));
        empleado.setEstadoCivil("Soltero");
        empleado.setFechaNacimiento(validaciones.transformarFechatoDate("05-01-1995"));
        empleado.setSexo("F");
        empleado.setCiudad("CalI");
        empleado.setEstado("inactivo");
        empleado.setCodEmpleado(1);
    */
    query =    "UPDATE empleado " 
            + " SET fecha_ingreso='"+empleado.getFechaIngreso()+"',"
            + " estado_civil='"+empleado.getEstadoCivil()+"',"
            + " fecha_nacimiento='"+empleado.getFechaNacimiento()+"',"
            + " sexo='"+empleado.getSexo()+"',"
            + " ciudad='"+empleado.getCiudad()+"',"
            + " estado='"+empleado.getEstado()+"'"
            + " from persona  WHERE cod_persona_e = cod_persona and "
            + " numero_documento = '"+empleado.getPersona().getNumeroDocumento()+"'";
    
    return sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarEmpleado(Integer codEmpleado){
            
            query = "DELETE FROM empleado " +
                    "WHERE cod_empleado = "+codEmpleado+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Empleado> consultarEmpleado()throws SQLException{
        
        
        
            query = "SELECT cod_empleado, cod_persona_e, fecha_ingreso,"
                    + " estado_civil, fecha_nacimiento, sexo,"
                    + " ciudad, estado " 
                    +" FROM empleado WHERE estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' ORDER BY cod_empleado ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearEmpleados(resultset);
    }
    
        public Empleado consultarEmpleadoCodEmpleado(String documentoEmpleado) throws SQLException{
            
            query = "SELECT cod_empleado, cod_persona_e, fecha_ingreso,"
                    + " estado_civil, fecha_nacimiento, sexo,"
                    + " ciudad, estado, nombres, apellidos,direccion, telefono,"
                    + " celular, tipo_documento, numero_documento " 
                    +" FROM empleado, persona WHERE cod_persona_e = cod_persona"
                    + " AND estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' "
                    + " AND numero_documento = '"+documentoEmpleado+"' ORDER BY cod_empleado ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            if (!resultset.next()) {
                return null;
            }
            
            return  mapearEmpleado(resultset);
    }
        
        public List <Empleado> mapearEmpleados(ResultSet resultset){
            
                List <Empleado> listadoEmpleados = new ArrayList<>();
                Empleado empleado = new Empleado();
                
            try {
                
              while(resultset.next()){
                
                empleado.setCodEmpleado(resultset.getInt("cod_empleado"));
                empleado.setCodPersona(resultset.getInt("cod_persona_e"));
                empleado.setFechaNacimiento(resultset.getDate("fecha_nacimiento"));
                empleado.setSexo(resultset.getString("sexo"));
                empleado.setCiudad(resultset.getString("ciudad"));
                empleado.setEstadoCivil(resultset.getString("estado_civil"));
                empleado.setFechaIngreso(resultset.getDate("fecha_ingreso"));
                empleado.setEstado(resultset.getString("estado"));
               
                listadoEmpleados.add(empleado);

                System.out.println(" empleado "+empleado.getCiudad());
                System.out.println(" empleado "+empleado.getEstadoCivil());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoEmpleados;
        
        }
    
                public Empleado mapearEmpleado(ResultSet resultset){
                
                Empleado empleado = new Empleado();
                Persona persona = new Persona();
            try {
                    
              if(resultset.next()){
                
                empleado.setCodEmpleado(resultset.getInt("cod_empleado"));
                empleado.setCodPersona(resultset.getInt("cod_persona_e"));
                empleado.setFechaNacimiento(resultset.getDate("fecha_nacimiento"));
                empleado.setSexo(resultset.getString("sexo"));
                empleado.setCiudad(resultset.getString("ciudad"));
                empleado.setEstadoCivil(resultset.getString("estado_civil"));
                empleado.setFechaIngreso(resultset.getDate("fecha_ingreso"));
                empleado.setEstado(resultset.getString("estado"));
                persona.setNombres(resultset.getString("nombres"));
                persona.setApellidos(resultset.getString("apellidos"));
                persona.setDireccion(resultset.getString("direccion"));
                persona.setTelefono(resultset.getString("telefono"));
                persona.setCelular(resultset.getString("celular"));
                persona.setTipoDocumento(resultset.getString("tipo_documento"));
                persona.setNumeroDocumento(resultset.getString("numero_documento"));
                empleado.setPersona(persona);

                System.out.println(" empleado "+empleado.getCiudad());
                System.out.println(" empleado "+empleado.getEstadoCivil());
                System.out.println(""+resultset.getString("nombres"));
                
            }
            } catch (Exception e) {
            }
      
        return empleado;
        }
                
     
        
    public static void main(String[] args) throws SQLException, ParseException {
        EmpleadoDAO c = new EmpleadoDAO();
        Empleado empleado = new Empleado();
        
         // c.registrarEmpleado(empleado);
          //c.modificarEmpleado(empleado);
          //c.consultarEmpleado();
          //c.consultarEmpleadoCodEmpleado("5");
          //c.eliminarEmpleado(1);
          

    }
    
 
}
