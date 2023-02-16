/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author nozystem
 */
public class main {

    public static void main(String[] args) throws IOException {
        /*
       Casa miCasa = new Casa("53317286C", "sergio", 21);
        System.out.println(miCasa.getNombre());/*
         */
        ArrayList<Casa> casas = new ArrayList<>();
        BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;
        do {
            System.out.print(">"); // imprimo el >
            String leer = terminal.readLine(); // Esta variable contiene lo que se me pasa por terminal
            String[] palabra = leer.split(" "); // Hago un split de leer y lo guardo en una array list palabra
            switch (palabra[0]) {  // Al switch le paso como parametro la primera palabra de la array
                case "addCasa":
                    if (palabra.length == 4){
                        Casa miCasa = new Casa(palabra[1], palabra[2], Integer.parseInt(palabra[3]));
                        casas.add(miCasa);
                    }
                    break;
                case "quit":
                    quit = true;
                    break;
            
                case "list":
                    for( int i = 0; i > casas.length(); i ++)
                    break;
            }
        } while (!quit); // quit == false
    }
}
