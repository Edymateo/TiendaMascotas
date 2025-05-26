package modelo;

import java.time.LocalDate;
import java.util.List;

import modelo.ItemInventario;
import modelo.Producto;
import modelo.Venta;

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

    public List<ItemInventario> obtenerInventario() {
        throw new UnsupportedOperationException("obtenerInventario");
    }

    public ItemInventario buscar(Object codigo) {
        throw new UnsupportedOperationException("buscar");
    }

    public void registrarSalida(Object codigo, int cantidad) {
        throw new UnsupportedOperationException("registrarSalida");
    }

    public List<ItemInventario> getItemsInventario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemsInventario'");
    }

}