package Abastecimiento;

import clientes.Cliente;
import productos.Producto;

public class Abastecimiento {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Abastecimiento(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }


}
