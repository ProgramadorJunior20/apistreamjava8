package co.jmurillo.api.stream.ejemplos;

import co.jmurillo.api.stream.models.Producto;


import java.util.*;
import java.util.stream.Collectors;

public class EjemploDemoProducto {
    public static void main(String[] args) {
        // 1. Trabajando con una lista de productos
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", 1200.0, "Electrónica"),
                new Producto("Smartphone", 800.0, "Electrónica"),
                new Producto("Libro", 25.0, "Libros"),
                new Producto("Tablet", 400.0, "Electrónica"),
        new Producto("Pantalon", 400.0, "Testil")
        );

        // 2. Filtrar productos de Electrónica
        System.out.println("Productos de Electrónica:");
        productos.stream()
                .filter(p -> p.getCategoria().equals("Electrónica"))
                .forEach(System.out::println);

        // 3. Calcular precio total de productos
        double precioTotal = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        System.out.println("\nPrecio total: $" + precioTotal);

        // 4. Agrupar productos por categoría
        Map<String, List<Producto>> porCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        System.out.println("\nProductos por categoría:");
        porCategoria.forEach( (categoria, prods) -> {
            System.out.println(categoria + ":");
            prods.forEach(p -> System.out.println(" - " + p));
        });

        // 5. Encontrar el producto más caro
        Optional<Producto> productoMasCaro = productos.stream()
                .max(Comparator.comparing(Producto::getPrecio));

        productoMasCaro.ifPresent(p ->
                System.out.println("\nProducto más caro: " + p));
    }
}
