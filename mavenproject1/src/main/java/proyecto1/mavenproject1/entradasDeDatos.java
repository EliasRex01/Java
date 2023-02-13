/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.mavenproject1;

import javax.swing.JOptionPane;

/**
 *
 * @rex_elias
 */
import java.util.Scanner;
public class entradasDeDatos {
    public static void main(String[] args) {
        //introducir datos por teclado
        /*Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca un numero entero :");
        
        int numeroReal=entrada.nextInt();
        System.out.println("Numero en binario " + Integer.toBinaryString(numeroReal));
        
        System.out.println("Numero en Hexadecimal " + Integer.toHexString(numeroReal));
       
        System.out.println("Numero en octal " + Integer.toOctalString(numeroReal));
        */
        /*
        //convertir string a tipo de dato primitivo
        String booleano="true";
        boolean booleanoConvertido=Boolean.parseBoolean(booleano);
            System.out.println(Boolean.parseBoolean(booleano));
            //convierte la cadena a boolean
            
        String decimales="2.56";
        double decimalesConvertidos=Double.parseDouble(decimales);
        System.out.println(decimalesConvertidos);
        //convierte cadena a decimal
        
        String entero="395";
        int enteroConvertido=Integer.parseInt(entero);
        System.out.println(enteroConvertido);
        //convertido a entero
        
        String flotante="2.56e2f";
        float flotanteConvertido=Float.parseFloat(flotante);
        System.out.println(flotanteConvertido);
        
        //no crea problemas por que son en efectivo tipos de datos primitivos
        */
        
        /*
        //tipo de dato primitivo a string
        boolean cierto=true;
        String ciertoConvertido=Boolean.toString(cierto);
    
        //cada clase tiene su metodo toString que lo convierte en string
        int numero=20;
        String numeroConvertido=Integer.toString(numero);
        
        float flojo=1.23e2f;
        String flojoConvertido=Float.toString(flojo);
        
        double doble=2099.388;
        String dobleConvertido=Double.toString(doble);
        
        String conjunto = ciertoConvertido+"\n"+numeroConvertido+"\n"
                +flojoConvertido+"\n"+dobleConvertido;
        System.out.println(conjunto);
        */
        
        
        
        //Conversiones entre tipos primitivos
        int i = 400;
        short s=(short)i;  //si i es mayor a la capacidad de short se pierde informacion
        System.out.println(s);
        //casting, forzar que una variable se vuelva otra
        long l=1;    //como 400 entra en el rango de long no hace falta el casting
        System.out.println(l);
        
        char c=(char)i;
        System.out.println(c);
        //dara un codigo de caracter de la tabla ASCI
    }
}
