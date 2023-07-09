package json.exportar;

import java.io.BufferedReader;
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

	private static List<Divisa> lista = new ArrayList<>();

	private static void crearDataBase() {
		Divisa dolar = new Divisa("Dolar", "USD", 1.00);
		Divisa euro = new Divisa("Euro", "EUR", 0.91);
		Divisa libras = new Divisa("Libras", "PND", 0.78);
		Divisa yen = new Divisa("Yen japones", "YEN", 142.12);
		Divisa won = new Divisa("Won sud-coreano", "WON", 1298.66);
		Divisa pesoChileno = new Divisa("Peso Chileno", "CLP", 806.89);
		Divisa pesoArgentino = new Divisa("peso Argentino", "ARG", 260.77);

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
//		String json = gson.toJson(lista);

		try (FileWriter fileWriter = new FileWriter("gson.json")) {
			gson.toJson(lista, fileWriter);
			System.out.println("Objetos Divisa convertidos a JSON y guardados en el archivo 'divisas.json'.");

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void importarDataBase() {
		if (lista.isEmpty()) {
			lista.isEmpty();
			lista.size();
			crearDataBase();
		}
		
		String jsonContent = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader("gson.json"))){
			String line;
			while ((line = reader.readLine()) != null) {
				jsonContent += line;
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Divisa>>() {}.getType();
		List<Divisa> listaDivisas = gson.fromJson(jsonContent, listType);
		
		 for (Divisa divisa : listaDivisas) {
	            System.out.println("Nombre: " + divisa.getNombre());
	            System.out.println("Código: " + divisa.getCodigo());
	            System.out.println("Valor: " + divisa.getValor());
	            System.out.println("-------------------------");
	        }
		
	}
	
	public static void agregarDivisa(String nombre, String codigo, Double valor) {
		Divisa nuevaDivisa = new Divisa(nombre, codigo, valor);
		
		lista.add(nuevaDivisa);
	}

}

class test {
	public static void main(String[] args) {
		JsonDataBase.agregarDivisa("HOLA", "JAJA", 990.9);
		JsonDataBase.guardarDataBase();
		JsonDataBase.importarDataBase();
		
	}
}
