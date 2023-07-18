package conversor.divisas;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	Monedas dolar = new Monedas("Dolar", "USD", 1.00);
    	Monedas peso = new Monedas("Peso Chileno", "CLP", 806.89);

		
		Monedas m = new Monedas("Dolar", "USD", 110.0);
		Convertidor c = new Convertidor("peso", "peso", 33.4);
		
		System.out.println(m.getValor());
		System.out.println(c.getValor());
		System.out.println(m.getValor());
		
//		System.out.println(ConvertirDivisas.convertir(110.0, dolar, peso));
	}

}
