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
