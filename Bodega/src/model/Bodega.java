package model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * @author Alejandra Carreño P
 */
public class Bodega {
    private List<Producto> productos;

    public Bodega() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equals(id));
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public void ordenarPorNombre() {
        productos.sort(Comparator.comparing(Producto::getNombre));
    }

    public void ordenarPorPrecio() {
        productos.sort(Comparator.comparingDouble(Producto::getPrecio));
    }

    public void cambiarProducto(Producto producto) {
        productos.add(producto);
        String id = producto.getId();
        Producto productob = buscarProductoPorId(id);
        productos.remove(productob);
    }
}