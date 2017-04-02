
package Modelo;

import java.sql.Date;

/**
 *
 * @author jose luis Rodriguez
 */
public class Cliente {
    private Integer codCliente, codPersona;
    
    private Date fechaNacimiento;
    
    private String sexo, barrio, tieneMotocicleta, estado;
    
    private Persona persona;

    public Cliente() {
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTieneMotocicleta() {
        return tieneMotocicleta;
    }

    public void setTieneMotocicleta(String tieneMotocicleta) {
        this.tieneMotocicleta = tieneMotocicleta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
