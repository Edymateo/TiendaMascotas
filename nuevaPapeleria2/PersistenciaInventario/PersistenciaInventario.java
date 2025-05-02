import java.io.*;
import java.util.ArrayList;
import java.util.List;

import itemInventario.ItemInventario;
import productos.Producto;

public class PersistenciaInventario{
    private String rutaArchivo;

    public PersistenciaInventario(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        crearArchivoSiNoExiste();
    }

    // Crea el archivo si no existe
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

    public List<ItemInventario> leerInventario() {
        List<ItemInventario> inventario = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("-/-");
                if (datos.length == 4) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];

                    ItemInventario itemInventario = new ItemInventario(id, nombre, descripcion);
                    inventario.add(producto);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return productos;
    }

}
