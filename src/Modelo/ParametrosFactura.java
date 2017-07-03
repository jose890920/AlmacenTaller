/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose luis Rodriguez
 */
public class ParametrosFactura {
    
    private String numeroDocumentoCliente;
    private String numeroDocumentoEmpleado;
    private String nombreCliente;
    private String nombreEmpleado;
    private DefaultTableModel productosaVender;
    private int codigoVenta;

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    
    public String getNumeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
        this.numeroDocumentoCliente = numeroDocumentoCliente;
    }

    public String getNumeroDocumentoEmpleado() {
        return numeroDocumentoEmpleado;
    }

    public void setNumeroDocumentoEmpleado(String numeroDocumentoEmpleado) {
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public DefaultTableModel getProductosaVender() {
        return productosaVender;
    }

    public void setProductosaVender(DefaultTableModel productosaVender) {
        this.productosaVender = productosaVender;
    }
    
    
    
}
