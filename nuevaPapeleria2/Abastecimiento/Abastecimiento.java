package papeleria.Abastecimiento;

import papeleria.clientes.Cliente;
import papeleria.productos.Producto;

public class Abastecimiento {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Abastecimiento(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void mostrarAbastecimiento() {
        System.out.println("Cliente: " + cliente.getNombre() + ", Producto: " + producto.getNombre() + ", Cantidad: " + cantidad);
    }
}
