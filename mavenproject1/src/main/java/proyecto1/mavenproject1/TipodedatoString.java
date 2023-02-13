/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.mavenproject1;

import java.util.Locale;

/**
 *
 * @rex_elias
 */
public class TipodedatoString {
    public static void main(String[] args) {
        //los string son tipo de datos referenciales al objeto
       /* Inmutables, se concatenan con el operador suma: +,
        con el operador == se comparan por referencia,
        con el operador equals() se compara por valor*/
        
       
        //para declarar string
       String Hola = "Hola gracias";
       String Hola1 = new String("Hola gracias");
       String Hola2 = "Hola gracias";
       System.out.println(Hola==Hola2); //debe ser la misma declaracion para comparar con ==
        System.out.println(Hola.equals(Hola1));
       //equals compara el contenido y no la declaracion
       
       /*
       //string es un objeto que tiene varios metodos
       //concatenacion de strings
       String saludo = "Hola, gracias por la informacion ";
       String nombre = "Peter ";
       String saludoPersonalizado = "\n" + saludo + "querido " + nombre;
       String saludoPersonalizado1 = saludo.concat("querido ").concat(nombre);
       System.out.println(saludoPersonalizado);
        System.out.println(saludoPersonalizado1);
       */
        
        
        
       /*Inmutable es ajeno a que le modifiques cosas ya que 
       se declaro a menos que se usen metodos de la clase string
        para cambiar los datos*/
       
        String saludo = "Hola, gracias por la informacion ";
       String nombre = "Peter ";
       String nombre1 = "Peter ";
       String saludoPersonalizado = "\n" + saludo + "querido " + nombre;
       String saludoPersonalizado1 = saludo.concat("querido ").concat(nombre);
       System.out.println(saludoPersonalizado);
        System.out.println(saludoPersonalizado1);
        
        //otra forma de concatenacion transformando
        saludo=saludo.transform(s-> {
            return s="gracias "+nombre; 
            /*una vez se usa nombre en la funcion ya no se puede
            modificar ya que es parte de una funcion,
            ya que nombre se vuelve una instancia final
            parecida a una constante*/
        });
        System.out.println(saludo);
        
        //cambiar algunas letras del string
        nombre1=nombre1.replace("P", "p");
        System.out.println(nombre1);
        //agarro Peter y cambio las P mayusculas por minusculas
        
        
        //metodos importantes de la clase string
        String minombre="Rex";
        System.out.println(minombre.toUpperCase(Locale.ROOT));
        //todo en mayuscula upper case
        System.out.println(minombre.toLowerCase(Locale.ROOT));
        //todo en minuscula lower case
        
        //comparar strings con equals
        System.out.println(minombre.equals("rex")); //dira false
        System.out.println(minombre.equalsIgnoreCase("rex"));
     //ignorecase lo que hace es forzar que todos los caracteres sean iguales
       //ignora mayusculas y minusculas
    
        //compareto, compara caracter a caracter, cuantos cambiar para llegar a la otra letra
        System.out.println(minombre.compareTo("peter"));
        //si quiero solo un caracter del string
        System.out.println(minombre.charAt(0));
        //el 0 es el primer caracter y asi va aumentando en orden al numero de letras
        
        //para contar elementos
        System.out.println(minombre.length());
        //ultimo caracter con lenght y charAt
        System.out.println(minombre.charAt(minombre.length()-1)); //-1 por el rango desde 0
        
        
        
    }
    
}
    
    

