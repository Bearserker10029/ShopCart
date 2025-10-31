package com.example.lab9_20202132.Beans;

import java.math.BigDecimal;

public class producto {
    private int id_producto;
    private categoria id_categoria;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    public producto() {
    }

    public producto(int id_producto, categoria id_categoria, String nombre, String descripcion, BigDecimal precio,
            int stock) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
