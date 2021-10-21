package AppFrontend.src.main.java.servlet.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import AppFrontend.src.main.java.servlet.modelo.DTO.Productos;
import AppFrontend.src.main.java.servlet.modelo.DTO.Ventas;

public class TestJSONProductos {

	private static URL url;
		private static String sitio = "http://localhost:5000/";
		//	private static String sitio = "http://localhost:8080/Back_PapeleriaWWW-0.0.1-SNAPSHOT/";
	
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

	public static ArrayList<Productos> getJSONProductos(long id) throws IOException, ParseException { // devolver un
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
	public static Productos getJSONProducto(Long id) throws IOException, ParseException { // devolver un
		// listado JSON

		url = new URL(sitio + "Productos/listar"); // trae el metodo de Usuarios.API
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
		Productos lista = new Productos();
		listaTemporal = parsingProductos(json);

		for (Productos producto : listaTemporal) {
			if (producto.getCodigoProducto() == id) {
				lista = producto;
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

		String data = "{" + "\",\"codigoProducto\": \"" + String.valueOf(producto.getCodigoProducto())
				+ "\",\"nombreProducto\": \"" + producto.getNombreProducto() 
				+ "\",\"nitProveedor\": \""	+ String.valueOf(producto.getNitProveedor())
				+ "\",\"precioCompra\":\"" + String.valueOf(producto.getPrecioCompra()) 
				+ "\",\"ivaCompra\":\""	+ String.valueOf(producto.getIvaCompra()) 
				+ "\",\"precioVenta\":\"" + String.valueOf(producto.getPrecioVenta()) + "\"}";

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

		String data = "{" + "\"codigoProducto\":\"" + id 
		+ "\",\"nombreProducto\": \"" + producto.getNombreProducto() 
		+ "\",\"nitProveedor\": \""	+ String.valueOf(producto.getNitProveedor())
		+ "\",\"precioCompra\":\"" + String.valueOf(producto.getPrecioCompra()) 
		+ "\",\"ivaCompra\":\""	+ String.valueOf(producto.getIvaCompra()) 
		+ "\",\"precioVenta\":\"" + String.valueOf(producto.getPrecioVenta()) + "\"}";
		
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
