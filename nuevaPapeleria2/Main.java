import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.Producto;
import modelo.Venta;
import modelo.Ventas;
import modelo.InfoConsola;
import modelo.Inventario;
import modelo.ItemInventario;
import persistencia.PersistenciaInventario;
import persistencia.PersistenciaProductos;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

    PersistenciaProductos persistenciaProductos = new PersistenciaProductos();
    List<Producto> itemsProductos = persistenciaProductos.leerProductos();

    PersistenciaInventario persistenciaInventario = new PersistenciaInventario("inventario.txt");
    List<ItemInventario> itemsInventario = persistenciaInventario.leerInventario(itemsProductos);

    Inventario nuevoinventario = new Inventario(itemsInventario);
    List<Venta> listaVentaInicial = new ArrayList<>();
    Ventas ventas = new Ventas(listaVentaInicial);

        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Ver inventario");
            System.out.println("2. Registrar entrada Inventario");
            System.out.println("3. Registrar salida Inventario");
            System.out.println("4. Modificar productos");
            System.out.println("5. Buscar producto");
            System.out.println("6. Guardar Producto");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            boolean entrada = false;
            while (!entrada) {
                    try {
                    opcion = Integer.parseInt(scanner.nextLine());
                    entrada = true;
                } catch (NumberFormatException e) {
                    System.out.println("Debes poner un número.");
            }
            }

            switch (opcion) {
                case 1:
                    InfoConsola.mostraInfoInvetario(nuevoinventario);
                break;
                case 2:
                    try {
                        System.out.println("------- Registrar entrada de inventario -------");
                        System.out.print("Ingrese el ID del producto: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese el precio costo del producto: ");
                        double precioCosto = scanner.nextDouble();
                        System.out.print("Ingrese el margen de ganancia (%): ");    
                        float margenGanancia = scanner.nextFloat();
                        System.out.print("Ingrese la cantidad actual producto: ");
                        int cantidadActual = scanner.nextInt();

                        double precioVenta = calcularPrecioVenta(precioCosto, margenGanancia);
                        double valorGanancia = calcularValorGanancia(precioCosto, margenGanancia);


                        Producto productoEncontrado = null;
                        for (Producto producto : itemsProductos) {
                            if (producto.getId() == id) {
                                productoEncontrado = producto;
                                break;
                            }
                        }
                        if (productoEncontrado == null) {
                            System.out.println("El ID del producto no fue encontrado");
                        } else {
                            System.out.printf("Precio de venta: $%.2f\n", precioVenta);
                            System.out.printf("Valor de Ganancia : $%.2f\n", valorGanancia);
                            System.out.println("Producto agregado al inventario.");
                            ItemInventario nuevoItem = new ItemInventario(
                                null, null, productoEncontrado, precioCosto, margenGanancia,
                                precioVenta, valorGanancia, cantidadActual);
                            nuevoinventario.registrarEntrada(nuevoItem);
                        }
                        } catch (InputMismatchException e) {
                        System.out.println("Error: Debes ingresar un valor numérico válido.");
                        scanner.nextLine();
                        } catch (Exception e) {
                        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                        scanner.nextLine();
                    }
                break;

                    case 3:
                        try {
                        System.out.println("------- Registrar salida de inventario -------");
                        System.out.print("Ingrese el ID del producto: ");
                        int idBuscar = scanner.nextInt();
                        System.out.print("Ingrese la cantidad del producto retirado: ");
                        int cantidadRetirada = scanner.nextInt();

                        Producto productoEncontrado = null;
                        for (Producto p : itemsProductos) {
                        if (p.getId() == idBuscar) {
                        productoEncontrado = p;
                        break;
            }
        }
                        if (productoEncontrado == null) {
                        System.out.println("El ID del producto no fue encontrado");
                        } else {
                        ItemInventario itemExistente = nuevoinventario.buscar(productoEncontrado);
                        if (itemExistente == null) {
                        System.out.println("El producto no está registrado en el inventario.");
                        } else {
                        ventas.agregarVenta(nuevoinventario.registrarSalida(productoEncontrado, cantidadRetirada));
                        System.out.println("Venta agregada correctamente");
            }
        }
                        } catch (InputMismatchException e) {
                        System.out.println("Error: Debes ingresar un valor numérico válido.");
                        scanner.nextLine();
                        } catch (Exception e) {
                        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                        scanner.nextLine();
                    }
                        break;
                    case 4:
                        try {
                        System.out.println("------- Modificar Productos -------");
                        System.out.print("Ingrese el ID del producto: ");
                        int idModificar = scanner.nextInt();
                        System.out.print("Ingrese el precio costo del producto: ");
                        double precioCosto = scanner.nextDouble();
                        System.out.print("Ingrese el margen de ganancia (%): ");    
                        float margenGanancia = scanner.nextFloat();
                        System.out.print("Ingrese la cantidad actual: ");
                        int cantidadActualModificar = scanner.nextInt();

                        double precioVenta = calcularPrecioVenta(precioCosto, margenGanancia);
                        double valorGanancia = calcularValorGanancia(precioCosto, margenGanancia);

                        Producto productoModificado = null;
                        for (Producto producto : itemsProductos) {
                            if (producto.getId() == idModificar) {
                                productoModificado = producto;
                            break;
                        }
                            }

                        if (productoModificado == null) {
                            System.out.println("El ID del producto no fue encontrado");
                        } else {
                            ItemInventario itemMod = nuevoinventario.buscar(productoModificado);
                            itemMod.setPrecioCosto(precioCosto);
                            itemMod.setMargenGanacia(margenGanancia);
                            itemMod.setPrecioVenta(precioVenta);
                            itemMod.setValorGananacia(valorGanancia);
                            itemMod.setCantidadActual(cantidadActualModificar);
                            System.out.printf("Precio de venta: $%.2f\n", precioVenta);
                            System.out.printf("Valor de Ganancia : $%.2f\n", valorGanancia);
                            System.out.println("Producto modificado con éxito.");
                        }
                        } catch (InputMismatchException e) {
                        System.out.println("Error: Debes ingresar un valor numérico válido.");
                        scanner.nextLine();
                        } catch (Exception e) {
                        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                    case 5:
                        try {
                        System.out.println("------- Buscar Producto -------");
                        System.out.print("Ingrese el ID del producto a buscar: ");
                        int idBuscar = scanner.nextInt();
                        scanner.nextLine();

                        Producto productoEncontrado = null;
                        for (Producto producto : itemsProductos) {
                            if (producto.getId() == idBuscar) {
                                productoEncontrado = producto;
                            break;
                        }
                        }

                        if (productoEncontrado != null) {
                           System.out.println("Producto encontrado:");
                           System.out.println("ID: " + productoEncontrado.getId());
                           System.out.println("Nombre: " + productoEncontrado.getNombre());
                           System.out.println("Descripción: " + productoEncontrado.getDescripcion());
                        } else {
                           System.out.println("Producto no encontrado con el ID ingresado.");
                        }
                  } catch (InputMismatchException e) {
                        System.out.println("Error: Debes ingresar un número válido.");
                        scanner.nextLine();
                  } catch (Exception e) {
                        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                  }
                  break;

               case 6:
               try {
                  System.out.println("------- Guardar Producto -------");
                  System.out.print("Ingrese ID del producto: ");
                  int id = scanner.nextInt();
                  scanner.nextLine(); // limpiar buffer
                  System.out.print("Ingrese nombre del producto: ");
                  String nombre = scanner.nextLine();
                  System.out.print("Ingrese descripción del producto: ");
                  String descripcion = scanner.nextLine();
                  System.out.println("Ingrese la Cantidad");
                  int cantidad = scanner.nextInt();
                  System.out.println("Ingrese el precio");
                  int precio = scanner.nextInt();


                  Producto nuevoProducto = new Producto(id, nombre, descripcion, cantidad, precio);
                  persistenciaProductos.agregarProducto(nuevoProducto);
                  } catch (InputMismatchException e) {
                     System.out.println("Error: Debes ingresar un número válido.");
                  }
                  break;
               case 7:
                  salir = true;
                  break;

               default:
                  System.out.println("Opción no válida.");
                  break;
            }
      }

            scanner.close();
            System.out.println("Programa finalizado.");
   }

      public static List<Producto> crearProductos() {
         List<Producto> itemsProductos = new ArrayList<>();
         String[] nombresProductos = {
            "Cuaderno", "Lapiz Negro", "Lapiz Rojo", "Esfero Azul", "Esfero Negro",
            "Esfero Rojo", "Resma de Papel", "Tijeras", "Acetato", "Borrador",
            "Corrector", "Regla", "Compas", "Escuadra", "Cinta",
            "Grapadora", "Marcador Negro", "Marcador Rojo", "Marcador Azul", "Cartulina"
      };

         for (int i = 0; i < nombresProductos.length; i++) {
            Producto nuevoProducto = new Producto(i, nombresProductos[i], "Es un " + nombresProductos[i], i, i);
            itemsProductos.add(nuevoProducto);
      }

      return itemsProductos;
   }

      public static List<ItemInventario> crearItemsInventario(List<Producto> itemsProductos) {
         List<ItemInventario> itemsInventario = new ArrayList<>();

         for (int i = 0; i < itemsProductos.size(); i++) {
            ItemInventario nuevoItem = new ItemInventario(
                LocalDate.now(), null,
                itemsProductos.get(i), 0.0, 0, 0.0, 0.0, (i + 1) * 11
            );
            itemsInventario.add(nuevoItem);
      }

      return itemsInventario;
   
   }
      public static double calcularPrecioVenta(double precioCosto, float margenGanancia) {
         return precioCosto * (1 + (margenGanancia / 100.0));
}

public static double calcularValorGanancia(double precioCosto, float margenGanancia) {
   double precioVenta = calcularPrecioVenta(precioCosto, margenGanancia);
   return precioVenta - precioCosto;
}

}

