/*nombre de tipo string que representa el nombre del doctor.
atiendeRespiratorios de tipo boolean que indica si el doctor atiende casos respiratorios o no.
listaEspera es una PriorityQueue de pacientes que representa la lista de espera de pacientes para ese doctor. El orden de la cola se establece en el constructor de la clase dependiendo de si el doctor atiende casos respiratorios o no.
El constructor de la clase toma dos parámetros: el nombre del doctor y un booleano que indica si atiende casos respiratorios o no. En base a este booleano, se crea la cola de pacientes con el orden adecuado.
Los métodos getNombre y atiendeRespiratorios acceeden a los atributos privados nombre y atiendeRespiratorios.
El método agregarPaciente toma un objeto Paciente y lo agrega a la cola de pacientes del doctor.
El método llamarPaciente devuelve el siguiente paciente en la cola de espera del doctor (o null si no hay pacientes en la cola).
El método imprimirListaEspera imprime por pantalla la lista de pacientes en espera del doctor, ordenada según los criterios de la cola establecidos en el constructor.

*/

public class Doctor {
    private String nombre;
    private boolean atiendeRespiratorios;
    private PriorityQueue<Paciente> listaEspera;

    public Doctor(String nombre, boolean atiendeRespiratorios) {
        this.nombre = nombre;
        this.atiendeRespiratorios = atiendeRespiratorios;
        if (atiendeRespiratorios) {
            listaEspera = new PriorityQueue<>(Comparator.comparing(Paciente::getTriage).thenComparing(Paciente::esVulnerable).reversed().thenComparing(Paciente::getFechaYHoraIngreso));
        } else {
            listaEspera = new PriorityQueue<>(Comparator.comparing(Paciente::getTriage).thenComparing(Paciente::esVulnerable).reversed().thenComparing(Paciente::getFechaYHoraIngreso));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean atiendeRespiratorios() {
        return atiendeRespiratorios;
    }

    public void agregarPaciente(Paciente paciente) {
        listaEspera.add(paciente);
    }

    public Paciente llamarPaciente() {
        return listaEspera.poll();
    }

    public void imprimirListaEspera() {
        System.out.println("Lista de espera del Dr. " + nombre);
        System.out.println("Atiende casos respiratorios: " + atiendeRespiratorios);
        PriorityQueue<Paciente> listaTemporal = new PriorityQueue<>(listaEspera);
        while (!listaTemporal.isEmpty()) {
            Paciente paciente = listaTemporal.poll();
            System.out.println("Triage: " + paciente.getTriage().toString() + ". Paciente: " + paciente.getCodigo() + ", Fecha y Hora de ingreso: " + paciente.getFechaYHoraIngreso().toString());
        }
    }
}

