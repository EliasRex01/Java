import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente {
    private int nroCedula;
    private String apellidos;
    private String nombres;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaYHoraIngreso;
    private char sexo;
    private boolean cuadroRespiratorio;
    private String triage;
    private String grupoAtencion;
    private boolean esVulnerable;

    public Paciente(int nroCedula, String apellidos, String nombres, LocalDate fechaNacimiento,
                    LocalDateTime fechaYHoraIngreso, char sexo, boolean cuadroRespiratorio, String triage) {
        this.nroCedula = nroCedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaYHoraIngreso = fechaYHoraIngreso;
        this.sexo = sexo;
        this.cuadroRespiratorio = cuadroRespiratorio;
        this.triage = triage;
        this.grupoAtencion = cuadroRespiratorio ? "respiratorio" : "no respiratorio";
        this.esVulnerable = esVulnerable();
    }

    public String getCodigoPaciente() {
        String codigo = apellidos.substring(0, 1) + nombres.substring(0, 1) + String.format("%03d", nroCedula % 1000);
        return codigo.toUpperCase();
    }

    public boolean esVulnerable() {
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        return edad >= 60 || edad <= 5;
    }

    public String getTriage() {
        return triage;
    }

    public String getGrupoAtencion() {
        return grupoAtencion;
    }

    public boolean isEsVulnerable() {
        return esVulnerable;
    }

    @Override
    public String toString() {
        return getCodigoPaciente() + ", " + fechaYHoraIngreso + ", " + triage;
    }
}
