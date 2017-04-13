
package Control;

import Modelo.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class EmpleadoDAO {
    
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarEmpleado(Empleado empleado)throws SQLException, ParseException{

     
        empleado.setCodPersona(1);
        empleado.setFechaIngreso(validaciones.transformarFecha("05-05-2017"));
        empleado.setEstadoCivil("Soltero");
        empleado.setFechaNacimiento(validaciones.transformarFecha("05-05-1995"));
        empleado.setSexo("M");
        empleado.setCiudad("Cali");
        empleado.setEstado("Activo");
        
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
    
    public void modificarEmpleado(Empleado empleado) throws ParseException{
        
        empleado.setCodPersona(1);
        empleado.setFechaIngreso(validaciones.transformarFecha("05-01-2017"));
        empleado.setEstadoCivil("Soltero");
        empleado.setFechaNacimiento(validaciones.transformarFecha("05-01-1995"));
        empleado.setSexo("F");
        empleado.setCiudad("CalI");
        empleado.setEstado("inactivo");
        empleado.setCodEmpleado(1);
    
    query =    "UPDATE empleado " 
            + " SET  cod_persona_e="+empleado.getCodPersona()+","
            + " fecha_ingreso='"+empleado.getFechaIngreso()+"',"
            + " estado_civil='"+empleado.getEstadoCivil()+"',"
            + " fecha_nacimiento='"+empleado.getFechaNacimiento()+"',"
            + " sexo='"+empleado.getSexo()+"',"
            + " ciudad='"+empleado.getCiudad()+"'," 
            + " estado='"+empleado.getEstado()+"'"
            + " WHERE cod_empleado = "+empleado.getCodEmpleado()+"";
    
    sentencia.gestionarRegistro(query);
    
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
                    +" FROM empleado WHERE estado = 'Activo' ORDER BY cod_empleado ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearEmpleados(resultset);
    }
    
        public Empleado consultarEmpleadoCodEmpleado(Integer codEmpleado){
            
            query = "SELECT cod_empleado, cod_persona_e, fecha_ingreso,"
                    + " estado_civil, fecha_nacimiento, sexo,"
                    + " ciudad, estado, nombres " 
                    +" FROM empleado, persona WHERE cod_persona_e = cod_persona"
                    + " AND estado = 'Activo' "
                    + " AND cod_empleado = "+codEmpleado+" ORDER BY cod_empleado ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
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
        
          //c.registrarEmpleado(empleado);
          //c.modificarEmpleado(empleado);
          //c.consultarEmpleado();
          //c.consultarEmpleadoCodEmpleado(2);
          //c.eliminarEmpleado(1);
          

    }
}
