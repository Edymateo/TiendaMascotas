package itemInventario;

import java.time.LocalDate;

import productos.Producto;
import personas.Persona;

public class ItemInventario {

    private Persona proveedor;
    private LocalDate ultimaEntrada;
    private LocalDate ultimaSalida;
    private Producto producto;
    private double precioCosto;
    private float margenGanancia;
    private double precioVenta;
    private double valorGananacia;
    private int cantidadActual;

    public ItemInventario(Persona proveedor, LocalDate ultimaEntrada, LocalDate ultimaSalida, Producto producto,
            double precioCosto, float margenGanancia, double precioVenta, double valorGananacia, int cantidadActual) {
        this.proveedor = proveedor;
        this.ultimaEntrada = ultimaEntrada;
        this.ultimaSalida = ultimaSalida;
        this.producto = producto;
        this.precioCosto = precioCosto;
        this.margenGanancia = margenGanancia;
        this.precioVenta = precioVenta;
        this.valorGananacia = valorGananacia;
        this.cantidadActual = cantidadActual;
    }

    public Persona getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Persona proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getUltimaEntrada() {
        return this.ultimaEntrada;
    }

    public void setUltimaEntrada(LocalDate ultimaEntrada) {
        this.ultimaEntrada = ultimaEntrada;
    }

    public LocalDate getUltimaSalida() {
        return this.ultimaSalida;
    }

    public void setUltimaSalida(LocalDate ultimaSalida) {
        this.ultimaSalida = ultimaSalida;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioCosto() {
        return this.precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public float getMargenGanancia() {
        return this.margenGanancia;
    }

    public void setMargenGanancia(float margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getValorGananacia() {
        return this.valorGananacia;
    }

    public void setValorGananacia(double valorGananacia) {
        this.valorGananacia = valorGananacia;
    }

    public int getCantidadActual() {
        return this.cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void setMargenGanacia(float mg) {
        margenGanancia = mg;
        precioVenta = precioCosto / (1 - mg);
        valorGananacia = precioVenta - precioCosto;
    }

    public void retirar(int cantidadRetirar) {
        cantidadActual = (cantidadActual - cantidadRetirar);

    }


}