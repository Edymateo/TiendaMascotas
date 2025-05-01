package inventario;

import java.util.ArrayList;
import productos.Producto;

public class Inventario {
    private List<itemInventario> items;

    // contructores
    public void ItemInventario(List<ItemInventario> items) {
        items=items;
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

    public void registrarEntrar(ItemInventario itemNuevo) {
        ItemInventario itemExistente = buscar(itemNuevo.getProducto());
        if (itemExistente == null) {
            items.add(itemNuevo);
        } else {
            // Actualiza el item existente con los datos del nuevo
            // recalcular
            registrarEntrada(itemExistente, itemNuevo);
        }
    }

    public static void registrarSalida(Producto p, int cantidad) {
        ItemInventario itemExistente= buscar (p);
        if (itemExistente !=null) {
            itemExistente.retirar(cantidad);
        }
        
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