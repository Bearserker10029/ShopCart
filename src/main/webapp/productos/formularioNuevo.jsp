<%@page import="java.util.ArrayList" %>
        <%@ page import="com.example.ShopCart.Beans.categoria" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <jsp:useBean scope="request" id="listacategoria"
                    type="java.util.ArrayList<com.example.ShopCart.Beans.categoria>" />
                <!DOCTYPE html>
                <html>

                <head>
                    <title>Nuevo producto</title>
                    <jsp:include page="../includes/headCss.jsp"></jsp:include>
                </head>

                <body>
                    <div class='container'>
                        <jsp:include page="../includes/navbar.jsp">
                            <jsp:param name="currentPage" value="emp" />
                        </jsp:include>
                        <div class="row mb-4">
                            <div class="col"></div>
                            <div class="col-md-6">
                                <h1 class='mb-3'>Nuevo producto</h1>
                                <hr>
                                <form method="POST" action="<%= request.getContextPath() %>/Lista?action=guardar">
                                    <div class="mb-3">
                                        <label class="form-label" for="id_categoria">Categoria</label>
                                        <select name="id_categoria" id="id_categoria" class="form-select">
                                            <% for (categoria categoria : listacategoria) {%>
                                                <option value="<%=categoria.getId_categoria()%>">
                                                    <%=categoria.getNombre()%>
                                                </option>
                                                <% }%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="nombre">nombre</label>
                                        <input type="text" class="form-control form-control-sm" id="nombre"
                                            name="nombre">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="descripcion">descripcion</label>
                                        <input type="text" class="form-control form-control-sm" id="descripcion"
                                            name="descripcion">
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label" for="phone">precio</label>
                                        <input type="text" class="form-control form-control-sm" id="precio"
                                            name="precio">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="hire_date">stock</label>
                                        <input type="text" class="form-control form-control-sm" id="stock" name="stock">
                                    </div>


                                    <a href="<%= request.getContextPath()%>/Lista"
                                        class="btn btn-danger">Cancelar</a>
                                    <input type="submit" value="Guardar" class="btn btn-primary" />
                                </form>
                            </div>
                            <div class="col"></div>
                        </div>
                    </div>
                    <jsp:include page="../includes/footer.jsp" />
                </body>

                </html>