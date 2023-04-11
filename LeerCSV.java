/*lee un archivo csv y devuelve una lista de objetos de tipo paciente
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Paciente> readPacientes() throws IOException {
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { // skip header line
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                int cedula = Integer.parseInt(data[0]);
                String apellidos = data[1];
                String nombres = data[2];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime fechaNacimiento = LocalDateTime.parse(data[3], formatter);

                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime fechaYHoraIngreso = LocalDateTime.parse(data[4], formatter);

                char sexo = data[5].charAt(0);
                boolean cuadroRespiratorio = Boolean.parseBoolean(data[6]);
                String triageString = data[7];

                Triage triage;
                switch (triageString) {
                    case "ALTO":
                        triage = Triage.ALTO;
                        break;
                    case "MEDIO":
                        triage = Triage.MEDIO;
                        break;
                    default:
                        triage = Triage.BAJO;
                }

                Paciente paciente = new Paciente(cedula, apellidos, nombres, fechaNacimiento, fechaYHoraIngreso,
                        sexo, cuadroRespiratorio, triage);
                pacientes.add(paciente);
            }
        }

        return pacientes;
    }

}


/*Se usa BufferedReader para leer el archivo CSV línea por línea y procesar cada línea para crear un objeto Paciente. 
Los datos de cada paciente se separan utilizando la coma como separador y se convierten al tipo de dato correspondiente (por ejemplo, la fecha se convierte a un objeto LocalDateTime utilizando un objeto DateTimeFormatter). 
Los objetos Paciente se agregan a una lista que se devuelve al final del método.*/
