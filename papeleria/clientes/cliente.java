package papeleria.clientes;
import papeleria.personas.Persona;

public class Cliente extends Persona{
    private String telefono;

    public Cliente(String nombre, String telefono) {
        super(nombre);
        this.telefono = telefono;
    }

    public String getTelefono() { return telefono; }

    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + getNombre() + ", Telefono: " + telefono);
    }
}