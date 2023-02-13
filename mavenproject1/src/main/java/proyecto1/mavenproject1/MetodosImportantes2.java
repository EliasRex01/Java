/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.mavenproject1;

/**
 *
 * @rex_elias
 */

public class MetodosImportantes2 {
    public static void main(String[] args) {
        String nombre="rex";
    //contraparte de converto que ignora mayusculas
        System.out.println(nombre.compareToIgnoreCase("leandro"));
        
    //reemplazar un caracter
        System.out.println(nombre.replace("R", "."));
        
    //busca cuantas veces aparece un caracter en un string
        System.out.println(nombre.lastIndexOf("x"));
        
    //quiero el indice especifico
        System.out.println(nombre.indexOf("e")); //da 2 que es el numero del caracter
        
    //verificar si empieza o termina con algo
        System.out.println(nombre.startsWith("re"));
        //aqui da true por que comienza con re
        
    //verificar si el string contiene algo
        System.out.println(nombre.contains("m"));
        //aqui da false ya que el string="rex" no contiene una m
        
    //recortar el string, pe eliminar espacios
        System.out.println(nombre.trim());
        //sirve para la limpieza de datos
        
        
        
        
        
    
    }
    
}
