
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class motocilceta {
    
    private Integer codMotocicleta, codCliente;
    
    private String placa, paisMatricula, modelo, marca, cilindraje, linea,
                   tipoMotocicleta;
    
    private Cliente cliente;

    public motocilceta() {
    }

    public Integer getCodMotocicleta() {
        return codMotocicleta;
    }

    public void setCodMotocicleta(Integer codMotocicleta) {
        this.codMotocicleta = codMotocicleta;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPaisMatricula() {
        return paisMatricula;
    }

    public void setPaisMatricula(String paisMatricula) {
        this.paisMatricula = paisMatricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getTipoMotocicleta() {
        return tipoMotocicleta;
    }

    public void setTipoMotocicleta(String tipoMotocicleta) {
        this.tipoMotocicleta = tipoMotocicleta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
