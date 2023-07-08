package conversor.divisas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
//        double dolares = 20.0;
//        double pesosChilenos = 1400.0;
//
//        double resultadoPesosChilenos = Divisas.convertirDolaresAPesosChilenos(dolares);
//        double resultadoDolares = Divisas.convertirPesosChilenosADolares(pesosChilenos);
//        double resultadoPesosArgentinos = Divisas.convertirPesosChilenosAPesosArgentinos(pesosChilenos);
//
//        System.out.println(dolares + " dólares equivale a " + resultadoPesosChilenos + " pesos chilenos");
//        System.out.println(pesosChilenos + " pesos chilenos equivale a " + resultadoDolares + " dólares");
//        System.out.println(pesosChilenos + " pesos chilenos equivale a " + resultadoPesosArgentinos + " pesos argentinos");
//        
//        Interfaz_principal app = new Interfaz_principal();
//    	Scanner scanner = new Scanner(System.in);
//    	String usuario = scanner.nextLine();
//  
//    	System.out.println("usuaio es: " + usuario);
    	
    	List<Divisa> lista = new ArrayList();
    	
    	Divisa dolar = new Divisa("Dolár", "USD", 1.00);
    	Divisa pesoChileno = new Divisa("Peso Chileno", "CLP", 806.89);
    	Divisa pesoArgentino = new Divisa("peso Argentino", "PES", 260.77);
    	
    	lista.add(dolar);
    	lista.add(pesoChileno);
//    	dolar.setNombre("hola");
//    	dolar.setValor(23.0);
    	
    	for (Divisa divisa : lista) {
			System.out.println(divisa.getValor());
		}
    	
    	

//    	BigDecimal value1 = new BigDecimal("200.45");
//    	BigDecimal value2 = new BigDecimal("200.45");
//    	BigDecimal value3 = value1.multiply(value2);
//    	BigDecimal value4 = value3.setScale(2, RoundingMode.HALF_UP);
//    	
//    	System.out.println("value 1: " + value1);
//    	System.out.println("value 2: " + value2);
//    	System.out.println("value 3: " + value3);
//    	System.out.println("value 4: " + value4);
        
//    	Double d = 20.3;
//    	BigDecimal bd = new BigDecimal(d.toString());
//    	System.out.println(bd);
//    	System.out.println(pesoChileno.getValor().compareTo(dolar.getValor()));
    	
//    	System.out.println(ConvertirDivisas.convertir(300.20, dolar, pesoChileno));
//    	105401.55
//    	105,205.075
    	
    	System.out.println(ConvertirDivisas.convertir(44572.2, pesoArgentino, pesoChileno));
    }
}
