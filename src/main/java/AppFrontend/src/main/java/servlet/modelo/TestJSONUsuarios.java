package AppFrontend.src.main.java.servlet.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection; //esta libreria es para realizar la conexion
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import AppFrontend.src.main.java.servlet.modelo.DTO.Clientes;
import AppFrontend.src.main.java.servlet.modelo.DTO.Productos;
import AppFrontend.src.main.java.servlet.modelo.DTO.Proveedores;
import AppFrontend.src.main.java.servlet.modelo.DTO.Usuarios;

public class TestJSONUsuarios {
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	// ***********************************************************************************************************************************************
	// modulo de Usuarios
	// ************************************************************************************************************************************************
	// agregar informacion a la tabla usuario

	public static ArrayList<Usuarios> parsingUsuarios(String json) throws ParseException {// devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator(); // recorrer la tabla usuario
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Usuarios usuario = new Usuarios();
			usuario.setCedulaUsuario(Long.parseLong(innerObj.get("cedulaUsuario").toString())); // convertir de String a
																								// Long
			usuario.setEmailUsuario(innerObj.get("emailUsuario").toString());
			usuario.setNombreUsuario(innerObj.get("nombreUsuario").toString());
			usuario.setPassword(innerObj.get("password").toString());
			usuario.setUsuario(innerObj.get("usuario").toString());
			lista.add(usuario);
		}
		return lista;
	}

	// listar la informacion
	public static ArrayList<Usuarios> getJSONUsuarios() throws IOException, ParseException { // devolver un listado JSON

		url = new URL(sitio + "usuarios/listar"); // trae el metodo de Usuarios.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<Usuarios> getJSONUsuarios(Long id) throws IOException, ParseException { // devolver un
																									// listado JSON

		url = new URL(sitio + "usuarios/listar"); // trae el metodo de Usuarios.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Usuarios> listaTemporal = new ArrayList<Usuarios>();
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		listaTemporal = parsingUsuarios(json);

		for (Usuarios usuario : listaTemporal) {
			if (usuario.getCedulaUsuario() == id) {
				lista.add(usuario);
				break;
			}
		}
		
		http.disconnect();
		return lista;
	}

	public static int postJSON(Usuarios usuario) throws IOException {

		url = new URL(sitio + "usuarios/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"cedulaUsuario\":\"" + String.valueOf(usuario.getCedulaUsuario())
				+ "\",\"emailUsuario\": \"" + usuario.getEmailUsuario() + "\",\"nombreUsuario\": \""
				+ usuario.getNombreUsuario() + "\",\"password\":\"" + usuario.getPassword() + "\",\"usuario\":\""
				+ usuario.getUsuario() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Usuarios usuario, Long id) throws IOException {

		url = new URL(sitio + "usuarios/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"cedulaUsuario\":\"" + id + "\",\"emailUsuario\": \"" + usuario.getEmailUsuario()
				+ "\",\"nombreUsuario\": \"" + usuario.getNombreUsuario() + "\",\"password\":\"" + usuario.getPassword()
				+ "\",\"usuario\":\"" + usuario.getUsuario() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteJSONUsuarios(Long id) throws IOException {

		url = new URL(sitio + "usuarios/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	/// ***********************************************************************************************************************************************
	// modulo de Clientes
	// ************************************************************************************************************************************************
	public static ArrayList<Clientes> parsingClientes(String json) throws ParseException {// devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		JSONArray clientes = (JSONArray) jsonParser.parse(json);
		Iterator i = clientes.iterator(); // recorrer la tabla cliente
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Clientes cliente = new Clientes();
			cliente.setCedulaCliente(Long.parseLong(innerObj.get("cedulaCliente").toString())); // convertir de String
																								// a Long
			cliente.setDireccionCliente(innerObj.get("direccionCliente").toString());
			cliente.setEmailCliente(innerObj.get("emailCliente").toString());
			cliente.setNombreCliente(innerObj.get("nombreCliente").toString());
			cliente.setTelefonoCliente(innerObj.get("telefonoCliente").toString());
			lista.add(cliente);
		}
		return lista;
	}

	// listar la informacion
	public static ArrayList<Clientes> getJSONClientes() throws IOException, ParseException { // devolver un listado JSON

		url = new URL(sitio + "clientes/listar"); // trae el metodo de Clientes.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<Clientes> getJSONClientes(Long id) throws IOException, ParseException { // devolver un
																									// listado JSON

		url = new URL(sitio + "clientes/listar"); // trae el metodo de Usuarios.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Clientes> listaTemporal = new ArrayList<Clientes>();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		listaTemporal = parsingClientes(json);

		for (Clientes cliente : listaTemporal) {
			if (cliente.getCedulaCliente() == id) {
				lista.add(cliente);
			}
		}
		http.disconnect();
		return lista;
	}

	public static int postJSON(Clientes cliente) throws IOException {

		url = new URL(sitio + "clientes/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"cedulaCliente\":\"" + String.valueOf(cliente.getCedulaCliente())
				+ "\",\"direccionCliente\": \"" + cliente.getDireccionCliente() + "\",\"emailCliente\": \""
				+ cliente.getEmailCliente() + "\",\"nombreCliente\":\"" + cliente.getNombreCliente()
				+ "\",\"telefonoCliente\":\"" + cliente.getTelefonoCliente() + "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Clientes cliente, Long id) throws IOException {

		url = new URL(sitio + "clientes/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"cedulaCliente\":\"" + id + "\",\"direccionCliente\": \"" + cliente.getDireccionCliente()
				+ "\",\"emailCliente\": \"" + cliente.getEmailCliente() + "\",\"nombreCliente\":\""
				+ cliente.getNombreCliente() + "\",\"telefonoCliente\":\"" + cliente.getTelefonoCliente() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteJSONClientes(Long id) throws IOException {

		url = new URL(sitio + "clientes/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	// ***********************************************************************************************************************************************
	// modulo de proveedores
	// ************************************************************************************************************************************************

	public static ArrayList<Proveedores> parsingProveedores(String json) throws ParseException {// devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		Iterator i = proveedores.iterator(); // recorrer la tabla proveedores
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Proveedores proveedor = new Proveedores();
			proveedor.setNitProveedor(Long.parseLong(innerObj.get("nitProveedor").toString())); // convertir de String a
																								// Long
			proveedor.setNombreProveedor(innerObj.get("nombreProveedor").toString());
			proveedor.setCiudadProveedor(innerObj.get("ciudadProveedor").toString());
			proveedor.setDireccionProveedor(innerObj.get("direccionProveedor").toString());
			proveedor.setTelefonoProveedor(innerObj.get("telefonoProveedor").toString());
			lista.add(proveedor);
		}
		return lista;
	}

	// listar la informacion
	public static ArrayList<Proveedores> getJSONProveedores() throws IOException, ParseException { // devolver un
																									// listado JSON
		url = new URL(sitio + "proveedores/listar"); // trae el metodo de Proveedores.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<Proveedores> getJSONProveedores(Long id) throws IOException, ParseException { // devolver un
																											// listado
																											// JSON

		url = new URL(sitio + "proveedores/listar"); // trae el metodo de Proveedores.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Proveedores> listaTemporal = new ArrayList<Proveedores>();
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		listaTemporal = parsingProveedores(json);

		for (Proveedores proveedor : listaTemporal) {
			if (proveedor.getNitProveedor() == id) {
				lista.add(proveedor);
			}
		}
		http.disconnect();
		return lista;
	}

	public static int postJSON(Proveedores proveedor) throws IOException {

		url = new URL(sitio + "proveedores/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"nitProveedor\":\"" + String.valueOf(proveedor.getNitProveedor())
				+ "\",\"nombreProveedor\": \"" + proveedor.getNombreProveedor() + "\",\"ciudadProveedor\": \""
				+ proveedor.getCiudadProveedor() + "\",\"direccionProveedor\":\"" + proveedor.getDireccionProveedor()
				+ "\",\"telefonoProveedor\":\"" + proveedor.getTelefonoProveedor() + "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Proveedores proveedor, Long id) throws IOException {

		url = new URL(sitio + "proveedores/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"nitProveedor\":\"" + id + "\",\"nombreProveedor\": \"" + proveedor.getNombreProveedor()
				+ "\",\"ciudadProveedor\": \"" + proveedor.getCiudadProveedor() + "\",\"direccionProveedor\":\""
				+ proveedor.getDireccionProveedor() + "\",\"telefonoProveedor\":\"" + proveedor.getTelefonoProveedor()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteJSONProveedores(Long id) throws IOException {

		url = new URL(sitio + "proveedores/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	// **************************************************************************************************************************************************************************
	// modulo de Productos
	// *************************************************************************************************************************************************************************

	public static ArrayList<Productos> parsingProductos(String json) throws ParseException {// devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Productos> lista = new ArrayList<Productos>();
		JSONArray productos = (JSONArray) jsonParser.parse(json);
		Iterator i = productos.iterator(); // recorrer la tabla productos
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Productos producto = new Productos();
			producto.setCodigoProducto(Long.parseLong(innerObj.get("codigoProducto").toString())); // convertir de
																									// String a Long
			producto.setNombreProducto(innerObj.get("nombreProducto").toString());
			producto.setNitProveedor(Long.parseLong(innerObj.get("nitProveedor").toString()));
			producto.setPrecioCompra(Double.parseDouble(innerObj.get("precioCompra").toString()));
			producto.setIvaCompra(Double.parseDouble(innerObj.get("ivaCompra").toString()));
			producto.setPrecioVenta(Double.parseDouble(innerObj.get("precioVenta").toString()));
			lista.add(producto);
		}
		return lista;
	}

	// listar la informacion
	public static ArrayList<Productos> getJSONProductos() throws IOException, ParseException { // devolver un listado
																								// JSON
		url = new URL(sitio + "productos/listar"); // trae el metodo de Productos.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<Productos> getJSONProductos(Long id) throws IOException, ParseException { // devolver un
																										// listado JSON

		url = new URL(sitio + "productos/listar"); // trae el metodo de Proveedores.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Productos> listaTemporal = new ArrayList<Productos>();
		ArrayList<Productos> lista = new ArrayList<Productos>();
		listaTemporal = parsingProductos(json);

		for (Productos producto : listaTemporal) {
			if (producto.getCodigoProducto() == id) {
				lista.add(producto);
			}
		}
		http.disconnect();
		return lista;
	}

	public static int postJSON(Productos producto) throws IOException {

		url = new URL(sitio + "productos/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"codigoProducto\":\"" + String.valueOf(producto.getCodigoProducto())
				+ "\",\"nombreProducto\": \"" + producto.getNombreProducto() + "\",\"nitProveedor\": \""
				+ String.valueOf(producto.getNitProveedor()) + "\",\"precioCompra\":\""
				+ String.valueOf(producto.getPrecioCompra()) + "\",\"ivaCompra\":\""
				+ String.valueOf(producto.getIvaCompra()) + "\",\"precioVenta\":\""
				+ String.valueOf(producto.getPrecioVenta()) + "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Productos producto, Long id) throws IOException {

		url = new URL(sitio + "productos/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"codigoProducto\":\"" + id + "\",\"nombreProducto\": \"" + producto.getNombreProducto()
				+ "\",\"nitProveedor\": \"" + String.valueOf(producto.getNitProveedor()) + "\",\"precioCompra\":\""
				+ String.valueOf(producto.getPrecioCompra()) + "\",\"ivaCompra\":\""
				+ String.valueOf(producto.getIvaCompra()) + "\",\"precioVenta\":\""
				+ String.valueOf(producto.getPrecioVenta()) + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteJSONProductos(Long id) throws IOException {

		url = new URL(sitio + "productos/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

}