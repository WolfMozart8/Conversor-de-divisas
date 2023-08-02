package conversor.divisas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Divisa {

	
	private String nombre;		// dolar
	private String codigo;		// USD
	private BigDecimal valor;	// 1.00
//	private LocalDate fecha = null;
	private String fecha;
	
	
	public Divisa(String currency, String code, Double value) {
		this.nombre = currency;
		this.codigo = code;
		this.valor = new BigDecimal(value.toString());
		
	}
	public Divisa(String currency, String code, Double value, int[] fecha) {
		this(currency, code, value);
		this.fecha = LocalDate.of(fecha[0], fecha[1], fecha[2]).toString();
	}


	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
