package co.jmurillo.api.stream.ejemplos;

import co.jmurillo.api.stream.models.Empleado;

import java.util.*;
import java.util.stream.Collectors;

public class EjemploDemoFilter {
    public static void main(String[] args) {
        // Ejemplo 1: Filtrado básico con números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("--- Filtrado de números pares ---");
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0) // Predicado para números pares
                //.collect(Collectors.toList());
                .toList();
        System.out.println("Números pares: " + pares);
        System.out.println("******************************************************");
        // Ejemplo 2: Filtrado con objetos
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Juan", "Desarrollo", 45000),
                new Empleado("Ana", "Marketing", 38000),
                new Empleado("Pedro", "Desarrollo", 42000),
                new Empleado("María", "Ventas", 48000)
        );

        // Filtrado por departamento
        System.out.println("\n--- Empleados de Desarrollo ---");
        empleados.stream()
                .filter(emp -> emp.getDepartamento().equals("Desarrollo"))
                .forEach(System.out::println);

        // Filtrado por salario
        System.out.println("\n--- Empleados con salario mayor a 40000 ---");
        empleados.stream()
                .filter(emp -> emp.getSalario() > 40000)
                .forEach(System.out::println);

        // Ejemplo 3: Múltiples condiciones de filtrado
        System.out.println("\n--- Empleados de Desarrollo con salario > 43000 ---");
        empleados.stream()
                .filter(emp -> emp.getDepartamento().equals("Desarrollo"))
                .filter(emp -> emp.getSalario() > 43000) // Podemos encadenar múltiples filters
                // Alternativa: .filter(emp -> emp.getDepartamento().equals("Desarrollo") && emp.getSalario() > 43000)
                .forEach(System.out::println);

        // Ejemplo 4: Filtrado con Optional
        System.out.println("\n--- Primer empleado de Marketing ---");
        Optional<Empleado> primerMarketing = empleados.stream()
                .filter(emp -> emp.getDepartamento().equals("Marketing"))
                .findFirst();
        primerMarketing.ifPresent(System.out::println); // ifPresent: Si hay un valor presente,
        // realiza la acción indicada con el valor; de lo contrario, no hace nada.

        // Ejemplo 5: Filtrado y recolección de estadísticas
        System.out.println("\n--- Estadísticas de salarios en Desarrollo ---");
        DoubleSummaryStatistics stats = empleados.stream()
                .filter(emp -> emp.getDepartamento().equals("Desarrollo"))
                .mapToDouble(Empleado::getSalario)
                .summaryStatistics();

        System.out.println("Salario promedio en Desarrollo: " + stats.getAverage());
        System.out.println("Salario máximo en Desarrollo: " + stats.getMax());
        System.out.println("Salario mínimo en Desarrollo: " + stats.getMin());

    }
}