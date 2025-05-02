package inventario;

import java.util.List;

import itemInventario.ItemInventario;
import personas.Persona;
import productos.Producto;

public class Inventario {
    private List<ItemInventario> items;

    // contructores

    public Inventario(List<ItemInventario> items) {
        this.items = items;
    }

    public void registrarEntrada(ItemInventario itemNuevo, Persona persona) {
        ItemInventario itemExistente = buscar(itemNuevo.getProducto());
        if (itemExistente == null) {
            items.add(itemNuevo);
        } else {
            ItemInventario itemPromedio = new ItemInventario(persona, itemExistente.getUltimaEntrada(), itemExistente.getUltimaSalida(), itemExistente.getProducto(), (itemExistente.getPrecioCosto()+itemNuevo.getPrecioCosto())/2, (itemExistente.getMargenGanancia()+itemNuevo.getMargenGanancia()/2), (itemExistente.getPrecioVenta()+itemNuevo.getPrecioVenta()/2), (itemExistente.getValorGananacia()+itemNuevo.getValorGananacia()/2),itemExistente.getCantidadActual()+itemNuevo.getCantidadActual());
            items.remove(itemExistente);
            items.add(itemPromedio);
            
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