package nuevaPapeleria2.productos;
import papeleria.interfaces.Mostrable;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;

    

    public Producto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String precio) { this.descripcion=descripcion; }
    public void setId(int id) { this.id=id; }
    public void setNombre(String nombre) { this.nombre=nombre; }


}