package conversor.divisas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Divisa {

								// ejemplo:
	private String nombre;		// Dólar
	private String codigo;		// USD
	private BigDecimal valor;	// 1.00 (Valor equivalente a 1 dolar)
	private String fecha;		// fecha actualizacion
	
	/**
	 * Crea una nueva divisa.
	 * @param nombre	(Ej: Euro)
	 * @param codigo	(Ej: EUR)
	 * @param valor		Valor equivalente a 1 dólar (Ej: CLP = 853.21)
	 */
	public Divisa(String nombre, String codigo, Double valor) {
		this.nombre = nombre;
		this.codigo = codigo;
		
		// fecha actual por defecto
		this.valor = new BigDecimal(valor);
		
		this.fecha = LocalDate.now().toString();
		
	}
	
	/**
	 * Constructor para crear con una fecha perzonalizada
	 * @param nombre
	 * @param codigo
	 * @param valor
	 * @param fecha
	 */
	public Divisa(String nombre, String codigo, Double valor, int[] fecha) {
		this(nombre, codigo, valor);
		this.fecha = LocalDate.of(fecha[0], fecha[1], fecha[2]).toString();
	}


	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
//		LocalDate nuevaFecha = LocalDate.parse(fecha);
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
	public String getValorString() {
		return String.valueOf(valor.setScale(2, RoundingMode.HALF_UP));
	}

	public void setValor(Double valor) {
		this.valor = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
	}
	
	
}
