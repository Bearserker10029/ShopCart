<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ShopCart.Dto.CarritoyListadodeProductosDto" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaCarrito" type="java.util.ArrayList<com.example.ShopCart.Dto.CarritoyListadodeProductosDto>" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <title>Carrito de Compras</title>
    <jsp:include page="../includes/headCss.jsp"></jsp:include>
</head>
<body>
<div class='container'>
    <jsp:include page="../includes/navbar.jsp">
        <jsp:param name="currentPage" value="carrito"/>
    </jsp:include>

    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Carrito de Compras</h1>
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
            <th>ID Item</th>
            <th>Producto</th>
            <th>Usuario</th>
            <th>Precio Unitario</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <% 
            for (CarritoyListadodeProductosDto item : listaCarrito) {
        %>
        <tr>
            <td><%= item.getIdItem() %></td>
            <td><%= item.getNombreProducto() %></td>
            <td><%= item.getNombreUsuario() %></td>
            <td><%= String.format("%.2f", item.getPrecioUnit()) %></td>
            <td><%= item.getCantidad() %></td>
            <td><%= String.format("%.2f", item.getSubtotal()) %></td>
        </tr>
        <% 
            }
        %>
        </tbody>
        <a href="<%= request.getContextPath()%>/Lista" class="btn btn-danger">Regresar</a>
    </table>
    
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
</html>

