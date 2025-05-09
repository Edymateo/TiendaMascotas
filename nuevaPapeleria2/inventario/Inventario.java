package inventario;

import java.time.LocalDate;
import java.util.List;

import itemInventario.ItemInventario;
import personas.Persona;
import productos.Producto;
import venta.Venta;

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
            itemExistente.setPrecioCosto((itemExistente.getPrecioCosto()+itemNuevo.getPrecioCosto())/2);
            itemExistente.setMargenGanancia((itemExistente.getMargenGanancia()+itemNuevo.getMargenGanancia()/2));
            itemExistente.setPrecioVenta((itemExistente.getPrecioVenta()+itemNuevo.getPrecioVenta()/2));
            itemExistente.setValorGananacia((itemExistente.getValorGananacia()+itemNuevo.getValorGananacia()/2));
            itemExistente.setCantidadActual(itemExistente.getCantidadActual()+itemNuevo.getCantidadActual());
            System.out.println("hace otra cosa");
        }
    }

    public Venta registrarSalida(Producto p, int cantidad) {
        ItemInventario itemExistente = buscar(p);
        itemExistente.retirar(cantidad);
        Venta nuevaVenta = new Venta(LocalDate.now(), p, cantidad,(itemExistente.getPrecioVenta()*cantidad));
        return nuevaVenta;
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