
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import clientes.Cliente;
import productos.Producto;
import venta.Venta;
import ventas.Ventas;
import InfoConsola.InfoConsola;
import inventario.Inventario;
import itemInventario.ItemInventario;
import personas.Persona;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      List<Producto> itemsProductos = crearProductos();
      Persona jhanYuler = new Persona("jhanYuler");
      List<ItemInventario> itemsInventario = crearItemsInventario(jhanYuler, itemsProductos);
      Inventario nuevoinventario = new Inventario(itemsInventario);
      List<Venta> listaVentaInicial = new ArrayList<>();
      Ventas ventas = new Ventas(listaVentaInicial);

      boolean salir = false;
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
               InfoConsola.mostraInfoInvetario(nuevoinventario);
               break;
            case 2:
               System.out.print("Ingrese el ID del producto: ");
               int id = scanner.nextInt();
               scanner.nextLine();
               System.out.print("Ingrese el precio costo del producto: ");
               double precioCosto = scanner.nextDouble();
               System.out.print("Ingrese el margen de ganancia del producto: ");
               float margenGanancia = scanner.nextInt();
               System.out.print("Ingrese el precio venta del producto: ");
               double precioVenta = scanner.nextDouble();
               System.out.print("Ingrese el valor de la ganancia producto: ");
               double valorGananacia = scanner.nextInt();
               System.out.print("Ingrese la cantidad actual producto: ");
               int cantidadActual = scanner.nextInt();
                //Producto producto = new Producto(id, nombre, precio, porcentaje, stock);
                //nuevoinventario.agregarProducto(producto);
               System.out.println("Producto agregado al inventario.");
               Producto productoEncontrado = null;
               for (Producto producto : itemsProductos) {
                  if (producto.getId()==id) {
                     productoEncontrado = producto;
                  }
               }
               ItemInventario nuevoItems = new ItemInventario(jhanYuler, null, null, productoEncontrado, precioCosto, margenGanancia, precioVenta, valorGananacia, cantidadActual);
               nuevoinventario.registrarEntrada(nuevoItems, jhanYuler);
               break;
            case 3:
            System.out.print("Ingrese el ID del producto: ");
            int idBuscar = scanner.nextInt();
            System.out.print("Ingrese la cantidad del producto retirado: ");
            int cantidadRetirada = scanner.nextInt();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            Producto productoEncontradoSalidaEntrada= null;
               for (Producto p : itemsProductos) {
                  if (p.getId()==idBuscar) {
                     
                  }
               }
                
               ventas.agregarVenta(nuevoinventario.registrarSalida(productoEncontradoSalidaEntrada,cantidadRetirada));
               System.out.print("Venta agregada correctamente");
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
               /*
                * Producto productoEncontradoEntrada
                * =nuevoinventario.buscarProducto(idVendidoEntrada);
                * Abastecimiento abastecimiento = new Abastecimiento(clienteEntrada,
                * productoEncontradoEntrada, cantidadEntrada);
                * abastecimiento.mostrarAbastecimiento();
                * nuevoinventario.modificarProducto(productoEncontradoEntrada.getId(),
                * productoEncontradoEntrada.getPrecio(),
                * productoEncontradoEntrada.getPorcentajeGanacia(),
                * productoEncontradoEntrada.getStock()-cantidadEntrada);
                */

               break;
            case 5:
               System.out.print("Ingrese el ID del producto: ");
               int idModificar = scanner.nextInt();
               System.out.print("Ingrese el precio costo: ");
               double precioCostoModificar = scanner.nextDouble();
               System.out.print("Ingrese el nuevo Margen de ganancia: ");
               float margenGananciaModificar = scanner.nextFloat();
               System.out.print("Ingrese el nuevo precio de venta: ");
               double precioVentaModificar = scanner.nextDouble();
               System.out.print("Ingrese valor de ganancia de venta: ");
               double valorGananaciaModificar = scanner.nextDouble();
               System.out.print("Ingrese la cantidad actual: ");
               int cantidadActualModificar = scanner.nextInt();
               Producto productoModificado = null;
               for (Producto producto : itemsProductos) {
                  if (producto.getId()==idModificar) {
                     productoModificado = producto;
                  }
               }
               ItemInventario itemInventarioModificar = nuevoinventario.buscar(productoModificado);
               itemInventarioModificar.setPrecioCosto(precioCostoModificar);
               itemInventarioModificar.setMargenGanacia(margenGananciaModificar);
               itemInventarioModificar.setPrecioVenta(precioVentaModificar);
               itemInventarioModificar.setValorGananacia(valorGananaciaModificar);
               itemInventarioModificar.setCantidadActual(cantidadActualModificar);
               System.out.println("producto modificado con exito");

               /*
                * nuevoinventario.modificarProducto(idModificar, precioNuevo,
                * porcentajeNuevo,stockNuevo);
                * System.out.println("Producto modificado con exito");
                * System.out.println("La nueva ganancia para este producto es de "
                * + nuevoinventario.mostrarganancia(idModificar));
                */
               break;
            case 6:
               salir = true;
               break;
            default:
               System.out.println("Opcion no valida.");
         }
      }

      scanner.close();
      System.out.println("Programa finalizado.");

   }

   public static List<Producto> crearProductos() {
      List<Producto> itemsProductos = new ArrayList<>();
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

      // crear productos
      for (int i = 0; i < nombresProductos.length; i++) {
         Producto nuevoProducto = new Producto(i, nombresProductos[i], "Es un " + nombresProductos[i]);
         itemsProductos.add(nuevoProducto);
      }

      return itemsProductos;
   }

   public static List<ItemInventario> crearItemsInventario(Persona jhanYuler, List<Producto> itemsProductos) {
      List<ItemInventario> itemsInventario = new ArrayList<>();

      for (int i = 0; i < itemsProductos.size(); i++) {
         ItemInventario nuevoItemInventario = new ItemInventario(jhanYuler, LocalDate.now(), null,
               itemsProductos.get(i), 0.0, 0, 0.0, 0.0, ((i + 1) * 11));
         itemsInventario.add(nuevoItemInventario);
      }

      return itemsInventario;

   }

}