import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Producto p : productos) {
            subtotal += p.getSubtotal();
        }
        return subtotal;
    }

    // SINTOMA: cada promocion nueva obliga a abrir y modificar este metodo
    public double calcularTotal(String promocion) {
        double subtotal = getSubtotal();
        if (promocion.equals("BLACK_FRIDAY")) {
            return subtotal * 0.80;
        } else if (promocion.equals("ESTUDIANTE")) {
            return subtotal * 0.90;
        } else if (promocion.equals("BONO_20MIL")) {
            if (subtotal >= 150000) {
                return subtotal - 20000;
            }
            return subtotal;
        }
        return subtotal; // "NINGUNA"... o cualquier texto mal escrito
    }
}
