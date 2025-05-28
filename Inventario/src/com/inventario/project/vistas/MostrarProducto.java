package com.inventario.project.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.inventario.project.controlador.Controlador;
import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;
import java.awt.Color;
import java.awt.SystemColor;

public class MostrarProducto extends JFrame {
    private static final long serialVersionUID = 1L;

    private Controlador controlador;
    private JPanel contentPane;
    private PersistenciaInventario persistenciaInventario;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public MostrarProducto() {
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

        JLabel lblNewLabel = new JLabel("PRODUCTOS");
        lblNewLabel.setBounds(214, 10, 82, 42);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("ver");
        btnNewButton.setBackground(SystemColor.textHighlight);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               controlador.mostrarVentanaVerInventario();
               dispose();
                }
            
        });
        
        JButton btnRegistrarSalida = new JButton("Registrar Salida");
        btnRegistrarSalida.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.mostrarVentanaRegistrarSalida();
        		dispose();
        	}
        });
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setBackground(SystemColor.textHighlight);
        btnSalir.setBounds(174, 227, 136, 23);
        panel.add(btnSalir);
        btnRegistrarSalida.setBackground(SystemColor.textHighlight);
        btnRegistrarSalida.setBounds(174, 161, 136, 23);
        panel.add(btnRegistrarSalida);
        
        JButton btnModificarProducto = new JButton("Modificar Producto");
        btnModificarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.mostrarVentanaModificarProducto();
        		dispose();
        	}
        });
        btnModificarProducto.setBackground(SystemColor.textHighlight);
        btnModificarProducto.setBounds(174, 194, 136, 23);
        panel.add(btnModificarProducto);
        
        JButton btnBuscarProducto = new JButton("Buscar Producto");
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.mostrarVentanaBuscarProducto();
        		dispose();
        	}
        });
        btnBuscarProducto.setBackground(SystemColor.textHighlight);
        btnBuscarProducto.setBounds(174, 128, 136, 23);
        panel.add(btnBuscarProducto);
        btnNewButton.setBounds(174, 62, 136, 23);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Guardar producto");
        btnNewButton_1.setBackground(SystemColor.textHighlight);
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.mostrarVentanaRegistrarProducto();
        		dispose();
        	}
        });
        btnNewButton_1.setBounds(174, 95, 136, 23);
        panel.add(btnNewButton_1);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}