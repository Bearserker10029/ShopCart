package com.example.lab9_20202132.Beans;

import java.sql.Timestamp;

public class carrito_item {
    private int id_item;
    private usuario id_usuario;
    private producto id_producto;
    private int cantidad;
    private Timestamp agregado_en;

    public carrito_item() {
    }

    public carrito_item(int id_item, usuario id_usuario, producto id_producto, int cantidad, Timestamp agregado_en) {
        this.id_item = id_item;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.agregado_en = agregado_en;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(producto id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getAgregado_en() {
        return agregado_en;
    }

    public void setAgregado_en(Timestamp agregado_en) {
        this.agregado_en = agregado_en;
    }
}
