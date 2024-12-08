package co.jmurillo.api.stream.ejemplos;

import co.jmurillo.api.stream.models.UsuarioOptional;

import java.util.Optional;

public class EjemploOptionalDemo {
    public static void main(String[] args) {
        // 1. Creación de Optional
        // Crear Optional con un valor
        Optional<String> optionalConValor = Optional.of("Hola Mundo");

        // Crear Optional vacío
        Optional<String> optionalVacio = Optional.empty();

        // Crear Optional que puede ser null
        String valorNulo = null;
        Optional<String> optionalNullable = Optional.ofNullable(valorNulo);

        // 2. Métodos básicos
        System.out.println("--- Métodos básicos ---");
        // Verificar si hay valor presente
        System.out.println("¿Tiene valor? " + optionalConValor.isPresent());
        System.out.println("¿Está vacío? " + optionalConValor.isEmpty());

        // 3. Obtener valores
        System.out.println("\n--- Obtener valores ---");
        // Obtener valor directamente (puede lanzar NoSuchElementException)
        System.out.println("Valor directo: " + optionalConValor.get());

        // Obtener valor con valor por defecto
        String valorPorDefecto= optionalVacio.orElse("Valor Por defecto 1");
        System.out.println("Valor por defecto: " + valorPorDefecto);

        // Obtener valor o lanzar excepción personalizada
        try {
            String valor = optionalVacio.orElseThrow(() ->
                    new RuntimeException("Optional vacío"));
        }catch (RuntimeException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        // 4. Transformaciones y filtros
        System.out.println("\n--- Transformaciones ---");
        Optional<Integer> longitud = optionalConValor
                .map(str -> str.length());
        System.out.println("Longitud del string: " + longitud.orElse(0));

        // Filtrar valores
        Optional<String> filtrado = optionalConValor
                .filter(str -> str.contains("Mundo"));
        System.out.println("Después de filtrar: "  + filtrado.orElse("No encontrado"));

        // 5. Ejemplo práctico con Usuario
        UsuarioOptional usuarioOptional = new UsuarioOptional("Juan", "juan@email.com");
        Optional<UsuarioOptional> optUsuario = Optional.of(usuarioOptional);

        // Obtener email en mayúsculas si existe el usuario
        String email = optUsuario
                .map(UsuarioOptional::getEmail)
                .map(String::toUpperCase)
                .orElse("Usuario no disponible");

        System.out.println("\n--- Ejemplo práctico ---");
        System.out.println("Email en mayúsculas: " + email);

        // 6. Uso de ifPresent y ifPresentOrElse
        System.out.println("\n--- ifPresent y ifPresentOrElse ---");
        optionalConValor.ifPresent(valor -> System.out.println("Valor presente: " + valor));

        optionalVacio.ifPresentOrElse(
                valor -> System.out.println("Valor: " + valor),
                () -> System.out.println("No hay valor presente")
        );

    }
}
