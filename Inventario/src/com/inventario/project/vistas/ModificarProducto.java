package com.inventario.project.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventario.project.controlador.Controlador;
import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ModificarProducto extends JFrame {
	private JTextField textFieldId;
	private JTextField textField_nombre;
	private JTextField textField_descripcion;
	private JTextField textField_cantidad;
	private Controlador controlador;
	private JTextField textField_precio;
	public ModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 409);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			private Component btnNewButton;

			public void actionPerformed(ActionEvent e) {
				try {
					PersistenciaInventario inventario = new PersistenciaInventario();
					Producto producto = new Producto();
					producto.setId(Integer.parseInt(textFieldId.getText()));
					producto.setNombre(textField_nombre.getText());
					producto.setDescripcion(textField_descripcion.getText());
					producto.setCantidad(Integer.parseInt(textField_cantidad.getText()));
					producto.setPrecio(Integer.parseInt(textField_precio.getText()));
					if(inventario.modificarProducto(producto)) {
						JOptionPane.showMessageDialog(this.btnNewButton, "Producto Modificado");
					} else {
						JOptionPane.showMessageDialog(this.btnNewButton, "No se pudo modificar el producto");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this.btnNewButton, "Por favor ingrese valores numéricos válidos para ID, Cantidad y Precio");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this.btnNewButton, "Error al modificar el producto: " + ex.getMessage());
				}
			}
		});
		btnNewButton_2.setBounds(127, 278, 85, 21);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Volver al Men\u00FA");
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarVentanaConsultaProducto();
				dispose();
			}
		});
		btnNewButton_1.setBounds(270, 278, 136, 21);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("MODIFICAR PRODUCTO");
		lblNewLabel_1.setBounds(190, 24, 136, 26);
		contentPane.add(lblNewLabel_1);

		textFieldId = new JTextField();
		textFieldId.setBounds(202, 82, 86, 19);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		textField_nombre = new JTextField();
		textField_nombre.setBounds(202, 125, 144, 19);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);

		textField_descripcion = new JTextField();
		textField_descripcion.setBounds(202, 160, 152, 19);
		contentPane.add(textField_descripcion);
		textField_descripcion.setColumns(10);

		textField_cantidad = new JTextField();
		textField_cantidad.setBounds(203, 196, 85, 19);
		contentPane.add(textField_cantidad);
		textField_cantidad.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(63, 85, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(63, 128, 72, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(63, 163, 107, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setBounds(63, 199, 61, 13);
		contentPane.add(lblNewLabel_4);

		textField_precio = new JTextField();
		textField_precio.setBounds(202, 227, 86, 20);
		contentPane.add(textField_precio);
		textField_precio.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("precio");
		lblNewLabel_5.setBounds(63, 229, 46, 14);
		contentPane.add(lblNewLabel_5);
	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
