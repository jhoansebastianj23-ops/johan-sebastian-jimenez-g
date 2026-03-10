public class Usuario {

    private String documento;
    private String nombre;
    private String tipoUsuario; // Administrador, Bibliotecario o Lector

    public Usuario(String documento, String nombre, String tipoUsuario) {
        this.documento = documento;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void mostrarUsuario() {
        System.out.println("Documento: " + documento);
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de usuario: " + tipoUsuario);
    }
}

