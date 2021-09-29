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

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	        ArrayList<Usuarios> lista = TestJSON.getJSON();
		 request.setAttribute("lista", lista);
	     } catch (Exception e) {
		 e.printStackTrace();
	     }
	  }else if(accion.equals("Agregar")) {
	     Usuarios usuario = new Usuarios();
	     usuario.setCedulaUsuario(Long.parseLong(request.getParameter("txtcedula")));
	     usuario.setNombreUsuario(request.getParameter("txtnombre"));
	     usuario.setEmailUsuario(request.getParameter("txtemail"));
	     usuario.setUsuario(request.getParameter("txtusuario"));
	     usuario.setPassword(request.getParameter("txtpassword"));
					
            int respuesta=0;
	      try {
		   respuesta = TestJSON.postJSON(usuario);
		   PrintWriter write = response.getWriter();
		   if (respuesta==200) {
	request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
	} else {
		   write.println("Error: " +  respuesta);
		}
		   write.close();
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}else if(accion.equals("Actualizar")) {
	     Usuarios usuario = new Usuarios();
	     usuario.setCedulaUsuario(Long.parseLong(request.getParameter("txtcedula")));
	     usuario.setNombreUsuario(request.getParameter("txtnombre"));
	     usuario.setEmailUsuario(request.getParameter("txtemail"));
	     usuario.setUsuario(request.getParameter("txtusuario"));
	     usuario.setPassword(request.getParameter("txtpassword"));
		
             int respuesta=0;
		try {
		   respuesta = TestJSON.putJSON(usuario,usuario.getCedulaUsuario());
		   PrintWriter write = response.getWriter();
						
		   if (respuesta==200) {
	request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
        	   } else {
			write.println("Error: " +  respuesta);
		   }
			write.close();
		   } catch (Exception e) {
			e.printStackTrace();
		   }
	}else if(accion.equals("Cargar")) {
		Long id= Long.parseLong(request.getParameter("id"));
		try {
                ArrayList<Usuarios> lista1 = TestJSON.getJSON();
		   System.out.println("Parametro: " + id);						
		   for (Usuarios usuarios:lista1){
			if (usuarios.getCedulaUsuario()==id) {
			   request.setAttribute("usuarioSeleccionado", usuarios);
	request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
			}
		   }
		 } catch (Exception e) {
	       	e.printStackTrace();
		 }
	}else if(accion.equals("Eliminar")) {
        	Long id= Long.parseLong(request.getParameter("id"));			
		int respuesta=0;
		try {
		   respuesta = TestJSON.deleteJSON(id);
		   PrintWriter write = response.getWriter();
		   if (respuesta==200) {
	request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
		   } else {
			write.println("Error: " +  respuesta);
		   }
		      write.close();
		   } catch (Exception e) {
			e.printStackTrace();
		   }	
	}request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
             break;
	 case "Clientes":
		 if (accion.equals("Listar")) {
		     try {
		        ArrayList<Clientes> lista = TestJSON.getJSONCl();
			 request.setAttribute("lista", lista);
		     } catch (Exception e) {
			 e.printStackTrace();
		     }
		  }else if(accion.equals("Agregar")) {
			  Clientes cliente = new Clientes();
			     cliente.setCedulaCliente(Long.parseLong(request.getParameter("txtcedula")));
			     cliente.setDireccionCliente(request.getParameter("txtdireccion"));
			     cliente.setEmailCliente(request.getParameter("txtemail"));
			     cliente.setNombreCliente(request.getParameter("txtnombre"));
			     cliente.setTelefonoCliente(request.getParameter("txttelefono"));
						
	            int respuesta=0;
		      try {
			   respuesta = TestJSON.postJSON(cliente);
			   PrintWriter write = response.getWriter();
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
		} else {
			   write.println("Error: " +  respuesta);
			}
			   write.close();
			} catch (Exception e) {
			   e.printStackTrace();
			}
		}else if(accion.equals("Actualizar")) {
			Clientes cliente = new Clientes();
		     cliente.setCedulaCliente(Long.parseLong(request.getParameter("txtcedula")));
		     cliente.setDireccionCliente(request.getParameter("txtdireccion"));
		     cliente.setEmailCliente(request.getParameter("txtemail"));
		     cliente.setNombreCliente(request.getParameter("txtnombre"));
		     cliente.setTelefonoCliente(request.getParameter("txttelefono"));
			
	             int respuesta=0;
			try {
			   respuesta = TestJSON.putJSON(cliente,cliente.getCedulaCliente());
			   PrintWriter write = response.getWriter();
							
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
	        	   } else {
				write.println("Error: " +  respuesta);
			   }
				write.close();
			   } catch (Exception e) {
				e.printStackTrace();
			   }
		}else if(accion.equals("Cargar")) {
			Long id= Long.parseLong(request.getParameter("id"));
			try {
	                ArrayList<Clientes> lista1 = TestJSON.getJSONCl();
			   System.out.println("Parametro: " + id);						
			   for (Clientes clientes:lista1){
				if (clientes.getCedulaCliente()==id) {
				   request.setAttribute("clienteSeleccionado", clientes);
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
				}
			   }
			 } catch (Exception e) {
		       	e.printStackTrace();
			 }
		}else if(accion.equals("Eliminar")) {
	        	Long id= Long.parseLong(request.getParameter("id"));			
			int respuesta=0;
			try {
			   respuesta = TestJSON.deleteJSONCl(id);
			   PrintWriter write = response.getWriter();
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
			   } else {
				write.println("Error: " +  respuesta);
			   }
			      write.close();
			   } catch (Exception e) {
				e.printStackTrace();
			   }	
		}request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
	   break;
	  case "Proveedores":	
	    request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
	    break;
	  case "Productos":
	 	request.getRequestDispatcher("/Productos.jsp").forward(request, response);
		break;
	  case "Ventas":	
		request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
		break;
		}
      
   	}
}