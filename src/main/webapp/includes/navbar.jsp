<%@ page import="com.example.lab9_20202132.Beans.usuario" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <% String currentPage=request.getParameter("currentPage")==null ? "" : request.getParameter("currentPage"); %>
            <jsp:useBean id="usuarioLogueado" scope="session" type="usuario"
                class="com.example.lab9_20202132.Beans.usuario" />

            <nav class="navbar navbar-expand-md navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/Lista">Tienda</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link <%= currentPage.equals(" productos") ? "active" : "" %>"
                                    href="<%=request.getContextPath()%>/Lista">
                                        Productos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <%= currentPage.equals(" carrito") ? "active" : "" %>"
                                    href="<%=request.getContextPath()%>/Carrito">
                                        Ver Carrito
                                </a>
                            </li>

                            <li class="nav-item">
                                <% if(usuarioLogueado.getId_usuario()==0){ %>
                                    <a class="nav-link" style="text-decoration: underline;color: #0d6efd;"
                                        href="<%=request.getContextPath()%>/LoginServlet">
                                        (Iniciar sesión)
                                    </a>
                                    <% }else{ %>
                                        <a class="nav-link disabled">
                                            Tienda - <%=usuarioLogueado.getNombres() + " " +
                                                usuarioLogueado.getApellidos()%>
                                        </a>
                                        <% } %>
                            </li>
                            <% if(usuarioLogueado.getId_usuario() !=0){ %>
                                <li class="nav-item">
                                    <a class="nav-link" style="text-decoration: underline;color: #0d6efd;"
                                        href="<%=request.getContextPath()%>/LoginServlet?a=lo">(Cerrar sesión)</a>
                                </li>
                                <% } %>
                        </ul>
                    </div>
                </div>
            </nav>