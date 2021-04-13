<%@page import="com.emergentes.modelo.Producto"%> 
<%
  Producto req = (Producto)request.getAttribute("miobjper");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Produtos!</h1>
        <form action="ServletMain" method="POST">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%= req.getId() %>" size="3" readonly/></td>
                </tr>
                <tr>
                    <td>Nombres_Produtcto</td>
                    <td><input type="text" name="nombre" value="<%= req.getProducto() %>" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="<%= req.getPrecio() %>" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" name="cantidad" value="<%= req.getCantidad() %>" size="3" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
