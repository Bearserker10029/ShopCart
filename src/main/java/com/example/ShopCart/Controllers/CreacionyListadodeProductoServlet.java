package com.example.ShopCart.Controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.ShopCart.Beans.categoria;
import com.example.ShopCart.Daos.CreacionyListadodeProductoDao;
import com.example.ShopCart.Dto.CreacionyListadodeProductoDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CreacionyListadodeProductoServlet", urlPatterns = { "/Lista" })
public class CreacionyListadodeProductoServlet extends HttpServlet {
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

        CreacionyListadodeProductoDao creacionyListadodeProductoDao = new CreacionyListadodeProductoDao();
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        switch (action) {
            case "crear":
                ArrayList<categoria> listacategoria = creacionyListadodeProductoDao.listaCategorias();
                request.setAttribute("listacategoria", listacategoria);
                rd = request.getRequestDispatcher("/productos/formularioNuevo.jsp");
                rd.forward(request, response);
                break;

            default:
                ArrayList<CreacionyListadodeProductoDto> listaProductos = creacionyListadodeProductoDao
                        .listaProductos();
                request.setAttribute("listaproducto", listaProductos);
                rd = request.getRequestDispatcher("/productos/lista.jsp");
                rd.forward(request, response);
                break;
        }
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
            case "guardar":
                CreacionyListadodeProductoDao creacionyListadodeProductoDao = new CreacionyListadodeProductoDao();
                try {
                    int categoriaId = Integer.parseInt(request.getParameter("id_categoria"));
                    String nombre = request.getParameter("nombre");
                    String descripcion = request.getParameter("descripcion");
                    BigDecimal precio = new BigDecimal(request.getParameter("precio"));
                    int stock = Integer.parseInt(request.getParameter("stock"));

                    creacionyListadodeProductoDao.crearproducto(categoriaId, nombre, descripcion, precio, stock);
                    response.sendRedirect(request.getContextPath() + "/Lista?msg=Producto creado exitosamente");
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/Lista?err=Error al crear el producto");
                }
                break;
            default:
                break;
        }

    }
}
