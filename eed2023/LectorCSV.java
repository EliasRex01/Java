/*  En este ejemplo, la clase LectorCSV tiene un atributo rutaArchivo que indica la 
ubicación del archivo CSV que queremos leer. El método leerPacientes devuelve una lista
de objetos Paciente a partir de los datos del archivo CSV.
El método leerPacientes usa un objeto BufferedReader para leer el archivo línea por línea, 
y el método readLine() devuelve una cadena que representa la línea leída, o null si se 
llegó al final del archivo.
Dentro del ciclo while, dividimos la línea leída en un array de valores utilizando el
método split(","), que divide la cadena en cada coma encontrada. Luego, creamos un 
objeto Paciente a partir de los valores obtenidos y lo agregamos a la lista de pacientes.
Por último, si ocurre un error al leer el archivo, se muestra un mensaje de error en la
consola.



        */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
    private String rutaArchivo;

    public LectorCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Paciente> leerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leemos el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividimos la línea en un array de valores
                String[] valores = linea.split(",");

                // Creamos un objeto Paciente a partir de los valores
                Paciente paciente = new Paciente(valores[0], valores[1], Integer.parseInt(valores[2]), valores[3]);

                // Agregamos el objeto Paciente a la lista
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo CSV: " + e.getMessage());
        }

        return pacientes;
    }
}
