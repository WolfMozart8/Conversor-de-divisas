package conversor.testGrapfic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import conversor.divisas.ConvertirDivisas;
import conversor.divisas.Divisa;
import json.exportar.JsonDataBase;

public class TestG {
	public static void main(String[] args) {
		JsonDataBase.importarDataBase();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		DefaultListModel<String> li1 = new DefaultListModel<>();

		JButton button = new JButton();
//		JButton btn = new JButton("click");
		JTextField text1 = new JTextField();
		JTextField text2 = new JTextField();
//		JTextField text3 = new JTextField();

		Divisa[] lista = JsonDataBase.getLista();

//		for (Divisa divisa : lista) {
//			li1.addElement(divisa.getNombre());
//		}
//		JList<String> jlist = new JList<>(li1);

		String[] nombres1 = new String[lista.length];
		String[] nombres2 = new String[lista.length];

		for (int i = 0; i < lista.length; i++) {
			nombres1[i] = lista[i].getNombre();
			nombres2[i] = lista[i].getNombre();
		}

		JComboBox<String> jc1 = new JComboBox(nombres1);
		JComboBox<String> jc2 = new JComboBox(nombres2);

//		text1.setText("");

		text1.setBounds(30, 30, 100, 50);
		text1.setFont(null);
		text2.setBounds(170, 30, 100, 50);
//		text3.setBounds(80, 100, 100, 50);
		jc1.setBounds(40, 100, 100, 50);
		jc2.setBounds(140, 100, 100, 50);
//		jlist.setBounds(120, 150, 100, 50);
		button.setBounds(100, 200, 100, 50);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

				if (isNumeroValido(text1.getText(), text2)) {
					
					Double valor = Double.parseDouble(text1.getText());
					
					// TODO Auto-generated method stub
					
					Divisa divisa1 = lista[jc1.getSelectedIndex()];
					Divisa divisa2 = lista[jc2.getSelectedIndex()];
					
					text2.setText(ConvertirDivisas.convertir(valor, divisa1, divisa2).toString());
				}
				

			}
		});



		frame.add(text1);
		frame.add(text2);
		frame.add(jc1);
		frame.add(jc2);
//		frame.add(jlist);
//		frame.add(text3);
		frame.add(button);

		frame.setBounds(200, 200, 400, 400);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	
	/**
	 * Verifica si el texto del JTextField de entrada es valido para ser convertido a Double
	 * 
	 * @param textField JTextField que será validado
	 * @param textOutput JTextField de salida, el cual se vaciará en caso de no ser Inválido
	 * @return
	 */
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
}
