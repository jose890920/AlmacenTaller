
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class tipoProducto implements CatalogoI{
    
    private String llave;
    
    private String valor;

    @Override
    public String getLlave() {
        return llave;
    }

    @Override
    public String getValor() {
        return valor;
    }

    @Override
    public void setLlave(String llave) {
        this.llave = llave;
    }

    @Override
    public void setValor(String valor) {
        this.valor = valor;
    }

   
}
