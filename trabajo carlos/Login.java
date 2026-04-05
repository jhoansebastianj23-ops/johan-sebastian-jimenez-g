import java.util.*;

public class Biblioteca {

    List<Libro> libros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<Prestamo> prestamos = new ArrayList<>();

    int maxPrestamos = 3;

    
    public void registrarLibro(Libro l) {
        for (Libro libro : libros) {
            if (libro.isbn.equals(l.isbn)) {
                System.out.println("ISBN repetido");
                return;
            }
        }
        libros.add(l);
    }

    public void listarLibros() {
        for (Libro l : libros) l.mostrar();
    }

    public Libro buscarLibro(String isbn) {
        for (Libro l : libros)
            if (l.isbn.equals(isbn)) return l;
        return null;
    }

    public void eliminarLibro(String isbn) {
        libros.removeIf(l -> l.isbn.equals(isbn));
    }
public void registrarUsuario(Usuario u) {
        for (Usuario user : usuarios) {
            if (user.documento.equals(u.documento)) {
                System.out.println("Documento repetido");
                return;
            }
        }
        usuarios.add(u);
    }

    public Usuario buscarUsuario(String doc) {
        for (Usuario u : usuarios)
            if (u.documento.equals(doc)) return u;
        return null;
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) u.mostrar();
    }
public void prestar(String isbn, String doc, Usuario admin) {
        if (!(admin.tipo.equals("Administrador") || admin.tipo.equals("Bibliotecario"))) {
            System.out.println("No tienes permiso");
            return;
        }

        Libro l = buscarLibro(isbn);
        Usuario u = buscarUsuario(doc);

        if (l == null || u == null) {
            System.out.println("Datos incorrectos");
            return;
        }

        if (!l.disponible) {
            System.out.println("Libro no disponible");
            return;
        }

        long cantidad = prestamos.stream().filter(p -> p.documento.equals(doc)).count();

        if (cantidad >= maxPrestamos) {
            System.out.println("Máximo de préstamos alcanzado");
            return;
        }

        prestamos.add(new Prestamo(isbn, doc));
        l.disponible = false;
    }

    public void devolver(String isbn) {
        prestamos.removeIf(p -> p.isbn.equals(isbn));

        Libro l = buscarLibro(isbn);
        if (l != null) l.disponible = true;
    }
}
