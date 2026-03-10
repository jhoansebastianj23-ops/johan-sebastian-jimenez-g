public class Libro {

    String isbn;
    String titulo;
    String autor;
    int anio;
    boolean disponible;

    public Libro(String isbn, String titulo, String autor, int anio) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = true;

    }

    public void mostrar() {

        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("Estado: " + (disponible ? "Disponible" : "Prestado"));
        System.out.println("--------------------");

    }

}