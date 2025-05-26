package persistencia;

import java.io.*;
import java.util.*;

import modelo.Producto;

public class PersistenciaProductos {
    private String rutaArchivo;

    public PersistenciaProductos() {
        this.rutaArchivo = "productos.txt";
        crearArchivoSiNoExiste();
    }

    public void crearArchivoSiNoExiste() {
        File archivo = new File(rutaArchivo);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
                System.out.println("Archivo creado: " + rutaArchivo);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("-");
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    int cantidad = Integer.parseInt(datos[3]);
                    int precio = Integer.parseInt(datos[4]);

                    Producto producto = new Producto(id, nombre, descripcion,cantidad, precio);
                    productos.add(producto);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return productos;
    }

    public void guardarTodosLosProductos(List<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Producto producto : productos) {
                String linea = producto.getId() + "-" + producto.getNombre() + "-" + producto.getDescripcion();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los productos: " + e.getMessage());
        }
    }

    public void agregarProducto(Producto nuevoProducto) {
    List<Producto> productos = leerProductos();

    for (Producto p : productos) {
        if (p.getId() == nuevoProducto.getId()) {
            System.out.println("Ya existe un producto con el ID: " + nuevoProducto.getId());
            return;
        }
    }

    // Agregar el nuevo producto a la lista
    productos.add(nuevoProducto);       

    // Guardar la lista completa actualizada
    guardarTodosLosProductos(productos);
    System.out.println("Producto agregado correctamente.");
    }



}
    

