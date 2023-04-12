/* La clase Doctor tiene tres atributos privados: nombre, especialidad y pacientes. 
El primer y segundo atributo son simplemente el nombre y la especialidad del médico, 
respectivamente. El tercer atributo es una lista de pacientes que están siendo atendidos
por el doctor.
El constructor de la clase Doctor recibe el nombre y la especialidad del médico y 
crea una lista vacía de pacientes.
La clase Doctor tiene métodos para obtener el nombre, la especialidad y la lista 
de pacientes del médico, así como para agregar y eliminar pacientes de la lista. 
También podrían implementarse otros métodos según las necesidades del programa, 
como atenderPacientes(), darDeAltaPaciente(), etc.       */

public class Doctor {
    private String nombre;
    private String especialidad;
    private List<Paciente> pacientes;

    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.pacientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    // Otros métodos de la clase, como toString(), equals(), hashCode(), etc.
}

