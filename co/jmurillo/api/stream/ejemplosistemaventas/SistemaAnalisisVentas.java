package co.jmurillo.api.stream.ejemplosistemaventas;

import co.jmurillo.api.stream.appventasmodels.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SistemaAnalisisVentas {
    public static void main(String[] args) {
        // Creamos datos de ejemplo
        List<Venta> ventas = Arrays.asList(
                new Venta("V001", LocalDate.now(), Arrays.asList(
                        new DetalleVenta(new Producto("Laptop", 1200.00, Categoria.TECNOLOGIA), 5),
                        new DetalleVenta(new Producto("Mouse", 25.50, Categoria.TECNOLOGIA), 3)
                )),
                new Venta("V002", LocalDate.now().minusDays(1), Arrays.asList(
                        new DetalleVenta(new Producto("Monitor", 199.99, Categoria.TECNOLOGIA), 1),
                        new DetalleVenta(new Producto("Libro Java", 45.99, Categoria.LIBROS), 2)
                )),
                new Venta("V003", LocalDate.now().minusDays(2), Arrays.asList(
                        new DetalleVenta(new Producto("Teclado", 45.99, Categoria.TECNOLOGIA), 2),
                        new DetalleVenta(new Producto("Libro Python", 39.99, Categoria.LIBROS), 9)
                ))
        );

        // 1. Calcular total de ventas por categoría
        System.out.println("=== Total de Ventas por Categoría ===");
        Map<Categoria, Double> ventasPorCategoria = ventas.stream()
                .flatMap(v -> v.getDetalles().stream())
                .collect(Collectors.groupingBy(
                        d -> d.getProducto().getCategoria(),
                        Collectors.summingDouble(d -> d.getCantidad() * d.getProducto().getPrecio())
                ));
        ventasPorCategoria.forEach((cat, total) ->
                System.out.printf("%s: $%.2f%n", cat, total));

        // 2. Encontrar el producto más vendido
        System.out.println("\n=== Producto Más Vendido ===");
        Optional<DetalleVenta> productoMasVendido = ventas.stream()
                .flatMap(v -> v.getDetalles().stream())
                .collect(Collectors.groupingBy(
                        DetalleVenta::getProducto,
                        Collectors.summingInt(DetalleVenta::getCantidad)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> new DetalleVenta(entry.getKey(), entry.getValue()));
        productoMasVendido.ifPresent( d ->
                System.out.printf("%s - %d unidades%n",
                        d.getProducto().getNombre(), d.getCantidad())
        );

        // 3. Calcular el promedio de venta por factura
        System.out.println("\n=== Promedio de Venta por Factura ===");
        double promedioVenta = ventas.stream()
                .mapToDouble(v -> v.getDetalles().stream()
                        .mapToDouble(d -> d.getProducto().getPrecio() * d.getCantidad())
                        .sum())
                .average()
                .orElse(0.0);

        System.out.printf("Promedio: $%.2f%n", promedioVenta);
    }
}
