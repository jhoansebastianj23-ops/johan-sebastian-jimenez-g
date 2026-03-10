import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static Usuario iniciarSesion(ArrayList<Usuario> usuarios) {

        Scanner sc = new Scanner(System.in);

        int intentos = 0;
        int maxIntentos = Integer.parseInt(Config.propiedades.getProperty("maxIntentosLogin"));

        while (intentos < maxIntentos) {

            System.out.println("Documento:");
            String doc = sc.nextLine();

            System.out.println("Contraseña:");
            String pass = sc.nextLine();

            for (Usuario u : usuarios) {

                if (u.documento.equals(doc) && u.password.equals(pass)) {

                    System.out.println("Bienvenido " + u.nombre);
                    return u;

                }

            }

            intentos++;
            System.out.println("Datos incorrectos.");

        }

        System.out.println("Usuario bloqueado.");
        return null;

    }

}
