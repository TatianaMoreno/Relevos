/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Clase que alamacena el corredor con sus tipos de variables
 * @author AndresChila, Tatiana Moreno
 */
public class Corredor extends Thread {
    //Variables staticas usadas para los colores
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLACK = "\u001B[30m";
    //Variable que almacena el equipo al que pertenece el corredor 
    Equipo equipo;
    //Variable que almacena la posicion inicial del corredor esto se usa para
    //poder saber en que posicio  debe empezar el corredor si como el primero en
    //salio el del medio o el ultimo
    private int posicion;
    //Variable que guarda el nombre del corredor 
    private String nombre;
    //Constructor de la clase
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

    /*
    
    */
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
    
    /**
     * Metodo que se usa para poder mover al corredor
     * @param corredor 
     */
    public void avance(int corredor){
        while(true){
            if(corredor == 1){
                int pasoActual = pasos();
                if (pasoActual >= 33) { 
                    synchronized (equipo) {
                        equipo.notifyAll();
                    }
                    break;
                }
            }
            if(corredor == 2){
                int pasoActual = pasos();
                if (pasoActual >= 66) {  
                    synchronized (equipo) {
                        equipo.notify();
                    }
                    break;
                }
            }
            if(corredor == 3){
                int pasoActual = pasos();
                if (pasoActual >= 100) {   
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
    /**
     * Metodo que se usa para sumar al corredor el random de 0 a 3
     * @return la posicion del corredor
     */
    public int pasos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = RandomPasos.random();
        
        equipo.setAnterior(equipo.getAnterior() + avance);
        imprimir();
        limpiaConsola();
        return equipo.getAnterior();
            
      }
   /**
    * Metodo que imprime al corredor y su posicion
    */
    public void imprimir(){
        if(equipo.sincronizarImpresion().contains("R")){
            System.out.println("\033[31m"+equipo.sincronizarImpresion());
        }else if(equipo.sincronizarImpresion().contains("A")){
            System.out.println("\033[34m"+equipo.sincronizarImpresion());
        }else if(equipo.sincronizarImpresion().contains("V")){
            System.out.println("\033[32m"+equipo.sincronizarImpresion());
        }
    }
    /**
     * Metodo que se usa para hacer esperar a un corredor 
     */
    public void esperar(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Metodo usado para poder limpiar la consola 
     */
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
