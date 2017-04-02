
package Modelo;

import java.sql.Date;

/**
 *
 * @author jose luis Rodriguez
 */
public class Ajuste {
    
        private Integer codAjuste, codEmpleado, valorTotal;
    
    private Date fechaAjuste;
    
    private String estado, tipoAjuste;
        
    private Empleado empleado;

    public Ajuste() {
    }

    public Integer getCodAjuste() {
        return codAjuste;
    }

    public void setCodAjuste(Integer codAjuste) {
        this.codAjuste = codAjuste;
    }

    public Integer getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaAjuste() {
        return fechaAjuste;
    }

    public void setFechaAjuste(Date fechaAjuste) {
        this.fechaAjuste = fechaAjuste;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(String tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
}
