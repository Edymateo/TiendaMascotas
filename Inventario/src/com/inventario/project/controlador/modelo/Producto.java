package com.inventario.project.controlador.modelo;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;

    public Producto(int id, String nombre, String descripcion, int cantidad, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }



	public Producto(int int1) {
		// TODO Auto-generated constructor stub
	}



	public Producto() {
		// TODO Auto-generated constructor stub
	}




	//getters and setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;

}
 
 
 
 
}
