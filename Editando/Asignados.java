import java.util.ArrayList;

public class Asignados {
    private ArrayList<Paciente> pacientesAsignadosRespiratorios;
    private ArrayList<Paciente> pacientesAsignadosNoRespiratorios;

    public Asignados() {
        pacientesAsignadosRespiratorios = new ArrayList<>();
        pacientesAsignadosNoRespiratorios = new ArrayList<>();
    }

    public void asignarPaciente(Paciente paciente, boolean respiratorio) {
        if (respiratorio) {
            pacientesAsignadosRespiratorios.add(paciente);
        } else {
            pacientesAsignadosNoRespiratorios.add(paciente);
        }
    }

    public Paciente llamarPaciente(boolean respiratorio) {
        Paciente paciente = null;
        if (respiratorio) {
            if (!pacientesAsignadosRespiratorios.isEmpty()) {
                paciente = pacientesAsignadosRespiratorios.get(0);
                pacientesAsignadosRespiratorios.remove(0);
            }
        } else {
            if (!pacientesAsignadosNoRespiratorios.isEmpty()) {
                paciente = pacientesAsignadosNoRespiratorios.get(0);
                pacientesAsignadosNoRespiratorios.remove(0);
            }
        }
        return paciente;
    }

    public boolean hayPacientes(boolean respiratorio) {
        if (respiratorio) {
            return !pacientesAsignadosRespiratorios.isEmpty();
        } else {
            return !pacientesAsignadosNoRespiratorios.isEmpty();
        }
    }
}

/*
La clase Asignados tiene dos atributos: dos listas de pacientes asignados, una para pacientes respiratorios y otra para pacientes no respiratorios. El constructor simplemente inicializa estas dos listas.

La función asignarPaciente recibe un paciente y un booleano que indica si el paciente es respiratorio o no. A continuación, agrega el paciente a la lista correspondiente.

La función llamarPaciente recibe un booleano que indica si se quiere llamar a un paciente respiratorio o no. Si hay pacientes en la lista correspondiente, se devuelve el primer paciente de la lista y se elimina de ella. Si no hay pacientes en la lista, se devuelve null.

La función hayPacientes recibe un booleano que indica si se quiere saber si hay pacientes respiratorios o no. Devuelve true si hay pacientes en la lista correspondiente, false si no hay pacientes.
*/
