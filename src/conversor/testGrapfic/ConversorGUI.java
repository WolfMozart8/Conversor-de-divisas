package conversor.testGrapfic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ViewportLayout;

import conversor.divisas.Divisa;
import json.exportar.JsonDataBase;

public class ConversorGUI extends JPanel{

	JButton botonConvertir = new JButton("->");
	JLabel codigo1 = new JLabel("hola");
	JLabel codigo2 = new JLabel("adios");
	JTextField textoEntrada = new JTextField();
	JTextField textoSalida = new JTextField();
	Divisa[] listaDivisas = null;
	
	public ConversorGUI() {
		// TODO Auto-generated constructor stub
		JsonDataBase.importarDataBase();
		listaDivisas = JsonDataBase.getLista();
		
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLayout(new GridLayout(3, 1));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.CYAN);
//		panel2.setLayout(new GridLayout(1, 2));
		
		JPanel panelIzq = new JPanel();
		JPanel panelDer = new JPanel();
		
		panel2.setLayout(new FlowLayout());
		
		String[] nombres1 = new String[listaDivisas.length];
		String[] nombres2 = new String[listaDivisas.length];
		
		String[] codigos1 = new String[listaDivisas.length];
		String[] codigos2 = new String[listaDivisas.length];

		
		for (int i = 0; i < listaDivisas.length; i++) {
			nombres1[i] = listaDivisas[i].getNombre();
			nombres2[i] = listaDivisas[i].getNombre();
			
			codigos1[i] = listaDivisas[i].getCodigo();
			codigos2[i] = listaDivisas[i].getCodigo();
		}
		
		JComboBox<String> listaNombres1 = new JComboBox(nombres1);
		JComboBox<String> listaNombres2 = new JComboBox(nombres2);
		
//		listaNombres1.setBounds(10, 10, 100, 200);
//		listaNombres2.setBounds(100, 140, 300, 400);
		Font font = this.getFont();
		Font newFont = font.deriveFont(font.getSize() + 10f);
		listaNombres1.setFont(newFont);
		listaNombres2.setFont(newFont);
		
		
		
		panel1.add(listaNombres1);
		panel1.add(botonConvertir);
		panel1.add(listaNombres2);
		
		
		textoEntrada.setSize(100, 120);
		panelIzq.add(codigo1);
		panelIzq.setLayout(new FlowLayout());
		textoEntrada.setSize(200, 100);
		panelIzq.setBackground(Color.red);
		
		panelIzq.add(textoEntrada);
		panel2.add(panelIzq);
		panelDer.setBackground(Color.blue);

		
		panelDer.add(textoSalida);
		panelDer.add(codigo2);
		panel2.add(panelDer);
//		setSize(400, 300);
//		setLayout(new BorderLayout());
		add(panel1);
		add(panel2);
//		add(listaNombres2);
		setVisible(true);

	}
}
