/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;

/**
 *  Clase con los atributos de un corredor 
 * @author tmore
 */
public class Corredor {
    //Variable que guarda la cantidad de pasos que da el corredor este va de 0 a 3 
    private int pasos;
    //Variable que guarda el nombre del corredor
    private String nombre;
    //Constructor de la clase
    public Corredor(int pasos, String nombre) {
        this.pasos = pasos;
        this.nombre = nombre;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
