package papeleria.productos;
import papeleria.interfaces.Mostrable;

public class Producto implements Mostrable {
    private int id;
    private String nombre;
    private int precio;
    private double porcentajeGanacia;
    private int stock;

    public Producto(int id, String nombre, int precio, double porcentajeGanacia,int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.porcentajeGanacia = porcentajeGanacia;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getPrecio() { return this.precio; }
    public int getStock() { return this.stock; }
    public double getPorcentajeGanacia() { return this.porcentajeGanacia; }
    public void setPrecio(int precio) { this.precio=precio; }
    public void setStock(int stock) { this.stock=stock; }
    public void setPorcentajeGanacia(double porcentaje) { this.porcentajeGanacia=porcentaje; }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Porcentaje ganancia: " +porcentajeGanacia+ ", Stock: " +stock);
    }
}