/* Creacion y uso de una funcion definida por el usuario */

#include<stdio.h> /* llamada desde el preprocesador a librerias */

int cuadrado(int y); /* prototipado de la funcion cuadrado */

/* la funcion main comienza la ejecucion del programa */
int main()
{
	int x; /* declaramos la variable que sera contador dentro del ciclo de repeticion */
	
	/* repite 10 veces el ciclo y calcula e imprime el cuadrado de x */
	for(x = 1; x <= 10; x++){
		printf("%d ", cuadrado(x)); /* llamada a la funcion cuadrado */
	}
	
	return 0; /* indica terminacion exitosa del programa */

} /* fin de la funcion main*/


/* definicion de la funcion cuadrado, devuelve el cuadrado del parametro*/
int cuadrado(int y) /* y es una copia del argumento para la funcion */
{
	return y*y; /* devuelve el cuadrado de y como un entero(int) */
} /* fin de la funcion cuadrado*/
	