/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * Sistemas tales como el binario, el hexagesimal, el desimal, etc
 */
package proyecto1.mavenproject1;


import javax.swing.JOptionPane;

/**
 *
 * @rex_elias
 */
public class SistemasNumericos {
    public static void main(String[] args) {
        /*int numero=450;
        System.out.println("Nuestro numero es " + numero);
        
        //conversion a binario
        String numBinario=Integer.toBinaryString(numero);
        //primero lo convierte a string
        System.out.println("Numero en binario " + numBinario);
        //imprime el resultado en binario
        
        System.out.println("Numero en binario escrito en java " + 0b111000010);
        //0b indica que queremos que nos lea el binario como decimal
        
        //numero a hexagesimal
        System.out.println("Numero en Hexadecimal " + Integer.toHexString(numero));
        //convierte el decimal a hexadecimal
        System.out.println("Numero dexadecimal escrito en java " + 0x1c2);
        //0x indica que se busca que nos lea el hexa como decimal
        
        //numero en octal
        System.out.println("Numero en octal " + Integer.toOctalString(numero));
        //imprime el numero decimal en octal
        System.out.println("Numero octal escrito en java " + 0702);
        //prefijo 0 para que lea octal como decimal
        */
        
        //como hacer que salga un cuadro de dialogo o introducir datos
        String numero2 = JOptionPane.showInputDialog( null, "Ingrese un numero entero ");
        //primero lo convierte a string
        int numeroReal=Integer.parseInt(numero2);  //convierte el string a numero real
        System.out.println("Numero en binario " + Integer.toBinaryString(numeroReal));
        //imprime el resultado en binario
        
        System.out.println("Numero en Hexadecimal " + Integer.toHexString(numeroReal));
        //convierte el decimal a hexadecimal
       
        System.out.println("Numero en octal " + Integer.toOctalString(numeroReal));
        //imprime el numero decimal en octal
        
        //imprimir en una pantallita el resultado de operar el numero
        String resultados = "Su numero es: " + numero2 + "\nEl numero en binario es: " + Integer.toBinaryString(numeroReal)
                + "\nEl numero en Hexadecimal es: " + Integer.toHexString(numeroReal)
                +"\nEl numero en octal es: "+Integer.toOctalString(numeroReal);
       JOptionPane.showMessageDialog(null, resultados);
     
        
    }
    
    
}
