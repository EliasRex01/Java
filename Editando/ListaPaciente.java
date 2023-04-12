import java.util.ArrayList;

public class ListaPaciente {
    private ArrayList<Paciente> pacientes;
    
    public ListaPaciente() {
        this.pacientes = new ArrayList<Paciente>();
    }
    
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }
    
    public Paciente buscarPaciente(String codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCodigo().equals(codigo)) {
                return paciente;
            }
        }
        return null;
    }
    
    public void eliminarPaciente(Paciente paciente) {
        this.pacientes.remove(paciente);
    }
    
    public ArrayList<Paciente> filtrarPacientes(boolean respiratorio, String triage) {
        ArrayList<Paciente> filtrados = new ArrayList<Paciente>();
        for (Paciente paciente : pacientes) {
            if (paciente.isCuadroRespiratorio() == respiratorio && paciente.getTriage().equals(triage)) {
                filtrados.add(paciente);
            }
        }
        filtrados.sort(new OrdenarPacientesPorVulnerabilidad());
        return filtrados;
    }
}
