
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetallePago {
    
    private Integer codDetallePago, codPago;
    
    private double valorServicio, descuentoServicio;
    
    private String tipoServicio,descripcion,placa;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
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

    public double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) {
        this.valorServicio = valorServicio;
    }

    public double getDescuentoServicio() {
        return descuentoServicio;
    }

    public void setDescuentoServicio(double descuentoServicio) {
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
