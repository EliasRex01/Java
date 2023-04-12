import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ListaPacientes listaPacientes;
    private Asignados asignados;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.listaPacientes = new ListaPacientes();
        this.asignados = new Asignados();
    }

    public void mostrar() {
        boolean salir = false;

        do {
            System.out.println("\n----- Centro Médico -----\n");
            System.out.println("1. Cargar más llegadas de pacientes");
            System.out.println("2. Llamar a un paciente de la lista de espera");
            System.out.println("3. Imprimir lista de espera");
            System.out.println("4. Salir\n");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cargarPacientes();
                    break;
                case 2:
                    llamarPaciente();
                    break;
                case 3:
                    imprimirListaEspera();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
                    break;
            }
        } while (!salir);
    }

    private void cargarPacientes() {
        scanner.nextLine(); // Consume el salto de línea que queda en el buffer

        System.out.print("\nIngrese la ruta del archivo CSV: ");
        String rutaArchivo = scanner.nextLine();

        System.out.print("Ingrese el grupo de atención (R: respiratorio, N: no respiratorio): ");
        char grupoAtencion = scanner.next().charAt(0);

        System.out.print("Ingrese la prioridad según triage (A: alto, M: medio, B: bajo): ");
        char prioridadTriage = scanner.next().charAt(0);

        boolean exito = listaPacientes.cargarPacientesDesdeArchivo(rutaArchivo, grupoAtencion, prioridadTriage);

        if (exito) {
            System.out.println("\nLlegadas de pacientes cargadas exitosamente.");
        } else {
            System.out.println("\nNo se pudo cargar el archivo. Por favor, verifique la ruta e intente nuevamente.");
        }
    }

    private void llamarPaciente() {
        scanner.nextLine(); // Consume el salto de línea que queda en el buffer

        System.out.print("\nIngrese el grupo de atención (R: respiratorio, N: no respiratorio): ");
        char grupoAtencion = scanner.next().charAt(0);

        Paciente paciente = asignados.llamarProximoPaciente(grupoAtencion);

        if (paciente != null) {
            System.out.println("\nEl siguiente paciente a ser atendido es: " + paciente.getCodigoPaciente());
        } else {
            System.out.println("\nNo hay pacientes en la lista de espera.");
        }
    }

    private void imprimirListaEspera() {
        System.out.println("\n----- Listado de Pacientes en Espera -----\n");

        System.out.println("Casos Respiratorios");

        imprimirListaEsperaPorGrupo('R');

        System.out.println("\nCasos NO Respiratorios");

        imprimirListaEsperaPorGrupo('N');
    }

    public void imprimirListaEsperaPorGrupo() {
    // Imprimir pacientes respiratorios
    System.out.println("Casos Respiratorios");
    imprimirListaEsperaPorTriageYGrupo(Triage.ALTO, GrupoAtencion.RESPIRATORIO);
    imprimirListaEsperaPorTriageYGrupo(Triage.MEDIO, GrupoAtencion.RESPIRATORIO);
    imprimirListaEsperaPorTriageYGrupo(Triage.BAJO, GrupoAtencion.RESPIRATORIO);

    // Imprimir pacientes no respiratorios
    System.out.println("Casos NO Respiratorios");
    imprimirListaEsperaPorTriageYGrupo(Triage.ALTO, GrupoAtencion.NO_RESPIRATORIO);
    imprimirListaEsperaPorTriageYGrupo(Triage.MEDIO, GrupoAtencion.NO_RESPIRATORIO);
    imprimirListaEsperaPorTriageYGrupo(Triage.BAJO, GrupoAtencion.NO_RESPIRATORIO);
}

  
  // Método para agregar un nuevo paciente a la lista de espera
public void agregarPaciente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresar datos del paciente:");

    System.out.print("Número de cédula: ");
    int cedula = scanner.nextInt();

    System.out.print("Apellidos: ");
    String apellidos = scanner.next();

    System.out.print("Nombres: ");
    String nombres = scanner.next();

    System.out.print("Fecha de nacimiento (DD/MM/AAAA): ");
    String fechaNacimientoStr = scanner.next();
    LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    System.out.print("Sexo (H/M): ");
    char sexo = scanner.next().charAt(0);

    System.out.print("Cuadro respiratorio (true/false): ");
    boolean cuadroRespiratorio = scanner.nextBoolean();

    System.out.print("Grupo de atención (RESPIRATORIO/NO_RESPIRATORIO): ");
    GrupoAtencion grupoAtencion = GrupoAtencion.valueOf(scanner.next().toUpperCase());

    System.out.print("Triage (ALTO/MEDIO/BAJO): ");
    Triage triage = Triage.valueOf(scanner.next().toUpperCase());

    // Calcular código de paciente
    String codigoPaciente = apellidos.substring(0, 1).toUpperCase() + nombres.substring(0, 1).toUpperCase() +
            String.format("%03d", cedula % 1000);

    // Crear paciente y agregarlo a la lista de espera
    Paciente paciente = new Paciente(cedula, apellidos, nombres, fechaNacimiento, sexo, cuadroRespiratorio, triage, grupoAtencion, codigoPaciente);
    listaPacientes.agregar(paciente);

    System.out.println("Paciente agregado exitosamente.");
}

// Método para llamar al siguiente paciente de la lista de espera
public void llamarSiguientePaciente(GrupoAtencion grupoAtencion) {
    Paciente paciente = busqueda.buscarSiguientePaciente(listaPacientes, grupoAtencion);
    if (paciente == null) {
        System.out.println("No hay pacientes pendientes para el grupo de atención " + grupoAtencion.toString());
        return;
    }

    LocalDateTime fechaYHoraAtencion = LocalDateTime.now();
    paciente.setFechaYHoraAtencion(fechaYHoraAtencion);
    System.out.println("Paciente

          
          
