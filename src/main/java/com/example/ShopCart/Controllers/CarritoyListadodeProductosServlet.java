package com.example.ShopCart.Controllers;

import com.example.ShopCart.Beans.usuario;
import com.example.ShopCart.Daos.CarritoyListadodeProductosDao;
import com.example.ShopCart.Dto.CarritoyListadodeProductosDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CarritoyListadodeProductosServlet", urlPatterns = { "/Carrito" })
public class CarritoyListadodeProductosServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;

        CarritoyListadodeProductosDao carritoyListadodeProductosDao = new CarritoyListadodeProductosDao();

        ArrayList<CarritoyListadodeProductosDto> listaCarrito = carritoyListadodeProductosDao.listaProductos();
        request.setAttribute("listaCarrito", listaCarrito);
        rd = request.getRequestDispatcher("/carrito/lista.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action") == null ? "" : request.getParameter("action");

        switch (action) {
            case "anadir":
                usuario usuarioLogueado = (usuario) session.getAttribute("usuarioLogueado");
                CarritoyListadodeProductosDao carritoDao = new CarritoyListadodeProductosDao();

                try {
                    int idProducto = Integer.parseInt(request.getParameter("id_producto"));
                    carritoDao.anadirAlCarrito(idProducto, usuarioLogueado.getId_usuario());
                    response.sendRedirect(request.getContextPath() + "/Lista?msg=Producto añadido al carrito");
                } catch (NumberFormatException | SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/Lista?err=Error al añadir producto al carrito");
                }
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/Lista");
                break;
        }
    }
}