package conversor.divisas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ConvertirDivisas {

	public static BigDecimal convertir(Double valor, Divisa divisa1, Divisa divisa2) {
		BigDecimal valorBigDecimal = new BigDecimal(valor.toString());
		
		if (divisa1.equals(divisa2)) {
			return divisa1.getValor().multiply(valorBigDecimal);
		}
		
		MathContext mc = new MathContext(8, RoundingMode.HALF_UP);
		boolean esDolar = divisa1.getCodigo() == "USD" | divisa2.getCodigo() == "USD";


		if (esDolar) {
//			division = divisa1.getValor().divide(divisa2.getValor(), mc);
//			return resultadoDolar(valor, divisa1, divisa2);
			BigDecimal resultado = divisa1.getValor().multiply(divisa2.getValor()).multiply(valorBigDecimal);
			return resultado.setScale(2, RoundingMode.HALF_UP);
		} else {

			BigDecimal division = divisa2.getValor().divide(divisa1.getValor(), mc);
			BigDecimal resultado = valorBigDecimal.multiply(division).setScale(2, RoundingMode.HALF_UP);

			return resultado;
		}

	}

//	private static BigDecimal resultadoDolar(Double valor, Divisa divisa1, Divisa divisa2) {
//		// TODO Auto-generated method stub
//		BigDecimal resultado = divisa1.getValor().multiply(divisa2.getValor()).multiply(valorBigDecimal);
//		return resultado.setScale(2, RoundingMode.HALF_UP);
//	}
}
