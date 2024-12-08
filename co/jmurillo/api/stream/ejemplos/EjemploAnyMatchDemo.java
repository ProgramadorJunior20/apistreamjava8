package co.jmurillo.api.stream.ejemplos;

import co.jmurillo.api.stream.models.ProductoAnyMatch;

import java.util.*;
import java.util.stream.Stream;

public class EjemploAnyMatchDemo {
    public static void main(String[] args) {
        // 1. Ejemplo básico con números
        List<Integer> numeros = Arrays.asList(2, 4, 6, 8, 9, 10);

        // Verificar si existe algún número impar
        boolean hayImpar = numeros.stream()
                .peek(System.out::println)
                .anyMatch(n -> n % 2 != 0);
        System.out.println("¿Hay algún número impar? " + hayImpar);

        // 2. Ejemplo con cadenas
        List<String> palabras = Arrays.asList(
                "Java", "Stream", "Programming", "API"
        );

        // Verificar si existe alguna palabra con más de 6 letras
        boolean hayPalabraLarga = palabras.stream()
                .peek(System.out::println)
                .anyMatch(p -> p.length() > 6);
        System.out.println("\n¿Hay alguna palabra con más de 6 letras? " + hayPalabraLarga);

        // 3. Ejemplo con objetos complejos
        List<ProductoAnyMatch> productos = Arrays.asList(
                new ProductoAnyMatch("Laptop", 1200.0, 5),
                new ProductoAnyMatch("Mouse", 25.0, 0),
                new ProductoAnyMatch("Teclado", 50.0, 3)
        );

        // Verificar si hay productos sin stock
        boolean haySinStock = productos.stream()
                .peek(System.out::println)
                .anyMatch(p -> p.getStock() == 0);
        System.out.println("\n¿Hay productos sin stock? " + haySinStock);

        // Verificar si hay productos caros (más de 1000)
        boolean hayProductoCaro = productos.stream()
                .peek(System.out::println)
                .anyMatch(p -> p.getPrecio() > 1000);
        System.out.println("¿Hay productos caros? " + hayProductoCaro);

        // 4. Ejemplo con múltiples condiciones
        boolean hayProductosCarosConStock = productos.stream()
                .peek(System.out::println)
                .anyMatch(p -> p.getPrecio() > 1000 && p.getStock() > 0);
        System.out.println("¿Hay productos caros con stock? " + hayProductosCarosConStock);

        // 5. Ejemplo con Stream vacío
        boolean resultadoVacio = Stream.empty().anyMatch(x -> true);
        System.out.println("\n¿Stream vacío tiene coincidencias? " + resultadoVacio);
    }
}
