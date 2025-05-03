package PersistenciaProductos;

import java.io.*;
import java.util.*;

import productos.Producto;
public class PersistenciaProductos {
    private String rutaArchivo;

    public PersistenciaProductos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
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
                String[] datos = linea.split("\\|");
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    Producto producto = new Producto(id, nombre, descripcion);
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
                String linea = producto.getId() + "\\|" + producto.getNombre() + "-/-" + producto.getDescripcion();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los productos: " + e.getMessage());
        }
    }
    
}
