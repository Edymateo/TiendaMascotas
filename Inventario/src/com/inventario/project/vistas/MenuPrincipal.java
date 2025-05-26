package com.inventario.project.vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.inventario.project.controlador.Controlador;

import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controlador controlador;

	private JPanel contentPane;
	private JTextField txtEsta;


	/**
	 * Launch the application.
	 */

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.activeCaption);
		panel1.setForeground(SystemColor.desktop);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("INVENTARIO VARIEDADES RUIZ");
		lblNewLabel_1.setBounds(62, 5, 300, 50);
		panel1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(SystemColor.control);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setPreferredSize(new Dimension(300, 50));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		JButton btnNewButton = new JButton("Ver Panel de opciones");
		btnNewButton.setBounds(105, 159, 200, 32);
		panel1.add(btnNewButton);
		
		txtEsta = new JTextField();
		txtEsta.setText("Mediante esta aplicacion podras\r\n gestionar datos del inventario");
		txtEsta.setBounds(48, 51, 325, 97);
		panel1.add(txtEsta);
		txtEsta.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarVentanaConsultaProducto();
				dispose();
			}
		});

	}
}
