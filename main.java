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

    public static void crearCasas() {

        Casa miCasa = new Casa("12345678M", "sergio", 100);
        casas.add(miCasa);

        PlacaSolar miPlaca = new PlacaSolar(80, 30, 60);
        miCasa.anadirPlaca(miPlaca);
        Aparato miAparato = new Aparato("TV", 20);
        miCasa.anadirAparato(miAparato);

    }
    //Creo el metodo que va a comprobar si la casa/placa/aparato que quiero añadir
    //existe o no existe

    public static Casa dameCasa(String nifCasa) {
        for (int i = 0; i < casas.size(); i++) {
            if (casas.get(i).getNif().equalsIgnoreCase(nifCasa)) {
                return casas.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        crearCasas();
        //instancio el buffered reader para poder leer por consola
        BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false; // Defino que quit vale false, para poder cerrar la consola cuando valga true
        do {
            System.out.print(">"); // imprimo el >
            String leer = terminal.readLine(); // Esta variable contiene lo que se me pasa por terminal
            String[] palabra = leer.split(" "); // Hago un split de leer y lo guardo en una array list palabra
            boolean NIFexiste; //Defino un booleano que me va a servir para comprobar si existe una casa o no

            switch (palabra[0].toUpperCase()) {  // Al switch le paso como parametro la primera palabra de la array

                case "ADDCASA": // En el caso de que escriban al principio addCasa:
                    try {
                    NIFexiste = false; // Defino que por defecto el dni no esta reptido

                    if (palabra.length == 4) {
                        if (casas.isEmpty() == false) {
                            if (dameCasa(palabra[1]) != null) {
                                NIFexiste = true;
                                System.out.println("ERR: El nif introducido ya pertenece a una casa");
                            }
                        }

                        if (Integer.parseInt(palabra[3]) >= 10) {
                            if (palabra[1].length() == 9) {
                                if (NIFexiste == false) {
                                    Casa miCasa = new Casa(palabra[1], palabra[2], Integer.parseInt(palabra[3]));
                                    casas.add(miCasa);
                                    System.out.println("OK: Casa registrada.");
                                }
                            } else {
                                System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10");
                            }
                        } else {
                            System.out.println("ERROR: Ja hi ha una casa registrada amb aquest nif");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte");
                    }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                       
                    }
                    break;

                case "ADDPLACA":
                    Casa casa = dameCasa(palabra[1]);
                    try {
                    if (palabra.length != 5) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    break;}

                    if (casa == null) {
                        System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                    break; }

                    int superficie = Integer.parseInt(palabra[2]);
                    float precio = Float.parseFloat(palabra[3]);
                    int potencia = Integer.parseInt(palabra[4]);

                    if (superficie <= 0) {
                        System.out.println("ERROR: Superfície incorrecta. Ha de ser més gran de 0.");
                    break; }

                    if (precio <= 0) {
                        System.out.println("ERROR: Precio incorrecto. Ha de ser més gran de 0.");
                    break;
                    }
                    if (potencia <= 0) {
                        System.out.println("ERROR: Potencia incorrecta. Ha de ser més gran de 0.");
                    break; }

                    if (casa.comprobarSuperficie() < superficie) {
                        System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                    break;
                    }
                    PlacaSolar miPlaca = new PlacaSolar(superficie, precio, potencia);
                    casa.anadirPlaca(miPlaca);
                    System.out.println("OK: Placa afegida a la casa.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                    
                case "ADDAPARELL":
                    casa = dameCasa(palabra[1]);
                    try{
                    if (palabra.length != 4 || casa == null) {
                        System.out.println("ERROR: Número de paràmetres incorrecte o no hi ha cap casa registrada amb aquest nif.");
                        break;
                    }
                    String descripcion = palabra[2];
                    int potencia = Integer.parseInt(palabra[3]);
                    if (potencia <= 0 || casa.dameAparato(descripcion) != null) {
                        System.out.println("ERROR: Potència incorrecte o ja existeix un aparell amb aquesta descripció a la casa indicada.");
                        break;
                    }
                    Aparato miAparato = new Aparato(descripcion, potencia);
                    casa.anadirAparato(miAparato);
                    System.out.println("OK: Aparell afegit a la casa.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "ONAPARELL":
                    casa = dameCasa(palabra[1]);
                    try{
                    if (palabra.length != 3) {
                        System.out.println("ERROR: Número de paràmetres incorrecte");
                        break;
                    }
                    Aparato aparato = casa.dameAparato(palabra[2]);
                    if (aparato == null) {
                        System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");
                        break;
                    }
                    if (casa.getInterruptor() == false) {
                        System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
                        break;
                    }
                    if (aparato.getInterruptor() == true) {
                        System.out.println("ERROR: L'aparell ja està encès");
                        break;
                    }
                    aparato.setAparell(true);
                    if (casa.PotenciaPlacas() < casa.PotenciaAparell()) {
                        casa.setInterruptor(false);
                        for (int i = 0; i < casa.getAparatos().size(); i++) {
                            casa.getAparatos().get(i).setAparell(false);
                            System.out.println("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
                        }
                    } else {
                        System.out.println("OK: Aparell encès.");
                    }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "ONCASA":
                    try{
                    if (palabra.length != 2) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: onCasa [nif]");
                        break;
                    }
                    casa = dameCasa(palabra[1]);
                    if (casa == null) {
                        System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        break;
                    }
                    if (casa.getInterruptor()) {
                        System.out.println("ERROR: La casa ja té l'interruptor encès.");
                        break;
                    }
                    casa.setInterruptor(true);
                    System.out.println("OK: Interruptor general activat");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "OFFAPARELL":
                    try{
                    if (palabra.length != 3) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: offAparell [nif] [descripció aparell]");
                        break;
                    }
                    casa = dameCasa(palabra[1]);
                    if (casa == null) {
                        System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif");
                        break;
                    }
                    aparato = casa.dameAparato(palabra[2]);
                    if (aparato == null) {
                        System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");
                        break;
                    }
                    if (aparato.getInterruptor() == false) {
                        System.out.println("ERROR: L'aparell ja està apagat");
                        break;
                    }
                    aparato.setAparell(false);
                    System.out.println("OK: Aparell apagat.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "INFO":
                    try {
                    if (palabra.length == 2) {
                        casa = dameCasa(palabra[1]);
                        if (casa != null) {
                            System.out.println("client: " + palabra[1] + " - " + casa.getNombre());
                            System.out.println("Plaques solars instal·lades: " + casa.listPlaca());
                            System.out.println("Potència total: " + casa.PotenciaPlacas());
                            System.out.println("Inversió total: " + casa.InversionTotal() + "€");
                            System.out.println("Aparells registrats: " + casa.getAparatos().size());
                            System.out.println("Consum actual: " + casa.PotenciaAparell() + "W");
                        }
                        if (casa.PotenciaAparell() > 0) System.out.println("Aparells encesos:");

                        for (int i = 0; i < casa.getAparatos().size(); i++) {
                            if (casa.getAparatos().get(i).getInterruptor() == true) {
                                System.out.println("- " + casa.getAparatos().get(i).getDescripcion());
                            }
                        }
                    }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    break;
                case "LIST":
                    try {
                    System.out.println("--- Endolls Solars, S.L. ---");
                    System.out.println("Cases enregistrades: " + casas.size());
                    for (int i = 0; i < casas.size(); i++) {
                        System.out.println("Casa " + (i + 1));
                        System.out.println("Client: " + casas.get(i).getNif() + " - " + casas.get(i).getNombre());
                        System.out.println("Superfície de teulada: " + casas.get(i).getSuperficie());
                        System.out.println("Superfície disponible: " + casas.get(i).comprobarSuperficie());
                        if (casas.get(i).getInterruptor() == false) {
                            System.out.println("Interruptor general: apagat");
                        } else {
                            System.out.println("Interruptor general: encés");
                        }
                        System.out.println("Plaques solars instal·lades: " + casas.get(i).listPlaca());
                        System.out.println("Aparells registrats: " + casas.get(i).getAparatos().size());
                    }
                   
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    
                    break;
                case "QUIT":
                    if(palabra.length == 1) quit = true;
                    else System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: quit");
                break;
                
                default:
                    System.out.println("ERROR: Comanda incorrecta");
                break;
            }
        } while (!quit);
    }

}
