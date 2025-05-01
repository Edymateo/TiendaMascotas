package itemInventario;

import java.time.LocalDate;

import nuevaPapeleria2.productos.Producto;
import nuevaPapeleria2.personas.Persona;

public class itemInventario {

    private Persona proveedor; 
    private LocalDate ultimaEntrada; 
    private LocalDate ultimaSalida; 
    private Producto producto; 
    private double precioCosto; 
    private float margenGanancia; 
    private double precioVenta; 
    private double valorGananacia; 
    private int cantidadActual;
    
    
    //constructores  getters and setters


    public void setMargenGanacia(float mg){
        margenGanancia=mg;
        precioVenta=precioCosto/(1 - mg);
        valorGananacia=precioVenta-precioCosto;
    }



}