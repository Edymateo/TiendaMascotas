package com.inventario.project.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.SystemColor;

public class RegistrarSalida extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private Controlador controlador;
	private JTextField textField_cantidad;
	public RegistrarSalida() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 544, 409);
			JPanel contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ID Producto");
			lblNewLabel.setBounds(144, 131, 62, 13);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(229, 170, 134, 19);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(229, 128, 134, 19);
			contentPane.add(textField_1);
			
			JLabel lblNewLabel_1 = new JLabel("SALIDA DE INVENTARIO");
			lblNewLabel_1.setBounds(207, 82, 131, 13);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Cantidad");
			lblNewLabel_2.setBounds(156, 173, 50, 13);
			contentPane.add(lblNewLabel_2);
			
			JButton btnNewButton = new JButton("Registrar Venta");
			btnNewButton.setBackground(SystemColor.textHighlight);
			btnNewButton.addActionListener(new ActionListener() {
				private Component btnNewButton_5;

				public void actionPerformed(ActionEvent e) {
					try {
					PersistenciaInventario inventario = new PersistenciaInventario();
					Producto producto = new Producto();
					
						int cantidad = Integer.parseInt(textField.getText().trim());
						int idProducto = Integer.parseInt(textField_1.getText().trim());

						producto.setId(idProducto);
						producto.setCantidad(cantidad);

						if (inventario.modificarProducto(producto)) {
							JOptionPane.showMessageDialog(this.btnNewButton_5, "Se registró una Venta");
						} else {
							JOptionPane.showMessageDialog(this.btnNewButton_5, "No se pudo registrar la Venta");
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(this.btnNewButton_5, "Error: ID y cantidad deben ser números válidos.");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(this.btnNewButton_5, "Ocurrió un error: " + ex.getMessage());
					}
				}	
			});
			btnNewButton.setBounds(177, 215, 85, 21);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Volver al Menu");
			btnNewButton_1.setBackground(SystemColor.textHighlight);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.mostrarVentanaConsultaProducto();
				    dispose();
				}
			});
			btnNewButton_1.setBounds(278, 215, 101, 21);
			contentPane.add(btnNewButton_1);

	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
