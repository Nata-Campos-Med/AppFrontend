package AppFrontend.src.main.java.servlet.controlador;

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

import AppFrontend.src.main.java.servlet.modelo.TestJSONUsuarios;
import AppFrontend.src.main.java.servlet.modelo.TestJSONVentas;
import AppFrontend.src.main.java.servlet.modelo.TestJSONClientes;
import AppFrontend.src.main.java.servlet.modelo.TestJSONProductos;
import AppFrontend.src.main.java.servlet.modelo.TestJSONProveedores;
import AppFrontend.src.main.java.servlet.modelo.DTO.Clientes;
import AppFrontend.src.main.java.servlet.modelo.DTO.Productos;
import AppFrontend.src.main.java.servlet.modelo.DTO.Proveedores;
import AppFrontend.src.main.java.servlet.modelo.DTO.Usuarios;
import AppFrontend.src.main.java.servlet.modelo.DTO.Ventas;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		switch (menu) {
		case "menu":
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
			break;
		case "Usuarios":
			if (accion.equals("Listar")) {
				try {

					ArrayList<Usuarios> lista = TestJSONUsuarios.getJSONUsuarios();
					request.setAttribute("lista", lista);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (accion.equals("Agregar")) {
				if (request.getParameter("txtcedula") != "" && request.getParameter("txtnombre") != ""
						&& request.getParameter("txtemail") != "" && request.getParameter("txtusuario") != ""
						&& request.getParameter("txtpassword") != "") {
					Usuarios usuario = new Usuarios();
					usuario.setCedulaUsuario(Long.parseLong(request.getParameter("txtcedula")));
					usuario.setNombreUsuario(request.getParameter("txtnombre"));
					usuario.setEmailUsuario(request.getParameter("txtemail"));
					usuario.setUsuario(request.getParameter("txtusuario"));
					usuario.setPassword(request.getParameter("txtpassword"));

					int respuesta = 0;
					try {
						respuesta = TestJSONUsuarios.postJSON(usuario);
						if (respuesta == 200) {
							
							out.println("<html><head><title>Success</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Usuario creado exitosamente\",\"\" ,\"success\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
									+ "</script>");
							out.println("</body></html>");

						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Error</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Faltan datos.\", \"\", \"error\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Actualizar")) {
				if (request.getParameter("txtcedula") != "") {
					if (request.getParameter("txtcedula") != "" && request.getParameter("txtnombre") != ""
							&& request.getParameter("txtemail") != "" && request.getParameter("txtusuario") != ""
							&& request.getParameter("txtpassword") != "") {
						Usuarios usuario = new Usuarios();
						usuario.setCedulaUsuario(Long.parseLong(request.getParameter("txtcedula")));
						usuario.setNombreUsuario(request.getParameter("txtnombre"));
						usuario.setEmailUsuario(request.getParameter("txtemail"));
						usuario.setUsuario(request.getParameter("txtusuario"));
						usuario.setPassword(request.getParameter("txtpassword"));

						int respuesta = 0;
						try {
							respuesta = TestJSONUsuarios.putJSON(usuario, usuario.getCedulaUsuario());

							if (respuesta == 200) {
								out.println("<html><head><title>Success</title><style>"
										+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
										+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
										+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
										+ "	.swal-title{color: #FFF; font-weight: 500;}"
										+ " .swal-text{color: #FFF; font-weight: 300;}"
										+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
										+ "	.swal-button:hover{opacity: 1}"
										+ "</style></head>");
								out.println("<body>");
								out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
								out.println("<script>"
										+ "	swal(\"Usuario actualizado exitosamente\",\"\" ,\"success\", {closeOnClickOutside: false});"
										+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
										+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
										+ "</script>");
								out.println("</body></html>");
							} else {
								out.println("<html><head><title>Error</title><style>"
										+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
										+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
										+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
										+ "	.swal-title{color: #FFF; font-weight: 500;}"
										+ " .swal-text{color: #FFF; font-weight: 300;}"
										+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
										+ "	.swal-button:hover{opacity: 1}"
										+ "</style></head>");
								out.println("<body>");
								out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
								out.println("<script>"
										+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
										+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
										+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
										+ "</script>");
								out.println("</body></html>");
							}
							out.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						out.println("<html><head><title>Error</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Faltan datos.\", \"\", \"error\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
						out.close();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese una cédula.\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Usuarios> lista1 = TestJSONUsuarios.getJSONUsuarios();
					System.out.println("Parametro: " + id);
					for (Usuarios usuarios : lista1) {
						if (usuarios.getCedulaUsuario() == id) {
							request.setAttribute("usuarioSeleccionado", usuarios);
							request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				if (request.getParameter("txtcedula") != "") {
					Long id = Long.parseLong(request.getParameter("txtcedula"));
					int respuesta = 0;
					try {
						respuesta = TestJSONUsuarios.deleteJSONUsuarios(id);
						if (respuesta == 200) {
							out.println("<html><head><title>Success</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Usuario eliminado.\", \"\", \"success\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
							out.close();
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Usuario no encontrado.\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
							out.close();
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese una cédula.\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Consultar")) {
				if (request.getParameter("txtcedula") != "") {
					Long id = Long.parseLong(request.getParameter("txtcedula"));
					try {
						ArrayList<Usuarios> lista1 = TestJSONUsuarios.getJSONUsuarios(id);
						if (!lista1.isEmpty()) {

							for (Usuarios usuarios : lista1) {
								if (usuarios.getCedulaUsuario() == id) {
									request.setAttribute("usuarioSeleccionado", usuarios);
									request.setAttribute("lista", lista1);

								}
							}
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Usuario no existente.\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
							out.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese una cédula.\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Usuarios.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Usuarios> lista = TestJSONUsuarios.getJSONUsuarios();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
			break;

		case "Clientes":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Clientes> lista = TestJSONClientes.getJSONClientes();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				if (request.getParameter("txtcedula") != "" && request.getParameter("txtdireccion") != ""
						&& request.getParameter("txtemail") != "" && request.getParameter("txtnombre") != ""
						&& request.getParameter("txttelefono") != "") {
					Clientes cliente = new Clientes();
					cliente.setCedulaCliente(Long.parseLong(request.getParameter("txtcedula")));
					cliente.setDireccionCliente(request.getParameter("txtdireccion"));
					cliente.setEmailCliente(request.getParameter("txtemail"));
					cliente.setNombreCliente(request.getParameter("txtnombre"));
					cliente.setTelefonoCliente(request.getParameter("txttelefono"));

					int respuesta = 0;
					try {
						respuesta = TestJSONClientes.postJSON(cliente);
						if (respuesta == 200) {
							out.println("<html><head><title>Success</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Cliente creado exitosamente.\", \"\", \"success\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Error</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Faltan datos.\", \"\", \"error\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Actualizar")) {
				if (request.getParameter("txtcedula") != "") {
					if (request.getParameter("txtcedula") != "" && request.getParameter("txtdireccion") != ""
							&& request.getParameter("txtemail") != "" && request.getParameter("txtnombre") != ""
							&& request.getParameter("txttelefono") != "") {
						Clientes cliente = new Clientes();
						cliente.setCedulaCliente(Long.parseLong(request.getParameter("txtcedula")));
						cliente.setDireccionCliente(request.getParameter("txtdireccion"));
						cliente.setEmailCliente(request.getParameter("txtemail"));
						cliente.setNombreCliente(request.getParameter("txtnombre"));
						cliente.setTelefonoCliente(request.getParameter("txttelefono"));

						int respuesta = 0;
						try {
							respuesta = TestJSONClientes.putJSON(cliente, cliente.getCedulaCliente());

							if (respuesta == 200) {
								out.println("<html><head><title>Success</title><style>"
										+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
										+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
										+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
										+ "	.swal-title{color: #FFF; font-weight: 500;}"
										+ " .swal-text{color: #FFF; font-weight: 300;}"
										+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
										+ "	.swal-button:hover{opacity: 1}"
										+ "</style></head>");
								out.println("<body>");
								out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
								out.println("<script>"
										+ "	swal(\"Cliente se actualizo correctamente.\", \"\", \"success\", {closeOnClickOutside: false});"
										+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
										+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
										+ "</script>");
								out.println("</body></html>");
							} else {
								out.println("<html><head><title>Error</title><style>"
										+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
										+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
										+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
										+ "	.swal-title{color: #FFF; font-weight: 500;}"
										+ " .swal-text{color: #FFF; font-weight: 300;}"
										+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
										+ "	.swal-button:hover{opacity: 1}"
										+ "</style></head>");
								out.println("<body>");
								out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
								out.println("<script>"
										+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
										+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
										+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
										+ "</script>");
								out.println("</body></html>");
							}
							out.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						out.println("<html><head><title>Error</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Faltan datos.\", \"\", \"error\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
						out.close();
					}

				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese cédula\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}

			} else if (accion.equals("Cargar")) {

				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Clientes> lista1 = TestJSONClientes.getJSONClientes();
					System.out.println("Parametro: " + id);
					for (Clientes clientes : lista1) {
						if (clientes.getCedulaCliente() == id) {
							request.setAttribute("clienteSeleccionado", clientes);
							request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				if (request.getParameter("txtcedula") != "") {
					Long id = Long.parseLong(request.getParameter("txtcedula"));
					int respuesta = 0;
					try {
						respuesta = TestJSONClientes.deleteJSONClientes(id);
						if (respuesta == 200) {
							out.println("<html><head><title>Success</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"El cliente fue eliminado.\", \"\", \"success\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese una cédula\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Consultar")) {
				if (request.getParameter("txtcedula") != "") {
					Long id = Long.parseLong(request.getParameter("txtcedula"));
					try {
						ArrayList<Clientes> lista1 = TestJSONClientes.getJSONClientes(id);
						if (!lista1.isEmpty()) {

							for (Clientes cliente : lista1) {
								if (cliente.getCedulaCliente() == id) {
									request.setAttribute("clienteSeleccionado", cliente);
									request.setAttribute("lista", lista1);

								}
							}
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Cliente no existente.\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
							out.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese cédula\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Clientes.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Clientes> lista = TestJSONClientes.getJSONClientes();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			break;
		case "Proveedores":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Proveedores> lista = TestJSONProveedores.getJSONProveedores();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				if (request.getParameter("txtnit") != "" && request.getParameter("txtnombre") != ""
						&& request.getParameter("txtciudad") != "" && request.getParameter("txtdireccion") != ""
						&& request.getParameter("txttelefono") != "") {
					Proveedores proveedor = new Proveedores();
					proveedor.setNitProveedor(Long.parseLong(request.getParameter("txtnit")));
					proveedor.setNombreProveedor(request.getParameter("txtnombre"));
					proveedor.setCiudadProveedor(request.getParameter("txtciudad"));
					proveedor.setDireccionProveedor(request.getParameter("txtdireccion"));
					proveedor.setTelefonoProveedor(request.getParameter("txttelefono"));

					int respuesta = 0;
					try {
						respuesta = TestJSONProveedores.postJSON(proveedor);
						if (respuesta == 200) {
							out.println("<html><head><title>Success</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Proveedor creado correctamente.\", \"\", \"success\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Error</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Faltan datos.\", \"\", \"error\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Actualizar")) {
				if (request.getParameter("txtnit") != "") {

					if (request.getParameter("txtnit") != "" && request.getParameter("txtnombre") != ""
							&& request.getParameter("txtciudad") != "" && request.getParameter("txtdireccion") != ""
							&& request.getParameter("txttelefono") != "") {
						Proveedores proveedor = new Proveedores();
						proveedor.setNitProveedor(Long.parseLong(request.getParameter("txtnit")));
						proveedor.setNombreProveedor(request.getParameter("txtnombre"));
						proveedor.setCiudadProveedor(request.getParameter("txtciudad"));
						proveedor.setDireccionProveedor(request.getParameter("txtdireccion"));
						proveedor.setTelefonoProveedor(request.getParameter("txttelefono"));

						int respuesta = 0;
						try {
							respuesta = TestJSONProveedores.putJSON(proveedor, proveedor.getNitProveedor());

							if (respuesta == 200) {
								out.println("<html><head><title>Success</title><style>"
										+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
										+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
										+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
										+ "	.swal-title{color: #FFF; font-weight: 500;}"
										+ " .swal-text{color: #FFF; font-weight: 300;}"
										+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
										+ "	.swal-button:hover{opacity: 1}"
										+ "</style></head>");
								out.println("<body>");
								out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
								out.println("<script>"
										+ "	swal(\"Proveedor actualizado correctamente.\", \"\", \"success\", {closeOnClickOutside: false});"
										+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
										+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
										+ "</script>");
								out.println("</body></html>");
							} else {
								out.println("<html><head><title>Error</title><style>"
										+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
										+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
										+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
										+ "	.swal-title{color: #FFF; font-weight: 500;}"
										+ " .swal-text{color: #FFF; font-weight: 300;}"
										+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
										+ "	.swal-button:hover{opacity: 1}"
										+ "</style></head>");
								out.println("<body>");
								out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
								out.println("<script>"
										+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
										+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
										+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
										+ "</script>");
								out.println("</body></html>");
							}
							out.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						out.println("<html><head><title>Error</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Faltan datos.\", \"\", \"error\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
						out.close();
					}

				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese un NIT.\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Cargar")) {

				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Proveedores> lista1 = TestJSONProveedores.getJSONProveedores();
					System.out.println("Parametro: " + id);
					for (Proveedores proveedor : lista1) {
						if (proveedor.getNitProveedor() == id) {
							request.setAttribute("proveedorSeleccionado", proveedor);
							request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				if (request.getParameter("txtnit") != "") {
					Long id = Long.parseLong(request.getParameter("txtnit"));
					int respuesta = 0;
					try {
						respuesta = TestJSONProveedores.deleteJSONProveedores(id);
						if (respuesta == 200) {
							out.println("<html><head><title>Success</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Proveedor eliminado.\", \"\", \"success\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
							out.close();
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese un NIT.\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();

				}
			} else if (accion.equals("Consultar")) {
				if (request.getParameter("txtnit") != "") {
					Long id = Long.parseLong(request.getParameter("txtnit"));
					try {
						ArrayList<Proveedores> lista1 = TestJSONProveedores.getJSONProveedores(id);
						if (!lista1.isEmpty()) {

							for (Proveedores proveedor : lista1) {
								if (proveedor.getNitProveedor() == id) {
									request.setAttribute("proveedorSeleccionado", proveedor);
									request.setAttribute("lista", lista1);

								}
							}
						} else {
							out.println("<html><head><title>Error</title><style>"
									+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
									+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
									+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
									+ "	.swal-title{color: #FFF; font-weight: 500;}"
									+ " .swal-text{color: #FFF; font-weight: 300;}"
									+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
									+ "	.swal-button:hover{opacity: 1}"
									+ "</style></head>");
							out.println("<body>");
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script>"
									+ "	swal(\"Proveedor no existente.\", \"\", \"error\", {closeOnClickOutside: false});"
									+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
									+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
									+ "</script>");
							out.println("</body></html>");
							out.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.println("<html><head><title>Warning</title><style>"
							+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
							+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
							+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
							+ "	.swal-title{color: #FFF; font-weight: 500;}"
							+ " .swal-text{color: #FFF; font-weight: 300;}"
							+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
							+ "	.swal-button:hover{opacity: 1}"
							+ "</style></head>");
					out.println("<body>");
					out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
					out.println("<script>"
							+ "	swal(\"Ingrese un NIT.\", \"\", \"warning\", {closeOnClickOutside: false});"
							+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
							+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Proveedores.jsp\"})"
							+ "</script>");
					out.println("</body></html>");
					out.close();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Proveedores> lista = TestJSONProveedores.getJSONProveedores();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			break;
		case "Productos":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Productos> lista = TestJSONProductos.getJSONProductos();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Productos producto = new Productos();
				producto.setCodigoProducto(Long.parseLong(request.getParameter("txtcodigo")));
				producto.setNombreProducto(request.getParameter("txtnombre"));
				producto.setNitProveedor(Long.parseLong(request.getParameter("txtnit_proveedor")));
				producto.setPrecioCompra(Double.parseDouble(request.getParameter("txtprecio_compra")));
				producto.setIvaCompra(Double.parseDouble(request.getParameter("txtiva_compra")));
				producto.setPrecioVenta(Double.parseDouble(request.getParameter("txtprecio_venta")));

				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.postJSON(producto);
					if (respuesta == 200) {
						out.println("<html><head><title>Success</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Producto agregado correctamente.\", \"\", \"success\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
					} else {
						out.println("<html><head><title>Error</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
					}
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Productos producto = new Productos();
				producto.setCodigoProducto(Long.parseLong(request.getParameter("txtcodigo")));
				producto.setNombreProducto(request.getParameter("txtnombre"));
				producto.setNitProveedor(Long.parseLong(request.getParameter("txtnit_proveedor")));
				producto.setPrecioCompra(Double.parseDouble(request.getParameter("txtprecio_compra")));
				producto.setIvaCompra(Double.parseDouble(request.getParameter("txtiva_compra")));
				producto.setPrecioVenta(Double.parseDouble(request.getParameter("txtprecio_venta")));

				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.putJSON(producto, producto.getNitProveedor());

					if (respuesta == 200) {
						out.println("<html><head><title>Success</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Producto actualizado correctamente.\", \"\", \"success\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
					} else {
						out.println("<html><head><title>Error</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
					}
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Productos> lista1 = TestJSONProductos.getJSONProductos();
					System.out.println("Parametro: " + id);
					for (Productos producto : lista1) {
						if (producto.getCodigoProducto() == id) {
							request.setAttribute("productosSeleccionado", producto);
							request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("txtcodigo"));
				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.deleteJSONProductos(id);
					if (respuesta == 200) {
						out.println("<html><head><title>Info</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Producto eliminado correctamente.\", \"\", \"info\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
					} else {
						out.println("<html><head><title>Error</title><style>"
								+ " .swal-icon--success:after, .swal-icon--success:before, .swal-icon--success__hide-corners {background: transparent}"
								+ " .swal-overlay{background-color: rgb(172, 77, 251, 0.45);}"
								+ " .swal-modal{background-color: rgba(0, 0, 0, 0.3); box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.3); font-family: 'Segoe UI', Tahoma, sans-serif}"
								+ "	.swal-title{color: #FFF; font-weight: 500;}"
								+ " .swal-text{color: #FFF; font-weight: 300;}"
								+ "	.swal-button{opacity: .8; transition: opacity 0.5s;}"
								+ "	.swal-button:hover{opacity: 1}"
								+ "</style></head>");
						out.println("<body>");
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script>"
								+ "	swal(\"Error: " + respuesta +  ".\", \"\", \"error\", {closeOnClickOutside: false});"
								+ " const btnSwal = document.getElementsByClassName(\"swal-button\");"
								+ "	btnSwal[0].addEventListener(\"click\", () => {window.location=\"./Productos.jsp\"})"
								+ "</script>");
						out.println("</body></html>");
					}
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Consultar")) {
				Long id = Long.parseLong(request.getParameter("txtcodigo"));
				try {
					ArrayList<Productos> lista1 = TestJSONProductos.getJSONProductos(id);
					System.out.println("Parametro: " + id);
					for (Productos producto : lista1) {
						if (producto.getCodigoProducto() == id) {
							request.setAttribute("productoSeleccionado", producto);
							request.setAttribute("lista", lista1);

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Productos> lista = TestJSONProductos.getJSONProductos();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Productos.jsp").forward(request, response);
			break;
		case "Ventas":
			request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
			break;
		case "Reportes":
			int opcion = 0;

			if (accion.equals("ReporteUsuarios")) {
				opcion = 1;
				try {
					ArrayList<Usuarios> lista = TestJSONUsuarios.getJSONUsuarios();
					request.setAttribute("listaUsuarios", lista); // envio el arraylist
					request.setAttribute("opcion", opcion); // variable creada
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("ReporteClientes")) {
				opcion = 2;
				try {
					ArrayList<Clientes> lista = TestJSONClientes.getJSONClientes();
					request.setAttribute("listaClientes", lista); // envio el arraylist
					request.setAttribute("opcion", opcion); // variable creada
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("ReporteVentas")) {
				opcion = 3;
				try {
					ArrayList<Ventas> lista = TestJSONVentas.getJSONVentas();
					request.setAttribute("listaVentas", lista); // envio el arraylist
					request.setAttribute("opcion", opcion); // variable crada
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
			request.getRequestDispatcher("/Reportes.jsp").forward(request, response);
			break;

		case "Salir":
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			break;
		}

	}
}