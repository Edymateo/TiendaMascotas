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
        panel.setBounds(0, 0, 528, 370);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("PRODUCTOS");
        lblNewLabel.setBounds(191, 11, 136, 27);
        panel.add(lblNewLabel);

        String[] columnas = {"Código", "Nombre", "Descripcion","cantidad","precio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(156, 41, 363, 257); 
        panel.add(scrollPane);

        JButton btnNewButton = new JButton("ver");
        btnNewButton.addActionListener(new ActionListener() {
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
        btnNewButton.setBounds(10, 44, 89, 23);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Guardar producto");
        btnNewButton_1.setBackground(Color.YELLOW);
        btnNewButton_1.setForeground(Color.BLUE);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.mostrarVentanaRegistrarProducto();
        		dispose();
        	}
        });
        btnNewButton_1.setBounds(10, 70, 136, 23);
        panel.add(btnNewButton_1);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}