package InfoConsola;

import java.io.PrintWriter;
import java.util.Collection;

import inventario.Inventario;
import ventas.Ventas;
import venta.Venta;

public class InfoConsola {
    static PrintWriter w = System.console().writer();
   /*  public static void mostrarInfoVentas(Collection<Venta> ventas){
        w.println("Ventas");
        w.println("======");
        w.println("Fecha        Producto            Cantidad        Total");
        for (Venta v : ventas) {
            w.printf("%s  %-20.20s %8d %,11.0f%n",v.fecha, v.productoNombre, v.cantidad,v.valorTotal);
        }


    }*/

    public static void mostraInfoInvetario(Inventario inventario){
       for (int i = 0; i < inventario.getItems().size() ; i++) {
        System.out.println("Nombre: "+inventario.getItems().get(i).getProducto().getNombre()
        + "\tCantidad: "+ inventario.getItems().get(i).getCantidadActual()
        + "\tPrecio Venta: "+ inventario.getItems().get(i).getPrecioVenta()
        + "\tMargen Ganancia: "+ inventario.getItems().get(i).getMargenGanancia()
        );
       }
    }


    
}