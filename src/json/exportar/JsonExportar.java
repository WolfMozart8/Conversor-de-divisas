package json.exportar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import conversor.divisas.Divisa;

public class JsonExportar {
	private static String filePath = "divisas.json";
//	private String json = "";
	private static List<Divisa> listaDeDivisas = new ArrayList();

	public static void guardar() {
		String json = "[\n";
		int index = 0;
		int size = listaDeDivisas.size();
		
		for (Divisa divisa : listaDeDivisas) {

			String jsonFormat = "{\"nombre\":\"" + divisa.getNombre() + "\",\"codigo\":\"" + divisa.getCodigo()
					+ "\",\"valor\":" + divisa.getValor() + "}";

//    		System.out.println(jsonFormat);
			json += jsonFormat;
			if (index != (size - 1)) { // si no es ultimo le agrega ","
    			json += ",";
    		}
			json += "\n";
    		index++;
		}
		json += "]";

//		FileWriter fileWriter = null;
		try (FileWriter fileWriter = new FileWriter(filePath)){
//			fileWriter = new FileWriter(filePath);
			fileWriter.write(json);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		System.out.println(json);
	}
	
	
	private static void create ( ) {
		Divisa dolar = new Divisa("Dolar", "USD", 1.00);
    	Divisa euro = new Divisa("Euro", "EUR", 0.91);
    	Divisa libras = new Divisa("Libras", "PND", 0.78);
    	Divisa yen = new Divisa("Yen japones", "YEN", 142.12);
    	Divisa won = new Divisa("Won sud-coreano", "WON", 1298.66);
    	Divisa pesoChileno = new Divisa("Peso Chileno", "CLP", 806.89);
    	Divisa pesoArgentino = new Divisa("peso Argentino", "ARG", 260.77);
    	
    	listaDeDivisas.add(dolar);
    	listaDeDivisas.add(euro);
    	listaDeDivisas.add(libras);
    	listaDeDivisas.add(yen);
    	listaDeDivisas.add(dolar);
    	listaDeDivisas.add(won);
    	listaDeDivisas.add(pesoChileno);
    	listaDeDivisas.add(pesoArgentino);
    	
    	guardar();
	}
	
	public static void importar () {
		if (listaDeDivisas.isEmpty()) {
			create();
		}
		
		List<Divisa> lista = new ArrayList();
		
		StringBuilder jsonContent = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
//                System.out.println("antes");
                System.out.println(line);
//                System.out.println("despues");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
//		System.out.println(jsonContent);
	}

}
