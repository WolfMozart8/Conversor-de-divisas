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

    public InterfazSwing() {

		JsonDataBase.importarDataBase();
		listaDivisas = JsonDataBase.getLista();
    	
        // Configuración de la ventana principal
        setTitle("Ejemplo Java Swing");
        setSize(400, 200);
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
        JButton button = new JButton("Botón");
        JComboBox<String> comboBox2 = new JComboBox<>(nombres2);


        // Componentes para la parte inferior
        JLabel label1 = new JLabel("USD");
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JLabel label2 = new JLabel("USD");
        
        comboBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBox1.getSelectedIndex();
				String cod = codigos1[index];
				label1.setText(cod);
				
			}
		});
        
        comboBox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBox2.getSelectedIndex();
				String cod = codigos2[index];
				label2.setText(cod);
				
			}
		});
        
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

				if (isNumeroValido(textField1.getText(), textField2)) {
					
					Double valor = Double.parseDouble(textField1.getText());
					
					// TODO Auto-generated method stub
					
					Divisa divisa1 = listaDivisas[comboBox1.getSelectedIndex()];
					Divisa divisa2 = listaDivisas[comboBox2.getSelectedIndex()];
					
					textField2.setText(ConvertirDivisas.convertir(valor, divisa1, divisa2).toString());
				}
				

			}
		});

        // Panel para la parte superior
        JPanel panelArriba = new JPanel();
        panelArriba.add(comboBox1);
        panelArriba.add(button);
        panelArriba.add(comboBox2);

        // Panel para la parte inferior
        JPanel panelCentro = new JPanel();
        panelCentro.add(label1);
        panelCentro.add(textField1);
        panelCentro.add(textField2);
        panelCentro.add(label2);

        // Agregar paneles a la ventana principal
        add(panelArriba, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
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
