import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente {
    private String cedula;
    private String apellidos;
    private String nombres;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaYHoraIngreso;
    private char sexo;
    private boolean cuadroRespiratorio;
    private String triage;
    private String codigo;

    public Paciente(String cedula, String apellidos, String nombres, LocalDate fechaNacimiento,
                    LocalDateTime fechaYHoraIngreso, char sexo, boolean cuadroRespiratorio) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaYHoraIngreso = fechaYHoraIngreso;
        this.sexo = sexo;
        this.cuadroRespiratorio = cuadroRespiratorio;
        this.triage = determinarTriage();
        this.codigo = generarCodigo();
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDateTime getFechaYHoraIngreso() {
        return fechaYHoraIngreso;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean isCuadroRespiratorio() {
        return cuadroRespiratorio;
    }

    public String getTriage() {
        return triage;
    }

    public String getCodigo() {
        return codigo;
    }

    private String determinarTriage() {
        String triage;
        if (cuadroRespiratorio) {
            triage = "ALTO";
        } else if (calcularEdad() >= 60 || calcularEdad() <= 5) {
            triage = "ALTO";
        } else if (calcularDolor()) {
            triage = "MEDIO";
        } else {
            triage = "BAJO";
        }
        return triage;
    }

    private boolean calcularDolor() {
        // aquí se implementaría la lógica para determinar si el paciente tiene mucho dolor
        // por simplicidad, retornamos false en todos los casos
        return false;
    }

    private int calcularEdad() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - fechaNacimiento.getYear();
        if (now.getMonthValue() < fechaNacimiento.getMonthValue()) {
            age--;
        } else if (now.getMonthValue() == fechaNacimiento.getMonthValue()
                && now.getDayOfMonth() < fechaNacimiento.getDayOfMonth()) {
            age--;
        }
        return age;
    }

    private String generarCodigo() {
        String codigo = "";
        codigo += apellidos.charAt(0);
        codigo += nombres.charAt(0);
        codigo += cedula.substring(cedula.length() - 3);
        codigo = codigo.toUpperCase();
        return codigo;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHoraIngreso = fechaYHoraIngreso.format(formatter);
        return codigo + ", " + apellidos + " " + nombres + ", " + fechaHoraIngreso + ", " + triage;
    }
}


/*hacer archivo de ejemplo para comprobar los atributos necesarios
*/
