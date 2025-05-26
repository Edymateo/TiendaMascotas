package modelo;

import java.time.LocalDate;
import modelo.Producto;

public class Venta {
    public LocalDate fecha;
    public Producto producto;
    public String productoNombre;
    public int cantidad;
    public double valorTotal;

    

    public Venta(LocalDate fecha, Producto producto, int cantidad, double valorTotal) {
        this.fecha = fecha;
        this.productoNombre = producto.getNombre();
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
    }


    public Venta(Producto producto2, int cantidad2, double precioVenta, Object valorGanancia) {
        //TODO Auto-generated constructor stub
    }


    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
