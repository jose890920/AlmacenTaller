
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleVenta {

    public DetalleVenta() {
    }
    
    private Integer codDetalleVenta, codVenta, codProducto, cantidadProducto;
    
    private double valorUnitario, valorConjunto, descuento;
    
    private Venta venta;
    
    private Producto producto;

    public Integer getCodDetalleVenta() {
        return codDetalleVenta;
    }

    public void setCodDetalleVenta(Integer codDetalleVenta) {
        this.codDetalleVenta = codDetalleVenta;
    }

    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
        this.codVenta = codVenta;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
}
