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

		switch (menu) {
		case "menu":
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
			break;
		case "Usuarios":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Usuarios> lista = TestJSON.getJSONUsuarios();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}if (accion.equals("Agregar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedulaUsuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombreUsuario(request.getParameter("txtnombre"));
				usuario.setEmailUsuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.postJSON(usuario);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				if (request.getParameter("txtcedula") != null) {
					Usuarios usuario = new Usuarios();
					usuario.setCedulaUsuario(Long.parseLong(request.getParameter("txtcedula")));
					usuario.setNombreUsuario(request.getParameter("txtnombre"));
					usuario.setEmailUsuario(request.getParameter("txtemail"));
					usuario.setUsuario(request.getParameter("txtusuario"));
					usuario.setPassword(request.getParameter("txtpassword"));

					int respuesta = 0;
					try {
						respuesta = TestJSON.putJSON(usuario, usuario.getCedulaUsuario());
						PrintWriter write = response.getWriter();

						if (respuesta == 200) {
							request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
									response);
						} else {
							write.println("Error: " + respuesta);
						}
						write.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Usuarios> lista1 = TestJSON.getJSONUsuarios();
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
				Long id = Long.parseLong(request.getParameter("txtcedula"));
				int respuesta = 0;
				try {
					respuesta = TestJSON.deleteJSONUsuarios(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Consultar")) {
				Long id = Long.parseLong(request.getParameter("txtcedula"));
				try {
					ArrayList<Usuarios> lista1 = TestJSON.getJSONUsuarios(id);
					System.out.println("Parametro: " + id);
					for (Usuarios usuarios : lista1) {
						if (usuarios.getCedulaUsuario() == id) {
							request.setAttribute("usuarioSeleccionado", usuarios);
							request.setAttribute("lista", lista1);

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Usuarios> lista = TestJSON.getJSONUsuarios();
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
					ArrayList<Clientes> lista = TestJSON.getJSONClientes();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Clientes cliente = new Clientes();
				cliente.setCedulaCliente(Long.parseLong(request.getParameter("txtcedula")));
				cliente.setDireccionCliente(request.getParameter("txtdireccion"));
				cliente.setEmailCliente(request.getParameter("txtemail"));
				cliente.setNombreCliente(request.getParameter("txtnombre"));
				cliente.setTelefonoCliente(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.postJSON(cliente);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Clientes cliente = new Clientes();
				cliente.setCedulaCliente(Long.parseLong(request.getParameter("txtcedula")));
				cliente.setDireccionCliente(request.getParameter("txtdireccion"));
				cliente.setEmailCliente(request.getParameter("txtemail"));
				cliente.setNombreCliente(request.getParameter("txtnombre"));
				cliente.setTelefonoCliente(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.putJSON(cliente, cliente.getCedulaCliente());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Clientes> lista1 = TestJSON.getJSONClientes();
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
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSON.deleteJSONClientes(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Consultar")) {
				Long id = Long.parseLong(request.getParameter("txtcedula"));
				try {
					ArrayList<Clientes> lista1 = TestJSON.getJSONClientes(id);
					System.out.println("Parametro: " + id);
					for (Clientes cliente : lista1) {
						if (cliente.getCedulaCliente() == id) {
							request.setAttribute("clienteSeleccionado", cliente);
							request.setAttribute("lista", lista1);

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Clientes> lista = TestJSON.getJSONClientes();
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
					ArrayList<Proveedores> lista = TestJSON.getJSONProveedores();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitProveedor(Long.parseLong(request.getParameter("txtnit")));
				proveedor.setNombreProveedor(request.getParameter("txtnombre"));
				proveedor.setCiudadProveedor(request.getParameter("txtciudad"));
				proveedor.setDireccionProveedor(request.getParameter("txtdireccion"));
				proveedor.setTelefonoProveedor(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.postJSON(proveedor);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitProveedor(Long.parseLong(request.getParameter("txtnit")));
				proveedor.setNombreProveedor(request.getParameter("txtnombre"));
				proveedor.setCiudadProveedor(request.getParameter("txtciudad"));
				proveedor.setDireccionProveedor(request.getParameter("txtdireccion"));
				proveedor.setTelefonoProveedor(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.putJSON(proveedor, proveedor.getNitProveedor());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Proveedores> lista1 = TestJSON.getJSONProveedores();
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
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSON.deleteJSONProveedores(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Consultar")) {
				Long id = Long.parseLong(request.getParameter("txtnit"));
				try {
					ArrayList<Proveedores> lista1 = TestJSON.getJSONProveedores(id);
					System.out.println("Parametro: " + id);
					for (Proveedores proveedor : lista1) {
						if (proveedor.getNitProveedor() == id) {
							request.setAttribute("proveedorSeleccionado", proveedor);
							request.setAttribute("lista", lista1);

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Mostrar Todo")) {
				try {
					ArrayList<Proveedores> lista = TestJSON.getJSONProveedores();
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
					ArrayList<Productos> lista = TestJSON.getJSONProductos();
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
					respuesta = TestJSON.postJSON(producto);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
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
					respuesta = TestJSON.putJSON(producto, producto.getNitProveedor());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Productos> lista1 = TestJSON.getJSONProductos();
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
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSON.deleteJSONProductos(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Consultar")) {
				Long id = Long.parseLong(request.getParameter("txtcodigo"));
				try {
					ArrayList<Productos> lista1 = TestJSON.getJSONProductos(id);
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
					ArrayList<Productos> lista = TestJSON.getJSONProductos();
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
		case "Salir":
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			break;
		}

	}
}