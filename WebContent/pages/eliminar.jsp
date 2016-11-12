<%@page import="com.pabloQuiroga.persistencia.ArticuloImpl"%>
<%@page import="com.pabloQuiroga.modelos.Articulo"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! 
    Articulo a;
    int x;
%>
<%
    x = Integer.parseInt(request.getParameter("id"));
    a = new ArticuloImpl().getArticulo(x);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Eliminar articulo</title>
        <link rel="stylesheet" href="../css/forms.css" >
        <link rel="stylesheet" href="../css/estiloBase.css" >
    </head>
    <body>
        <div id="menu"><a href="<%=request.getContextPath() %>/Home">Home</a></div>
        <div id="cabecera"><h1>Eliminar articulo</h1></div>
                  
        <div id="subtitulo"><h3>Articulo a eliminar</h3></div>
        <form  action="<%=request.getContextPath() %>/eliminar?id=<%=a.getId()%>" method="post" name="form">
            <label>Codigo</label>
            <input type="number" name="codigo" value="<%=a.getId()%>" disabled />
            <br><br>
            
            <label>Producto</label>
            <input type="text" name="nombre" value="<%=a.getNombre()%>" disabled />
            <br><br>
            
            <label>Cantidad</label>
            <input type="number" name="cantidad" value="<%=a.getCantidad()%>" disabled />
            <br><br>
            
            <label>Precio</label>
            <input type="number" name="precio" value="<%=a.getPrecio()%>" disabled />
            <br><br>
            <div class="btn">
            <button id="btnEnviar" type="submit" title="Eliminar articulo de listado">Eliminar</button>
            </div>
        </form>
        
        
    </body>
</html>