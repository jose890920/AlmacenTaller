/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Control.ClienteDAO;
import Control.EmpleadoDAO;
import Control.MotocicletaDAO;
import Control.PersonaDAO;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Motocicleta;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadeCliente {
     PersonaDAO personaDAO = new PersonaDAO();
     MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
     
    public void registrarCliente(Cliente cliente) throws SQLException, ParseException{
       ClienteDAO clienteoDAO = new ClienteDAO();
       cliente.setCodPersona(personaDAO.registrarPersona(cliente.getPersona()));
       cliente.getMotocicleta().setCodCliente(clienteoDAO.registrarCliente(cliente));
        if (validarRegistroMotocilieta(cliente.getMotocicleta().getLinea())) {
            motocicletaDAO.registrarMotocicleta(cliente.getMotocicleta());
        }
       
       
   } 
   
    public String modificarCliente(Cliente cliente) throws SQLException, ParseException{
       ClienteDAO clienteoDAO = new ClienteDAO();
       personaDAO.modificarPersona(cliente.getPersona());
       if (validarRegistroMotocilieta(cliente.getMotocicleta().getLinea())) {
            cliente.getMotocicleta().setCodCliente(cliente.getCodCliente());
            motocicletaDAO.registrarMotocicleta(cliente.getMotocicleta());
        }
       return clienteoDAO.modificarCliente(cliente);
   } 
      
    public Cliente consultarCliente(Cliente cliente) throws SQLException, ParseException{
       ClienteDAO clienteoDAO = new ClienteDAO();
        System.out.println("numero documento"+cliente.getPersona().getNumeroDocumento());
       return clienteoDAO.consultarClienteCodCliente(cliente.getPersona().getNumeroDocumento());
   } 
    
    public boolean validarRegistroMotocilieta(String campo){
    
        if (campo != null ) {
        if (!campo.trim().equals("") )    
           return true;
        }
        return false;
    
    }
    
}
