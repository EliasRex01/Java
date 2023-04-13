/* Cuenta de calificacion representada por una letra */

#include<stdio.h> /* llamadas desde el preprocesador a librerias */

/* la funcion main comienza la ejecucion del programa */
int main()
{
	int calificacion; 	/* definimos esta variable que sera una calificacion */
	int cuentaA = 0;	/* inicializamos esta variable que representara los numeros de As*/
	int cuentaB = 0;	/* inicializamos esta variable que representara los numeros de Bs*/
	int cuentaC = 0;	/* inicializamos esta variable que representara los numeros de Cs*/
	int cuentaD = 0;	/* inicializamos esta variable que representara los numeros de Ds*/
	int cuentaF = 0;	/* inicializamos esta variable que representara los numeros de Fs*/

	printf(" Introduzca una letra que representara la calificacion.\n ");
	printf(" Introduza el caracter EOF para indicar la finalizacion del programa.\n ");
	
	/* condicion de repeticion la cual seguira hasta que el usuario digite la secuencia de fin de archivo */
	while( (calificacion = getchar()) != EOF ){
		
		/* Determina cual calificacion se ha ingresado*/
		switch( calificacion ){ /*switch anidado en while*/
			case 'A': /* la calificacion en A*/
			case 'a': /* o es a */
				++cuentaA; /* incrementamos cuentaA */
				break; /* necesario para finalizar el switch */

			case 'B': /* la calificacion en B*/
			case 'b': /* o es b */
				++cuentaB; /* incrementamos cuentaB */
				break; /* necesario para finalizar el switch */

			case 'C': /* la calificacion en C*/
			case 'c': /* o es c */
				++cuentaC; /* incrementamos cuentaC */
				break; /* necesario para finalizar el switch */
			
			case 'D': /* la calificacion en D*/
			case 'd': /* o es d */
				++cuentaD; /* incrementamos cuentaD */
				break; /* necesario para finalizar el switch */

			case 'F': /* la calificacion en F*/
			case 'f': /* o es f*/
				++cuentaF; /* incrementamos cuentaF */
				break; /* necesario para finalizar el switch */

			case '\n': /* ignora nuevas lineas */
			case '\t': /* tabulaciones*/
			case ' ' : /* y espacios en blanco*/
				break; /* necesario para finalizar el switch */
			
			default: /* Abarcamos todos los casos incorrectos*/
				printf(" La calificacion ingresada es incorrecta. ");
				printf(" Ingrese nuevamente.\n");
				break; /* es opcional, de todas formas finalizara el switch */
		
		} /* fin de switch */
	
	} /* fin de while */			


	/* Desplegamos los resultados de las calificaciones */
	printf("A: %d\n", cuentaA); /* desplegamos las As*/
	printf("B: %d\n", cuentaB); /* importante no olvidar el tipo de dato a mostrar, en este caso entero(%d) */ 
	printf("C: %d\n", cuentaC);
	printf("D: %d\n", cuentaD);
	printf("F: %d\n", cuentaF);

	return 0; /* indica terminacion exitosa del programa */

} /* fin de la funcion main */

/* es bueno recordar que asi como existen instrucciones de seleccion simple como el if, */
/* instrucciones de seleccion doble como el if/else, */
/* tambien existe la instruccion de seleccion multiple, en este caso switch */
/* la misma consiste en una serie de etiquetas case y un caso especial llamada default */
			