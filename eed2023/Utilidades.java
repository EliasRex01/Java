/*  En este ejemplo, se han definido tres métodos estáticos que podrían ser útiles en 
diferentes partes de una aplicación:
validarRut: recibe un RUT chileno como argumento y devuelve un valor booleano indicando 
si el RUT es válido o no.
generarNumeroAleatorio: recibe un valor mínimo y un valor máximo como argumentos y 
devuelve un número entero aleatorio entre ellos.
imprimirMensaje: recibe un mensaje como argumento y lo imprime por consola.
Estos son solo algunos ejemplos de los muchos métodos que podrían ser útiles en una 
aplicación y que podrían definirse en una clase Utilidades. La idea es que esta clase 
agrupe métodos que no tienen una relación directa con ninguna otra clase de la aplicación,
pero que pueden ser útiles en diferentes partes de la misma.      */

public class Utilidades {
    public static boolean validarRut(String rut) {
        // Lógica para validar un RUT chileno
    }

    public static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    // Otros métodos útiles...
}
