package modelo;


import java.io.PrintWriter;
import java.util.Collection;
import modelo.Inventario;
import modelo.Ventas;
import modelo.Venta;

public class InfoConsola {
    static PrintWriter w = System.console().writer();

    public static void mostraInfoInvetario(Inventario inventario){
        System.out.print("\n\n\n\n\n------- Mostrando inventario -------\n");
    for (int i = 0; i < inventario.getItems().size() ; i++) {
        System.out.println("Nombre: "+inventario.getItems().get(i).getProducto().getNombre()
        + "\tCantidad: "+ inventario.getItems().get(i).getCantidadActual()
        + "\tPrecio Venta: "+ inventario.getItems().get(i).getPrecioVenta()
        + "\tMargen Ganancia: "+ inventario.getItems().get(i).getMargenGanancia()
        );
        }
    }


    
}