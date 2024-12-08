package co.jmurillo.api.stream.ejercicios;

import java.util.stream.IntStream;

public class TareaStream1 {
    public static void main(String[] args) {
        /*
        Como desafió consiste en un arreglo de 100 elementos del 1 al 100,
        del tipo int, utilizando el api stream se pide eliminar los divisibles en 10,
        luego convertir los elementos restante del flujo en tipo double y dividirlos en 2,
        para finalmente devolver la suma total de todos ellos usando el operador terminal reduce.
        El resultado debería ser 2250.0
        */

        // 1. Crear el stream de números del 1 al 100
        double resultado = IntStream.rangeClosed(1, 100)

                // 2. Filtrar: eliminar los divisibles por 10
                .filter(n -> n % 10 != 0)

                // 2. Filtrar: eliminar los divisibles por 10
                .mapToDouble(n -> n / 2.0)
                .reduce(0.0, Double::sum);

        System.out.println("Resultado: " + resultado);
        System.out.println("¿Es Correcto? " + (resultado == 2250.0)); // ¿ true o false ?
    }
}
