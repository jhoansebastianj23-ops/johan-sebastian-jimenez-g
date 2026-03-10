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

