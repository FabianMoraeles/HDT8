import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Heap ColaP = new Heap(10);

        
        String[] datos = {
            "Juan Perez,fractura de pierna,C",
            "Maria Ramirez,apendicitis,A",
            "Lorenzo Toledo,chikunguya,E",
            "Carmen Sarmientos,dolores de parto,B",
            "Fabián Morales,cacaceca,B"
        };

        
        try {
            File archivo = new File("Pacientes.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");
                String nombre = campos[0].trim();
                String motivo = campos[1].trim();
                char prioridad = campos[2].trim().charAt(0);
                ColaP.insertar(new Paciente(nombre, motivo, prioridad));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
            e.printStackTrace();
        }

        
        System.out.println("Orden de atención según prioridad:");
        while (true) {
            try {
                Paciente paciente = ColaP.Eliminacion();
                System.out.println(paciente.nombre + ", Razón: " + paciente.motivo + " con una prioridad: " + paciente.prioridad);
            } catch (IllegalStateException e) {
                break;
            }
        }
    }
}
