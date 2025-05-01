package PersistenciaInventario;
import java.io.*;
import java.util.*;

import itemInventario.ItemInventario;
import productos.Producto;

public class GestorInventario {
    public static void main(String[] args) {
        String rutaProductos = "productos.txt";
        String rutaInventario = "inventario.txt";

        List<Producto> productos = new ArrayList<>();
        List<ItemInventario> items = new ArrayList<>();

        try {
            // Leer productos
            try (BufferedReader br = new BufferedReader(new FileReader(rutaProductos))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    Map<String, String> datos = parseLinea(linea);
                    Producto p = new Producto(
                            datos.get("id"),
                            datos.get("nombre"),
                            datos.get("descripcion"),
                            Double.parseDouble(datos.get("precio"))
                    );
                    productos.add(p);
                }
            }

            // Leer items del inventario
            try (BufferedReader br = new BufferedReader(new FileReader(rutaInventario))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    Map<String, String> datos = parseLinea(linea);
                    ItemInventario item = new ItemInventario(
                            datos.get("idProducto"),
                            Integer.parseInt(datos.get("cantidad")),
                            datos.get("lote")
                    );
                    items.add(item);
                }
            }

            // Crear inventario
            Inventario inventario = new Inventario(items);

            // Mostrar inventario con nombre de producto
            System.out.println("Inventario:");
            for (ItemInventario item : inventario.getItems()) {
                Producto prod = buscarProductoPorId(productos, item.getIdProducto());
                if (prod != null) {
                    System.out.println("- Producto: " + prod.getNombre() +
                            ", Cantidad: " + item.getCantidad() +
                            ", Lote: " + item.getLote());
                } else {
                    System.out.println("- Producto con ID " + item.getIdProducto() + " no encontrado.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivos: " + e.getMessage());
        }
    }

    // Método utilitario para parsear líneas tipo clave:valor
    private static Map<String, String> parseLinea(String linea) {
        Map<String, String> datos = new HashMap<>();
        String[] partes = linea.split(",");
        for (String parte : partes) {
            String[] kv = parte.split(":", 2);
            if (kv.length == 2) {
                datos.put(kv[0].trim(), kv[1].trim());
            }
        }
        return datos;
    }

    // Buscar producto en la lista por ID
    
}
