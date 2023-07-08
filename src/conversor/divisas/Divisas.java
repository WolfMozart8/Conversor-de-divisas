package conversor.divisas;

public class Divisas {
//	private static final double TIPO_CAMBIO_DOLAR = 1.0;
    private static final double TIPO_CAMBIO_PESO_CHILENO = 804.3;
    private static final double TIPO_CAMBIO_PESO_ARGENTINO = 260.38;

    public static double convertirDolaresAPesosChilenos(double dolares) {
        return dolares * TIPO_CAMBIO_PESO_CHILENO;
    }

    public static double convertirPesosChilenosADolares(double pesosChilenos) {
        return pesosChilenos / TIPO_CAMBIO_PESO_CHILENO;
    }

    public static double convertirPesosArgentinosADolares(double pesosArgentinos) {
        return pesosArgentinos / TIPO_CAMBIO_PESO_ARGENTINO;
    }
    public static double convertirDolaresAPesosArgentinos(double dolares) {
        return dolares * TIPO_CAMBIO_PESO_ARGENTINO;
    }
//    806.89
//    142.11
    public static double convertirPesosChilenosAPesosArgentinos(double pesosChilenos) {
        return pesosChilenos * (TIPO_CAMBIO_PESO_ARGENTINO / TIPO_CAMBIO_PESO_CHILENO);
    }
}
