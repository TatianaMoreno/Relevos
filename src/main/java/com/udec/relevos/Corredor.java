/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AndresChila, Tatiana Moreno
 */
public class Corredor extends Thread {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLACK = "\u001B[30m";
    
    Equipo equipo;
    private int posicion;
    private String nombre;

    public Corredor(Equipo equipo, int posicion, String nombre) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(byte posicion) {
        this.posicion = posicion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     
    @Override
    public void run() {
        if (posicion == 0) {
            avance(1);
        } else if(posicion ==33){
            avance(2);
        }else if(posicion == 66){
            avance(3);
        }else{
            esperar();
        }
    }
    
    public void avance(int corredor){
        while(true){
            if(corredor == 1){
                int pasoActual = pasos();
                if (pasoActual >= 33) { 
                    limpiaConsola();
                    synchronized (equipo) {
                        equipo.notifyAll();
                        
                    }
                    break;
                }
            }
            if(corredor == 2){
                int pasoActual = pasos();
                if (pasoActual >= 66) {    
                    limpiaConsola();
                    synchronized (equipo) {
                        equipo.notify();
                    }
                    
                    break;
                }
            }
            if(corredor == 3){
                int pasoActual = pasos();
                if (pasoActual >= 100) {   
                    limpiaConsola();
                    if(equipo.getNombreEquipo()=="Equipo Rojo")
                    {System.out.println(ANSI_BLACK+"El equipo "+ANSI_RED+equipo.getNombreEquipo()+ANSI_BLACK+" Ganó");}
                    else if(equipo.getNombreEquipo()=="Equipo Azul")
                    {System.out.println(ANSI_BLACK+"El equipo "+ANSI_BLUE+equipo.getNombreEquipo()+ANSI_BLACK+" Ganó");}
                    else{System.out.println(ANSI_BLACK+"El equipo "+ANSI_GREEN+equipo.getNombreEquipo()+ANSI_BLACK+" Ganó");}
                    System.exit(0);
                }
            }
        }
    }
    public int pasos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Random.random();
        
        equipo.setAnterior(equipo.getAnterior() + avance);
        imprimir();
        return equipo.getAnterior();
            
      }
    public void imprimir(){
        if(equipo.sincronizarImpresion().contains("R")){
            System.out.println("\033[31m"+equipo.sincronizarImpresion());
        }else if(equipo.sincronizarImpresion().contains("A")){
            System.out.println("\033[34m"+equipo.sincronizarImpresion());
        }else if(equipo.sincronizarImpresion().contains("V")){
            System.out.println("\033[32m"+equipo.sincronizarImpresion());
        }
    }   
    public void esperar(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void limpiaConsola(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
