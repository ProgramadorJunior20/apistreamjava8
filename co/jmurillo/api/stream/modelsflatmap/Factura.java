package co.jmurillo.api.stream.modelsflatmap;

import java.time.*;
import java.util.List;

public class Factura {
    private String numero;
    private LocalDate fecha;
    private List<DetalleFactura> detalles;

    public Factura(String numero, LocalDate fecha, List<DetalleFactura> detalles) {
        this.numero = numero;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }
}
