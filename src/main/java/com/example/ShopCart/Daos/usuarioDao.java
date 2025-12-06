package com.example.ShopCart.Daos;

import com.example.ShopCart.Beans.usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class usuarioDao extends DaoBase {

    public usuario obtenerUsuarioPorId(int idUsuario) {
        usuario usuario = null;
        String sql = "SELECT u.nombres, u.apellidos, u.email "
                + "FROM usuario u " +
                " WHERE u.id_usuario = ?";

        try (Connection conn = getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new usuario();
                    usuario.setId_usuario(idUsuario);

                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public usuario validarUsuarioPassword(String username, String password) {
        usuario usuario = null;
        String sql = "SELECT id_usuario FROM usuario WHERE email = ? AND password_hash = ? and estado = 'ACTIVO'";
        try (Connection conn = getConection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String hashedPassword = hashPassword(password);

            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int usuarioId = rs.getInt("id_usuario");
                    System.out.println("✓ Usuario encontrado! ID: " + usuarioId);
                    usuario = this.obtenerUsuarioPorId(usuarioId);
                } else {
                    System.out.println("✗ No se encontró usuario con ese email y contraseña");

                }
            }
            System.out.println("==================");
        } catch (SQLException ex) {
            System.err.println("ERROR SQL en validarUsuarioPassword:");
            ex.printStackTrace();
        }
        return usuario;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
