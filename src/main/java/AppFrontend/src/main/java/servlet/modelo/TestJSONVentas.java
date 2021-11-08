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
import AppFrontend.src.main.java.servlet.modelo.DTO.Ventas;

public class TestJSONVentas {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
//	private static String sitio = "http://localhost:8080/Back_PapeleriaWWW-0.0.1-SNAPSHOT/";

	public static ArrayList<Ventas> parsingVentas(String json) throws ParseException {// devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		JSONArray ventas = (JSONArray) jsonParser.parse(json);
		Iterator i = ventas.iterator(); // recorrer la tabla cliente
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Ventas Venta = new Ventas();

			Venta.setCodigoVenta(Long.parseLong(innerObj.get("codigoVenta").toString()));
			Venta.setCedulaCliente(Long.parseLong(innerObj.get("cedulaCliente").toString()));
			Venta.setValorVenta(Double.parseDouble(innerObj.get("valorVenta").toString()));
			Venta.setIvaVenta(Double.parseDouble(innerObj.get("ivaVenta").toString()));
			Venta.setTotalVenta(Double.parseDouble(innerObj.get("totalVenta").toString()));
			Venta.setNombreCliente(innerObj.get("nombreCliente").toString());
			lista.add(Venta);
		}
		return lista;
	}

	// listar la informacion
	public static ArrayList<Ventas> getJSONVentas() throws IOException, ParseException { // devolver un listado JSON

		url = new URL(sitio + "ventas/listar"); // trae el metodo de Clientes.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<Ventas> getJSONVentas(Long id) throws IOException, ParseException { // devolver un
																								// listado JSON

		url = new URL(sitio + "ventas/listar"); // trae el metodo de Usuarios.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Ventas> listaTemporal = new ArrayList<Ventas>();
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		listaTemporal = parsingVentas(json);

		for (Ventas ventas : listaTemporal) {
			if (ventas.getCodigoVenta() == id) {
				lista.add(ventas);
			}
		}
		http.disconnect();
		return lista;
	}

	public static Ventas getJSONVenta(Long id) throws IOException, ParseException { // devolver un
		// listado JSON

		url = new URL(sitio + "ventas/listar"); // trae el metodo de Usuarios.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Ventas> listaTemporal = new ArrayList<Ventas>();
		Ventas lista = new Ventas();
		listaTemporal = parsingVentas(json);

		for (Ventas venta : listaTemporal) {
			if (venta.getCedulaCliente() == id) {
				lista = venta;
			}
		}
		http.disconnect();
		return lista;
	}

	public static int postJSON(Ventas ventas) throws IOException {

		url = new URL(sitio + "ventas/guardar");
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

		String data = "{" + "\"codigoVenta\":\"" + String.valueOf(ventas.getCodigoVenta()) + "\",\"cedulaCliente\": \""
				+ String.valueOf(ventas.getCedulaCliente()) + "\",\"valorVenta\":\""
				+ String.valueOf(ventas.getValorVenta()) + "\",\"ivaVenta\":\"" + String.valueOf(ventas.getIvaVenta())
				+ "\",\"totalVenta\":\"" + String.valueOf(ventas.getTotalVenta()) + "\",\"nombreCliente\":\""
				+ String.valueOf(ventas.getNombreCliente()) + "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Ventas ventas, Long id) throws IOException {

		url = new URL(sitio + "ventas/actualizar");
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

		String data = "{" + "\"codigoVenta\":\"" + id + "\",\"cedulaCliente\": \""
				+ String.valueOf(ventas.getCedulaCliente()) + "\",\"valorVenta\":\""
				+ String.valueOf(ventas.getValorVenta()) + "\",\"ivaVenta\":\"" + String.valueOf(ventas.getIvaVenta())
				+ "\",\"totalVenta\":\"" + String.valueOf(ventas.getTotalVenta()) + "\",\"nombreCliente\":\""
				+ String.valueOf(ventas.getNombreCliente()) + "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteJSONVentas(Long id) throws IOException {

		url = new URL(sitio + "ventas/eliminar/" + id);
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
