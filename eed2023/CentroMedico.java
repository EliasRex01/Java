/*  En esta clase, se tienen dos atributos: doctores y listaEspera. El primero es una
lista de objetos de tipo Doctor, y el segundo es un objeto de tipo ListaEspera. Se 
definen tres métodos:
agregarDoctor: agrega un objeto Doctor a la lista de doctores.
agregarPaciente: agrega un objeto Paciente a la lista de espera.
atenderPacientes: este método se encarga de iterar sobre la lista de doctores y, 
por cada doctor, atender los pacientes mientras haya pacientes en la lista de espera 
y el doctor no esté ocupado. El método estaOcupado de la clase Doctor verifica si el 
doctor está ocupado atendiendo a un paciente, y el método siguientePaciente de la clase
ListaEspera devuelve el siguiente paciente en la lista de espera.      */

import java.util.ArrayList;
import java.util.List;

public class CentroMedico {
    private List<Doctor> doctores;
    private ListaEspera listaEspera;

    public CentroMedico() {
        this.doctores = new ArrayList<>();
        this.listaEspera = new ListaEspera();
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void agregarPaciente(Paciente paciente) {
        listaEspera.agregarPaciente(paciente);
    }

    public void atenderPacientes() {
        for (Doctor doctor : doctores) {
            while (!doctor.estaOcupado() && !listaEspera.estaVacia()) {
                Paciente paciente = listaEspera.siguientePaciente();
                doctor.atenderPaciente(paciente);
            }
        }
    }
}
