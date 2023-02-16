/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author nozystem
 */
public class Aparato {
    
    private String descripcion;
    private int consumo;
    private boolean interruptor;

    public Aparato(String descripcion, int consumo) {
        this.descripcion = descripcion;
        this.consumo = consumo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getConsumo() {
        return this.consumo;
    }

    public boolean geInterruptor() {
        return this.interruptor;
    }
}
