package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Inventario;
import modelo.ItemInventario;
import modelo.Producto;
import persistencia.PersistenciaInventario;
import persistencia.PersistenciaProductos;

import java.awt.*;
import java.util.List;

public class PanelVerInventario extends JPanel {
    private Inventario inventario;
    private JTable tablaInventario;
    private DefaultTableModel modeloTabla;
    private PersistenciaProductos persistenciaProductos;

    public PanelVerInventario(Inventario inventario) {
        this.inventario = inventario;
        setLayout(new BorderLayout());


        persistenciaProductos = new PersistenciaProductos();
        List<Producto> producto = persistenciaProductos.leerProductos();

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Descripción", "Cantidad", "Precio Venta"}, 0);
        tablaInventario = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaInventario);
        add(scroll, BorderLayout.CENTER);
        

        actualizarTabla(producto);
    }

    public void actualizarTabla(List<Producto> productos) {
        modeloTabla.setRowCount(0); // Limpiar la tabla
        List<Producto> items = productos;
        for (Producto item : items) {
            modeloTabla.addRow(new Object[]{
                item.getId(),
                item.getNombre(),       
                item.getDescripcion(),
                item.getCantidad(),
                item.getPrecio(),
            });
        }
    }
}
