<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prueba jdbc con servlets</title>
</head>
<body>
	<h1>Prueba jdbc con servlets</h1>
        <ul id="listadoBoton" name="listadoBoton">
            <li><a href="pages/carga.html">Cargar</a></li>
            <li><a href="jsp2.jsp">Busqueda por Nombre</a></li>
            <li><a href="#">Mostrar Todos</a></li>
        </ul>
	<hr>
        Hay <c:out value="${listado.size()}" /> articulos
        <hr>
        <ul>
        <c:forEach items="${listado}" var="elemento" >
            <li>Codigo: <c:out value="${elemento.getId()}" /></li>
            Producto: <c:out value="${elemento.getNombre()}" /><br>
            Precio: <c:out value="${elemento.getPrecio()}" /><br>
            Cantidad en Stock: <c:out value="${elemento.getCantidad()}" />
        </c:forEach>
        </ul>
</body>
</html>