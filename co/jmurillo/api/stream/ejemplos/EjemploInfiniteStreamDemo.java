package co.jmurillo.api.stream.ejemplos;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploInfiniteStreamDemo {
    public static void main(String[] args) {
        // 1. Stream infinito usando iterate
        System.out.println("Stream infinito de números:");
        Stream.iterate(1, n -> n + 1)
                .limit(1000) // Limitamos a 5 elementos para el ejemplo
                .forEach(System.out::println);

        // 2. Stream infinito usando generate
        System.out.println("\nStream infinito de timestamps:");
        Stream.generate(() -> LocalTime.now())
                .limit(10)
                .forEach(System.out::println);

        // 3. Fibonacci usando iterate
        System.out.println("\nSecuencia Fibonacci:");
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(20)
                .map(f -> f[0])
                .forEach(System.out::println);

        // 4. Stream infinito con delay
        System.out.println("\nStream con intervalo de tiempo:");
        try {
            Stream.generate(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1); // Espera 1 segundo
                    return "Evento en: " + LocalTime.now();
                } catch (InterruptedException e) {
                    return "Interrumpido";
                }
            })
                    .limit(3)
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Stream de números pares infinito
        System.out.println("\nNúmeros pares:");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }
}
