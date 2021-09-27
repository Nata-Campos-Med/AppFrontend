package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3310/papeleriawww";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "lDs1215";
	private static Connection dbConnection = null;
	
	public static Connection getConexion() {
		try {
			Class.forName(DB_DRIVER);
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}

