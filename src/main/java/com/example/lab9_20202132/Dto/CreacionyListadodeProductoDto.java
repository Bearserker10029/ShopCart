package com.example.lab9_20202132.Dto;

import java.math.BigDecimal;

public class CreacionyListadodeProductoDto {
    private int id;
    private String nombre;
    private String categoriaNombre;
    private BigDecimal precio;
    private int stock;

    public CreacionyListadodeProductoDto() {
    }

    public CreacionyListadodeProductoDto(int id, String nombre, String categoriaNombre, BigDecimal precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoriaNombre = categoriaNombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
