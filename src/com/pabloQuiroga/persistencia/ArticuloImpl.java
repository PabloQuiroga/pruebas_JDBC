package com.pabloQuiroga.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pabloQuiroga.modelos.Articulo;
import java.sql.Statement;

/**
 * Clase para la implementacion de metodos DAO sobre tabla de articulos
 * 
 * @author Pablo Daniel Quiroga
 */
public class ArticuloImpl {

    private Connection conn = null;
	
    public ArticuloImpl(){
        conn = AdministradorDeConexiones.getConexion();
    }
    
    private void finallizaConexion(){
        try{
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al terminar la conexion",
                    "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * comprueba la conexion
     * @return boolean 'isConnected'
     */
    public boolean ifConecta(){
        boolean conectado = false;
        
        if(conn != null){
            conectado = true;
        }
        return conectado;
    }
	
    /**
     * Ejecuta consulta total de articulos
     * @return listado de Articulos
     */
    public ArrayList<Articulo> getArticulos(){
	ArrayList<Articulo> listado = new ArrayList<>();
		
	String consulta = "SELECT codigo,nombre,cantidad,precio FROM productos";
	
	if(ifConecta()){
            try{
		PreparedStatement ps = conn.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();
				
		while(rs.next()){
                    Articulo a = new Articulo();
                    a.setId(rs.getInt("codigo"));
                    a.setNombre(rs.getString("nombre"));
                    a.setCantidad(rs.getInt("cantidad"));
                    a.setPrecio(rs.getFloat("precio"));
                    
                    listado.add(a);
		}
				
		ps.close();
                // TODO verificar como manejar error al refrescar pagina luego de cerrar la conexion
		//conn.close();
				
            }catch (SQLException ex) {
                ExceptionSQL(consulta);
            }
        }
		
        return listado;
    }
	
    /**
     * Realiza alta de Producto en la base de datos
     * @param p 
     */
    public void alta_producto(Articulo a){
        String sentencia = "INSERT INTO test.productos (nombre, cantidad, precio)"
                + "VALUES('" + a.getNombre() + "'," +
                a.getCantidad() + "," + a.getPrecio() + ")";
        if(ifConecta()){
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
    public void update_producto(String column, String upgrade, int x){
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
        if(ifConecta()){
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
    public void baja_producto(int x){
        String sentencia = "DELETE FROM productos WHERE id=" + x;
        if(ifConecta()){
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
     * Ejecuta consulta y devuelve objetos
     * @param campo corresponde a columna
     * @param x corresponde a valor buscado
     * @return listado de Articulos
     */
    public ArrayList busqueda(String campo, Object x){
        String sentencia;
        ArrayList<Articulo> articulos = new ArrayList<>();
        
        if(ifConecta()){
            sentencia = "SELECT * FROM productos WHERE " + campo + "=" + x;
            
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sentencia);
                while(rs.next()){
                    Articulo a = new Articulo();
                    a.setId(rs.getInt("id"));
                    a.setNombre(rs.getString("nombre"));
                    a.setCantidad(rs.getInt("cantidad"));
                    a.setPrecio(rs.getFloat("precio"));
                    a.setCategoria(rs.getString("categoria"));
                    
                    articulos.add(a);
                }
                
                rs.close();
                stmt.closeOnCompletion();
            }catch(SQLException ex){
                ExceptionSQL(sentencia);
            }
        }
        return articulos;
    }
	private void ExceptionSQL(String query){
        JOptionPane.showMessageDialog(null, "Error al ejecutar Query:\n" + query,
                    "Error", JOptionPane.WARNING_MESSAGE);
    }
}
