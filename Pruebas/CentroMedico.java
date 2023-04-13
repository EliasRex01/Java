import java.util.PriorityQueue;

public class CentroMedico {
    
    private PriorityQueue<Paciente> colaRespiratorios;
    private PriorityQueue<Paciente> colaNoRespiratorios;
    private ColaEspera colaEspera;
    
    public CentroMedico() {
        this.colaRespiratorios = new PriorityQueue<>();
        this.colaNoRespiratorios = new PriorityQueue<>();
        this.colaEspera = new ColaEspera();
    }
    
    public void agregarPaciente(Paciente paciente) {
        if (paciente.isRespiratorio()) {
            this.colaRespiratorios.add(paciente);
        } else {
            this.colaNoRespiratorios.add(paciente);
        }
        this.colaEspera.agregarPaciente(paciente);
    }
    
    public Paciente llamarSiguientePaciente() {
        Paciente paciente = null;
        if (!this.colaRespiratorios.isEmpty()) {
            paciente = this.colaRespiratorios.poll();
        } else if (!this.colaNoRespiratorios.isEmpty()) {
            paciente = this.colaNoRespiratorios.poll();
        } else {
            paciente = this.colaEspera.llamarSiguientePaciente();
        }
        return paciente;
    }
    
    public void mostrarListaEspera() {
        this.colaEspera.mostrarListaEspera();
    }
    
    public void mostrarColaRespiratorios() {
        System.out.println("Cola de pacientes respiratorios:");
        for (Paciente paciente : this.colaRespiratorios) {
            System.out.println(paciente.toString());
        }
    }
    
    public void mostrarColaNoRespiratorios() {
        System.out.println("Cola de pacientes no respiratorios:");
        for (Paciente paciente : this.colaNoRespiratorios) {
            System.out.println(paciente.toString());
        }
    }
}


/*
Esta clase maneja tres colas: colaRespiratorios, colaNoRespiratorios y colaEspera. La primera y la segunda son colas de prioridad para los casos respiratorios y no respiratorios, respectivamente. La tercera es una instancia de la clase ColaEspera que maneja una cola simple para todos los pacientes en espera.
El método agregarPaciente() se encarga de agregar un paciente a la cola correspondiente. Si el paciente es respiratorio, se agrega a colaRespiratorios, de lo contrario, se agrega a colaNoRespiratorios. Además, el paciente se agrega a la cola colaEspera para mantener la lista de espera.
El método llamarSiguientePaciente() llama al siguiente paciente en la cola correspondiente, dando prioridad a los casos respiratorios. Si no hay pacientes respiratorios en espera, se llama al siguiente paciente en colaNoRespiratorios. Si ambas colas están vacías, se llama al siguiente paciente en colaEspera.
Los métodos mostrarListaEspera(), mostrarColaRespiratorios() y mostrarColaNoRespiratorios() se encargan de mostrar el contenido de las colas correspondientes.
*/

