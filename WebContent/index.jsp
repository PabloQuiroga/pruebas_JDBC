<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Prueba jdbc con servlets</title>
        <link rel="stylesheet" href="css/estiloBase.css" />
    </head>
<body>
    <div id="cabecera">
	<h1>Prueba jdbc con servlets</h1>
    </div>
    <div id="menu">
        <ul>
            <li><a href="pages/agregar.jsp" >Agregar</a></li>
        </ul>
    </div>
            
    <br>
    <div><strong>Hay <c:out value="${listado.size()}" /> articulos</strong></div>
    <br>
    <div id="mensajes"><c:out value="${mensaje}" /></div>
    <br>
    <hr>
    
    <table>
        <tr>
            <th>Codigo</th>
            <th>Producto</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Acciones</th>
        </tr>
        <tbody>
            <c:forEach items="${listado}" var="elemento" >
                <tr>
                    <td><c:out value="${elemento.getId()}" /></td>
                    <td><c:out value="${elemento.getNombre()}" /></td>
                    <td><c:out value="${elemento.getPrecio()}" /></td>
                    <td><c:out value="${elemento.getCantidad()}" /></td>
                    <td id="acciones">
                        <a href="<%=request.getContextPath() %>/pages/editar.jsp?id=<c:out value="${elemento.getId()}" />">Editar</a>
                        <a href="<%=request.getContextPath() %>/pages/eliminar.jsp?id=<c:out value="${elemento.getId()}" />">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        
</body>
</html>