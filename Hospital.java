/* Se desea generar un programa que permita recibir desde un archivo CSV, un listado inicial de
un número de pacientes que están en espera en la sala de urgencias de un centro médico.
De cada paciente interesa saber: nro. de cedula (numérico), apellidos (cadena), nombres
(cadena), fechaNacimiento (fecha DD/MM/AAAA), fechaYHoraIngreso (fechaHora
DD/MM/AAAA HH24:MI:SS), sexo (char, H o M ara Hombre o Mujer), cuadroRespiratorio
(booleano TRUE es sí, FALSE es no), urgencia o triage de su cuadro (definir mejor tipo de dato
posible). Si la urgencia es de peligro de muerte el triage es ALTO. Si la urgencia no es de peligro
de muerte pero si de mucho dolor triage es MEDIO, sino el triage es BAJO. Si la edad del
paciente es mayor o igual a 60 años, o es menor o igual a 5, se le considera vulnerable.
Con estos datos se calcula un campo CODIGO DE PACIENTE con la siguiente lógica: primera
letra del primer apellido + primera letra del primer nombre + últimos 3 dígitos de su nro. de
cédula. Todo esto convertido a mayúscula. Ejemplo, para ZORRILLA ALCARAZ JOSE MANUEL
5.245.885, su código sería: ZJ885. Por simplicidad asuma que nunca se darán códigos
repetidos.
De esta manera, el programa debe permitir ir registrando la llegada de nuevos pacientes y
también debe permitir a los doctores ir llamando al siguiente que debe ser atendido. Hay dos
grupos de doctores, los que atienden casos respiratorios y los que atienden casos no
respiratorios. Luego, en cada grupo, se debe priorizar primero a los de triage ALTO, luego a los
MEDIOS y finalmente a los BAJOS. Si hay varios pacientes en el mismo grupo de triage, se debe
atender primero a los “vulnerables” y luego por orden de llegada.

//clase menu
El menú principal del programa que verían los usuarios debe permitir elegir entre opciones:
• Cargar más llegadas de pacientes, (especificando además de datos del paciente, su
grupo de atención (respiratorio o no respiratorio) y la prioridad según triage). Esto
agrega al paciente a la lista de espera inicializada desde el archivo CSV cuando se inició
el programa. Debe tomarse la fecha y hora exacta del sistema como fecha de ingreso
//clase archivo, paciente, una posible clase lista pacientes

• Llamar a un paciente de la lista de espera. Aquí debe preverse 2 posibles llamadores,
puede llamarse a un paciente respiratorio o a un paciente no respiratorio. Debe
tomarse la fecha y hora exacta del sistema como fecha y hora de atención.
//clase busqueda y una posible clase de cola de espera

• Imprimir lista de espera. Genera en pantalla la lista de todos los pacientes pendientes
de ser atendidos, en el orden que serian atendidos.
Un ejemplo de la salida:
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

• Debe proponer y crear sus estructuras de datos para el diseño de la solución
• Se deben manejar todos los errores y validaciones de datos de entrada
• Adicionalmente al proyecto fuente a entregar, adjunte en formato JPG o PNG el
diagrama de clases completo de su solución diseñada.*/



/*Se estilan 6 posibles clases:
1.Paciente: con los atributos y métodos necesarios para manejar la información de cada paciente.
ListaEspera: contiene una lista de pacientes en espera y métodos para agregar y ordenar pacientes en la lista.
Doctor: contiene información sobre si atiende pacientes respiratorios o no, y una lista de pacientes que ha atendido.
CentroMedico: clase principal que contiene la lista de espera y los doctores, además de los métodos para cargar pacientes, llamar a pacientes y generar la lista de espera.
Lector de CSV: lee un archivo CSV y genera una lista de pacientes.
Utilidades: es una clase que contiene métodos útiles, como el método para generar el código de paciente./*
