<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    Random aleatorio;
    int x;
    
%>
<%
    aleatorio = new Random();
    x = 100000 + aleatorio.nextInt(999999);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Carga de articulos</title>
        <link rel="stylesheet" href="../css/forms.css" >
        <link rel="stylesheet" href="../css/estiloBase.css" >
    </head>
    <body>
        <div id="menu"><a href="<%=request.getContextPath() %>/Home">Home</a></div>
        <div id="cabecera"><h1>Carga de articulos</h1></div>
                        
        <form  action="<%=request.getContextPath() %>/nuevo" method="post" name="form"  accept-charset="ISO-8859-1">
            <label>Codigo</label>
            <input type="number" value="<%= x %>" name="codigo" required  />
            <br><br>
            
            <label>Producto</label>
            <input type="text" placeholder="Nombre" name="nombre" required/>
            <br><br>
            
            <label>Cantidad</label>
            <input type="number" placeholder="Cantidad" title="Si no posee cantidad ingrese 0" name="cantidad" required/>
            <br><br>
            
            <label>Precio</label>
            <input type="number" step="any" placeholder="Precio" title="Para decimales ingrese con 'coma'" name="precio" required/>
            <br><br>
            <div class="btn">
            <button id="btnEnviar" type="submit" title="Cargar articulo en listado">Enviar</button>
            </div>
        </form>
            
    </body>
</html>
