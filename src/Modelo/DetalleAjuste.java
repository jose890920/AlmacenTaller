
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleAjuste {

    private Integer codDetalleAjuste, codAjuste, codProducto, cantidadProducto;
    private double valorUnitario, valorConjunto, descuento;
    private Ajuste ajuste;
    
    private Producto producto;

    public DetalleAjuste() {
    }

    public Integer getCodDetalleAjuste() {
        return codDetalleAjuste;
    }

    public void setCodDetalleAjuste(Integer codDetalleAjuste) {
        this.codDetalleAjuste = codDetalleAjuste;
    }

    public Integer getCodAjuste() {
        return codAjuste;
    }

    public void setCodAjuste(Integer codAjuste) {
        this.codAjuste = codAjuste;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorConjunto() {
        return valorConjunto;
    }

    public void setValorConjunto(double valorConjunto) {
        this.valorConjunto = valorConjunto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Ajuste getAjuste() {
        return ajuste;
    }

    public void setAjuste(Ajuste ajuste) {
        this.ajuste = ajuste;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}    

