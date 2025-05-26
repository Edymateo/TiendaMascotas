package com.inventario.project.persitencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.inventario.project.controlador.Controlador;
import com.inventario.project.controlador.modelo.Producto;

public class PersistenciaInventario {


	private Controlador controlador;
	private String rutaArchivo = "productos.txt";



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

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;

	}

	public ArrayList<Producto> verInventario() {

		ArrayList<Producto> productos = new  ArrayList<>();
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

	public boolean guardarTodosLosProductos(List<Producto> productos) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
			for (Producto producto : productos) {
				String linea = producto.getId() + "-" + producto.getNombre() + "-" + producto.getDescripcion()+ "-" + producto.getCantidad()+ "-" + producto.getPrecio();
				writer.write(linea);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al guardar los productos: " + e.getMessage());
			return false;
		}
		return true;
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

	public boolean agregarProducto(Producto nuevoProducto) {
		List<Producto> productos = leerProductos();

		for (Producto p : productos) {
			if (p.getId() == nuevoProducto.getId()) {
				return false;

			}
		}
		// Agregar el nuevo producto a la lista
		productos.add(nuevoProducto);       
		// Guardar la lista completa actualizada
		return guardarTodosLosProductos(productos);

	}








}
