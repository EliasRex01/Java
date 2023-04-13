import java.util.LinkedList;
import java.util.Queue;

public class ColaEspera {
    private Queue<Paciente> pacientes;

    public ColaEspera() {
        pacientes = new LinkedList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente llamarSiguientePaciente() {
        return pacientes.poll();
    }

    public void mostrarListaPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.toString());
        }
    }
}




import java.util.PriorityQueue;
import java.util.Queue;

public class ColaRespiratorios {
    private Queue<Paciente> pacientes;

    public ColaRespiratorios() {
        pacientes = new PriorityQueue<>((paciente1, paciente2) -> {
            if (paciente1.getEstado().equals("grave") && !paciente2.getEstado().equals("grave")) {
                return -1;
            } else if (!paciente1.getEstado().equals("grave") && paciente2.getEstado().equals("grave")) {
                return 1;
            } else {
                return paciente1.getOrdenLlegada() - paciente2.getOrdenLlegada();
            }
        });
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente llamarSiguientePaciente() {
        return pacientes.poll();
    }

    public void mostrarListaPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.toString());
        }
    }
}



import java.util.PriorityQueue;
import java.util.Queue;

public class ColaNoRespiratorios {
    private Queue<Paciente> pacientes;

    public ColaNoRespiratorios() {
        pacientes = new PriorityQueue<>((paciente1, paciente2) -> {
            if (paciente1.getEstado().equals("grave") && !paciente2.getEstado().equals("grave")) {
                return -1;
            } else if (!paciente1.getEstado().equals("grave") && paciente2.getEstado().equals("grave")) {
                return 1;
            } else {
                return paciente1.getOrdenLlegada() - paciente2.getOrdenLlegada();
            }
        });
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente llamarSiguientePaciente() {
        return pacientes.poll();
    }

    public void mostrarListaPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.toString());
        }
    }
}















