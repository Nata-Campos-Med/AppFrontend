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

import AppFrontend.src.main.java.servlet.modelo.DTO.DetalleVentas;


public class TestJSONDetalleVentas {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<DetalleVentas> parsingDetalleVentas(String json) throws ParseException {// devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<DetalleVentas> lista = new ArrayList<DetalleVentas>();
		JSONArray detalleVentas = (JSONArray) jsonParser.parse(json);
		Iterator i = detalleVentas.iterator(); // recorrer la tabla cliente
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			DetalleVentas detalleVenta = new DetalleVentas();
																
			detalleVenta.setCodigoDetalleVenta(Long.parseLong(innerObj.get("codigoDetalleVenta").toString()));
			detalleVenta.setCantidadProducto(Integer.parseInt(innerObj.get("cantidadProducto").toString()));
			detalleVenta.setCodigoProducto(Long.parseLong(innerObj.get("codigoProducto").toString()));
			detalleVenta.setCodigoVenta(Long.parseLong( innerObj.get("codigoVenta").toString()));
			detalleVenta.setValorTotal(Double.parseDouble( innerObj.get("valorTotal").toString()));
			detalleVenta.setValorVenta(Double.parseDouble( innerObj.get("valorVenta").toString()));
			detalleVenta.setValorIva(Double.parseDouble( innerObj.get("valorIva").toString()));
			lista.add(detalleVenta);
		}
		return lista;
	}

	// listar la informacion
	public static ArrayList<DetalleVentas> getJSONDetalleVentas() throws IOException, ParseException { // devolver un listado JSON

		url = new URL(sitio + "detalle_ventas/listar"); // trae el metodo de Clientes.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<DetalleVentas> lista = new ArrayList<DetalleVentas>();
		lista = parsingDetalleVentas(json);
		http.disconnect();
		return lista;
	}

	public static ArrayList<DetalleVentas> getJSONDetalleVentas(Long id) throws IOException, ParseException { // devolver un
																									// listado JSON

		url = new URL(sitio + "detalle_ventas/listar"); // trae el metodo de Usuarios.API
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<DetalleVentas> listaTemporal = new ArrayList<DetalleVentas>();
		ArrayList<DetalleVentas> lista = new ArrayList<DetalleVentas>();
		listaTemporal = parsingDetalleVentas(json);

		for (DetalleVentas detalleVentas : listaTemporal) {
			if (detalleVentas.getCodigoVenta() == id) {
				lista.add(detalleVentas);
			}
		}
		http.disconnect();
		return lista;
	}

	public static int postJSON(DetalleVentas detalleVentas) throws IOException {

		url = new URL(sitio + "detalle_ventas/guardar");
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

		String data = "{" + "\"codigoDetalleVenta\":\"" + String.valueOf(detalleVentas.getCodigoDetalleVenta())
				+ "\",\"cantidadProducto\": \"" + String.valueOf(detalleVentas.getCantidadProducto())
				+ "\",\"codigoProducto\": \""	+ String.valueOf(detalleVentas.getCodigoProducto()) 
				+ "\",\"codigoVenta\":\""	+ String.valueOf(detalleVentas.getCodigoVenta())
				+ "\",\"valorTotal\":\""	+ String.valueOf(detalleVentas.getValorTotal())
				+ "\",\"valorVenta\":\"" + String.valueOf(detalleVentas.getValorVenta()) 
				+ "\",\"valorIva\":\""	+ String.valueOf(detalleVentas.getValorIva())+ "\"}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(DetalleVentas detalleVentas, Long id) throws IOException {

		url = new URL(sitio + "detalle_ventas/actualizar");
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

		String data = "{" + "\"codigoDetalleVenta\":\"" + id 
				+ "\",\"cantidadProducto\": \"" + String.valueOf(detalleVentas.getCantidadProducto())
				+ "\",\"codigoProducto\": \""	+ String.valueOf(detalleVentas.getCodigoProducto()) 
				+ "\",\"codigoVenta\":\""	+ String.valueOf(detalleVentas.getCodigoVenta())
				+ "\",\"valorTotal\":\""	+ String.valueOf(detalleVentas.getValorTotal())
				+ "\",\"valorVenta\":\"" + String.valueOf(detalleVentas.getValorVenta()) 
				+ "\",\"valorIva\":\""	+ String.valueOf(detalleVentas.getValorIva())+ "\"}";
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int deleteJSONcodigoDetalleVenta(Long id) throws IOException {

		url = new URL(sitio + "detalle_ventas/eliminar/" + id);
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
