package conversor.InterfazGrafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import conversor.divisas.Divisa;
import json.JsonDataBase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class VentanaTabla extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton, modifyButton, deleteButton ;
    
    Divisa[] listaDivisas = null;

    public VentanaTabla(InterfazSwing interfazSwing) {
    	// cargar base de datos
    	JsonDataBase.importarDataBase();
		listaDivisas = JsonDataBase.getLista();
		
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setTitle("Tabla de Divisas");

        // Crear el modelo de la tabla con columnas
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Código");
        tableModel.addColumn("Valor (=1 USD)");
        tableModel.addColumn("Última Actualización valor");
        
        resetTable();

        // Crear la tabla con el modelo
        table = new JTable(tableModel);

        
        
        // Crear los botones
        addButton = new JButton("Agregar");
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addButton.setMargin(new Insets(5, 10, 5, 10)); // Agregar margen a los lados

        modifyButton = new JButton("Modificar");
        modifyButton.setMargin(new Insets(5, 10, 5, 10)); // Agregar margen a los lados

        deleteButton = new JButton("Eliminar");
        deleteButton.setMargin(new Insets(5, 10, 5, 10)); // Agregar margen a los lados

//        applyButton = new JButton("Aplicar");
//        cancelButton = new JButton("Cancelar");

        // Crear el panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
//        buttonPanel.add(applyButton);
//        buttonPanel.add(cancelButton);
        
        
        

        // ActionListener de los botones
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar una nueva fila a la tabla
            	ventanaAgregar(interfazSwing);

            	
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar una fila seleccionada en la tabla
            	int seleccionado = table.getSelectedRow();
            	
//            	JsonDataBase.getDivisa(seleccionado);
            	if (seleccionado == -1) {
            		JOptionPane.showMessageDialog(VentanaTabla.this , "Por favor seleccione un elemnto");
            	}
            	else {
            	String nombre = table.getValueAt(seleccionado, 0).toString();
            	String codigo = table.getValueAt(seleccionado, 1).toString();
            	String valorString = table.getValueAt(seleccionado, 2).toString();
            	
            	JsonDataBase.lista.get(seleccionado).setNombre(nombre);
            	JsonDataBase.lista.get(seleccionado).setCodigo(codigo);
            	
            	if (!JsonDataBase.lista.get(seleccionado).getValorString().equals(valorString)) {
            		Double valor = Double.valueOf(valorString);
            		
            		JsonDataBase.lista.get(seleccionado).setValor(valor);
            		
            		String fechaActual = LocalDate.now().toString();
            		
            		JsonDataBase.lista.get(seleccionado).setFecha(fechaActual);
            	}

            	
            	JOptionPane.showMessageDialog(VentanaTabla.this , "El item seleccionado se ha modificado exitosamente");
            	resetTable();
            	interfazSwing.resetLista();
            	
            	
            	}
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar una fila seleccionada de la tabla
            	int seleccionado = table.getSelectedRow();

            	if (seleccionado == -1) {
            		JOptionPane.showMessageDialog(VentanaTabla.this , "Por favor seleccione un elemnto");
            	}
            	else {
            	Mensaje(
            			"Lista modificada", 
            			"eliminado",
            			seleccionado);
            	
            	JsonDataBase.lista.remove(seleccionado);
            	resetTable();
            	interfazSwing.resetLista();

            	}
            }
        });


        // Agregar componentes al marco
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void ventanaAgregar(InterfazSwing interfazSwing) {
    	JTextField nombreField, codigoField, valorField;
        JButton addButton;

		JFrame dialog = new JFrame();
		dialog.setLayout(new GridLayout(4, 2, 10, 10));
		dialog.setSize(200, 150);
		
		nombreField = new JTextField();
        codigoField = new JTextField();
        valorField = new JTextField();
        addButton = new JButton("Agregar");

        dialog.add(new JLabel("Nombre:"));
        dialog.add(nombreField);
        dialog.add(new JLabel("Código:"));
        dialog.add(codigoField);
        dialog.add(new JLabel("Valor (= 1 USD):"));
        dialog.add(valorField);
        dialog.add(new JLabel()); // Espacio en blanco
        dialog.add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = nombreField.getText();
				String codigo = codigoField.getText();
				Double valor = Double.parseDouble(valorField.getText());
				
//				Divisa nueva = new Divisa(nombreD, codD, val);			
				JsonDataBase.agregarDivisa(nombre, codigo, valor);
				JsonDataBase.guardarDataBase();
				resetTable();
				
				System.out.println(JsonDataBase.lista.size());
				interfazSwing.resetLista();
				}
		});
		
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}
    
    public void resetTable () {
    	tableModel.setRowCount(0);
    	JsonDataBase.guardarDataBase();
    	
    	listaDivisas = JsonDataBase.getLista();
        for (int i = 0; i < listaDivisas.length; i++) {
        	Object[] fila = {
        			listaDivisas[i].getNombre(),
        			listaDivisas[i].getCodigo(),
        			listaDivisas[i].getValorString(),
        			listaDivisas[i].getFecha()
        	}; 
			tableModel.addRow(fila);
		}
    }
    
    
    
    public void Mensaje (String titulo, String mensaje, int divisaIndex) {
    	Divisa divisa = JsonDataBase.lista.get(divisaIndex);
    	String nombre = divisa.getNombre();
    	String codigo = divisa.getCodigo();
    	String valor = divisa.getValorString();
//    	String fecha = divisa.getFecha();
    	
    	
    	 JOptionPane.showMessageDialog(
    	            VentanaTabla.this, // El componente padre para el diálogo
    	            String.format(
    	            		"Se ha %s '%s' %s %s",
    	            		mensaje, nombre, codigo, valor), // El mensaje a mostrar
    	            titulo, // El título del diálogo
    	            JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (información)
    	        );
    }
    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            VentanaTabla frame = new VentanaTabla();
//            frame.setVisible(true);
//        });
//    }
}
