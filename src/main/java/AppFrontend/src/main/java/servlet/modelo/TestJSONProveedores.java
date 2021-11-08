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

import AppFrontend.src.main.java.servlet.modelo.DTO.Proveedores;

public class TestJSONProveedores {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
//	private static String sitio = "http://localhost:8080/Back_PapeleriaWWW-0.0.1-SNAPSHOT/";

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

}
