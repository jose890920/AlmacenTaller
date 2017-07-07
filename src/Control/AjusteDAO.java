
package Control;

import Modelo.Ajuste;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class AjusteDAO extends ConstantesAlmacenyTaller{

     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public int registrarAjuste(Ajuste ajuste)throws SQLException, ParseException{

     /*
        ajuste.setCodEmpleado(2);
        ajuste.setValorTotal(55_550);
        ajuste.setTipoAjuste("Devolucion");
        ajuste.setFechaAjuste(validaciones.transformarFechatoDate("05/05/2017"));
        ajuste.setEstado("Activo");
       */ 
        queryCodigo = "select MAX(cod_ajuste) conteo from ajuste";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        ajuste.setCodAjuste(sentencia.contarCodigos(result));
        
        query = "INSERT INTO ajuste( " 
                +" cod_ajuste, cod_empleado_a, tipo_ajuste,"
                + " fecha_ajuste, valor_total, estado) " 
                +" VALUES ("+ajuste.getCodAjuste()+","
                + " "+ajuste.getCodEmpleado()+",'"+ajuste.getTipoAjuste()+"',"
                + " '"+ajuste.getFechaAjuste()+"',"
                + " "+ajuste.getValorTotal()+", '"+ajuste.getEstado()+"')";
        
         sentencia.gestionarRegistro(query);
         
         return ajuste.getCodAjuste();
    }
    
    public String modificarAjuste(Ajuste ajuste) throws ParseException{
        /*
        ajuste.setCodEmpleado(2);
        ajuste.setValorTotal(55_000);
        ajuste.setTipoAjuste("Devolucion");
        ajuste.setFechaAjuste(validaciones.transformarFechatoDate("01-05-2017"));
        ajuste.setEstado("inactivo");
        ajuste.setCodAjuste(1);
    */
    query =    "UPDATE ajuste SET " 
            + " valor_total = "+ajuste.getValorTotal()+" " 
            + " WHERE cod_ajuste = "+ajuste.getCodAjuste()+"";
    
   return sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarAjuste(Integer codAjuste){
            
            query = "DELETE FROM ajuste" +
                    " WHERE cod_ajuste = "+codAjuste+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Ajuste> consultarAjuste()throws SQLException{
        
        
        
            query = "SELECT cod_ajuste, tipo_ajuste, cod_empleado_a,"
                    + " fecha_ajuste, valor_total, estado " 
                    +" FROM ajuste WHERE estado = 'Activo' ORDER BY cod_ajuste ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearAjustes(resultset);
    }
    
        public List<Ajuste> consultarAjusteCodAjuste(String numeroDocumento){
            
            query = "SELECT cod_ajuste, tipo_ajuste, cod_empleado_a,"
                    + " fecha_ajuste, valor_total, ajuste.estado, ciudad " 
                    +" FROM ajuste, empleado, persona WHERE "
                    + " ajuste.estado = '"+CONSTANTE_ESTADO_POR_DEFECTO+"' AND "
                    + " numero_documento = '"+numeroDocumento+"' "
                    + " AND cod_persona_a = cod_persona "
                    + " AND cod_empleado_a = cod_empleado ORDER BY cod_ajuste ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearAjuste(resultset);
    }
        
        public List <Ajuste> mapearAjustes(ResultSet resultset){
            
                List <Ajuste> listadoAjustes = new ArrayList<>();
                Ajuste ajuste = new Ajuste();
                
            try {
                
              while(resultset.next()){
                
                ajuste.setCodAjuste(resultset.getInt("cod_ajuste"));
                ajuste.setTipoAjuste(resultset.getString("tipo_ajuste"));
                ajuste.setCodEmpleado(resultset.getInt("cod_empleado_a"));
                ajuste.setFechaAjuste(resultset.getDate("fecha_ajuste"));
                ajuste.setValorTotal(resultset.getInt("valor_total"));
                ajuste.setEstado(resultset.getString("estado"));
               
                listadoAjustes.add(ajuste);

                System.out.println(" ajuste "+ajuste.getFechaAjuste());
                System.out.println(" ajuste "+ajuste.getValorTotal());
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoAjustes;
        
        }
    
                public List<Ajuste> mapearAjuste(ResultSet resultset){
                
                      List <Ajuste> listadoAjustes = new ArrayList<>();
                
            try {
                  
              while(resultset.next()){
                    Ajuste ajuste = new Ajuste();
                    ajuste.setCodAjuste(resultset.getInt("cod_ajuste"));
                    ajuste.setTipoAjuste(resultset.getString("tipo_ajuste"));
                    ajuste.setCodEmpleado(resultset.getInt("cod_empleado_a"));
                    ajuste.setFechaAjuste(resultset.getDate("fecha_ajuste"));
                    ajuste.setValorTotal(resultset.getInt("valor_total"));
                    ajuste.setEstado(resultset.getString("estado"));

                    System.out.println(" ajuste "+ajuste.getFechaAjuste());
                    System.out.println(" ajuste "+ajuste.getValorTotal());                
                    System.out.println(""+resultset.getString("ciudad"));
                    listadoAjustes.add(ajuste);
                
            }
            } catch (Exception e) {
            }
      
        return listadoAjustes;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        AjusteDAO a = new AjusteDAO();
        Ajuste ajuste = new Ajuste();
        
        a.registrarAjuste(ajuste);
       // a.consultarAjuste();
        //a.modificarAjuste(ajuste);
        //a.consultarAjusteCodAjuste(2);
        //a.eliminarAjuste(1);

    }    
}
