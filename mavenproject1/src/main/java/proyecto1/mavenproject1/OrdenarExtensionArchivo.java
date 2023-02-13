/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.mavenproject1;

/**
 *
 * @rex_elias
 */
public class OrdenarExtensionArchivo {
    public static void main(String[] args) {
        String archivo="Image.jpg";
        //queremos sacarle la extension, osea obtener jpg
        //el contenido podria tener muchos puntos por lo que podemos
        int i=archivo.lastIndexOf(".");
        //esto buscara el ultimo punto y lo guardara en i
        
        //ahora debo ver cuantos caracteres tiene el archivo
        System.out.println(archivo.length());
        
        //a patir del punto quiero los caracteres de adelante
        System.out.println(archivo.substring(i+1));
        //a partir de una subparte i del string, +1 para que no salga el punto
        
        
        
    }
    
    
    
    
}
