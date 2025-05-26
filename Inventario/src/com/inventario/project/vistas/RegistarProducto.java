package com.inventario.project.vistas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.inventario.project.controlador.Controlador;
import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;
import javax.swing.JTextField;

public class RegistarProducto extends JFrame {
	private static final long serialVersionUID = 1L;

	private Controlador controlador;
	private JPanel contentPane;
	private PersistenciaInventario persistenciaInventario;
	private JTextField textFieldId;
	private JTextField textField_Nombre;
	private JTextField textField_descripcion;
	private JTextField textField_cantidad;
	private JTextField textField_precio;

	public RegistarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 528, 370);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Guardar Producto");
		lblNewLabel.setBounds(212, 24, 136, 27);
		panel.add(lblNewLabel);

		textFieldId = new JTextField();
		textFieldId.setBounds(192, 83, 156, 20);
		panel.add(textFieldId);
		textFieldId.setColumns(10);

		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(192, 117, 156, 20);
		panel.add(textField_Nombre);
		textField_Nombre.setColumns(10);

		textField_descripcion = new JTextField();
		textField_descripcion.setBounds(190, 156, 158, 20);
		panel.add(textField_descripcion);
		textField_descripcion.setColumns(10);

		textField_cantidad = new JTextField();
		textField_cantidad.setBounds(192, 190, 156, 20);
		panel.add(textField_cantidad);
		textField_cantidad.setColumns(10);

		textField_precio = new JTextField();
		textField_precio.setBounds(192, 224, 156, 20);
		panel.add(textField_precio);
		textField_precio.setColumns(10);

		JButton btnNewButton_5 = new JButton("Registrar");
		btnNewButton_5.addActionListener(new ActionListener() {
			private Component btnNewButton_5;

			public void actionPerformed(ActionEvent e) {

				PersistenciaInventario inventario = new PersistenciaInventario();
				Producto producto = new Producto(Integer.parseInt(textFieldId.getText()), textField_Nombre.getText(),textField_descripcion.getText(),Integer.parseInt(textField_cantidad.getText()),Integer.parseInt(textField_precio.getText()));
				boolean flag = inventario.agregarProducto(producto);
				if(flag) { JOptionPane.showMessageDialog(this.btnNewButton_5, "Registrado correctamente");}
				else {
					JOptionPane.showMessageDialog(this.btnNewButton_5, "error al registrar");
				}

			}
		});
		btnNewButton_5.setBounds(133, 274, 89, 23);
		panel.add(btnNewButton_5);

		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(75, 86, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(75, 120, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(59, 159, 81, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setBounds(75, 193, 46, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Precio");
		lblNewLabel_5.setBounds(75, 227, 46, 14);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButtonAtras = new JButton("Volver al menu");
		btnNewButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarVentanaConsultaProducto();
			    dispose();
			}
		});
		btnNewButtonAtras.setBounds(273, 274, 116, 23);
		panel.add(btnNewButtonAtras);
		
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}