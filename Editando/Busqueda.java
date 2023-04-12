import java.util.ArrayList;

public class Busqueda {
    
    public static Paciente buscarPaciente(String codigo, ArrayList<Paciente> listaEspera) {
        for (Paciente paciente : listaEspera) {
            if (paciente.getCodigo().equals(codigo)) {
                return paciente;
            }
        }
        return null;
    }

    public static ArrayList<Paciente> filtrarPorGrupo(boolean esRespiratorio, ArrayList<Paciente> listaEspera) {
        ArrayList<Paciente> filtrados = new ArrayList<Paciente>();
        for (Paciente paciente : listaEspera) {
            if (paciente.isCuadroRespiratorio() == esRespiratorio) {
                filtrados.add(paciente);
            }
        }
        return filtrados;
    }

    public static ArrayList<Paciente> filtrarPorTriage(String triage, ArrayList<Paciente> listaEspera) {
        ArrayList<Paciente> filtrados = new ArrayList<Paciente>();
        for (Paciente paciente : listaEspera) {
            if (paciente.getTriage().equals(triage)) {
                filtrados.add(paciente);
            }
        }
        return filtrados;
    }

    public static Paciente obtenerSiguiente(ArrayList<Paciente> pacientes) {
        if (!pacientes.isEmpty()) {
            Paciente siguiente = pacientes.get(0);
            for (Paciente paciente : pacientes) {
                if (siguiente.getTriage().equals(paciente.getTriage())) {
                    if (siguiente.isVulnerable() && !paciente.isVulnerable()) {
                        siguiente = paciente;
                    } else if (siguiente.getFechaYHoraIngreso().compareTo(paciente.getFechaYHoraIngreso()) > 0) {
                        siguiente = paciente;
                    }
                } else if (siguiente.getTriage().equals("ALTO")) {
                    break;
                } else if (siguiente.getTriage().equals("MEDIO") && paciente.getTriage().equals("ALTO")) {
                    siguiente = paciente;
                }
            }
            return siguiente;
        }
        return null;
    }
}

/*

*/
