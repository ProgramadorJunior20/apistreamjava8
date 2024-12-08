package co.jmurillo.api.stream.ejercicios;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TareaNumeroMayor {
    public static void main(String[] args) {
        // Creamos una lista de números para probar
        List<Integer> numeros = Arrays.asList(18, 6, 4, 15, 22, 62, 1253, 1928, 24);


        // Definimos la función que encuentra el mayor entre dos números
        Function<List<Integer>, Integer> encontrarMayor = lista ->
                lista.stream()
                        .reduce((a, b) -> a > b ? a : b)
                        .orElseThrow(() -> new IllegalArgumentException("Lista Vacia"));

        // Aplicamos la función y mostramos el resultado
        Integer numeroMayor = encontrarMayor.apply(numeros);
        System.out.println("Lista Original: " + numeros);
        System.out.println("Numero Mayor: " + numeroMayor);
    }
}
