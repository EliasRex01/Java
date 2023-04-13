public class Busqueda {
    // Método que busca un paciente en la lista de espera por su código
    public static Paciente buscarPaciente(List<Paciente> listaEspera, String codigo) {
        for (Paciente paciente : listaEspera) {
            if (paciente.getCodigo().equals(codigo)) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente, retorna null
    }
    
    // Método que llama al siguiente paciente en la cola de prioridad correspondiente
    public static Paciente llamarSiguiente(List<Queue<Paciente>> colasPrioridad) {
        for (Queue<Paciente> cola : colasPrioridad) {
            Paciente paciente = cola.peek(); // Obtiene el siguiente paciente de la cola
            if (paciente != null) { // Si la cola no está vacía
                cola.remove(); // Remueve el paciente de la cola
                return paciente;
            }
        }
        return null; // Si no hay pacientes en ninguna cola, retorna null
    }
}


/*
El método buscarPaciente recibe como parámetros una lista de pacientes listaEspera y el código del paciente que se quiere buscar codigo. Luego, 
recorre la lista de pacientes buscando uno cuyo código coincida con el parámetro codigo. Si lo encuentra, retorna el paciente. Si no lo encuentra, retorna null.
El método llamarSiguiente recibe como parámetro una lista de colas de prioridad colasPrioridad. Cada cola de prioridad contiene pacientes con el mismo nivel 
de urgencia, y las colas están ordenadas de forma que el paciente más urgente está al principio de la cola. El método recorre la lista de colas de prioridad, 
empezando por la más urgente, buscando la primera cola que no esté vacía. Si encuentra una cola no vacía, obtiene el siguiente paciente de esa cola con el
método peek, lo remueve de la cola con el método remove y lo retorna. Si no hay pacientes en ninguna cola, retorna null.

*/



