/*  La clase ListaEspera es una clase que contiene una lista de pacientes en espera y 
proporciona métodos para agregar y ordenar pacientes en la lista.    */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaEspera {
    private List<Paciente> pacientes;

    public ListaEspera() {
        this.pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public void ordenarPorTriage() {
        Collections.sort(pacientes);
    }

    public void ordenarPorFechaYHora() {
        Collections.sort(pacientes, new ComparadorFechaYHora());
    }

    public List<Paciente> getPacientes() {
        return this.pacientes;
    }

    public List<Paciente> getPacientesPorTriage(Triage triage) {
        List<Paciente> pacientesPorTriage = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (paciente.getTriage() == triage) {
                pacientesPorTriage.add(paciente);
            }
        }
        return pacientesPorTriage;
    }

    public List<Paciente> getPacientesRespiratoriosPorTriage(Triage triage) {
        List<Paciente> pacientesRespiratoriosPorTriage = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (paciente.isCuadroRespiratorio() && paciente.getTriage() == triage) {
                pacientesRespiratoriosPorTriage.add(paciente);
            }
        }
        return pacientesRespiratoriosPorTriage;
    }

    public List<Paciente> getPacientesNoRespiratoriosPorTriage(Triage triage) {
        List<Paciente> pacientesNoRespiratoriosPorTriage = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (!paciente.isCuadroRespiratorio() && paciente.getTriage() == triage) {
                pacientesNoRespiratoriosPorTriage.add(paciente);
            }
        }
        return pacientesNoRespiratoriosPorTriage;
    }

    public void eliminarPaciente(Paciente paciente) {
        this.pacientes.remove(paciente);
    }
}

/*En esta implementación, la clase ListaEspera tiene una lista de pacientes y 
métodos para agregar pacientes, ordenar la lista por triage o por fecha y hora
de ingreso, obtener una lista de pacientes por triage o por triage y si son 
respiratorios o no respiratorios, y eliminar pacientes de la lista. La lista se 
almacena como un ArrayList de objetos Paciente, y los métodos ordenarPorTriage 
y ordenarPorFechaYHora utilizan la clase Collections de Java para ordenar la lista
según los criterios especificados. Los métodos getPacientesPorTriage, 
getPacientesRespiratoriosPorTriage y getPacientesNoRespiratoriosPorTriage 
devuelven listas de pacientes que coinciden con el triage y si son respiratorios
o no respiratorios especificados, utilizando un bucle for para iterar sobre la 
lista de pacientes. El método eliminarPaciente elimina un paciente específico de 
la lista utilizando el método remove de la clase ArrayList.*/
