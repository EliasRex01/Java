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


/*
En esta clase se implementa una lista de pacientes utilizando un ArrayList. La clase cuenta con los siguientes métodos:

ListaPaciente(): constructor de la clase que inicializa la lista de pacientes.
getPacientes(): método que devuelve la lista de pacientes.
agregarPaciente(Paciente paciente): método que agrega un paciente a la lista.
buscarPaciente(String codigo): método que busca un paciente en la lista a través de su código.
eliminarPaciente(Paciente paciente): método que elimina un paciente de la lista.
filtrarPacientes(boolean respiratorio, String triage): método que filtra los pacientes de acuerdo a si son respiratorios o no, y su triage. Retorna una lista con los pacientes filtrados y ordenados de acuerdo a su vulnerabilidad.
La clase ListaPaciente es utilizada en conjunto con la clase Paciente y la clase OrdenarPacientesPorVulnerabilidad para manejar la lista de pacientes y la selección de los pacientes según ciertos criterios en el sistema de atención de pacientes en la sala de urgencias.
*/
