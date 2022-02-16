/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author David
 *
 */
public class ConexionBD {
	/*  EJERCICIO 1 APARTADO 2.1
	 *  Para crear el usuario en la base de datos colocamos en MySQL los siguientes comandos:
	 * 
	 * create user empresa identified by '123456';
	   grant all privileges on empresa.* to empresa; 
	   
	 * Luego añadimos el nuevo usuario en sql para comprobar la conexion, añadimos el usuario y contraseña y comprobamos que funcina,
	 * una vez hecho cambiamos en la clase conexion el usuario y contraseña.
	 */
	
	private static final String database = "empresa";
	private static final String usuario = "empresa";
	private static final String contraseña = "123456";
	private static final String url="jdbc:mysql://localhost/"+database;
	
	private Connection conexion=null;
	
	
	public Connection getConexion() {
		if (conexion!=null) {
			return conexion;
		}
		
		// REgistra el driver de MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexion a bilioteca correcta");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no registrado");
		} catch (SQLException e) {
			System.out.println("Error SQLException: "+e.getMessage());
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			conexion.close();
			conexion=null;
		} catch (SQLException e) {
			System.out.println("Erorr cerrrando la conexion "+ e.getMessage());
		}
	}

}
