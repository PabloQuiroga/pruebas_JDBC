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
	<hr>
        Hay <c:out value="${listado.size()}" /> articulos
        <ul id="listadoBoton" name="listadoBoton">
            <li><a href="pages/carga.html">Cargar</a></li>
            <li><a href="jsp2.jsp">Busqueda por Nombre</a></li>
            <li><a href="jsp2.jsp">Mostrar Todos</a></li>
        </ul>
</body>
</html>