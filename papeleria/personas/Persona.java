package papeleria.personas;

public abstract class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return this.nombre; }
    public abstract void mostrarInfo();
}
