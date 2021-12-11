package ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;


public class Metodos_sql {
	// Esta clase se utiliza para utilizar los metodos de base de datos, para asì poder guardar, actualizar y eliminar datos de la base de datos remota.
	// tambien en esta clase se utiliza el diseño sigelton por contron de objectos del programa. 
	String[] datos = new String[4];
	DefaultTableModel Model = new DefaultTableModel(); 
	private static Metodos_sql Metodo;
	public static ConexionDt Conexion = new ConexionDt();
	ConexionDt con = new ConexionDt();
	Connection cn; 
	Statement st;
	Resultset rs;
	
	
	public static PreparedStatement sentencia_preparada;
	public static String sql;
	public static int resultado_numero = 0;
	
	//aqui se crea el contrutor de nuestra clase la cual es privada porque hacis se haces el singelton
	private Metodos_sql(){
		
	}
	// aqui se crea el getInstance segun el modelo singelton
	public static Metodos_sql getInstance() {
		if( Metodo == null ) {
			Metodo = new Metodos_sql();	
		}
		return Metodo;
	}
	//Este metodo se utiliza para guardar en la base de datos los usuario insertado por pantalla para poder hacer el login.
	public int guardar(String Usuario,String Nombre,String Apellido,String número_de_teléfono,String correo_eletrónico,String Contraceña) {
		
		int resultado = 0; 
		
		Connection conexion = null;
		
		String sentencia_guard = ("insert into usuarios(UserName, Nombre, Apellido, Telefono, Email, Password)VAlUES(?,?,?,?,?,?)");
		try {
			conexion = ConexionDt.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_guard);
			sentencia_preparada.setString(1, Usuario);
			sentencia_preparada.setString(2, Nombre);
			sentencia_preparada.setString(3, Apellido);
			sentencia_preparada.setString(4, número_de_teléfono);
			sentencia_preparada.setString(5, correo_eletrónico);
			sentencia_preparada.setString(6, Contraceña);
			resultado = sentencia_preparada.executeUpdate();
			
			
			sentencia_preparada.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return resultado;		
	}
	
	
	// Este metodo se utiliza para eliminar los usuarios no desado que estan en la bases de datos.  
	public int eliminal(String Usuario) {
		int resultado = 0; 
				
		Connection conexion = null;
		String sentencia_Eliminal = ("delete from usuarios where UserName = ?");
		try {
			conexion = ConexionDt.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Eliminal);
			sentencia_preparada.setString(1, Usuario);
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return resultado;
    }
	//Este metodo se utiliza para eliminar los productos no desado, que estan en la bases de datos.
	public int eliminalProd(String id_productp) {
		int resultado = 0; 
		
		Connection conexion = null;
		String sentencia_Eliminal = ("delete from productos where idProducto = ?");
		try {
			conexion = ConexionDt.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Eliminal);
			sentencia_preparada.setString(1, id_productp);
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return resultado;


    }

	
	
	//Este metodo se utiliza para Actualizar los datos de los usuarios que estan en la base de datos.
     public int Actualizar(String Usuario,String Nombre,String Apellido,String número_de_teléfono,String correo_eletrónico,String Contraceña,String Actualizar ) {
     
    	 int resultado = 0; 
    	 Connection conexion = null; 			 
     
    	 
     String sentencia_Actualizar = ("UPDATE usuarios SET UserName = ? , Nombre= ?, Apellido = ?, Telefono = ?, Email = ?,Password = ? WHERE UserName = ?");
		try {
			conexion = ConexionDt.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Actualizar);
			sentencia_preparada.setString(1, Usuario);
			sentencia_preparada.setString(2, Contraceña);
			sentencia_preparada.setString(3, Nombre);
			sentencia_preparada.setString(4, Apellido);
			sentencia_preparada.setString(5, número_de_teléfono);
			sentencia_preparada.setString(6, correo_eletrónico);
			sentencia_preparada.setString(7, Actualizar);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();}catch (Exception e) {
		System.out.println(e);
		}
		return resultado;

     }
     //Este metodo se utiliza para Actualizar los datos de los producto que estan en la base de datos.
     public int ActualizarProdu(String id_pro,String Nombre,String Marca,String categoría,String precio,String cantidad_disponible) {
         
    	 int resultado = 0; 
    	 Connection conexion = null; 			 
    	 int Id = Integer.parseInt(id_pro);
    	 
    	 
     String sentencia_Actualizar = ("UPDATE productos SET NombreProducto = ? ,MarcaProducto = ?, CategoriaProducto= ?, PrecioProducto = ?, StockProducto = ? WHERE idProducto = ?");
		try {
			conexion = ConexionDt.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Actualizar);
			sentencia_preparada.setString(1, Nombre);
			sentencia_preparada.setString(2, Marca);
			sentencia_preparada.setString(3, categoría);
			sentencia_preparada.setString(4, precio);
			sentencia_preparada.setString(5, cantidad_disponible);
			sentencia_preparada.setInt(6, Id);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();}catch (Exception e) {
		System.out.println(e);
		}
		return resultado;

     }
   //Este metodo se utiliza para guardar en la base de datos los producto insertado por pantalla.
     public int guardarProdu(String Nombre,String Marca,String categoría,String precio,String cantidad_disponible) {
    	 int resultado = 0; 
  		Connection conexion = null;
  		
		
  		String sentencia_guard = ("insert into productos(NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, StockProducto)VAlUES(?,?,?,?,?)");
  		try {
  			conexion = ConexionDt.getConexion();
  			sentencia_preparada = conexion.prepareStatement(sentencia_guard);
			sentencia_preparada.setString(1, Nombre);
			sentencia_preparada.setString(2, Marca);
			sentencia_preparada.setString(3, categoría);
			sentencia_preparada.setString(4, precio);
			sentencia_preparada.setString(5, cantidad_disponible);
			
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();

          }catch(Exception e) {
  			System.out.println(e);
  		}
  		
  		return resultado;
  		
  	}


 }	
	






		
		//JOptionPane.showMessageDialog(contentPane,e,"Error", JOptionPane.ERROR_MESSAGE);
		//JOptionPane.showMessageDialog(contentPane,e,"Error", JOptionPane.ERROR_MESSAGE);
