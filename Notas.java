/*Para implementar el programa descrito, sería necesario crear las siguientes clases:

Paciente: Esta clase contendría los siguientes atributos:

nroCedula (int): número de cédula del paciente
apellidos (String): apellidos del paciente
nombres (String): nombres del paciente
fechaNacimiento (Date): fecha de nacimiento del paciente
fechaYHoraIngreso (Date): fecha y hora de ingreso del paciente al centro médico
sexo (char): sexo del paciente (H para hombre, M para mujer)
cuadroRespiratorio (boolean): indicador de si el paciente tiene un cuadro respiratorio
urgencia (String): nivel de urgencia del paciente (ALTO, MEDIO o BAJO)
codigo (String): código asignado al paciente según la lógica descrita en el enunciado
Además, la clase Paciente tendría los siguientes métodos:

calcularCodigo(): método que calcula el código del paciente según la lógica descrita en el enunciado.
esVulnerable(): método que indica si el paciente es vulnerable según la edad.
toString(): método que devuelve una cadena con la información del paciente.
Archivo: Esta clase se encargaría de cargar los datos iniciales de los pacientes desde un archivo CSV y de guardar los nuevos pacientes agregados al programa. Esta clase tendría los siguientes métodos:

cargarPacientes(): método que carga los pacientes iniciales desde un archivo CSV.
agregarPaciente(): método que agrega un nuevo paciente al programa.
ListaPacientes: Esta clase se encargaría de mantener una lista de los pacientes que están en espera de ser atendidos. Tendría los siguientes atributos:

pacientes (List<Paciente>): lista de pacientes en espera
Además, tendría los siguientes métodos:
agregarPaciente(): método que agrega un nuevo paciente a la lista de espera.
siguientePacienteRespiratorio(): método que devuelve el siguiente paciente en la lista de espera que requiere atención respiratoria y tiene mayor prioridad.
siguientePacienteNoRespiratorio(): método que devuelve el siguiente paciente en la lista de espera que no requiere atención respiratoria y tiene mayor prioridad.
toString(): método que devuelve una cadena con la lista de pacientes en espera, ordenados por prioridad.
Asignados: Esta clase se encargaría de mantener una lista de los pacientes que ya han sido atendidos. Tendría los siguientes atributos:

pacientes (List<Paciente>): lista de pacientes ya atendidos.
Además, tendría el siguiente método:
agregarPaciente(): método que agrega un paciente a la lista de pacientes ya atendidos.
Busqueda: Esta clase se encargaría de buscar pacientes en la lista de espera. Tendría los siguientes métodos:

buscarSiguientePacienteRespiratorio(): método que busca el siguiente paciente en la lista de espera que requiere atención respiratoria y tiene mayor prioridad.
buscarSiguientePacienteNoRespiratorio(): método que busca el siguiente paciente en la lista de espera que no requiere atención respiratoria y tiene mayor prioridad.
Menú: Esta clase contendría el menú principal del programa y permitiría al usuario interactuar con el mismo. Tendría los siguientes métodos:

mostrarMenu(): método que muestra las opciones disponibles al usuario.
cargarPacientes(): método que permite al usuario cargar

*/
