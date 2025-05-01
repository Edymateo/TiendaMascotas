package nuevaPapeleria2.inventario;

import java.util.ArrayList;

import nuevaPapeleria2.itemInvetario.itemInventario;
import papeleria.productos.Producto;

public class Inventario {
    private List<ItemInventario> items;

    //contructores
    public void ItemInventario() {
        
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
        ItemInventario itemExistente=buscar (itemNuevo.getProducto());
        if (itemExistente==null){
            items.add(itemNuevo);
        }else {
            //Actualiza el item existente con los datos del nuevo
            //recalcular 
            registrarEntrada(itemExistente, itemNuevo);
        }
    }
    public static void registrarSalida(Producto p, int cantidad) {
        ItemInventario itemExistente= buscar (p);
        if (itemExistente !=null) {
            itemExistente.retirar(cantidad);
        }
        
    }
        return 0.0;
    }//

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