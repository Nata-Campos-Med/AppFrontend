package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.ModeloLogin;
import Entidad.Modelo;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		if ("iniciarSesion".equals(tipo)) {
			this.iniciarSesion(request, response);
		} else if ("cerrarSesion".equals(tipo)) {
			this.cerrarSesion(request, response);
		}
	}
   /* public login() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	//Iniciar Sesión
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String usuarioInicial = "adminicial";
		String contra = "admin1234";
		String usuario = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		ModeloLogin modelo = new ModeloLogin();
		Modelo login = modelo.inicarSesion(usuario, password);
		
		if (login != null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("nickname", login);
			response.sendRedirect("menu.jsp");
		}
		else
			request.setAttribute("mensaje", "Error, nombre de usuario y/o contraseña inválido");
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	//Cerrar Sesión
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("mensaje", "Iniciar Sesión");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
