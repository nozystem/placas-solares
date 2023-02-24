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
        
        // Creo la array list casas donde voy a guardar cada una de las placas que añada
        private static ArrayList<Casa> casas = new ArrayList<>();
        
        //Creo el metodo que va a comprobar si la casa/placa/aparato que quiero añadir
        //existe o no existe
        public static Casa dameCasa(String nifCasa) {
            for (int i = 0; i < casas.size(); i++) {
                if (casas.get(i).getNif().equalsIgnoreCase(nifCasa)) {
                    return casas.get(i); 
                }
            }return null;
        }
        
    public static void main(String[] args) throws IOException {

        //instancio el buffered reader para poder leer por consola
        BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
        casas = new ArrayList<>();
        boolean quit = false; // Defino que quit vale false, para poder cerrar la consola cuando valga true
        do {
            System.out.print(">"); // imprimo el >
            String leer = terminal.readLine(); // Esta variable contiene lo que se me pasa por terminal
            String[] palabra = leer.split(" "); // Hago un split de leer y lo guardo en una array list palabra
            boolean NIFexiste; //Defino un booleano que me va a servir para comprobar si existe una casa o no
           
            switch (palabra[0].toUpperCase()) {  // Al switch le paso como parametro la primera palabra de la array
                
                case "ADDCASA": // En el caso de que escriban al principio addCasa:    
                    NIFexiste = false; // Defino que por defecto el dni no esta reptido
      
                    if (palabra.length == 4) {
                        if (casas.isEmpty() == false) {
                            if(dameCasa(palabra[1]) !=  null){
                                NIFexiste = true;
                                System.out.println("ERR: El nif introducido ya pertenece a una casa");
                            }
                        }
                        
                        if (Integer.parseInt(palabra[3]) >= 10) {
                            if (palabra[1].length() == 9) {
                                if (NIFexiste == false) {
                                    Casa miCasa = new Casa(palabra[1], palabra[2], Integer.parseInt(palabra[3]));
                                    casas.add(miCasa);
                                    System.out.println("OK: Casa registrada.");}
                                
                                }else{  System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10");}
                            }else{  System.out.println("ERROR: Ja hi ha una casa registrada amb aquest nif");}
                        } else {System.out.println("ERROR: Número de paràmetres incorrecte");}
                break;
                
                case "ADDPLACA":
                     Casa casa = dameCasa(palabra[1]);
                     if (palabra.length == 5) {
                        if(dameCasa(palabra[1]) !=  null){
                            if (Integer.parseInt(palabra[2]) > 0){
                                if (Float.parseFloat(palabra[3])> 0){
                                    if (Integer.parseInt(palabra[4])> 0){
                                        if (casa.comprobarSuperficie() >= Integer.parseInt(palabra[2])){
                                            PlacaSolar miPlaca = new PlacaSolar(Integer.parseInt(palabra[2]), Float.parseFloat(palabra[3]), Integer.parseInt(palabra[4]));
                                            casa.anadirPlaca(miPlaca);
                                            System.out.println("OK: Placa afegida a la casa .");   
                                        } else {System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");}
                                    } else {System.out.println("ERROR: Potencia incorrecta. Ha de ser més gran de 0.");}
                                } else {System.out.println("ERROR: Precio incorrecto. Ha de ser més gran de 0.");}
                            } else {System.out.println("ERROR: Superfície incorrecta. Ha de ser més gran de 0.");}
                        } else {System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");}
                     } else {System.out.println("ERROR: Número de paràmetres incorrecte.");}
                break;
                case "LIST":
                    System.out.println("Cases enregistrades: " + casas.size());
                    for (int i = 0; i < casas.size(); i++) {
                        System.out.println("Client: " + casas.get(i).getNif() + " - " + casas.get(i).getNombre());
                        System.out.println("Superfície de teulada: " + casas.get(i).getSuperficie());
                    }
                break;

                case "QUIT":
                    quit = true;
                break;
            } 
        } while (!quit);
    }
}