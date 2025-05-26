package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import modelo.Inventario;
import modelo.ItemInventario;
import modelo.Producto;
import persistencia.PersistenciaProductos;

public class PanelEntradaInventario extends JPanel {

    private Inventario inventario;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private PersistenciaProductos persistenciaProductos;
    List<Producto> productos;

    public PanelEntradaInventario(Inventario inventario) {
        this.inventario = inventario;
        initUI();
        actualizarTabla();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Columnas de la tabla
        String[] columnas = {"Precio Costo", "Margen Ganancia", "Cantidad Actual"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        add(scrollPane, BorderLayout.CENTER);

        // Botón para actualizar
        JButton botonActualizar = new JButton("Actualizar Inventario");
        botonActualizar.addActionListener(e -> actualizarTabla());

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonActualizar);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // Limpiar tabla

        List<ItemInventario> items = inventario.getItems();
        for (ItemInventario item : items) {
            List<Producto> producto = productos;
        for (ItemInventario producto2 : items) {
            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getNombre(),       
                item.getDescripcion(),
                item.getCantidadActual(),
                item.getPrecioCosto(),
            });
        }
    }
}
}
