package pruebasjdbc;

import entidades.Articulo;
import entidades.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.AdministradorDeConexiones;

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
        pruebaBusquedaTotal();
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
        ArrayList<Articulo> listado = Producto.busqueda("id", "7");
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
        ArrayList<Articulo> listado = Producto.mostrarTodo();
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
    private static void pruebaAltaProducto(){
        Articulo p = new Articulo();
        p.setNombre("encendedor");
        p.setCantidad(1);
        p.setPrecio(5);
        Producto.alta_producto(p);
    }
    private static void pruebaUpdate(){
        Producto.update_producto("precio", "18", 3);
    }
    private static void pruebaEliminar(){
        Producto.baja_producto(6);
    }
}
