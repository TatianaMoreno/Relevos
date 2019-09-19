/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;

/**
 *
 * @author AndresChila, Tatiana Moreno
 */
public class Logica extends Thread {

    Corredor corredor1 = new Corredor((byte) 1, (byte) 0); ////(Equipo, posicion inicial)
    Corredor corredor2 = new Corredor((byte) 1, (byte) 33);
    Corredor corredor3 = new Corredor((byte) 1, (byte) 66);
    Corredor corredor4 = new Corredor((byte) 2, (byte) 0);
    Corredor corredor5 = new Corredor((byte) 2, (byte) 33);
    Corredor corredor6 = new Corredor((byte) 2, (byte) 66);
    Corredor corredor7 = new Corredor((byte) 3, (byte) 0);
    Corredor corredor8 = new Corredor((byte) 3, (byte) 33);
    Corredor corredor9 = new Corredor((byte) 3, (byte) 66);

    public Logica() {

    }

    public void comienza() {
        corredor1.start();
        corredor4.start();
        corredor7.start();
        while (corredor3.getPosicion() < 100 && corredor6.getPosicion() < 100 && corredor9.getPosicion() < 100) {
            if (corredor1.getPosicion() >= 33) {
                corredor2.start();
                corredor1.stop();
            }
            if (corredor2.getPosicion() >= 66) {
                corredor3.start();
                corredor2.stop();
            }
            if (corredor4.getPosicion() >= 33) {
                corredor5.start();
                corredor4.stop();
            }
            if (corredor5.getPosicion() >= 66) {
                corredor6.start();
                corredor5.stop();
            }
            if (corredor7.getPosicion() >= 33) {
                corredor8.start();
                corredor7.stop();
            }
            if (corredor8.getPosicion() >= 66) {
                corredor9.start();
                corredor8.stop();
            }
            limpiaConsola();
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
