import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
    
    private String nombreArchivo;
    
    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public List<Paciente> leerArchivo() throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String cedula = datos[0];
            String apellidos = datos[1];
            String nombres = datos[2];
            String fechaNacimiento = datos[3];
            String fechaIngreso = datos[4];
            String sexo = datos[5];
            boolean cuadroRespiratorio = Boolean.parseBoolean(datos[6]);
            int urgencia = Integer.parseInt(datos[7]);
            int codigo = Integer.parseInt(datos[8]);
            Paciente paciente = new Paciente(cedula, apellidos, nombres, fechaNacimiento, fechaIngreso, sexo, cuadroRespiratorio, urgencia, codigo);
            pacientes.add(paciente);
        }
        br.close();
        return pacientes;
    }
    
    public void escribirArchivo(List<Paciente> pacientes) throws IOException {
        FileWriter fw = new FileWriter(nombreArchivo);
        for (Paciente paciente : pacientes) {
            fw.write(paciente.getCedula() + "," + paciente.getApellidos() + "," + paciente.getNombres() + ","
                    + paciente.getFechaNacimiento() + "," + paciente.getFechaIngreso() + "," + paciente.getSexo() + ","
                    + paciente.isCuadroRespiratorio() + "," + paciente.getUrgencia() + "," + paciente.getCodigo() + "\n");
        }
        fw.close();
    }
    
}


/*
La duda en esta clase y a preguntar es si es necesario escribir los datos de los pacientes que van llegando en el archivo de donde se sacan los pacientes
y si se deberia tener un listado de los pacientes ya atendidos y si es el caso si se deben sobreescribir en el archivo ya dispuesto o guardar en un nuevo archivo
*/
