
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetallePago {
    
    private Integer codDetallePago, codPago,valorServicio, descuentoServicio;
    
    private String tipoServicio;
    
    private PagoEmpleado pagoEmpleado;

    public DetallePago() {
    }

    public Integer getCodDetallePago() {
        return codDetallePago;
    }

    public void setCodDetallePago(Integer codDetallePago) {
        this.codDetallePago = codDetallePago;
    }

    public Integer getCodPago() {
        return codPago;
    }

    public void setCodPago(Integer codPago) {
        this.codPago = codPago;
    }

    public Integer getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(Integer valorServicio) {
        this.valorServicio = valorServicio;
    }

    public Integer getDescuentoServicio() {
        return descuentoServicio;
    }

    public void setDescuentoServicio(Integer descuentoServicio) {
        this.descuentoServicio = descuentoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public PagoEmpleado getPagoEmpleado() {
        return pagoEmpleado;
    }

    public void setPagoEmpleado(PagoEmpleado pagoEmpleado) {
        this.pagoEmpleado = pagoEmpleado;
    }
    
    
    
}
