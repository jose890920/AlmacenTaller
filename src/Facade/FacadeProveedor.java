/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Control.ProveedorDAO;
import Control.PersonaDAO;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeProveedor {
        
   
    PersonaDAO personaDAO = new PersonaDAO();
    
       public void registrarProveedor(Proveedor proveedor) throws SQLException, ParseException{
       ProveedorDAO proveedorDAO = new ProveedorDAO();
       proveedor.setCodPersona(personaDAO.registrarPersona(proveedor.getPersona()));
       proveedorDAO.registrarProveedor(proveedor);
   } 
   
    public String modificarProveedor(Proveedor proveedor) throws SQLException, ParseException{
        ProveedorDAO proveedorDAO = new ProveedorDAO();
       personaDAO.modificarPersona(proveedor.getPersona());
       return proveedorDAO.modificarProveedor(proveedor);
   } 
      
    public Proveedor consultarProveedor(Proveedor proveedor) throws SQLException, ParseException{
        ProveedorDAO proveedorDAO = new ProveedorDAO();
       return proveedorDAO.consultarProveedorCodProveedor(proveedor.getPersona().getNumeroDocumento());
   } 
}
