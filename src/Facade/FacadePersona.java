/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Control.PersonaDAO;
import Modelo.Persona;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author jose luis Rodriguez
 */
public class FacadePersona {
    
        PersonaDAO personaDAO = new PersonaDAO();
    
       public void registrarPersona(Persona persona) throws SQLException, ParseException{
            
           personaDAO.registrarPersona(persona);
   } 
   
    public String modificarPersona(Persona persona) throws SQLException, ParseException{
       return personaDAO.modificarPersona(persona);
   } 
      
    public Persona consultarPersona(Persona persona) throws SQLException, ParseException{
       return personaDAO.consultarPersonaNumeroDocumento(persona.getNumeroDocumento());
   } 
    
}
