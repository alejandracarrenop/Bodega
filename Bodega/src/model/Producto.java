package model;

/**
 * @author Alejandra Carreño P
 */
public class Producto {
    private String Id;
    private String nombre;
    private String categoría;
    private int cantidad;
    private double precio;
    public Producto(String id, String n, String cg, int ct, double p){
        this.Id = id;
        this.nombre = n;
        this.categoría = cg;
        this.cantidad = ct;
        this.precio = p;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String cg) {
        this.categoría = cg;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int ct) {
        this.cantidad = ct;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double p) {
        this.precio = p;
    }
    
    @Override
    public String toString() {
        return "Producto{" +
               "id='" + Id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", categoría='" + categoría + '\'' +
               ", cantidad=" + cantidad +
               ", precio=" + precio +
               '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return Id.equals(producto.Id);
    }

    @Override
    public int hashCode() {
        return Id.hashCode();
    }
}