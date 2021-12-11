package Mantenimiento;
import clsprocye.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConexionBD.ConexionDt;


public class getionUsu {
	
	// Esta clase se utiliza extraer los datos de base de datos, gracias a los datos insetado por pantalla los que hacer que se cree la primera validacion de datos.
	public Usuario obtenerUsuario(Usuario usu) { 
		Usuario usuario = null;
		Connection con = null; 
		PreparedStatement pst = null;
		ResultSet rs = null;
		//Comprovacion de que todo funcione.
		try {
			//Aqui se utiliza la conexion a la base de datos creada en la clase ConexionDt.
			con = ConexionDt.getConexion();
			//Aqui se utiliza una sentencia sql para validar el usuario.
				
			String Sql = "select UserName,Password From usuarios where UserName = ? and Password = ?";
			pst = con.prepareStatement(Sql);
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			
			
			rs = pst.executeQuery();
			while(rs.next()) {
				usuario = new Usuario(rs.getString(1),rs.getString(2));
			}
		//De mostracios de error.
		}catch(Exception e) {
		 System.out.println("Error en obtener usuario");	
		}
		return usuario;
		
	}


}
  
