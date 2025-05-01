package empleados;

import personas.Persona;

public class Empleado extends Persona {

    private String puesto;
    private int codigo;

    public Empleado(String nombre, int codigo,String puesto) {
        super(nombre);
        this.puesto = puesto;
        this.codigo = codigo;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado: " + getNombre() + ", Puesto: " + this.puesto);
    }
}
