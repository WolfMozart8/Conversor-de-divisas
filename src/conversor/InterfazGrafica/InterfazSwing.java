package conversor.InterfazGrafica;

import javax.swing.*;

import conversor.divisas.ConvertirDivisas;
import conversor.divisas.Divisa;
import json.JsonDataBase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazSwing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Divisa[] divisas = null;
	JComboBox<String> listaDivisas1 = new JComboBox<>();
	JComboBox<String> listaDivisas2 = new JComboBox<>();
	
	Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	Font fontMid = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	Font fontBig = new Font(Font.SANS_SERIF, Font.PLAIN, 30);

	Divisa activo1;
	Divisa activo2;

	public InterfazSwing() {
        Color primaryColor = new Color(46, 134, 193);
        Color backgroundColor = new Color(230, 230, 230);
        
		JsonDataBase.importarDataBase();
		divisas = JsonDataBase.getLista();
		activo1 = divisas[0];
		activo2 = divisas[1];

		
		// Configuración de la ventana principal
		setTitle("Conversor de divisas");
		setSize(600, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		
		
		resetLista();


		// Componentes para la parte superior
		Character letra = '\u21C4';
		JButton botonSwap = new JButton(letra.toString());
		botonSwap.setForeground(primaryColor);
		botonSwap.setBackground(backgroundColor);
		botonSwap.setFont(fontMid);
		listaDivisas2.setSelectedIndex(1);


		// Panel para la parte superior
		JPanel panelArriba = new JPanel();
		panelArriba.add(listaDivisas1);
		panelArriba.add(botonSwap);
		panelArriba.add(listaDivisas2);
		
		listaDivisas1.setBackground(backgroundColor);
		listaDivisas2.setBackground(backgroundColor);
		listaDivisas1.setFont(font);
		listaDivisas2.setFont(font);

		// Panel para la parte inferior
		JPanel panelCentro = new JPanel(new GridLayout(2, 3, 5, 5));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

		// Establecer el tamaño de fuente grande para los JLabel
		JLabel codigo1 = new JLabel(activo1.getCodigo());
		codigo1.setFont(fontBig);
		codigo1.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
		codigo1.setVerticalAlignment(SwingConstants.CENTER); // Centrar texto verticalmente

		JLabel codigo2 = new JLabel(activo2.getCodigo());
		codigo2.setFont(fontBig);
		codigo2.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto horizontalmente
		codigo2.setVerticalAlignment(SwingConstants.CENTER); // Centrar texto verticalmente

		JButton botonConvertir = new JButton("Botón");
		botonConvertir.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		Character arrow = '\u2794';
		botonConvertir.setForeground(primaryColor);
		botonConvertir.setBackground(backgroundColor);
		botonConvertir.setText(arrow.toString());

		JTextField valor1 = new JTextField(10);
		JTextField valor2 = new JTextField(10);
		valor1.setFont(fontBig);
		valor2.setFont(fontBig);
		valor1.setText("1.0");
		valor2.setText("0");
		valor1.setHorizontalAlignment(SwingConstants.LEFT);
		valor2.setEditable(false);
		valor2.setHorizontalAlignment(SwingConstants.RIGHT);

		// Agregar componentes al panelCentro
		panelCentro.add(codigo1);
		panelCentro.add(new JLabel()); // Espacio en blanco para separar
		panelCentro.add(codigo2);

		panelCentro.add(valor1);
		panelCentro.add(botonConvertir); // Espacio en blanco para separar
		panelCentro.add(valor2);

		
		
		
		JRootPane root = getRootPane();

		// Crear una barra de menú
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Editar");
		bar.add(menu);

		// Agregar el ActionListener al elemento "Agregar"
		JMenuItem eritarDivisas = new JMenuItem("Divisas");
		eritarDivisas.addActionListener(e -> {
		VentanaTabla ventanaEditar = new VentanaTabla(this);
		ventanaEditar.setVisible(true);
		});
		menu.add(eritarDivisas);

//		menu.add("Editar");
//		menu.add("Modificar");
		root.setJMenuBar(bar);

		
		
		
		
		
		// Panel para la parte inferior
		JPanel panelAbajo = new JPanel(new GridLayout(2, 2));
		int margenInferior = 10;
		panelAbajo.setBorder(BorderFactory.createEmptyBorder(0, 0, margenInferior, 0));
		JLabel fechaAct1 = new JLabel("Última actualización:", SwingConstants.CENTER);
		JLabel fechaAct2 = new JLabel("Última actualización:", SwingConstants.CENTER);
		fechaAct1.setFont(font);
		fechaAct2.setFont(font);
		JLabel fecha1 = new JLabel(activo1.getFecha(), SwingConstants.CENTER);
		JLabel fecha2 = new JLabel(activo2.getFecha(), SwingConstants.CENTER);
		fecha1.setFont(font);
		fecha2.setFont(font);
		panelAbajo.add(fechaAct1);
		panelAbajo.add(fechaAct2);
		panelAbajo.add(fecha1);
		panelAbajo.add(fecha2);

		// Agregar paneles a la ventana principal
		add(panelArriba, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelAbajo, BorderLayout.SOUTH);

		/**
		 * Cambia el texto del codigo y la fecha de la divisa seleccionada
		 */
		listaDivisas1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int index = listaDivisas1.getSelectedIndex();
					activo1 = divisas[index];
					codigo1.setText(activo1.getCodigo());
					fecha1.setText(activo1.getFecha());
				} catch (ArrayIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});

		/**
		 * Cambia el texto del codigo y la fecha de la divisa seleccionada
		 */
		listaDivisas2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int index = listaDivisas2.getSelectedIndex();
					activo2 = divisas[index];
					codigo2.setText(activo2.getCodigo());
					fecha2.setText(activo2.getFecha());
				} catch (ArrayIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		botonConvertir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isNumeroValido(valor1.getText(), valor2)) {

					Double valor = Double.parseDouble(valor1.getText());

					// TODO Auto-generated method stub

//					Divisa divisa1 = listaDivisas[comboBox1.getSelectedIndex()];
//					Divisa divisa2 = listaDivisas[comboBox2.getSelectedIndex()];

					valor2.setText(ConvertirDivisas.convertir(valor, activo1, activo2).toString());
				}

			}
		});

		botonSwap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Divisa ac1 = activo1;

				activo1 = activo2;
				activo2 = ac1;

				Cambiar(activo1, codigo1);
				Cambiar(activo2, codigo2);

				int sel1 = listaDivisas1.getSelectedIndex();
				int sel2 = listaDivisas2.getSelectedIndex();

				listaDivisas1.setSelectedIndex(sel2);
				listaDivisas2.setSelectedIndex(sel1);

				String num = valor2.getText();
				valor1.setText(num);

				if (isNumeroValido(valor1.getText(), valor2)) {

					Double valor = Double.parseDouble(valor1.getText());



					valor2.setText(ConvertirDivisas.convertir(valor, activo1, activo2).toString());
				}
			}
		});

	}

	private static void Cambiar(Divisa act, JLabel label) {
		label.setText(act.getCodigo());
	}

	/**
	 * Verifica si el numer ingresado es valido para ser convertido
	 * @param textInput El valor debe ser un string de números
	 * @param textOutput Donde se mostrará la salida
	 * @return Retorna Si el string (textIInput) es válido o no
	 */
	private static boolean isNumeroValido(String textInput, JTextField textOutput) {
		try {
			Double.parseDouble(textInput);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("el texto no es valido");
			JOptionPane j = new JOptionPane();

			// test
//			test

			j.setVisible(true);
			JOptionPane.showMessageDialog(j, "Ingrese un número válido", "error", JOptionPane.WARNING_MESSAGE);

			textOutput.setText("");
			return false;
		}
	}

	
	/**
	 * Reinicia los items de los JComboBox
	 */
	public void resetLista() {
//		JsonDataBase.guardarDataBase();
//		JsonDataBase.importarDataBase();
		
		
		listaDivisas1.removeAllItems();
		listaDivisas2.removeAllItems();
		this.divisas = JsonDataBase.getLista();
		
		String[] nombres1 = new String[divisas.length];
		String[] nombres2 = new String[divisas.length];

//		String[] codigos1 = new String[listaDivisas.length];
//		String[] codigos2 = new String[listaDivisas.length];

		for (int i = 0; i < divisas.length; i++) {
			nombres1[i] = divisas[i].getNombre();
			nombres2[i] = divisas[i].getNombre();

			
//			codigos1[i] = listaDivisas[i].getCodigo();
//			codigos2[i] = listaDivisas[i].getCodigo();
			listaDivisas1.addItem(nombres1[i]);
			listaDivisas2.addItem(nombres2[i]);
		}
		
		listaDivisas1.setSelectedIndex(1);
		listaDivisas2.setSelectedIndex(2);
	}

}
