public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = true;
           }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarLibro() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("Estado: " + (disponible ? "Disponible" : "Prestado"));
    }
}


