package inventario;

import java.util.List;

import itemInventario.ItemInventario;
import productos.Producto;

public class Inventario {
    private List<ItemInventario> items;

    // contructores

    public Inventario(List<ItemInventario> items) {
        this.items = items;
    }

    public void registrarEntrada(ItemInventario itemNuevo) {
        ItemInventario itemExistente = buscar(itemNuevo.getProducto());
        if (itemExistente == null) {
            items.add(itemNuevo);
        } else {
            // Actualiza el item existente con los datos del nuevo
            // recalcular
            // registrarEntrada(itemExistente, itemNuevo);
            System.out.println("hace otra cosa");
        }
    }

    public void registrarSalida(Producto p, int cantidad) {
        ItemInventario itemExistente = buscar(p);
        if (itemExistente != null) {
            itemExistente.retirar(cantidad);
        }

    }

    public ItemInventario buscar(Producto productoEntrante) {
        ItemInventario itemInventarioEncontrado = null;
        for (ItemInventario itemEvaluado : items) {
            if (itemEvaluado.getProducto().getId() == productoEntrante.getId()) {
                itemInventarioEncontrado = itemEvaluado;
                break;
            }
        }
        return itemInventarioEncontrado;

    }

    public List<ItemInventario> getItems() {
        return this.items;
    }

    public void setItems(List<ItemInventario> items) {
        this.items = items;
    }

}