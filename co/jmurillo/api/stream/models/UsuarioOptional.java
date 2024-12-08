package co.jmurillo.api.stream.models;

public class UsuarioOptional {
    private String nombre;
    private String email;

    public UsuarioOptional(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
