package com.example.lab9_20202132.Controllers;

import com.example.lab9_20202132.Beans.usuario;
import com.example.lab9_20202132.Daos.usuarioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        usuario usuarioLogged = (usuario) httpSession.getAttribute("usuarioLogueado");

        if (usuarioLogged != null && usuarioLogged.getId_usuario() > 0) {

            if (request.getParameter("a") != null) {// logout
                httpSession.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/Lista");
        } else {
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username + " | hashedPassword: " + password);
        usuarioDao usuarioDao = new usuarioDao();
        usuario usuario = usuarioDao.validarUsuarioPassword(username, password);

        if (usuario != null) {
            System.out.println("usuario y password válidos");
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("usuarioLogueado", usuario);
            response.sendRedirect(request.getContextPath() + "/Lista");
        } else {
            System.out.println("usuario o password incorrectos");
            request.setAttribute("err", "Usuario o password incorrectos");
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
        }
    }
}