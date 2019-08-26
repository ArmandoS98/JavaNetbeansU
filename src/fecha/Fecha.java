/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.util.Scanner;


/**
 *
 * @author asantos
 */
public class Fecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
     
        Scanner input = new Scanner(System.in);
        String fecha;
        System.out.print("Introduzca una fecha -> ");
        fecha = input.next(); 
              
        new FechaLogica(fecha);        
    }
    
}
