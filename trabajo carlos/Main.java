import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Config.cargarConfig();

        System.out.println(Config.propiedades.getProperty("nombreBiblioteca"));
        System.out.println("Version: " + Config.propiedades.getProperty("versionSistema"));

        usuarios.add(new Usuario("1", "Admin", "Administrador", "123"));

        Usuario usuarioActual = Login.iniciarSesion(usuarios);

        if (usuarioActual == null) {
            return;
        }

        int opcion;

        do {

            System.out.println("1 Registrar libro");
            System.out.println("2 Listar libros");
            System.out.println("3 Registrar usuario");
            System.out.println("4 Registrar prestamo");
            System.out.println("5 Devolver libro");
            System.out.println("6 Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarLibro();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    registrarUsuario();
                    break;

                case 4:
                    registrarPrestamo();
                    break;

                case 5:
                    devolverLibro();
                    break;

            }

        } while (opcion != 6);

    }

    static void registrarLibro() {

        System.out.println("ISBN:");
        String isbn = sc.nextLine();

        System.out.println("Titulo:");
        String titulo = sc.nextLine();

        System.out.println("Autor:");
        String autor = sc.nextLine();

        System.out.println("Año:");
        int anio = sc.nextInt();
        sc.nextLine();

        if (anio > 2026) {

            System.out.println("Año inválido.");
            return;

        }

        libros.add(new Libro(isbn, titulo, autor, anio));

        System.out.println("Libro registrado.");

    }

    static void listarLibros() {

        for (Libro l : libros) {

            l.mostrar();

        }

    }

    static void registrarUsuario() {

        System.out.println("Documento:");
        String doc = sc.nextLine();

        System.out.println("Nombre:");
        String nombre = sc.nextLine();

        System.out.println("Rol:");
        String rol = sc.nextLine();

        System.out.println("Contraseña:");
        String pass = sc.nextLine();

        usuarios.add(new Usuario(doc, nombre, rol, pass));

        System.out.println("Usuario registrado.");

    }

    static void registrarPrestamo() {

        System.out.println("ISBN del libro:");
        String isbn = sc.nextLine();

        for (Libro l : libros) {

            if (l.isbn.equals(isbn) && l.disponible) {

                l.disponible = false;
                System.out.println("Prestamo realizado.");
                return;

            }

        }

        System.out.println("Libro no disponible.");

    }

    static void devolverLibro() {

        System.out.println("ISBN del libro:");
        String isbn = sc.nextLine();

        for (Libro l : libros) {

            if (l.isbn.equals(isbn)) {

                l.disponible = true;
                System.out.println("Libro devuelto.");
                return;

            }

        }

    }

}
