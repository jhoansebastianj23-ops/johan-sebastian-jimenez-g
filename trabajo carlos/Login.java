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
