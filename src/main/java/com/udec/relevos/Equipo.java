/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;

/**
 *
 * @author Tatiana Moreno y Andres Chila
 */
public class Equipo {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private String nombreEquipo;
    private int anterior;

    public Equipo(String nombre) {
        this.nombreEquipo = nombre;
    }
    public synchronized String sincronizarImpresion(){
        String imprimir="";
        imprimir = "\n" + nombreEquipo + " ";
        for (int i = 0; i <= 100; i++) {
            if (i == 33) {
                if(nombreEquipo=="Equipo Rojo")
                {imprimir += ""+ANSI_RED+"*";}
                else if(nombreEquipo=="Equipo Azul")
                {imprimir += ""+ANSI_BLUE+"*";}
                else{imprimir += ""+ANSI_GREEN+"*";}
            } else if (i == 66) {
                imprimir += "*";
            } else if (i == anterior) {
                imprimir += "*|";
            } else {
                imprimir += "_";
            }
            
        } 
        
        return imprimir;
        
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombre) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getAnterior() {
        return anterior;
    }

    public void setAnterior(int anterior) {
        this.anterior = anterior;
    }
    
}
