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
