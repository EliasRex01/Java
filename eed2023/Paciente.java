/*      */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente implements Comparable<Paciente> {
    private int cedula;
    private String apellidos;
    private String nombres;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaYHoraIngreso;
    private char sexo;
    private boolean cuadroRespiratorio;
    private String triage;

    public Paciente(int cedula, String apellidos, String nombres, LocalDateTime fechaNacimiento,
                    LocalDateTime fechaYHoraIngreso, char sexo, boolean cuadroRespiratorio, boolean urgencia) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaYHoraIngreso = fechaYHoraIngreso;
        this.sexo = sexo;
        this.cuadroRespiratorio = cuadroRespiratorio;
        this.triage = generarTriage(urgencia);
    }

    private String generarTriage(boolean urgencia) {
        if (urgencia) {
            return "ALTO";
        } else if (cuadroRespiratorio) {
            return "MEDIO";
        } else {
            return "BAJO";
        }
    }

    public String getCodigoPaciente() {
        String primerApellido = this.apellidos.split(" ")[0];
        String primerNombre = this.nombres.split(" ")[0];
        String tresUltimosDigitos = String.format("%03d", this.cedula % 1000);
        return (primerApellido.charAt(0) + "" + primerNombre.charAt(0) + "" + tresUltimosDigitos).toUpperCase();
    }

    public boolean esVulnerable() {
        int edad = LocalDateTime.now().getYear() - fechaNacimiento.getYear();
        return edad >= 60 || edad <= 5;
    }

    public boolean isCuadroRespiratorio() {
        return cuadroRespiratorio;
    }

    public String getTriage() {
        return triage;
    }

    public LocalDateTime getFechaYHoraIngreso() {
        return fechaYHoraIngreso;
    }

    @Override
    public int compareTo(Paciente otroPaciente) {
        if (this.triage.equals(otroPaciente.getTriage())) {
            if (this.esVulnerable() == otroPaciente.esVulnerable()) {
                return this.fechaYHoraIngreso.compareTo(otroPaciente.getFechaYHoraIngreso());
            } else if (this.esVulnerable()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.triage.equals("ALTO")) {
            return -1;
        } else if (otroPaciente.getTriage().equals("ALTO")) {
            return 1;
        } else if (this.triage.equals("MEDIO")) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return this.getCodigoPaciente() + ", " + formatter.format(this.fechaYHoraIngreso);
    }
}
