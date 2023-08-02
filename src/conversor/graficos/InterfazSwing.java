package conversor.graficos;

import javax.swing.*;

import conversor.divisas.ConvertirDivisas;
import conversor.divisas.Divisa;
import json.exportar.JsonDataBase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazSwing extends JFrame {
	Divisa[] listaDivisas = null;
	Divisa activo1;
	Divisa activo2;


	public InterfazSwing() {

		JsonDataBase.importarDataBase();
		listaDivisas = JsonDataBase.getLista();
		activo1 = listaDivisas[0];
		activo2 = listaDivisas[1];

		Font font = new Font("Arial", Font.BOLD, 16);

		// Configuración de la ventana principal
		setTitle("Conversor de divisas");
		setSize(400, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

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

		// Componentes para la parte superior
		JComboBox<String> comboBox1 = new JComboBox<>(nombres1);
		Character letra = '\u21C4';
		JButton button = new JButton(letra.toString());
		button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		JComboBox<String> comboBox2 = new JComboBox<>(nombres2);
		comboBox2.setSelectedIndex(1);

		// Componentes para la parte inferior
//        JLabel label1 = new JLabel("USD");
//        JTextField textField1 = new JTextField(10);
//        JTextField textField2 = new JTextField(10);
//        JLabel label2 = new JLabel("USD");

		// Panel para la parte superior
		JPanel panelArriba = new JPanel();
		panelArriba.add(comboBox1);
		panelArriba.add(button);
		panelArriba.add(comboBox2);

		// Panel para la parte inferior
		JPanel panelCentro = new JPanel(new GridLayout(2, 3, 5, 5));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

		// Establecer el tamaño de fuente grande para los JLabel
		JLabel label1 = new JLabel(activo1.getCodigo());
		label1.setFont(font);
		label1.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
		label1.setVerticalAlignment(SwingConstants.CENTER); // Centrar texto verticalmente

		JLabel label2 = new JLabel(activo2.getCodigo());
		label2.setFont(font);
		label2.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
		label2.setVerticalAlignment(SwingConstants.CENTER); // Centrar texto verticalmente

		JButton boton = new JButton("Botón");
		boton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30)); 
		Character arrow = '\u2794';
		boton.setText(arrow.toString());
//   boton.setPreferredSize(new Dimension(50, 30));

		JTextField textField1 = new JTextField(10);
		JTextField textField2 = new JTextField(10);
		textField1.setFont(font);
		textField2.setFont(font);
		textField1.setText("1.0");
		textField2.setText("0");
		textField2.setEditable(false);
		textField2.setHorizontalAlignment(SwingConstants.RIGHT);

		// Agregar componentes al panelCentro
		panelCentro.add(label1);
		panelCentro.add(new JLabel()); // Espacio en blanco para separar
		panelCentro.add(label2);

		panelCentro.add(textField1);
		panelCentro.add(boton); // Espacio en blanco para separar
		panelCentro.add(textField2);

//        JPanel panelCentro = new JPanel(new GridBagLayout());
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre los componentes
//
//        // Establecer el tamaño de fuente grande para los JLabel
//        JLabel label1 = new JLabel("USD");
//        label1.setFont(font);
//        label1.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
//        label1.setVerticalAlignment(SwingConstants.CENTER); // Centrar texto verticalmente
//
//        JLabel label2 = new JLabel("USD");
//        label2.setFont(font);
//        label2.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
//        label2.setVerticalAlignment(SwingConstants.CENTER); // Centrar texto verticalmente
//        
//        JButton boton = new JButton("Botón");
//        JButton boton2 = new JButton("Bot");
//
//        JTextField textField1 = new JTextField(10);
//        JTextField textField2 = new JTextField(10);
//        
//        textField1.setFont(font);
//        textField2.setFont(font);
//        textField1.setText("1.0");
//        textField2.setEditable(false);
//        textField2.setHorizontalAlignment(SwingConstants.RIGHT);
//        
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.CENTER; // Alineación izquierda
////        gbc.fill = gbc.HORIZONTAL;
//        panelCentro.add(label1, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        panelCentro.add(textField1, gbc);
//        
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        panelCentro.add(boton, gbc); 
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        panelCentro.add(Box.createGlue(), gbc); 
//
//        gbc.gridx = 2;
//        gbc.gridy = 0;
//        panelCentro.add(label2, gbc);
//
//        
//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        
//        panelCentro.add(textField2, gbc);

//        JPanel panelCentro = new JPanel();
//        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.X_AXIS));
//        panelCentro.setPreferredSize(new Dimension(300, 100));
//        panelCentro.add(Box.createHorizontalGlue()); // Espacio horizontal para centrar
//        panelCentro.add(label1);
//        panelCentro.add(textField1);
//        panelCentro.add(textField2);
//        panelCentro.add(label2);
//        panelCentro.add(Box.createHorizontalGlue()); // Espacio horizontal para centrar

		// Panel para la parte inferior
		JPanel panelAbajo = new JPanel(new GridLayout(2, 2));
		int margenInferior = 10;
		panelAbajo.setBorder(BorderFactory.createEmptyBorder(0, 0, margenInferior, 0));
		JLabel labelA1 = new JLabel("Etiqueta 1A", SwingConstants.CENTER);
		JLabel labelA2 = new JLabel("Etiqueta 1B", SwingConstants.CENTER);
		JLabel labelB1 = new JLabel("Etiqueta 2A", SwingConstants.CENTER);
		JLabel labelB2 = new JLabel("Etiqueta 2B", SwingConstants.CENTER);
		panelAbajo.add(labelA1);
		panelAbajo.add(labelA2);
		panelAbajo.add(labelB1);
		panelAbajo.add(labelB2);

		// Agregar paneles a la ventana principal
		add(panelArriba, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelAbajo, BorderLayout.SOUTH);

		comboBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBox1.getSelectedIndex();
				activo1 = listaDivisas[index];
				String cod = codigos1[index];
				label1.setText(cod);

			}
		});

		comboBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBox2.getSelectedIndex();
				activo2 = listaDivisas[index];
				String cod = codigos2[index];
				label2.setText(activo2.getCodigo());

			}
		});

		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isNumeroValido(textField1.getText(), textField2)) {

					Double valor = Double.parseDouble(textField1.getText());

					// TODO Auto-generated method stub

//					Divisa divisa1 = listaDivisas[comboBox1.getSelectedIndex()];
//					Divisa divisa2 = listaDivisas[comboBox2.getSelectedIndex()];

					textField2.setText(ConvertirDivisas.convertir(valor, activo1, activo2).toString());
				}

			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Divisa ac1 = activo1;
				
				activo1 = activo2;
				activo2 = ac1;
				
				Cambiar(activo1, label1);
				Cambiar(activo2, label2);
				
				int sel1 = comboBox1.getSelectedIndex();
				int sel2 = comboBox2.getSelectedIndex();
				
				comboBox1.setSelectedIndex(sel2);
				comboBox2.setSelectedIndex(sel1);
				
				String num = textField2.getText();
				textField1.setText(num);
				
				if (isNumeroValido(textField1.getText(), textField2)) {

					Double valor = Double.parseDouble(textField1.getText());

					// TODO Auto-generated method stub

//					Divisa divisa1 = listaDivisas[comboBox1.getSelectedIndex()];
//					Divisa divisa2 = listaDivisas[comboBox2.getSelectedIndex()];

					textField2.setText(ConvertirDivisas.convertir(valor, activo1, activo2).toString());
				}
			}
		});

		
	}
	
	private static void Cambiar(Divisa act, JLabel label) {
		label.setText(act.getCodigo());
	}

	private static boolean isNumeroValido(String textInput, JTextField textOutput) {
		try {
			Double.parseDouble(textInput);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("el texto no es valido");
			textOutput.setText("");
			return false;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			InterfazSwing interfaz = new InterfazSwing();
			interfaz.setVisible(true);
		});
	}
}
