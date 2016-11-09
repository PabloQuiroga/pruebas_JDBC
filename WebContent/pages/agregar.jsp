<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Carga de articulos</title>
        <link rel="stylesheet" href="../css/forms.css" >
        <link rel="stylesheet" href="../css/estiloBase.css" >
    </head>
    <body>
        <div id="menu"><a href="../index.jsp">Home</a></div>
        <div id="cabecera"><h1>Carga de articulos</h1></div>
                        
        <form  action="<%=request.getContextPath() %>/nuevo" method="post" name="form">
            <label>Codigo</label>
            <input type="text" placeholder="Codigo" name="codigo" />
            <br><br>
            
            <label>Producto</label>
            <input type="text" placeholder="Nombre" name="nombre" />
            <br><br>
            
            <label>Cantidad</label>
            <input placeholder="Cantidad" title="Si no posee cantidad ingrese 0" name="cantidad" />
            <br><br>
            
            <label>Precio</label>
            <input placeholder="Precio" title="Para decimales ingrese con 'coma'" name="precio" />
            <br><br>
            <div class="btn">
            <button id="btnEnviar" type="submit" title="Cargar articulo en listado">Enviar</button>
            </div>
        </form>
        
        
    </body>
</html>
