package papeleria.inventario;

import java.util.ArrayList;
import papeleria.productos.Producto;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void mostrarInventario() {
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }
}