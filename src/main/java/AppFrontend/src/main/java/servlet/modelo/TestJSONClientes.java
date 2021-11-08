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

import AppFrontend.src.main.java.servlet.modelo.DTO.Clientes;

public class TestJSONClientes {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
//	private static String sitio = "http://localhost:8080/Back_PapeleriaWWW-0.0.1-SNAPSHOT/";

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

	public static Clientes getJSONCliente(Long id) throws IOException, ParseException { // devolver un
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
		Clientes lista = new Clientes();
		listaTemporal = parsingClientes(json);

		for (Clientes cliente : listaTemporal) {
			if (cliente.getCedulaCliente() == id) {
				lista = cliente;
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
				+ "\",\"direccionCliente\": \"" + cliente.getDireccionCliente() 
				+ "\",\"emailCliente\": \""	+ cliente.getEmailCliente() 
				+ "\",\"nombreCliente\":\"" + cliente.getNombreCliente()
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

}
