package co.jmurillo.api.stream.models;

public class ProductoAnyMatch {
    private String nombre;
    private double precio;
    private int stock;

    public ProductoAnyMatch(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return nombre + " (Precio: $" + precio + ", Stock: " + stock + ")";
    }
}