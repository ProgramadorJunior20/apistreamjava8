package co.jmurillo.api.stream.modelsflatmap;

import java.util.List;

public class Usuario {
    private String nombre;
    private String email;
    private List<Factura> facturas;

    public Usuario(String nombre, String email, List<Factura> facturas) {
        this.nombre = nombre;
        this.email = email;
        this.facturas = facturas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}
