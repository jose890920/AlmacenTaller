
package Control;

import Modelo.Motocicleta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class MotocicletaDAO {
    
         SentenciaSQL sentencia = new SentenciaSQL();
     Validaciones validaciones = new Validaciones();
     String query;
     String queryCodigo ="";
     ResultSet resultset;
     
    public void registrarMotocicleta(Motocicleta motocicleta)throws SQLException, ParseException{

     
        motocicleta.setCodCliente(2);
        motocicleta.setPlaca("KPL14B");
        motocicleta.setPaisMatricula("Colombia");
        motocicleta.setModelo("2014");
        motocicleta.setMarca("suzuki");
        motocicleta.setCilindraje("124");
        motocicleta.setLinea("Best");
        motocicleta.setTipoMotocicleta("Semiautomatica");
        
        queryCodigo = "select MAX(cod_motocicleta) conteo from motocicleta";
        
        ResultSet result = sentencia.gestionarConsulta(queryCodigo);
      
        motocicleta.setCodMotocicleta(sentencia.contarCodigos(result));
        
        query = "INSERT INTO public.motocicleta( " 
                +" cod_motocicleta, cod_cliente_m, placa,"
                + " pais_matricula, modelo, marca,"
                + " cilindraje, linea, tipo_motocilceta) " 
                +" VALUES ("+motocicleta.getCodMotocicleta()+", "+motocicleta.getCodCliente()+","
                + " '"+motocicleta.getPlaca()+"', '"+motocicleta.getPaisMatricula()+"',"
                + " '"+motocicleta.getModelo()+"', '"+motocicleta.getMarca()+"',"
                + " '"+motocicleta.getCilindraje()+"', '"+motocicleta.getLinea()+"',"
                + " '"+motocicleta.getTipoMotocicleta()+"')";
        
        sentencia.gestionarRegistro(query);
    }
    
    public void modificarMotocicleta(Motocicleta motocicleta) throws ParseException{
        
        motocicleta.setCodCliente(2);
        motocicleta.setPlaca("KPL15B");
        motocicleta.setPaisMatricula("ColombiA");
        motocicleta.setModelo("2015");
        motocicleta.setMarca("suzuki");
        motocicleta.setCilindraje("114");
        motocicleta.setLinea("VivaR");
        motocicleta.setTipoMotocicleta("Semiautomatica");
        motocicleta.setCodMotocicleta(1);
    
    query =    "UPDATE motocicleta " 
            + " SET  cod_cliente_m = "+motocicleta.getCodCliente()+","
            + " placa='"+motocicleta.getPlaca()+"',"
            + " pais_matricula='"+motocicleta.getPaisMatricula()+"',"
            + " modelo= '"+motocicleta.getModelo()+"',"
            + " marca='"+motocicleta.getMarca()+"',"
            + " cilindraje = '"+motocicleta.getCilindraje()+"',"
            + " linea = '"+motocicleta.getLinea()+"',"
            + " tipo_motocilceta='"+motocicleta.getTipoMotocicleta()+"'" 
            + " WHERE cod_motocicleta = "+motocicleta.getCodMotocicleta()+"";
    
    sentencia.gestionarRegistro(query);
    
    }
    
    public void eliminarMotocicleta(Integer codMotocicleta){
            
            query = "DELETE FROM motocicleta " +
                    "WHERE cod_motocicleta = "+codMotocicleta+"";
            sentencia.gestionarRegistro(query);
    }
    
    public List <Motocicleta> consultarMotocicleta()throws SQLException{
        
        
        
            query =  "SELECT cod_motocicleta, cod_cliente_m, placa,"
                    + " pais_matricula, modelo, marca,"
                    + " cilindraje, linea, tipo_motocilceta " 
                    +" FROM motocicleta "
                    +" ORDER BY cod_motocicleta ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
          
         return mapearMotocicletas(resultset);
    }
    
        public Motocicleta consultarMotocicletaCodMotocicleta(Integer codMotocicleta){
            
            query =  "SELECT cod_motocicleta, cod_cliente_m, placa,"
                    + " pais_matricula, modelo, marca,"
                    + " cilindraje, linea, tipo_motocilceta, estado " 
                    +" FROM motocicleta, cliente WHERE cod_motocicleta = "+codMotocicleta+""
                    + " AND estado = 'Activo' "
                    + " ORDER BY cod_motocicleta ASC";
            
            resultset = sentencia.gestionarConsulta(query);
            
            return  mapearMotocicleta(resultset);
    }
        
        public List <Motocicleta> mapearMotocicletas(ResultSet resultset){
            
                List <Motocicleta> listadoMotocicletas = new ArrayList<>();
                Motocicleta motocicleta = new Motocicleta();
                
            try {
                
              while(resultset.next()){
                
                motocicleta.setCodMotocicleta(resultset.getInt("cod_motocicleta"));
                motocicleta.setCodCliente(resultset.getInt("cod_cliente_m"));
                motocicleta.setPlaca(resultset.getString("placa"));
                motocicleta.setPaisMatricula(resultset.getString("pais_matricula"));
                motocicleta.setModelo(resultset.getString("modelo"));
                motocicleta.setMarca(resultset.getString("marca"));
                motocicleta.setCilindraje(resultset.getString("cilindraje"));
                motocicleta.setLinea(resultset.getString("linea"));
                motocicleta.setTipoMotocicleta(resultset.getString("tipo_motocilceta"));   
                
                listadoMotocicletas.add(motocicleta);

                System.out.println(" Motocicleta "+motocicleta.getMarca());
                System.out.println(" Motocicleta "+motocicleta.getLinea());
                
            }
            } catch (Exception e) {
            }
      
        return listadoMotocicletas;
        
        }
    
                public Motocicleta mapearMotocicleta(ResultSet resultset){
                
                Motocicleta motocicleta = new Motocicleta();
            try {
                    
              if(resultset.next()){
                
                motocicleta.setCodMotocicleta(resultset.getInt("cod_motocicleta"));
                motocicleta.setCodCliente(resultset.getInt("cod_cliente_m"));
                motocicleta.setPlaca(resultset.getString("placa"));
                motocicleta.setPaisMatricula(resultset.getString("pais_matricula"));
                motocicleta.setModelo(resultset.getString("modelo"));
                motocicleta.setMarca(resultset.getString("marca"));
                motocicleta.setCilindraje(resultset.getString("cilindraje"));
                motocicleta.setLinea(resultset.getString("linea"));
                motocicleta.setTipoMotocicleta(resultset.getString("tipo_motocilceta"));   


                System.out.println(" Motocicleta "+motocicleta.getMarca());
                System.out.println(" Motocicleta "+motocicleta.getLinea());
                System.out.println(" Motocicleta "+resultset.getString("estado"));
                
            }
            } catch (Exception e) {
            }
      
        return motocicleta;
        }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        MotocicletaDAO p = new MotocicletaDAO();
        Motocicleta motocicleta = new Motocicleta();
        
        p.registrarMotocicleta(motocicleta);
        //p.consultarMotocicleta();
        //p.consultarMotocicletaCodMotocicleta(1);
        //p.modificarMotocicleta(motocicleta);
        //p.eliminarMotocicleta(1);

    }

    
}
