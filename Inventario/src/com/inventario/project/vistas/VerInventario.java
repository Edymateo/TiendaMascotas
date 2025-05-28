package com.inventario.project.vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.inventario.project.controlador.Controlador;
import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;
import java.awt.SystemColor;

public class VerInventario extends JFrame {
	private static final long serialVersionUID = 1L;

	private Controlador controlador;
	private JPanel contentPane;
	private PersistenciaInventario persistenciaInventario;
	private DefaultTableModel modeloTabla;
	private JTable tabla;

	public VerInventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 528, 370);
		contentPane.add(panel);
		panel.setLayout(null);

		String[] columnas = {"Código", "Nombre", "Descripcion","precio","cantidad"};
		modeloTabla = new DefaultTableModel(columnas, 0);
		tabla = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(27, 10, 479, 313); 
		panel.add(scrollPane);

		JButton btnNewButton_2 = new JButton("ver");
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersistenciaInventario persistenciaInventario = new PersistenciaInventario();
				ArrayList<Producto> productos = persistenciaInventario.verInventario();

				modeloTabla.setRowCount(0); 
				for (Producto item : productos) {
					modeloTabla.addRow(new Object[]{
							item.getId(),
							item.getNombre(),
							item.getDescripcion(),
							item.getPrecio(),
							item.getCantidad(),
					});
				}
			}
		});
		btnNewButton_2.setBounds(243, 333, 108, 27);
		panel.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Volver al menu");
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarVentanaConsultaProducto();
				dispose();
			}
		});
		btnNewButton_1.setBounds(368, 332, 138, 28);
		panel.add(btnNewButton_1);

	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
