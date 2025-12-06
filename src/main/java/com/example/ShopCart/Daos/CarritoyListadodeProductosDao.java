package com.example.ShopCart.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.ShopCart.Dto.CarritoyListadodeProductosDto;

public class CarritoyListadodeProductosDao extends DaoBase {

    public ArrayList<CarritoyListadodeProductosDto> listaProductos() {
        ArrayList<CarritoyListadodeProductosDto> listaProductos = new ArrayList<>();

        String sql = "SELECT ci.id_item, p.id_producto, p.nombre, u.nombres, p.precio, ci.cantidad AS stock, (p.precio * ci.cantidad) as subtotal FROM carrito_item ci"
                +
                " Inner Join usuario u on ci.id_usuario=u.id_usuario" +
                " Inner Join producto p on ci.id_producto=p.id_producto" +
                " group BY ci.id_item order by p.id_producto";

        try (Connection conn = this.getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CarritoyListadodeProductosDto producto = new CarritoyListadodeProductosDto();
                producto.setIdItem(rs.getInt("id_item"));
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setNombreUsuario(rs.getString("nombres"));
                producto.setPrecioUnit(rs.getBigDecimal("precio"));
                producto.setCantidad(rs.getInt("stock"));
                producto.setSubtotal(rs.getBigDecimal("subtotal"));
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public void anadirAlCarrito(int id_producto, int id_usuario) throws SQLException {
        String sql = "INSERT INTO carrito_item (id_producto, cantidad, id_usuario) VALUES (?, 1, ?) on duplicate key update cantidad=cantidad+1";
        try (Connection conn = this.getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_producto);
            pstmt.setInt(2, id_usuario);
            pstmt.executeUpdate();
        }
    }
}
