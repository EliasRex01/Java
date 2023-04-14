import java.time.LocalDateTime;

public class Paciente {
    private String cedula;
    private String apellidos;
    private String nombres;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaIngreso;
    private char sexo;
    private boolean cuadroRespiratorio;
    private int urgencia;
    private String codigoPaciente;

    public Paciente(String cedula, String apellidos, String nombres, LocalDateTime fechaNacimiento, 
                    char sexo, boolean cuadroRespiratorio, int urgencia) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = LocalDateTime.now();
        this.sexo = sexo;
        this.cuadroRespiratorio = cuadroRespiratorio;
        this.urgencia = urgencia;
        this.codigoPaciente = generarCodigoPaciente();
    }

    public String getCedula() {
        return cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean isCuadroRespiratorio() {
        return cuadroRespiratorio;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    private String generarCodigoPaciente() {
        // Lógica para generar código de paciente
        return "P" + fechaIngreso.getYear() + "-" + String.format("%04d", urgencia);
    }

    public boolean validarPaciente() {
        // Lógica para validar la información del paciente
        return true;
    }
  
  public boolean validarPaciente() {
    // Validar que los apellidos no estén vacíos
    if (apellidos.trim().isEmpty()) {
        System.out.println("Error: el campo apellidos no puede estar vacío");
        return false;
    }
    
    // Validar que los nombres no estén vacíos
    if (nombres.trim().isEmpty()) {
        System.out.println("Error: el campo nombres no puede estar vacío");
        return false;
    }
    
    // Validar que la fecha de nacimiento no sea nula
    if (fechaNacimiento == null) {
        System.out.println("Error: el campo fecha de nacimiento no puede estar vacío");
        return false;
    }
    
    // Validar que la fecha de ingreso no sea nula
    if (fechaIngreso == null) {
        System.out.println("Error: el campo fecha de ingreso no puede estar vacío");
        return false;
    }
    
    // Validar que el sexo sea M o F
    if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
        System.out.println("Error: el campo sexo debe ser M o F");
        return false;
    }
    
    // Validar que la urgencia esté entre 1 y 5
    if (urgencia < 1 || urgencia > 5) {
        System.out.println("Error: el campo urgencia debe ser un número entre 1 y 5");
        return false;
    }
    
    // Validar que el cuadro respiratorio sea S o N
    if (!cuadroRespiratorio.equalsIgnoreCase("S") && !cuadroRespiratorio.equalsIgnoreCase("N")) {
        System.out.println("Error: el campo cuadro respiratorio debe ser S o N");
        return false;
    }
    
    // Validar que el triage esté entre 1 y 5
    if (triage < 1 || triage > 5) {
        System.out.println("Error: el campo triage debe ser un número entre 1 y 5");
        return false;
    }
    
    // Si se pasaron todas las validaciones, se considera que el paciente es válido
    return true;
}


    public String toString() {
        return "Paciente [Cédula=" + cedula + ", Apellidos=" + apellidos + ", Nombres=" + nombres +
               ", Fecha de Nacimiento=" + fechaNacimiento + ", Fecha de Ingreso=" + fechaIngreso + 
               ", Sexo=" + sexo + ", Cuadro Respiratorio=" + cuadroRespiratorio + ", Urgencia=" + 
               urgencia + ", Código de Paciente=" + codigoPaciente + "]";
    }
}





/*
En esta clase, he definido los atributos que has descrito, así como un constructor que inicializa la información del paciente, un método para generar 
el código de paciente según la lógica especificada, y los métodos necesarios para obtener y validar la información del paciente.
Es importante destacar que la lógica de generación del código de paciente que he utilizado es un ejemplo, y debería ajustarse a las necesidades
específicas del sistema. Asimismo, el método validarPaciente() debería implementarse con la lógica necesaria para asegurarse de que la información 
del paciente sea correcta y completa.
*/















