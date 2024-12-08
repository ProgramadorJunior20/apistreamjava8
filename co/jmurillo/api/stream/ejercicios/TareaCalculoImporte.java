package co.jmurillo.api.stream.ejercicios;

import co.jmurillo.api.stream.models.TareaProducto;

import java.util.Arrays;
import java.util.List;

public class TareaCalculoImporte {
    public static void main(String[] args) {
        // Primero, creamos nuestra lista de productos
        List<TareaProducto> productos = Arrays.asList(
          new TareaProducto("Laptop", 1200.00, 2),
          new TareaProducto("Mouse", 25.50, 3),
          new TareaProducto("Monitor", 199.99, 1),
          new TareaProducto("Teclado", 45.99, 2)
        );

        // Calculamos el total usando stream
        double totalImporte = productos.stream()
                // Convertimos cada Producto a su importe (precio * cantidad)
                .mapToDouble(producto -> producto.getPrecio() * producto.getCantidad())
                // Sumamos todos los importes
                .sum();

        // Mostramos los detalles de cada producto
        System.out.println("Detalles de productos:");
        productos.forEach(p -> System.out.printf("%s: $%.2f x %d = $%.2f%n",
                p.getNombre(),
                p.getPrecio(),
                p.getCantidad(),
                p.getPrecio() * p.getCantidad()));

        // Mostramos el total
        System.out.printf("%nTotal del importe: $%.2f%n", totalImporte);

        // Método alternativo usando reduce
        double totalConReduce = productos.stream()
                .reduce(0.0,
                        (suma, producto) -> suma + (producto.getPrecio() * producto.getCantidad()),
                        Double::sum);
        System.out.printf("Total usando reduce: $%.2f%n", totalConReduce);
    }
}
