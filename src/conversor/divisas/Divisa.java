package conversor.divisas;

import java.math.BigDecimal;

public class Divisa {

	
	private String nombre;		// dolar
	private String codigo;		// USD
	private BigDecimal valor;	// 1.00
	
	public Divisa(String currency, String code, Double value) {
		this.nombre = currency;
		this.codigo = code;
		this.valor = new BigDecimal(value.toString());
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = new BigDecimal(valor.toString());
//		this.valor = valor;
	}
	
	
}
