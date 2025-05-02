package inventario;

import java.time.LocalDate;
import java.util.List;

import itemInventario.ItemInventario;
import personas.Persona;
import productos.Producto;
import venta.Venta;
import ventas.Ventas;

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

    public void registrarSalida(Producto p, int cantidad,Ventas ventas) {
        ItemInventario itemExistente = buscar(p);
        if (itemExistente != null) {
            itemExistente.retirar(cantidad);
            Venta nuevaVenta = new Venta(LocalDate.now(), p, cantidad,(itemExistente.getPrecioVenta()*cantidad));
            ventas.agregarVenta(nuevaVenta);  
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