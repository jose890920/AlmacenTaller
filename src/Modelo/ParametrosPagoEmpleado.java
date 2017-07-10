/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Date;

/**
 *
 * @author jose luis Rodriguez
 */
public class ParametrosPagoEmpleado {

    public ParametrosPagoEmpleado() {
    }
    
    private String descripcion,servicio;
    private double  valorServicio,descuentoServicio;
    private Date fechaServicio;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
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

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }
    
    
}
