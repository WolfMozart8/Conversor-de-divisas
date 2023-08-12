package conversor.InterfazGrafica;

import javax.swing.SwingUtilities;

/**
 * Inicia aplicación
 * @author Felipe Rios
 *
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			InterfazSwing interfaz = new InterfazSwing();
			interfaz.setVisible(true);
		});
	}
}
