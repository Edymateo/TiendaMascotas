package ventas;

import java.util.List;
import venta.Venta;

public class Ventas {
    
    private List<Venta> ventas;

    public Ventas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Venta> getVentas() {
        return this.ventas;
    }


    public void agregarVenta(Venta venta) {
        this.ventas.add(venta);
    }

}
