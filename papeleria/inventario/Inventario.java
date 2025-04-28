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

    public void modificarProducto(int id, int nuevoPrecio, double porcentaje, int stock) {
        for (Producto p : this.productos) {
            if (p.getId() == id) {
                p.setPrecio(nuevoPrecio);
                p.setPorcentajeGanacia(porcentaje);
                p.setStock(stock);
                break;
            }
        }
    }

    public double mostrarganancia(int productoId) {
        for (Producto p : this.productos) {
            if (p.getId() == productoId) {
                return (p.getPrecio() * p.getPorcentajeGanacia());
            }
        }
        return 0.0;
    }

    public Producto buscarProducto(int productoId) {
        Producto productoEncontrado = null;
        for (Producto p : this.productos) {
            if (p.getId() == productoId) {
                productoEncontrado = p;
            }
        }
        return productoEncontrado;
    }

}