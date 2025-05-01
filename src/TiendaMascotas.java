package Tienda;
import productos.Producto;
import venta.Venta;
import clientes.Cliente;

public class TiendaMascotas {
    public static void main(String[] args) {
        Producto alimentoGato = new Producto("Croquetas para Gato", 25.50, "Alimento balanceado para gatos adultos", "Gato");
        Cliente juan = new Cliente("Juan Pérez", "Calle 123", "3151234567");
        Ventas venta1 = new Ventas(juan, alimentoGato, 2);
        
        venta1.mostrarInfoVenta();
    }
}
