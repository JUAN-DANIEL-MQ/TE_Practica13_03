package com.emergentes.modelo;
public class Producto {
    private int id;
    private String producto;
    private String precio;
    private int cantidad;

    public Producto() {
        id = 0;
        producto = "";
        precio = "";
        cantidad = 0;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    
    
    
}
