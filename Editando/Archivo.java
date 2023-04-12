import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

    private String nombreArchivo;
    private ArrayList<Paciente> pacientes;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.pacientes = new ArrayList<>();
    }

    public ArrayList<Paciente> cargarPacientes() throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] datos = linea.split(",");
            int cedula = Integer.parseInt(datos[0]);
            String apellidos = datos[1];
            String nombres = datos[2];
            String fechaNacimiento = datos[3];
            String fechaYHoraIngreso = datos[4];
            char sexo = datos[5].charAt(0);
            boolean cuadroRespiratorio = Boolean.parseBoolean(datos[6]);
            String urgencia = datos[7];
            Paciente paciente = new Paciente(cedula, apellidos, nombres, fechaNacimiento,
                    fechaYHoraIngreso, sexo, cuadroRespiratorio, urgencia);
            pacientes.add(paciente);
        }
        lector.close();
        return pacientes;
    }

    public void guardarPaciente(Paciente paciente) throws IOException {
        FileWriter escritor = new FileWriter(nombreArchivo, true);
        String linea = paciente.getCedula() + "," + paciente.getApellidos() + ","
                + paciente.getNombres() + "," + paciente.getFechaNacimiento() + ","
                + paciente.getFechaYHoraIngreso() + "," + paciente.getSexo() + ","
                + paciente.isCuadroRespiratorio() + "," + paciente.getUrgencia() + "\n";
        escritor.write(linea);
        escritor.close();
    }
}

/*
La clase Archivo es responsable de cargar y guardar pacientes en un archivo CSV. Para cargar pacientes, se utiliza un objeto BufferedReader para leer el archivo línea por línea y luego se utiliza el método split() para dividir la línea en campos individuales. Se crea un objeto Paciente a partir de estos campos y se agrega a la lista de pacientes.

Para guardar pacientes, se utiliza un objeto FileWriter para escribir la información del paciente en una nueva línea del archivo. Se construye una cadena de texto que contiene los datos del paciente separados por comas y seguidos de un salto de línea.
*/
