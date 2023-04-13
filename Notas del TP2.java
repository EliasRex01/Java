/* Se desea generar un programa que permita recibir desde un archivo CSV, un listado inicial de
un número de pacientes que están en espera en la sala de urgencias de un centro médico.
De cada paciente interesa saber: nro. de cedula (numérico), apellidos (cadena), nombres
(cadena), fechaNacimiento (fecha DD/MM/AAAA), fechaYHoraIngreso (fechaHora
DD/MM/AAAA HH24:MI:SS), sexo (char, H o M ara Hombre o Mujer), cuadroRespiratorio
(booleano TRUE es sí, FALSE es no), urgencia o triage de su cuadro (definir mejor tipo de dato
posible). Si la urgencia es de peligro de muerte el triage es ALTO. 
Si la urgencia no es de peligro de muerte pero si de mucho dolor triage es MEDIO, sino el triage es BAJO. 
Si la edad del paciente es mayor o igual a 60 años, o es menor o igual a 5, se le considera vulnerable.
Con estos datos se calcula un campo CODIGO DE PACIENTE con la siguiente lógica: primera
letra del primer apellido + primera letra del primer nombre + últimos 3 dígitos de su nro. de
cédula. Todo esto convertido a mayúscula. Ejemplo, para ZORRILLA ALCARAZ JOSE MANUEL
5.245.885, su código sería: ZJ885. Por simplicidad asuma que nunca se darán códigos
repetidos.
//clase paciente, clase archivo, clase menu, clase centro medico

De esta manera, el programa debe permitir ir registrando la llegada de nuevos pacientes y
también debe permitir a los doctores ir llamando al siguiente que debe ser atendido. 
//agregar un paciente e ordenarlo en la cola de prioridad

Hay dos grupos de doctores, los que atienden casos respiratorios y los que atienden casos no
respiratorios. Luego, en cada grupo, se debe priorizar primero a los de triage ALTO, luego a los
MEDIOS y finalmente a los BAJOS. Si hay varios pacientes en el mismo grupo de triage, se debe
atender primero a los “vulnerables” y luego por orden de llegada.
// podria usarse una lista de espera donde estan todos los pacientes en cola general, esta clase podria hacer llamada a dos colas cprespitarorios y sprespiratorios
// las colas crespiratorios y sprespiratorios podria hacer llamada interna a 3 colas dependiendo del paciente triageA, triageM y triageB
// ademas podria haber otras 2 colas: vulberables y novulberables

//clase menu
Deberia tener 3 opciones:
• Cargar más llegadas de pacientes, (especificando además de datos del paciente, su
grupo de atención (respiratorio o no respiratorio) y la prioridad según triage). Esto
agrega al paciente a la lista de espera inicializada desde el archivo CSV cuando se inició
el programa. Debe tomarse la fecha y hora exacta del sistema como fecha de ingresos
//el programa ya inicia con el contenido de un archivo CSV

• Llamar a un paciente de la lista de espera. Aquí debe preverse 2 posibles llamadores,
puede llamarse a un paciente respiratorio o a un paciente no respiratorio. Debe
tomarse la fecha y hora exacta del sistema como fecha y hora de atención.
//aqui se necesitaria una clase busqueda que recorra la lista de espera mediante su codigo

• Imprimir lista de espera. Genera en pantalla la lista de todos los pacientes pendientes
de ser atendidos con el orden que serian atendidos.

Un ejemplo de la salida es:
o Orden de atención del Listado de Pacientes en Espera
Casos Respiratorios
 Triage: ALTO
 Paciente: CODIGO, Fecha y Hora de ingreso
 Paciente: CODIGO, Fecha y Hora de ingreso
 Triage: MEDIO
 Paciente: CODIGO, Fecha y Hora de ingreso
 Triage: BAJO
 Paciente: CODIGO, Fecha y Hora de ingreso
 Paciente: CODIGO, Fecha y Hora de ingreso
 Paciente: CODIGO, Fecha y Hora de ingreso
Casos NO Respiratorios
 Triage: ALTO
 Paciente: CODIGO, Fecha y Hora de ingreso
 Triage: MEDIO
 Paciente: CODIGO, Fecha y Hora de ingreso
 Triage: BAJO
 Paciente: CODIGO, Fecha y Hora de ingreso
 Paciente: CODIGO, Fecha y Hora de ingreso
 Paciente: CODIGO, Fecha y Hora de ingreso
 //clase asignados o asignacion de pacientes
 
• Salir del sistema

Entre las consideraciones especiales que debe tener en cuenta:
• Debe utilizar las clases de la implementación de Cola estudiada en la Unidad 4 como
base para implementar su Cola de Prioridad.


/*Se estilan 6 posibles clases:
1. Paciente: con los atributos y métodos necesarios para manejar la información de cada paciente.
2. ListaEspera: contiene una lista de pacientes en espera y métodos para agregar y ordenar pacientes en la lista.
// se podria tener una clase que guarde una lista de pacientes que se han atendido
4. CentroMedico: clase principal que contiene la lista de espera y los doctores, además de los métodos para cargar pacientes, llamar a pacientes y generar la lista de espera.
5. Lector de CSV: lee un archivo CSV y genera una lista de pacientes.
6. Utilidades: es una clase que contiene métodos útiles, como el método para generar el código de paciente./*





* Paciente: Esta clase contendría los siguientes atributos:
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

* Archivo: Esta clase se encargaría de cargar los datos iniciales de los pacientes desde un archivo CSV y de guardar los nuevos pacientes agregados al programa. Esta clase tendría los siguientes métodos: 
cargarPacientes(): método que carga los pacientes iniciales desde un archivo CSV.
agregarPaciente(): método que agrega un nuevo paciente al programa.

* ListaPacientes: Esta clase se encargaría de mantener una lista de los pacientes que están en espera de ser atendidos. Tendría los siguientes atributos:
pacientes (List<Paciente>): lista de pacientes en espera Además, tendría los siguientes métodos:
agregarPaciente(): método que agrega un nuevo paciente a la lista de espera.
siguientePacienteRespiratorio(): método que devuelve el siguiente paciente en la lista de espera que requiere atención respiratoria y tiene mayor prioridad.
siguientePacienteNoRespiratorio(): método que devuelve el siguiente paciente en la lista de espera que no requiere atención respiratoria y tiene mayor prioridad.
toString(): método que devuelve una cadena con la lista de pacientes en espera, ordenados por prioridad.

* Asignados: Esta clase se encargaría de mantener una lista de los pacientes que ya han sido atendidos. Tendría los siguientes atributos:
pacientes (List<Paciente>): lista de pacientes ya atendidos.
Además, tendría el siguiente método:
agregarPaciente(): método que agrega un paciente a la lista de pacientes ya atendidos.

* Busqueda: Esta clase se encargaría de buscar pacientes en la lista de espera. Tendría los siguientes métodos:
buscarSiguientePacienteRespiratorio(): método que busca el siguiente paciente en la lista de espera que requiere atención respiratoria y tiene mayor prioridad.
buscarSiguientePacienteNoRespiratorio(): método que busca el siguiente paciente en la lista de espera que no requiere atención respiratoria y tiene mayor prioridad.

* Menú: Esta clase contendría el menú principal del programa y permitiría al usuario interactuar con el mismo. Tendría los siguientes métodos:
mostrarMenu(): método que muestra las opciones disponibles al usuario.
cargarPacientes(): método que permite al usuario cargar
