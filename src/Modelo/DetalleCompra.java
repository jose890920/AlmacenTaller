
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleCompra {
    
    private Integer codDetalleCompra, codCompra, codProducto, cantidadProducto,
                    valorUnitario, valorConjunto, descuento;
    
    private Compra compra;
    
    private Producto producto;

    public DetalleCompra() {
    }

    public Integer getCodDetalleCompra() {
        return codDetalleCompra;
    }

    public void setCodDetalleCompra(Integer codDetalleCompra) {
        this.codDetalleCompra = codDetalleCompra;
    }

    public Integer getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(Integer codCompra) {
        this.codCompra = codCompra;
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

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getValorConjunto() {
        return valorConjunto;
    }

    public void setValorConjunto(Integer valorConjunto) {
        this.valorConjunto = valorConjunto;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
