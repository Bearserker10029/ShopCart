package com.example.ShopCart.Daos;

import com.example.ShopCart.Beans.categoria;
import com.example.ShopCart.Dto.CreacionyListadodeProductoDto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreacionyListadodeProductoDao extends DaoBase {

    public ArrayList<CreacionyListadodeProductoDto> listaProductos() {
        ArrayList<CreacionyListadodeProductoDto> listaProductos = new ArrayList<>();

        String sql = "SELECT p.id_producto, p.nombre, c.nombre AS categoriaNombre, p.precio, (p.stock - ifnull(sum(ci.cantidad),0)) AS stock\n"
                +
                " FROM producto p" +
                " JOIN categoria c ON p.id_categoria = c.id_categoria" +
                " LEFT JOIN carrito_item ci ON p.id_producto = ci.id_producto" +
                " group BY p.id_producto order by p.id_producto";

        try (Connection conn = this.getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CreacionyListadodeProductoDto producto = new CreacionyListadodeProductoDto();
                producto.setId(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoriaNombre(rs.getString("categoriaNombre"));
                producto.setPrecio(rs.getBigDecimal("precio"));
                producto.setStock(rs.getInt("stock"));
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public void crearproducto(int id_categoria, String nombre, String descripcion, BigDecimal precio, int stock)
            throws SQLException {
        String sql = "Insert into producto (id_categoria,nombre,descripcion,precio,stock) values(?,?,?,?,?)";
        try (Connection conn = this.getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id_categoria);
            pstmt.setString(2, nombre);
            pstmt.setString(3, descripcion);
            pstmt.setBigDecimal(4, precio);
            pstmt.setInt(5, stock);
            pstmt.executeUpdate();
        }
    }

    public ArrayList<categoria> listaCategorias() {
        ArrayList<categoria> listaCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection conn = this.getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                categoria categoria = new categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                listaCategorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCategorias;
    }
}
