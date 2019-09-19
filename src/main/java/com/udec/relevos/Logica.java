/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;

/**
 *  Clase que ejecuta todos los hilos 
 * @author AndresChila, Tatiana Moreno
 */
public class Logica extends Thread {
    
    Equipo equipo1 = new Equipo("Equipo Rojo");
    Equipo equipo2 = new Equipo("Equipo Azul");
    Equipo equipo3 = new Equipo("Equipo Verde");
    
    Corredor corredor1 = new Corredor(equipo1,0,"Corredor 1") ;
    Corredor corredor2 = new Corredor(equipo1,33,"Corredor 1");
    Corredor corredor3 = new Corredor(equipo1,66,"Corredor 1");
    Corredor corredor4 = new Corredor(equipo2,0,"Corredor 1");
    Corredor corredor5 = new Corredor(equipo2,33,"Corredor 1");
    Corredor corredor6 = new Corredor(equipo2,66,"Corredor 1");
    Corredor corredor7 = new Corredor(equipo3,0,"Corredor 1");
    Corredor corredor8 = new Corredor(equipo3,33,"Corredor 1");
    Corredor corredor9 = new Corredor(equipo3,66,"Corredor 1");

    public Logica() {

    }
    /**
     * Metodo usado para ejecutar los hilos
     */
    public void comienza() {
        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
        corredor9.start();
        
    }
    

}
