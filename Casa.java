/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;

/**
 *
 * @author nozystem
 */
public class Casa {

    private String nif;
    private String nombre;
    private int superficie;
    private boolean interruptor;
    private ArrayList<PlacaSolar> placas;
    private ArrayList<Aparato> aparatos; 

    public Casa(String nif, String nombre, int superficie) {
        this.nif = nif;
        this.nombre = nombre;
        this.superficie = superficie;
        placas = new ArrayList<>();
        aparatos = new ArrayList<>();
    }

    public String getNif() {
        return this.nif;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getSuperficie() {
        return this.superficie;
    }

    public boolean getIntrruptor() {
        return this.interruptor;
    }
    
    public void SetInterruptor(boolean newInterruptor) {
        this.interruptor = newInterruptor;
    }
    
    public void anadirPlaca(PlacaSolar miPlaca) {
        placas.add(miPlaca);
    }
    public int comprobarSuperficie(){
        int superficieTotal = 0;
        for(int i = 0; i < placas.size(); i++){
            superficieTotal += placas.get(i).getSuperficie();
        }
        int superficieRestante =  this.superficie - superficieTotal;
        return superficieRestante;
    }
}

