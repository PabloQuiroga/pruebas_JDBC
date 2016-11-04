package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.pabloQuiroga.modelos.Articulo;
import com.pabloQuiroga.persistencia.AdministradorDeConexiones;

/**
 * Clase de entidad
 * hace uso de Statement
 * 
 * @author Pablo Daniel Quiroga
 */
public class Producto extends Articulo{
    
    private static Connection conn = null;
    
    public Producto(){
    }

    /**
     * obtiene la conexion y comprueba
     * @return boolean 'isConnected'
     */
    public static boolean conectar(){
        conn = AdministradorDeConexiones.getConexion();
        boolean conectado = false;
        
        if(conn == null){
            JOptionPane.showMessageDialog(null, "conexion fallida");
        }else{
            JOptionPane.showMessageDialog(null, "conexion exitosa");
            conectado = true;
        }
        return conectado;
    }
    
    /**
     * Ejecuta consulta y devuelve objetos
     * @param campo corresponde a columna
     * @param x corresponde a valor buscado
     * @return listado de Articulos
     */
    public static ArrayList busqueda(String campo, Object x){
        String sentencia;
        ArrayList<Articulo> articulos = new ArrayList<>();
        
        if(conectar()){
            sentencia = "SELECT * FROM productos WHERE " + campo + "=" + x;
            
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sentencia);
                while(rs.next()){
                    Producto p = new Producto();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setPrecio(rs.getFloat("precio"));
                    p.setCategoria(rs.getString("categoria"));
                    
                    articulos.add(p);
                }
                
                rs.close();
                stmt.closeOnCompletion();
            }catch(SQLException ex){
                ExceptionSQL(sentencia);
            }
        }
        return articulos;
    }
    /**
     * Ejecuta consulta total de articulos
     * @return listado de Articulos
     */
    public static ArrayList<Articulo> mostrarTodo(){
        ArrayList<Articulo> articulos = new ArrayList<>();
        String sentencia;
        if(conectar()){
            sentencia = "SELECT * FROM productos";
            
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sentencia);
                while(rs.next()){
                    Producto p = new Producto();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setPrecio(rs.getFloat("precio"));
                    p.setCategoria(rs.getString("categoria"));
                    
                    articulos.add(p);
                }
                
                rs.close();
                stmt.closeOnCompletion();
            }catch(SQLException ex){
                ExceptionSQL(sentencia);
            }
        }
        return articulos;
    }
    /**
     * Realiza alta de Producto en la base de datos
     * @param p 
     */
    public static void alta_producto(Articulo p){
        String sentencia = "INSERT INTO test.productos (nombre, cantidad, precio)"
                + "VALUES('" + p.getNombre() + "'," +
                p.getCantidad() + "," + p.getPrecio() + ")";
        if(conectar()){
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sentencia);
            }catch(SQLException ex){
                ExceptionSQL(sentencia);
            }
        }
    }
    /**
     * Actualiza producto
     * 
     * @param column corresponde a columna a actualizar
     * @param upgrade corresponde a nuevo valor dado
     * @param x corresponde a fila seleccionada para actualizacion
     * 
     * primero comprueba el tipo de columna a actualizar,
     * luego establece la sentencia a ejecutar
     */
    public static void update_producto(String column, String upgrade, int x){
        String sentencia;
        if(column.equals("cantidad") | column.equals("precio")){
            Integer u = Integer.parseInt(upgrade);
            if(column.equals("precio")){
                sentencia = "UPDATE productos SET precio=" + u
                        + " WHERE id=" + x;
            }else{
                sentencia = "UPDATE productos SET cantidad=" + u 
                        + " WHERE id=" + x;
            }
        }else{
            sentencia = "UPDATE productos SET " + column + "='" + upgrade 
                        + "' WHERE id=" + x;
        }
        if(conectar()){
            try{
                Statement stmt = conn.createStatement();
                stmt.execute(sentencia);
                stmt.close();
            }catch(SQLException ex){
                ExceptionSQL(sentencia);
            }
        }
    }
    /**
     * Elimina un producto de la base de datos
     * @param x corresponde al ID a eliminar
     */
    public static void baja_producto(int x){
        String sentencia = "DELETE FROM productos WHERE id=" + x;
        if(conectar()){
            try{
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(sentencia);
                }
            }catch(SQLException ex){
                ex.printStackTrace();
                //ExceptionSQL(sentencia);
            }
        }
    }
    
    /**
     * Maneja excepciones producidas por error de sintaxis del query
     * @param query 
     */
    private static void ExceptionSQL(String query){
        JOptionPane.showMessageDialog(null, "Error al ejecutar Query:\n" + query,
                    "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    
}
