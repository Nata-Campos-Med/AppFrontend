package AppFrontend.src.main.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void validarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		try {
			
			ArrayList<Usuarios> lista = TestJSON.getJSONUsuarios();
			request.setAttribute("lista", lista);
			String usua = request.getParameter("txtusuario");
			String pass = request.getParameter("txtpassword");
			int respuesta = 0;
			for (Usuarios usuario : lista) {
				if (usuario.getUsuario().equals(usua) && usuario.getPassword().equals(pass)) {
					request.setAttribute("usuario", usuario);
					request.getRequestDispatcher("/menu.jsp").forward(request, response);
					respuesta = 1;
				}

			}

			if (respuesta == 0) {
				//String mensaje = "Error";
				
				PrintWriter out;
				response.setContentType("text/html");
				out = response.getWriter();
				out.println("<html><head><title>Error</title><style>.swal-overlay{background-color: red;}</style></head>");
				out.println("<body>");
				out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
				out.println("<script>swal(\"Oops\", \"Ha habido un error!\", \"error\", {closeOnClickOutside: false}); const btnSwal = document.getElementsByClassName(\"swal-button\"); btnSwal[0].addEventListener(\"click\", () => {window.location=\"./login.jsp\"}) </script>");
				out.println("</body></html>");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String accion = request.getParameter("accion");

		if (accion.equals("Ingresar")) {
			this.validarUsuarios(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}