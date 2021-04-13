
package com.emergentes.controller;
import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import com.emergentes.modelo.Producto;

@WebServlet(name = "ServletMain", urlPatterns = {"/ServletMain"})
public class ServletMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
        Producto objpro = new Producto();
        int id, pos;
        HttpSession ses = request.getSession();
        List<Producto> lista = (List<Producto>)ses.getAttribute("inventario");
        
        switch(opcion) {
            case "nuevo":
                request.setAttribute("miobjper", objpro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                //Obtener la posicion del elemento en la coleccion
                pos = buscarPorIndice(request, id);
                //ONTENER EL OBJETO
                objpro = lista.get(pos);
                //ENVIARLOS PARA LA EDICION
                request.setAttribute("miobjper", objpro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                
                break;
            case "eliminar":
                //Obtener la posicion del elemento en la coleccion
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("inventario", lista);
                response.sendRedirect("index.jsp");
                
                break;
            default:
                request.setAttribute("inventario", lista);
                response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("inventario");
        Producto objpro = new Producto();
        
        objpro.setId(id);
        objpro.setProducto(request.getParameter("nombre"));
        objpro.setPrecio(request.getParameter("precio"));
        objpro.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        System.out.println("El Id es: "+ id);
        
        if (id == 0) {
            int idNuevo = obtenerId(request);
            objpro.setId(idNuevo);
            
            lista.add(objpro);
            System.out.println(objpro.toString());
        }else{
            //edicion
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objpro);
            System.out.println(objpro.toString());
        }
        System.out.println("Enviando al index");
        request.setAttribute("inventario", lista);
        response.sendRedirect("index.jsp");
    }
    
    
    public int buscarPorIndice (HttpServletRequest request,int id){
       
        HttpSession ses = request.getSession();
        List<Producto> lista = (List<Producto>)ses.getAttribute("inventario");
        int pos = -1;
        if (lista != null) {
            for (Producto ele: lista) {
                ++pos;
                if (ele.getId() == id ) {
                    break;
                }
            }
        }
        
        return pos;
     }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("inventario");
        //Conteo Id desde 0
        int idn = 0;
        for (Producto ele : lista) {
            idn = ele.getId();
        }
         
        return idn + 1;
    }


}
