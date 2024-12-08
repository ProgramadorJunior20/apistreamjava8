package co.jmurillo.api.stream.ejercicios;

import java.util.Arrays;
import java.util.stream.Stream;

public class TareaRepetidos {
    public static void main(String[] args) {
        //El siguiente ejercicio es aplanar un arreglo bidimensional en un nivel y
        // eliminar repetidos usando el api stream.

        // Definimos nuestro array bidimensional de lenguajes
        String[][] lenguajes = {
                {"Java", "Groovy"},
                {"PHP"},
                {"c#", "Python", "Groovy"},
                {"Java", "Javascript", "Kotlin"},
                {"Javascript"},
                {}
        };

        // Solución usando flatMap y distinct
        String[] lenguajesAplanados = Arrays.stream(lenguajes) // Convertimos el array exterior a Stream
                .flatMap(Arrays::stream)     // Aplanamos cada subarray en un único Stream
                .distinct()                 // Eliminamos duplicados
                .toArray(String[]::new);   // Convertimos el resultado a un array

        // Mostramos el resultado
        System.out.println("Array original (bidimensional):");
        Arrays.stream(lenguajes)
                .forEach(subArray -> System.out.println(Arrays.toString(subArray)));

        System.out.println("\nArray aplanado (sin duplicados):");
        System.out.println(Arrays.toString(lenguajesAplanados));

        // Solución alternativa usando collect
        System.out.println("\nUsando collect (resultado igual):");
        String[] resultadoAlternativo = Arrays.stream(lenguajes)
                .flatMap(Stream::of)
                .distinct()
                .toArray(String[]::new);
        System.out.println(Arrays.toString(resultadoAlternativo));



    }
}
