package com.example.lab9_20202132.Dto;

import java.math.BigDecimal;

public class CarritoyListadodeProductosDto {
    private int idItem;
    private int idProducto;
    private String nombreProducto;
    private String nombreUsuario;
    private BigDecimal precioUnit;
    private int cantidad;
    private BigDecimal subtotal;

    public CarritoyListadodeProductosDto() {
    }

    public CarritoyListadodeProductosDto(int idItem, int idProducto, String nombreProducto, String nombreUsuario,
            BigDecimal precioUnit, int cantidad, BigDecimal subtotal) {
        this.idItem = idItem;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.nombreUsuario = nombreUsuario;
        this.precioUnit = precioUnit;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public BigDecimal getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(BigDecimal precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

}
