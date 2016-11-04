package com.pabloQuiroga.modelos;

/**
 * CREATE TABLE productos (
 * 	codigo INT NOT NULL,
 *	nombre VARCHAR(45) NOT NULL,
 *	tipo VARCHAR(100),
 *	unidad_venta VARCHAR(45),
 *	precio FLOAT NOT NULL,
 *	cantidad INT NOT NULL,
 *	PRIMARY KEY (codigo)
 * ) ENGINE=InnoDB;
 * 
 * @author Pablo Daniel Quiroga
 */

public class Articulo {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private float precio;
    private String categoria;
    private String unidad_venta;
    
    public Articulo(){
    }
    public Articulo(String nombre, int cant, float valor){
    	this.nombre = nombre;
    	this.cantidad = cant;
    	this.precio = valor;
    }
    /**
     * GETTERS y SETTERS
     * @param x
     */
    public void setId(int x){
        this.idProducto = x;
    }
    public void setNombre(String x){
        this.nombre = x;
    }
    public void setCantidad(int x){
        this.cantidad = x;
    }
    public void setPrecio(float x){
        this.precio = x;
    }
    public void setCategoria(String x){
        this.categoria = x;
    }
    public void setUVenta(String uv){
    	this.unidad_venta = uv;
    }
    
    public int getId(){
        return idProducto;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public float getPrecio(){
        return precio;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getUVenta(){
    	return unidad_venta;
    }
    
    /**
     * Solo para pruebas<br>
     * Devuelve el producto con sus campos en forma de cadena
     * @return Producto como String
     */
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre +
                ", cantidad=" + cantidad + ", precio=" + precio + ", categoria="
                + categoria + '}';
    }
}
