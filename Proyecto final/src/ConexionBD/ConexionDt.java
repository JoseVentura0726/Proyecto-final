package ConexionBD;
import java.sql.*;
public class ConexionDt {
    public static Connection  getConexion() {
		// Esta clase se utiliza para hacer la conexcion a la base de datos remota, por medios las libreria "com.mysql.cj.jdbc.Driver".
    	Connection con = null; 
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/almacenitlafinal?useUnicode=true$use "
					+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
					+ "serverTimezone=UTC";
			String usuario = "estuditlafinal";
			String contraseña = "itla123.";
			
			con =  DriverManager.getConnection(url,usuario,contraseña);
		// De mostración de errores.
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error --> con la BD");
			e.printStackTrace();
		}
		return con;
	}
}
