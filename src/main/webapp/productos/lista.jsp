<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ShopCart.Dto.CreacionyListadodeProductoDto" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaproducto" type="java.util.ArrayList<com.example.ShopCart.Dto.CreacionyListadodeProductoDto>" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Productos</title>
    <jsp:include page="../includes/headCss.jsp"></jsp:include>
</head>
<body>
<div class='container'>
    <jsp:include page="../includes/navbar.jsp">
        <jsp:param name="currentPage" value="productos"/>
    </jsp:include>

    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Lista de Productos</h1>
        </div>
        <div class="col-md-5 d-flex justify-content-end align-items-center">
            <a href="<%= request.getContextPath() %>/Lista?action=crear" class="btn btn-primary">Crear Producto</a>
        </div>
    </div>

    <% if (request.getParameter("msg") != null) { %>
    <div class="alert alert-success" role="alert"><%= request.getParameter("msg") %></div>
    <% } %>
    <% if (request.getParameter("err") != null) { %>
    <div class="alert alert-danger" role="alert"><%= request.getParameter("err") %></div>
    <% } %>

    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Precio</th>
            <th>Stock</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% 
            for (CreacionyListadodeProductoDto p : listaproducto) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getCategoriaNombre() %></td>
            <td><%= String.format("%.2f", p.getPrecio()) %></td>
            <td><%= p.getStock() %></td>
            <td>
                <form action="<%= request.getContextPath() %>/Carrito" method="post">
                    <input type="hidden" name="action" value="anadir">
                    <input type="hidden" name="id_producto" value="<%= p.getId() %>">
                    <button type="submit" class="btn btn-sm btn-success">Añadir al carrito</button>
                </form>
            </td>
        </tr>
        <% 
            }
        %>
        </tbody>
    </table>
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
</html>
