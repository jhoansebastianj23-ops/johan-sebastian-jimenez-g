import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    public static Properties propiedades = new Properties();

    public static void cargarConfig() {

        try {

            FileInputStream archivo = new FileInputStream("config.properties");
            propiedades.load(archivo);

        } catch (Exception e) {

            System.out.println("Error: No se encontró el archivo de configuración.");

        }

    }

}