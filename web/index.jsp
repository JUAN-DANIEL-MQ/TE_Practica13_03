<%@page import="java.util.ArrayList" %>
<%@page import="com.emergentes.modelo.Producto" %>
<%
   if (session.getAttribute("inventario")== null) {
           ArrayList<Producto> lis = new ArrayList<Producto>();
           session.setAttribute("inventario", lis);
    }
    ArrayList<Producto> lista = (ArrayList<Producto>)session.getAttribute("inventario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Inicio</title>
    </head>
    <body>
        <h1>Listado de Productos!</h1>
        //Este es el link de envio.Para introducir
        <a href="ServletMain?op=nuevo">Nuevo Producto</a>
        <table border = "1">
            <tr>
                <th>Id</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th></th>
                <th></th>
                
            </tr>
            <%
                if (lista != null) {
                   for (Producto item: lista) {
                  
            %>
            <tr>
                <td> <%= item.getId() %> </td>
                <td> <%= item.getProducto() %> </td>
                <td> <%= item.getPrecio() %> </td>
                <td> <%= item.getCantidad() %> </td>
                <td> <a href="ServletMain?op=editar&id=<%= item.getId()%>"> Modificar</a> </td>
                <td> <a href="ServletMain?op=eliminar&id=<%= item.getId()%>"
                        onclick="return(confirm('Esta que desea Eliminar??'))">Eliminar</a> </td>   
            </tr>
            <%
              }
            }
            %>
            
        </table>
        
    </body>
</html>
