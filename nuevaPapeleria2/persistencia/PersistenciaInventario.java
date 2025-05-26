package persistencia;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import modelo.ItemInventario;
import modelo.Producto;

public class PersistenciaInventario {
    private String rutaArchivo;

    public PersistenciaInventario(String rutaArchivo) {
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

    public List<ItemInventario> leerInventario(List<Producto> productosDisponibles) {
        List<ItemInventario> inventario = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");

                int idProducto = Integer.parseInt(datos[1]);

                Producto producto = productosDisponibles.stream()
                        .filter(p -> p.getId() == idProducto)
                        .findFirst()
                        .orElse(null);

                if (producto == null) {
                    System.out.println("Producto con ID " + idProducto + " no encontrado. Se omite línea.");
                    continue;
                }

                LocalDate entrada = LocalDate.parse(datos[2]);
                LocalDate salida = LocalDate.parse(datos[3]);
                double precioCosto = Double.parseDouble(datos[4]);
                float margen = Float.parseFloat(datos[5]);
                double precioVenta = Double.parseDouble(datos[6]);
                double ganancia = Double.parseDouble(datos[7]);
                int cantidad = Integer.parseInt(datos[8]);

                ItemInventario item = new ItemInventario(entrada, salida, producto,
                        precioCosto, margen, precioVenta, ganancia, cantidad);
                inventario.add(item);
            }
        } catch (IOException e) {
            System.out.println("Error al leer inventario: " + e.getMessage());
        }
        return inventario;
    }

    public void guardarItemInventario(ItemInventario item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            String linea = item.getNombre() + "|" +
                    item.getProducto().getId() + "|" +
                    item.getUltimaEntrada() + "|" +
                    item.getUltimaSalida() + "|" +
                    item.getPrecioCosto() + "|" +
                    item.getMargenGanancia() + "|" +
                    item.getPrecioVenta() + "|" +
                    item.getValorGananacia() + "|" +
                    item.getCantidadActual();
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar item: " + e.getMessage());
        }
    }

}
