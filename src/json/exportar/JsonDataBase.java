package json.exportar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import conversor.divisas.Divisa;

public class JsonDataBase {

	public static List<Divisa> lista = new ArrayList<>();

	private static void crearDataBase() {
//		2023-08-01 {2023, 07, 28}
		int[] fecha = { 2023, 07, 28 };
//		Divisa dolar = new Divisa("Dolar", "USD", 1.00);
//		Divisa euro = new Divisa("Euro", "EUR", 0.91);
//		Divisa libras = new Divisa("Libras", "PND", 0.78);
//		Divisa yen = new Divisa("Yen japones", "YEN", 142.12);
//		Divisa won = new Divisa("Won sud-coreano", "WON", 1298.66);
//		Divisa pesoChileno = new Divisa("Peso Chileno", "CLP", 806.89);
//		Divisa pesoArgentino = new Divisa("peso Argentino", "ARS", 260.77);
		Divisa dolar = new Divisa("Dolar", "USD", 1.00, fecha);
		Divisa euro = new Divisa("Euro", "EUR", 0.91, fecha);
		Divisa libras = new Divisa("Libras", "PND", 0.78, fecha);
		Divisa yen = new Divisa("Yen japones", "YEN", 142.12, fecha);
		Divisa won = new Divisa("Won sud-coreano", "WON", 1298.66, fecha);
		Divisa pesoChileno = new Divisa("Peso Chileno", "CLP", 806.89, fecha);
		Divisa pesoArgentino = new Divisa("peso Argentino", "ARS", 260.77, fecha);

		lista.add(dolar);
		lista.add(euro);
		lista.add(libras);
		lista.add(yen);
		lista.add(won);
		lista.add(pesoChileno);
		lista.add(pesoArgentino);

		guardarDataBase();
	}

	public static void guardarDataBase() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
//		System.out.println(json);

		try (FileWriter fileWriter = new FileWriter("divisas.json")) {
			gson.toJson(lista, fileWriter);
			System.out.println("Objetos Divisa convertidos a JSON y guardados en el archivo 'divisas.json'.");

		} catch (IOException e) {
			// TODO: handle exception
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
//	public static void importarDataBase() {
//		for (Divisa divisa : lista) {
//			System.out.println("antes: " + divisa.getNombre());
//		}
//		if (lista.isEmpty()) {
////			lista.isEmpty();
////			lista.size();
//			crearDataBase();
//		}
//		for (Divisa divisa : lista) {
//			System.out.println("despues: " + divisa.getNombre());
//		}
//		
//		String jsonContent = "";
//		
//		try (BufferedReader reader = new BufferedReader(new FileReader("divisas.json"))){
//			String line;
//			while ((line = reader.readLine()) != null) {
//				jsonContent += line;
//			}
//			
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		Gson gson = new Gson();
//		Type listType = new TypeToken<List<Divisa>>() {}.getType();
//		lista = gson.fromJson(jsonContent, listType);
//		
//	}

	public static void agregarDivisa(String nombre, String codigo, Double valor) {
		Divisa nuevaDivisa = new Divisa(nombre, codigo, valor);
		String diaAgregado = LocalDate.now().toString();

		nuevaDivisa.setFecha(diaAgregado);

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

class test {
	public static void main(String[] args) {
		JsonDataBase.importarDataBase();

		JsonDataBase.agregarDivisa("HOLA", "JAJA", 990.9);
		JsonDataBase.guardarDataBase();
		JsonDataBase.importarDataBase();

		String[] n = JsonDataBase.getNombres();
//                System.out.println(n[7]);

	}
}
