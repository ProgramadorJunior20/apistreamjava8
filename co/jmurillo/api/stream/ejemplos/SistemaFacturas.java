package co.jmurillo.api.stream.ejemplos;

import co.jmurillo.api.stream.modelsflatmap.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaFacturas {
    public static void main(String[] args) {
        // Creamos algunos productos para nuestras facturas
        Producto laptop = new Producto("Laptop", 1200.0);
        Producto mause = new Producto("Mause", 25.0);
        Producto teclado = new Producto("Teclado", 50.0);
        Producto monitor = new Producto("Monitor", 200.0);

        // Creamos algunas facturas con sus detalles
        Factura factura1 = new Factura("F001", LocalDate.now(), Arrays.asList(
                new DetalleFactura(laptop, 1),
                new DetalleFactura(mause, 2)
        ));

        Factura factura2 = new Factura("F002", LocalDate.now().minusDays(1), Arrays.asList(
                new DetalleFactura(monitor, 1),
                new DetalleFactura(teclado, 1)
        ));

        // Creamos algunos usuarios con sus facturas
        Usuario usuario1 = new Usuario("Juan", "juan@email.com", Arrays.asList(factura1));
        Usuario usuario2 = new Usuario("Ana", "ana@email.com", Arrays.asList(factura2));

        // Lista de todos los usuarios
        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);


        // 1. Obtener todos los productos comprados por todos los usuarios
        System.out.println("--- Todos los productos comprados ---");
        List<Producto> todosLosProductos = usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())       // Aplanamos las facturas de cada usuario
                .flatMap(f -> f.getDetalles().stream())      // Aplanamos los detalles de cada factura
                .map(DetalleFactura::getProducto)           // Obtenemos el producto de cada detalle
                .distinct()                                // Eliminamos duplicados
                //.collect(Collectors.toList())
                .toList();

        todosLosProductos.forEach(p -> System.out.println(p.getNombre()));

        // 2. Calcular el total gastado por todos los usuarios
        System.out.println("\n--- Total gastado por todos los usuarios ---");
        double totalGastado = usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .flatMap(f -> f.getDetalles().stream())
                .mapToDouble(d -> d.getProducto().getPrecio() * d.getCantidad())
                .sum();

        System.out.println("Total: $" + totalGastado);

        // 3. Obtener todos los productos con cantidad > 1
        System.out.println("\n--- Productos con cantidad mayor a 1 ---");
        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .flatMap(f -> f.getDetalles().stream())
                .filter( d -> d.getCantidad() > 1)
                .map(d -> d.getProducto().getNombre() + " (Cantidad: " + d.getCantidad() + ")")
                .forEach(System.out::println);



    }
}