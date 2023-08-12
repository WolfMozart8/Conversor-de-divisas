package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import conversor.divisas.Divisa;

public class JsonDataBase {

	public static List<Divisa> lista = new ArrayList<>();

	/**
	 * Crea una nueva base de datos json si no hay uno o si la lista está vacia
	 */
	private static void crearDataBase() {
//		2023-08-11 {2023, 08, 11} (año - mes - dia)
		int[] fecha = { 2023, 8, 11 };

		Divisa dolar = new Divisa("Dolar", "USD", 1.00, fecha);
		Divisa euro = new Divisa("Euro", "EUR", 0.91, fecha);
		Divisa libras = new Divisa("Libras", "GBP", 0.79, fecha);
		Divisa yen = new Divisa("Yen japonés", "JPY", 144.90, fecha);
		Divisa won = new Divisa("Won sud-coreano", "KRW", 1330.60, fecha);
		Divisa pesoChileno = new Divisa("Peso Chileno", "CLP", 853.21, fecha);
		Divisa pesoArgentino = new Divisa("Peso Argentino", "ARS", 286.87, fecha);

		lista.add(dolar);
		lista.add(euro);
		lista.add(libras);
		lista.add(yen);
		lista.add(won);
		lista.add(pesoChileno);
		lista.add(pesoArgentino);

		guardarDataBase();
	}

	/**
	 * Sobrescribe el archivo json actual
	 */
	public static void guardarDataBase() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(lista);
//		System.out.println(json);

		try (FileWriter fileWriter = new FileWriter("divisas.json")) {
			gson.toJson(lista, fileWriter);
			System.out.println("Objetos Divisa convertidos a JSON y guardados en el archivo 'divisas.json'.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarDataBase() {
//		for (Divisa divisa : lista) {
//			System.out.println("antes: " + divisa.getNombre());
//		}

		try {
			// Ruta del archivo JSON
			String filePath = "divisas.json";

			// Lee el contenido del archivo JSON
			FileReader fileReader = new FileReader(filePath);

			// Define el tipo de lista que se espera en el archivo JSON
			Type listType = new TypeToken<List<Divisa>>() {
			}.getType();

			// Parsea el JSON y conviértelo en una lista de objetos Divisa
			Gson gson = new Gson();
			lista = gson.fromJson(fileReader, listType);

			// Ahora puedes usar la lista de objetos Divisa como desees
			for (Divisa divisa : lista) {
				System.out.println("Nombre: " + divisa.getNombre());
			}

			// Cierra el FileReader después de usarlo
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lista.isEmpty()) {

			crearDataBase();
		}
	}


	public static void agregarDivisa(String nombre, String codigo, Double valor) {
		Divisa nuevaDivisa = new Divisa(nombre, codigo, valor);

		lista.add(nuevaDivisa);
	}

	public static String[] getNombres() {
		if (lista.isEmpty()) {
			crearDataBase();
		}

		String[] nombres = new String[lista.size()];

		for (int i = 0; i < lista.size(); i++) {
			String nombre = lista.get(i).getNombre();
			nombres[i] = nombre;
		}
		System.out.println(lista.size());
		return nombres;
	}

	
	public static Divisa getDivisa(int index) {
		return lista.get(index);
	}
	
	/**
	 * Retorna una lista de Divisas en forma de Array
	 * @return Divisas[]
	 */
	public static Divisa[] getLista() {
		if (lista.isEmpty()) {
			crearDataBase();
		}

		Divisa[] divisas = new Divisa[lista.size()];
		

		for (int i = 0; i < lista.size(); i++) {
			Divisa divisa = lista.get(i);
			divisas[i] = divisa;
		}
		return divisas;
	}
	
	

}
