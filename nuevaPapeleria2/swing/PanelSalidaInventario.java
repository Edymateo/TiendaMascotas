package swing;

import javax.swing.*;
import modelo.Inventario;
import modelo.Producto;
import modelo.Venta;
import modelo.Ventas;
import modelo.ItemInventario;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelSalidaInventario extends JPanel {
    private Inventario inventario;
    private Ventas ventas;

    private JTextField campoId, campoCantidad;
    private JButton botonVender;

    public PanelSalidaInventario(Inventario inventario, Ventas ventas) {
        this.inventario = inventario;
        this.ventas = ventas;

        setLayout(new GridLayout(4, 2, 10, 10));

        campoId = new JTextField();
        campoCantidad = new JTextField();
        botonVender = new JButton("Registrar Venta");

        add(new JLabel("ID Producto:"));
        add(campoId);
        add(new JLabel("Cantidad a vender:"));
        add(campoCantidad);
        add(new JLabel(""));
        add(botonVender);

        botonVender.addActionListener(this::registrarSalida);
    }

    private void registrarSalida(ActionEvent e) {
        try {
            int id = Integer.parseInt(campoId.getText());
            int cantidad = Integer.parseInt(campoCantidad.getText());

            // Buscar producto por ID
            ItemInventario item = inventario.buscar(new Producto(id, "", ""));
            if (item == null) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                return;
            }

            if (item.getCantidadActual() < cantidad) {
                JOptionPane.showMessageDialog(this, "No hay suficiente stock.");
                return;
            }

            Venta venta = inventario.registrarSalida(item.getProducto(), cantidad);
            ventas.agregarVenta(venta);

            JOptionPane.showMessageDialog(this, "Venta registrada: $" + venta.getValorTotal());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar salida: " + ex.getMessage());
        }
    }
}


