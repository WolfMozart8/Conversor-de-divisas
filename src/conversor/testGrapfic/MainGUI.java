package conversor.testGrapfic;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainGUI extends JFrame{
	
	public MainGUI() {
		// TODO Auto-generated constructor stub
		ConversorGUI conversorDivisasPanel = new ConversorGUI();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
//		setLayout(new BorderLayout());

		add(conversorDivisasPanel);
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			new MainGUI();
		});
//		JFrame GUI = new MainGUI();
//		JPanel conversorDivisasPanel = new ConversorGUI();
//		GUI.add(conversorDivisasPanel);
	}
}
