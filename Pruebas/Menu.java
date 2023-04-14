import java.util.Scanner;

public class Menu {
    
    private CentroMedico centroMedico;
    private Archivo archivo;
    private Scanner scanner;

    public Menu() {
        centroMedico = new CentroMedico();
        archivo = new Archivo();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nCentro Médico\n");
        System.out.println("1. Agregar paciente");
        System.out.println("2. Llamar siguiente paciente");
        System.out.println("3. Mostrar lista de espera");
        System.out.println("4. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarPaciente();
                break;
            case 2:
                llamarSiguientePaciente();
                break;
            case 3:
                mostrarListaEspera();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Opción inválida");
                mostrarMenu();
                break;
        }
    }

    private void agregarPaciente() {
        scanner.nextLine(); // Consumir salto de línea pendiente

        System.out.println("\nAgregar paciente");

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        System.out.print("Cuadro respiratorio (S/N): ");
        char cuadroRespiratorio = scanner.nextLine().charAt(0);

        System.out.print("Urgencia o triage del cuadro (1-5): ");
        int urgencia = scanner.nextInt();

        centroMedico.agregarPaciente(cedula, apellidos, nombres, fechaNacimiento, sexo, cuadroRespiratorio, urgencia);

        archivo.guardarListaEspera(centroMedico.getListaEspera());

        mostrarMenu();
    }

    private void llamarSiguientePaciente() {
        Paciente paciente = centroMedico.llamarSiguientePaciente();

        if (paciente != null) {
            System.out.println("\nSiguiente paciente llamado:");
            System.out.println(paciente);
        } else {
            System.out.println("\nNo hay pacientes en espera");
        }

        archivo.guardarListaEspera(centroMedico.getListaEspera());

        mostrarMenu();
    }

    private void mostrarListaEspera() {
        System.out.println("\nLista de espera");

        centroMedico.mostrarListaEspera();

        mostrarMenu();
    }
}


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    
    private static final String ARCHIVO = "pacientes.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static CentroMedico centroMedico;
    
    public static void main(String[] args) {
        Archivo archivo = new Archivo(ARCHIVO);
        try {
            List<Paciente> pacientes = archivo.leerArchivo();
            centroMedico = new CentroMedico(pacientes);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de pacientes.");
        }
        boolean salir = false;
        while (!salir) {
            System.out.println("\n---- Menú ----");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Llamar paciente");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarPaciente();
                    break;
                case 2:
                    llamarPaciente();
                    break;
                case 3:
                    mostrarListaEspera();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
        try {
            archivo.escribirArchivo(centroMedico.getPacientes());
        } catch (IOException e) {
            System.out.println("No se pudo escribir el archivo de pacientes.");
        }
    }
    
    public static void agregarPaciente() {
        System.out
      }
          
/*En este caso, la clase "Menu" se encarga de mostrar al usuario un menú con varias opciones para interactuar con la lista de espera de pacientes.
Además, utiliza instancias de las clases "CentroMedico" y "Archivo" para realizar las operaciones correspondientes.
En el método "mostrarMenu", se muestra el menú y se lee la opción seleccionada por el usuario. Luego, se utiliza una estructura switch para llamar 
al método correspondiente de la clase "Menu" según la opción seleccionada.
Los métodos "agregarPaciente", "llamarSiguientePaciente" y "mostrarListaEspera" hacen operaciones llamando a la lista de pacientes y a la clase paciente   */
          
          
          
          
          
          
          
