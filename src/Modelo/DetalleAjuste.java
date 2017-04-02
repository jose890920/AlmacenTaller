
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class DetalleAjuste {

 private Integer codDetalleAjuste, codAjuste, codProducto, cantidadProducto,
                    valorUnitario, valorConjunto, descuento;
    
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

