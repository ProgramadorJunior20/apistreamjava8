package co.jmurillo.api.stream.ejemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamBasicos {
    public static void main(String[] args) {
        // 1. Creación de Streams desde diferentes fuentes
        List<String> nombres = Arrays.asList("Juan", "Ana", "Pedro");
        Stream<String> streamDeList = nombres.stream();

        String[] arrayNombres = {"Juan", "Ana", "Pedro"};
        Stream<String> streamDeArray = Arrays.stream(arrayNombres);

        Stream<String> streamDirecto = Stream.of("Juan", "Ana", "Pedro");

        // 2. Operaciones básicas
        System.out.println("--- Nombres originales ---");
        nombres.forEach(System.out::println);

        System.out.println("\n--- Nombres en mayúscula ---");
        nombres.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("\n--- Nombres que empiezan con 'J' ---");
        nombres.stream()
                .filter(n -> n.startsWith("J"))
                .forEach(System.out::println);

        // 3. Demostración de inmutabilidad
        Stream<String> streamOriginal = nombres.stream();
        Stream<String> streamModificado = streamOriginal.map(String::toUpperCase);

        // La lista original no se modifica
        System.out.println("\n--- Lista original sigue igual ---");
        nombres.forEach(System.out::println);
    }
}
