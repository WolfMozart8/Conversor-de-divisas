package conversor.divisas;

import java.math.BigDecimal;

public class Monedas extends Convertidor {
	
	private BigDecimal valor;

	public Monedas(String nombre, String codigo, Double valor) {
		super(nombre, codigo);
		this.valor = new BigDecimal(valor.toString());
	}

	@Override
	public BigDecimal getValor() {
//		BigDecimal nuevoValor = new BigDecimal(valor.toString());
		return valor;
	}

	@Override
	public void setValor(Double valor) {
		this.valor = new BigDecimal(valor.toString());
	}
	
}
