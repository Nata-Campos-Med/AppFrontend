package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexion.Conexion;
import Entidad.Modelo;


public class ModeloLogin {
	
	public Modelo inicarSesion(String usuario, String password) {
		Modelo login = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String sql = "SELECT usuarios.usuario, usuarios.password FROM login usuarios WHERE usuarios.usuario = ? AND usuarios.password = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				login = new Modelo();
				login.setUsuario(rs.getString("usuario"));
				login.setPassword(rs.getString("password"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(cn != null) {
					cn.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return login;
		}
	

}

