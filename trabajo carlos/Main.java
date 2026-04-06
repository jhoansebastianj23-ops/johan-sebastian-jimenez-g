import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca b = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        // Usuario inicial
        Usuario admin = new Usuario("1", "Admin", "Administrador", "123");
        b.registrarUsuario(admin);

        System.out.println("=== LOGIN ===");
        System.out.print("Documento: ");
        String doc = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
Usuario log = b.buscarUsuario(doc);

        if (log == null || !log.password.equals(pass)) {
            System.out.println("Error de login");
            return;
        }

        int op;
        do {
            System.out.println("\n1. Registrar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("0. Salir");

            op = sc.nextInt();
            sc.nextLine();
switch (op) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Titulo: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = sc.nextInt();
                    sc.nextLine();

                    b.registrarLibro(new Libro(isbn, t, a, anio));
                    break;

                case 2:
                    b.listarLibros();
                    break;

                case 3:
                    System.out.print("Doc: ");
                    String d = sc.nextLine();
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();

                    b.registrarUsuario(new Usuario(d, n, tipo, p));
                    break;

                case 4:
                    b.listarUsuarios();
                    break;

                case 5:
                    System.out.print("ISBN: ");
                    String is = sc.nextLine();
                    System.out.print("Doc usuario: ");
                    String du = sc.nextLine();

                    b.prestar(is, du, log);
                    break;

                case 6:
                    System.out.print("ISBN: ");
                    String dev = sc.nextLine();
                    b.devolver(dev);
                    break;
            }

        } while (op != 0);
    }
}
