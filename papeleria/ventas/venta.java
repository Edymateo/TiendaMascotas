package papeleria.ventas;

import papeleria.clientes.Cliente;
import papeleria.productos.Producto;

public class Venta {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Venta(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void mostrarVenta() {
        System.out.println("Cliente: " + cliente.getNombre() + ", Producto: " + producto.getNombre() + ", Cantidad: " + cantidad);
    }
}
