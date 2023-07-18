package conversor.divisas;

//import java.math.BigDecimal;

public class Convertidor {

	
	private String nombre;		// dolar
	private String codigo;		// USD
	private Number valor;	// 1.00
	
	
	public Convertidor(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	public Convertidor(String nombre, String codigo, Double valor) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.valor = valor;
//		this.valor = new BigDecimal(value.toString());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Number getValor() {
		return (Double)valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

//	public void setValor(Double valor) {
//		this.valor = new BigDecimal(valor.toString());
////		this.valor = valor;
//	}
	
	
}
