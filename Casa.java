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

    public Casa(String nif, String nombre, int superficie) {
        this.nif = nif;
        this.nombre = nombre;
        this.superficie = superficie;
        ArrayList<PlacaSolar> placas = new ArrayList<>();
        ArrayList<Aparato> aparatos = new ArrayList<>();
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
}

