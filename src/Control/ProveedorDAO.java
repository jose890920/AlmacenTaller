
package Control;

import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class ProveedorDAO {
    
        
     SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarProveedor(Proveedor proveedor)throws SQLException, ParseException{

     
        proveedor.setCodPersona(2);
        proveedor.setRazonSocial("guayas colombia");
        proveedor.setTelefonoEmpresa("3554545");
        proveedor.setFax("3554545");
        proveedor.setEmailComercial("gc@gmail.com");
        proveedor.setPais("Colombia");
        proveedor.setPaginaWeb("www.gcolombia.com");
        proveedor.setEstado("Activo");
        
        queryCodigo = "select MAX(cod_proveedor) conteo from proveedor";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        proveedor.setCodProveedor(sentencia.contarCodigos(result));
        
        query = "INSERT INTO proveedor( " 
                +" cod_proveedor, cod_persona_p, razon_social,"
                + " telefono_empresa, fax, correo_comercial,"
                + " pais, pagina_web, estado) " 
                +" VALUES ("+proveedor.getCodProveedor()+","+proveedor.getCodPersona()+","
                + " '"+proveedor.getRazonSocial()+"',"
                + " '"+proveedor.getTelefonoEmpresa()+"', '"+proveedor.getFax()+"',"
                + " '"+proveedor.getEmailComercial()+"', '"+proveedor.getPais()+"',"
                + " '"+proveedor.getPaginaWeb()+"','"+proveedor.getEstado()+"')";
        
        sentencia.gestionarRegistro(query);
    }
    
    public void modificarProveedor(Proveedor proveedor) throws ParseException{
        
        proveedor.setCodPersona(1);
        proveedor.setRazonSocial("frenos colombia");
        proveedor.setTelefonoEmpresa("5554545");
        proveedor.setFax("5554545");
        proveedor.setEmailComercial("fc@gmail.com");
        proveedor.setPais("ColombiA");
        proveedor.setPaginaWeb("www.fcolombia.com");
        proveedor.setEstado("inactivo");
        proveedor.setCodProveedor(1);
    
    query =    "UPDATE proveedor " 
            + " SET  cod_persona_p="+proveedor.getCodPersona()+","
            + " razon_social='"+proveedor.getRazonSocial()+"',"
            + " telefono_empresa='"+proveedor.getTelefonoEmpresa()+"',"
            + " fax='"+proveedor.getFax()+"',"
            + " correo_comercial='"+proveedor.getEmailComercial()+"',"
            + " pais='"+proveedor.getPais()+"'," 
            + " pagina_web='"+proveedor.getPaginaWeb()+"',"
            + " estado='"+proveedor.getEstado()+"'"
            + " WHERE cod_proveedor = "+proveedor.getCodProveedor()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarProveedor(Integer codProveedor){
            
            query = "DELETE FROM proveedor " +
                    "WHERE cod_proveedor = "+codProveedor+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Proveedor> consultarProveedor()throws SQLException{
        
        
        
            query = "SELECT cod_proveedor, cod_persona_p, razon_social,"
                    + " telefono_empresa, fax, correo_comercial,"
                    + " pais, pagina_web, estado " 
                    +" FROM public.proveedor WHERE estado = 'Activo' ORDER BY cod_proveedor ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearProveedores(resultset);
    }
    
        public Proveedor consultarProveedorCodProveedor(Integer codProveedor){
            
            query = "SELECT cod_proveedor, cod_persona_p, razon_social,"
                    + " telefono_empresa, fax, correo_comercial,"
                    + " pais, pagina_web, estado, nombres " 
                    + "	FROM proveedor, persona WHERE cod_persona_p = cod_persona"
                    + " AND estado = 'Activo' "
                    + " AND cod_proveedor = "+codProveedor+" ORDER BY cod_proveedor ASC";            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearProveedor(resultset);
    }
        
        public List <Proveedor> mapearProveedores(ResultSet resultset){
            
                List <Proveedor> listadoProveedores = new ArrayList<>();
                Proveedor proveedor = new Proveedor();
                
            try {
                
              while(resultset.next()){
                
                proveedor.setCodProveedor(resultset.getInt("cod_proveedor"));
                proveedor.setCodPersona(resultset.getInt("cod_persona_p"));
                proveedor.setRazonSocial(resultset.getString("razon_social"));
                proveedor.setTelefonoEmpresa(resultset.getString("telefono_empresa"));
                proveedor.setFax(resultset.getString("fax"));
                proveedor.setEmailComercial(resultset.getString("correo_comercial"));
                proveedor.setPais(resultset.getString("pais"));
                proveedor.setPaginaWeb(resultset.getString("pagina_web"));
                proveedor.setEstado(resultset.getString("estado"));
               
                listadoProveedores.add(proveedor);

                System.out.println(" proveedor "+proveedor.getRazonSocial());
                System.out.println(" proveedor "+proveedor.getPais());
                
                
                
            }
            } catch (Exception e) {
            }
      
        return listadoProveedores;
        
        }
    
                public Proveedor mapearProveedor(ResultSet resultset){
                
                Proveedor proveedor = new Proveedor();
            try {
                    
              if(resultset.next()){
                
                proveedor.setCodProveedor(resultset.getInt("cod_proveedor"));
                proveedor.setCodPersona(resultset.getInt("cod_persona_p"));
                proveedor.setRazonSocial(resultset.getString("razon_social"));
                proveedor.setTelefonoEmpresa(resultset.getString("telefono_empresa"));
                proveedor.setFax(resultset.getString("fax"));
                proveedor.setEmailComercial(resultset.getString("correo_comercial"));
                proveedor.setPais(resultset.getString("pais"));
                proveedor.setPaginaWeb(resultset.getString("pagina_web"));
                proveedor.setEstado(resultset.getString("estado"));


                System.out.println(" proveedor "+proveedor.getRazonSocial());
                System.out.println(" proveedor "+proveedor.getPais()); 
                System.out.println(""+resultset.getString("nombres"));
                
            }
            } catch (Exception e) {
            }
      
        return proveedor;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        ProveedorDAO p = new ProveedorDAO();
        Proveedor proveedor = new Proveedor();
        
          p.registrarProveedor(proveedor);
          //p.modificarProveedor(proveedor);
          //p.consultarProveedor();
          //p.consultarProveedorCodProveedor(2);
          //p.eliminarProveedor(1);

    }
    
}
