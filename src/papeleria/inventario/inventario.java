package papeleria.inventario;

import java.util.ArrayList;
import papeleria.productos.producto;

public class Inventario {
    private ArrayList<producto> productos;

    public inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(producto producto) {
        this.productos.add(producto);
    }

    public void mostrarInventario() {
        for (producto p : productos) {
            p.mostrarInfo();
        }
    }
}