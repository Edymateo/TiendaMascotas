package com.inventario.project.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.inventario.project.controlador.Controlador;
import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;

public class BuscarProducto extends JFrame{
	private JLabel textFieldId;
	private Controlador controlador;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel modeloTabla;
	private JButton btnNewButton;
	public BuscarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 409);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR PRODUCTO");
		lblNewLabel.setBounds(201, 36, 104, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(123, 89, 155, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(53, 92, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		String[] columnas = {"Código", "Nombre", "Descripcion","precio","cantidad"};
        modeloTabla = new DefaultTableModel(columnas, 0);
		table = new JTable(modeloTabla);
		table.setBounds(154, 164, 191, 30);
		JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(123, 143, 364, 58); 

        btnNewButton = new JButton("Buscar");
        btnNewButton.setBackground(SystemColor.textHighlight);
        btnNewButton.addActionListener(new ActionListener() {
			private Component btnNewButton;
			public void actionPerformed(ActionEvent e) {
			  try {
        		int idTexto = Integer.parseInt(textField.getText());
        		PersistenciaInventario inventario = new PersistenciaInventario();
        		Producto item = new Producto();
        		item = inventario.buscarProducto(idTexto);
        		if(item.getId() != 0) {
        			modeloTabla.setRowCount(0); 
        			modeloTabla.addRow(new Object[]{
        					item.getId(),
        					item.getNombre(),
        					item.getDescripcion(),
        					item.getPrecio(),
        					item.getCantidad(),
        			});

        		}else {
        			JOptionPane.showMessageDialog(this.btnNewButton, "Producto no encontrado");
        		}
        	} catch (NumberFormatException ex) {
        		JOptionPane.showMessageDialog(this.btnNewButton, "Ingrese un número válido como ID");
        	} 
        	}
        });
		
		btnNewButton.setBounds(304, 88, 85, 21);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Volver al Menu");
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarVentanaConsultaProducto();
				dispose();
			}
		});
		btnNewButton_1.setBounds(399, 88, 104, 21);
		contentPane.add(btnNewButton_1);
		
		contentPane.add(scrollPane);
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}


