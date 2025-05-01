package PersistenciaProductos;

import java.io.*;
import java.util.*;

import productos.Producto;

public class PersistenciaProductos {
    public List<Producto> cargarProductos() {
        String rutaProductos = "productos.txt";
        List<Producto> productos = new ArrayList<>();


            try (BufferedReader br = new BufferedReader(new FileReader(rutaProductos))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    Map<String, String> datos = parseLinea(linea);
                    Producto p2 = new Producto(0, rutaProductos, linea);
                    Producto p = new Producto(
                            Integer.parseInt(datos.get("id")),
                            datos.get("nombre"),
                            datos.get("descripcion")
                    );
                    productos.add(p);
                }         
            }catch (IOException e) {
                System.out.println("Error al leer archivos: " + e.getMessage());
            }
        
            return productos;
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

}
