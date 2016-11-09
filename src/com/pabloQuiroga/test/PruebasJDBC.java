package com.pabloQuiroga.test;

import com.pabloQuiroga.modelos.Articulo;
import com.pabloQuiroga.persistencia.AdministradorDeConexiones;
import com.pabloQuiroga.persistencia.ArticuloImpl;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Proyecto para el manejo de JDBC
 * Clase main para pruebas
 * 
 * @author Pablo Daniel Quiroga
 */
public class PruebasJDBC {

    //prueba la conexion
    
    public static void main(String[] args) {
        
        //pruebaConexion();
        //pruebaBusqueda();
        //pruebaBusquedaTotal();
        //pruebaAltaProducto();
        //pruebaUpdate();
        //pruebaEliminar();
    }

    private static void pruebaConexion(){
        AdministradorDeConexiones adm = new AdministradorDeConexiones();
        adm.probar();
        adm.cerrarConnection();
    }
    private static void pruebaBusqueda(){
        ArticuloImpl imp = new ArticuloImpl();
        ArrayList<Articulo> listado = imp.busqueda("id", "7");
        String mensaje = "";
        if(!listado.isEmpty()){
            for(Articulo x: listado){
            mensaje += "\n"+x;
            }
        }
        if(!mensaje.equals("")){
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    private static void pruebaBusquedaTotal(){
        ArticuloImpl imp = new ArticuloImpl();
        ArrayList<Articulo> listado = imp.getArticulos();
        String mensaje = "";
        if(!listado.isEmpty()){
            for(Articulo x: listado){
                mensaje += "\n"+x;
            }
        }
        if(!mensaje.equals("")){
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    private void pruebaAltaProducto(){
        Articulo p = new Articulo();
        p.setNombre("encendedor");
        p.setCantidad(1);
        p.setPrecio(5);
        
        ArticuloImpl imp = new ArticuloImpl();
        imp.alta_producto(p);
    }
    private void pruebaUpdate(){
        ArticuloImpl imp = new ArticuloImpl();
        imp.update_producto("precio", "18", 3);
    }
    private void pruebaEliminar(int x){
        ArticuloImpl imp = new ArticuloImpl();
        imp.baja_producto(x);
    }
}
