package co.jmurillo.api.stream.appventasmodels;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private String numero;
    private LocalDate fecha;
    private List<DetalleVenta> detalles;

    public Venta(String numero, LocalDate fecha, List<DetalleVenta> detalles) {
        this.numero = numero;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public List<DetalleVenta> getDetalles() {return detalles;}
    public LocalDate getFecha() {return fecha;}

}
