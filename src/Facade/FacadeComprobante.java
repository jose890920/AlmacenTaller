/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Control.ComprobanteDAO;
import Modelo.Comprobante;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeComprobante {
    
       public void registrarComprobante(Comprobante comprobante) throws SQLException, ParseException{
       ComprobanteDAO comprobanteDAO = new ComprobanteDAO();
        comprobanteDAO.registrarComprobante(comprobante);
   } 
   
    public String modificarComprobante(Comprobante comprobante) throws SQLException, ParseException{
       ComprobanteDAO comprobanteDAO = new ComprobanteDAO();
       return comprobanteDAO.modificarComprobante(comprobante);
   } 
      
    public List<Comprobante> consultarComprobante(Comprobante comprobante) throws SQLException, ParseException{
       ComprobanteDAO comprobanteDAO = new ComprobanteDAO();
      return comprobanteDAO.consultarComprobanteCodComprobante(comprobante.getVenta().getCliente().getPersona().getNumeroDocumento());
   } 
    
    
    
}
