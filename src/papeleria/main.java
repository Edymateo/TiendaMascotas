package papeleria;

import java.util.Scanner;
import papeleria.clientes.cliente;
import papeleria.productos.producto;
import papeleria.ventas.venta;
import papeleria.inventario.Inventario;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario nuevoinventario = new inventario();
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
            producto nuevoProducto = new producto( i, nombresProductos[i], (i+1)*50);
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
                    nuevoinventario.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    producto producto = new producto(id, nombre, precio);
                    nuevoinventario.agregarProducto(producto);
                    System.out.println("Producto agregado al inventario.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el telefono del cliente: ");
                    String telefono = scanner.nextLine();
                    cliente cliente = new cliente(nombreCliente, telefono);
                    System.out.print("Ingrese el nombre del producto vendido: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    venta venta = new venta(cliente, new producto(0, nombreProducto, 0), cantidad);
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