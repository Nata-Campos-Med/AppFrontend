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
import AppFrontend.src.main.java.servlet.modelo.TestJSONClientes;
import AppFrontend.src.main.java.servlet.modelo.TestJSONProductos;
import AppFrontend.src.main.java.servlet.modelo.TestJSONProveedores;
import AppFrontend.src.main.java.servlet.modelo.DTO.Clientes;
import AppFrontend.src.main.java.servlet.modelo.DTO.Productos;
import AppFrontend.src.main.java.servlet.modelo.DTO.Proveedores;
import AppFrontend.src.main.java.servlet.modelo.DTO.Usuarios;

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
					System.out.println("usuario creado exitosamente");
				} else {
					System.out.println("faltan datos");
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
							PrintWriter write = response.getWriter();

							if (respuesta == 200) {
								request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
										response);
								System.out.println("usuario actualizado exitosamente");
							} else {
								write.println("Error: " + respuesta);
							}
							write.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
						System.out.println("faltan datos");
					}
				} else {
					System.out.println("ingrese una cedula");
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
						PrintWriter write = response.getWriter();
						if (respuesta == 200) {
							request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
									response);
							System.out.println("usuario eliminado");
						} else {
							request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
							System.out.println("usuario no encontrado");
						}
						write.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
					System.out.println("ingrese una cedula");
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
							System.out.println("usuario no existe");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ingrese una cedula");
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
						PrintWriter write = response.getWriter();
						if (respuesta == 200) {
							request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
									response);
							System.out.println("Cliente creado correctamente");
						} else {
							write.println("Error: " + respuesta);
						}
						write.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("faltan datos");
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
							PrintWriter write = response.getWriter();

							if (respuesta == 200) {
								request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
										response);
								System.out.println("Cliente se actualizo correctamente");
							} else {
								write.println("Error: " + respuesta);
							}
							write.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("faltan datos");
					}

				} else {
					System.out.println("ingrese una cedula");
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
						PrintWriter write = response.getWriter();
						if (respuesta == 200) {
							request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
									response);
							System.out.println("el cliente fue eliminado");
						} else {
							write.println("Error: " + respuesta);
						}
						write.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ingrese una cedula");
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
							System.out.println("Cliente no existe");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ingrese una cedula");
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
						PrintWriter write = response.getWriter();
						if (respuesta == 200) {
							request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
									response);
							System.out.println("proveedor creado correctamente");
						} else {
							write.println("Error: " + respuesta);
						}
						write.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("faltan datos");
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
							PrintWriter write = response.getWriter();

							if (respuesta == 200) {
								request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar")
										.forward(request, response);
								System.out.println("Proveedor actualizado correctamente");
							} else {
								write.println("Error: " + respuesta);
							}
							write.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("faltan datos ");
					}

				} else {
					System.out.println("ingrese un nit");
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
						PrintWriter write = response.getWriter();
						if (respuesta == 200) {
							request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
									response);
							System.out.println("Proveedor eliminado");
						} else {
							write.println("Error: " + respuesta);
						}
						write.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ingrese un nit");

				}
			}  else if (accion.equals("Consultar")) {
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
							System.out.println("Proveedor no existe");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ingrese una nit");
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
					respuesta = TestJSONProductos.putJSON(producto, producto.getNitProveedor());
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
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.deleteJSONProductos(id);
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
		case "Salir":
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			break;
		}

	}
}