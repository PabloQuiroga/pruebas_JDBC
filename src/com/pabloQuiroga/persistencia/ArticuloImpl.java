package com.pabloQuiroga.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pabloQuiroga.modelos.Articulo;

/**
 * Clase para la implementacion de metodos DAO sobre tabla de articulos
 * 
 * @author Pablo Daniel Quiroga
 */
public class ArticuloImpl {

	private Connection conn = null;
	
	/**
     * comprueba la conexion
     * @return boolean 'isConnected'
     */
    public boolean ifConecta(){
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
     * Ejecuta consulta total de articulos
     * @return listado de Articulos
     */
	public ArrayList<Articulo> getArticulos(){
		ArrayList<Articulo> listado = new ArrayList<>();
		
		conn = AdministradorDeConexiones.getConexion();
		String consulta = "SELECT codigo, nombre, cantidad, precio FROM productos";
		
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
				
				rs.close();
				ps.close();
				conn.close();
				
			}catch (SQLException ex) {
				ExceptionSQL(consulta);
			}
		}
		
		return listado;
	}
	
	private void ExceptionSQL(String query){
        JOptionPane.showMessageDialog(null, "Error al ejecutar Query:\n" + query,
                    "Error", JOptionPane.WARNING_MESSAGE);
    }
}
