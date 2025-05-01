package nuevaPapeleria2;

import java.util.Scanner;
import nuevaPapeleria2.clientes.Cliente;
import nuevaPapeleria2.productos.Producto;
import nuevaPapeleria2.ventas.Ventas;
import nuevaPapeleria2.Abastecimiento.Abastecimiento;
import nuevaPapeleria2.inventario.Inventario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario nuevoinventario = new Inventario();
            
System.out.println("gholas");




        /* Scanner scanner = new Scanner(System.in);
        Inventario nuevoinventario = new Inventario();
        boolean salir = false;
        double ganaciaPorProducto = 0.10;
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
            Producto nuevoProducto = new Producto(i, nombresProductos[i], (i + 1) * 50, ganaciaPorProducto, i);
            nuevoinventario.agregarProducto(nuevoProducto);
        }

        while (!salir) {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar producto al inventario");
            System.out.println("3. Registrar entrada productos");
            System.out.println("4. Registrar salida productos");
            System.out.println("5. Modificar productos");
            System.out.println("6. Salir");
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
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    int precio = scanner.nextInt();
                    System.out.print("Ingrese el procentaje de ganancia del producto: ");
                    double porcentaje = scanner.nextDouble();
                    System.out.print("Ingrese el stock del producto: ");
                    int stock = scanner.nextInt();
                    Producto producto = new Producto(id, nombre, precio, porcentaje, stock);
                    nuevoinventario.agregarProducto(producto);
                    System.out.println("Producto agregado al inventario.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el telefono del cliente: ");
                    String telefono = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreCliente, telefono);
                    System.out.print("Ingrese el Id del producto reabastecido: ");
                    int idVendido = scanner.nextInt();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    Producto productoEncontrado =nuevoinventario.buscarProducto(idVendido);
                    Venta venta = new Venta(cliente, productoEncontrado, cantidad);
                    venta.mostrarVenta();
                    nuevoinventario.modificarProducto(productoEncontrado.getId(), productoEncontrado.getPrecio(), productoEncontrado.getPorcentajeGanacia(), productoEncontrado.getStock()+cantidad);

                    break;
                case 4:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreClienteEntrada = scanner.nextLine();
                    System.out.print("Ingrese el telefono del cliente: ");
                    String telefonoEntrada = scanner.nextLine();
                    Cliente clienteEntrada = new Cliente(nombreClienteEntrada, telefonoEntrada);
                    System.out.print("Ingrese el Id del producto vendido: ");
                    int idVendidoEntrada = scanner.nextInt();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidadEntrada = scanner.nextInt();
                    Producto productoEncontradoEntrada =nuevoinventario.buscarProducto(idVendidoEntrada);
                    Abastecimiento abastecimiento = new Abastecimiento(clienteEntrada, productoEncontradoEntrada, cantidadEntrada);
                    abastecimiento.mostrarAbastecimiento();
                    nuevoinventario.modificarProducto(productoEncontradoEntrada.getId(), productoEncontradoEntrada.getPrecio(), productoEncontradoEntrada.getPorcentajeGanacia(), productoEncontradoEntrada.getStock()-cantidadEntrada);

                    break;
                case 5:
                    System.out.print("Ingrese el ID del producto: ");
                    int idModificar = scanner.nextInt();
                    System.out.print("Ingrese el nuevo precio del producto: ");
                    int precioNuevo = scanner.nextInt();
                    System.out.print("Ingrese el nuevo porcentaje de ganancia del producto: ");
                    double porcentajeNuevo = scanner.nextDouble();
                    System.out.print("Ingrese el nuevo stock del producto: ");
                    int stockNuevo = scanner.nextInt();
                    nuevoinventario.modificarProducto(idModificar, precioNuevo, porcentajeNuevo,stockNuevo);
                    System.out.println("Producto modificado con exito");
                    System.out.println("La nueva ganancia para este producto es de "
                            + nuevoinventario.mostrarganancia(idModificar));
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
        System.out.println("Programa finalizado."); */
    }
}