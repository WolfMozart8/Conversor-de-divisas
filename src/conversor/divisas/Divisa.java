package conversor.divisas;

public class Divisa extends DivisaBase {

	public Divisa(String currency, String code, Double value) {
		super(currency, code, value);
		// TODO Auto-generated constructor stub
	}
	
	public void cambiarNombre (String nombre) {
		super.setNombre(nombre);
	}

}
