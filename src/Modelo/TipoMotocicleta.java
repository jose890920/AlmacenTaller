/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jose luis Rodriguez
 */
public class TipoMotocicleta implements CatalogoI{
    
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
