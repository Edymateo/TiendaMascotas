package papeleria;

import java.util.Scanner;
import papeleria.clientes.Cliente;
import papeleria.productos.Producto;
import papeleria.ventas.Venta;
import papeleria.inventario.Inventario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario nuevoinventario = new Inventario();
        boolean salir = false;
        String[] nombresProductos = { "Cuaderno",
                "Lapiz Negro",
                "Lapiz Rojo",
                "Esfero Azul",
                "Esfero Negro",
                "Esfero Rojo",
                "Resma de Papel",
                "Tijeras",
                "Acetato",
                "Borrador",
                "Corrector",
                "Regla",
                "Compas",
                "Escuadra",
                "Cinta",
                "Grapadora",
                "Marcador Negro",
                "Marcador Rojo",
                "Marcador Azul",
                "Cartulina" };

        for (int i = 0; i < 20; i++) {
            Producto nuevoProducto = new Producto(i, nombresProductos[i], (i + 1) * 50);
            nuevoinventario.agregarProducto(nuevoProducto);
        }

        while (!salir) {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar producto al inventario");
            System.out.println("3. Registrar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\n\n\n\n\n------- Mostrando inventario -------\n");
                    nuevoinventario.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del producto: ");
                    int id = scanner.nextInt();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    int precio = scanner.nextInt();
                    Producto producto = new Producto(id, nombre, precio);
                    nuevoinventario.agregarProducto(producto);
                    System.out.println("Producto agregado al inventario.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el telefono del cliente: ");
                    String telefono = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreCliente, telefono);
                    System.out.print("Ingrese el nombre del producto vendido: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    Venta venta = new Venta(cliente, new Producto(0, nombreProducto, 0), cantidad);
                    venta.mostrarVenta();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
        System.out.println("Programa finalizado.");
    }
}