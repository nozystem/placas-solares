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
        this.interruptor = true;
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

    public boolean getInterruptor() {
        return this.interruptor;
    }
    public ArrayList <Aparato> getAparatos(){
        return this.aparatos;
    }
    
    public void setInterruptor(boolean newInterruptor) {
        this.interruptor = newInterruptor;
    }
    
    public void anadirPlaca(PlacaSolar miPlaca) {
        placas.add(miPlaca);
    }
     public void anadirAparato(Aparato miAparato) {
        aparatos.add(miAparato);
    }
    public int comprobarSuperficie(){
        int superficieTotal = 0;
        for(int i = 0; i < placas.size(); i++){
            superficieTotal += placas.get(i).getSuperficie();
        }
        int superficieRestante =  this.superficie - superficieTotal;
        return superficieRestante;
    }
    public int listPlaca(){
        return placas.size();
    }
    
    public Aparato dameAparato(String descripcion) {
    for (int i = 0; i < aparatos.size(); i++) {
    if (aparatos.isEmpty() == false){
    if (aparatos.get(i).getDescripcion().equalsIgnoreCase(descripcion)) {
        return aparatos.get(i); 
                }
            }
         }return null;
    }
        
    public int PotenciaPlacas(){
        int potenciaTotal= 0;
        for (int i = 0; i < placas.size(); i++){
            potenciaTotal += placas.get(i).getPotencia();
        }
        return potenciaTotal;
    }
    public int PotenciaAparell(){
        int potenciaTotal= 0;
        for (int i = 0; i < aparatos.size(); i++){
            if (aparatos.get(i).getInterruptor() == true){
                potenciaTotal += aparatos.get(i).getConsumo();
            }
        }return potenciaTotal;
    }
    
    public float InversionTotal(){
        float inversionTotal = 0;
            for (int i = 0; i < aparatos.size(); i++){
            inversionTotal +=  placas.get(i).getPrecio();      
        }return inversionTotal;
    }
}