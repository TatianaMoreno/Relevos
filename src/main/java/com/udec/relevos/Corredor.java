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
public class Corredor extends Thread {

    private byte equipo;
    private byte posicion;
    private double numeroRandomico;
    private byte posicionFinal;

    public Corredor(byte equipo, byte posicion) {
        this.equipo = equipo;
        this.posicion = posicion;
    }

    public byte getPosicion() {
        return posicion;
    }

    public void setPosicion(byte posicion) {
        this.posicion = posicion;
    }

    @Override
    public void run() {
        while (this.getPosicion() < 100) {
            //try {
            numeroRandomico = Math.random() * 3;
            posicionFinal = (byte) (this.getPosicion() + numeroRandomico);
            this.setPosicion(posicionFinal);
            System.out.println("Equipo: " + equipo);
            for (int i = 0; i < this.getPosicion(); i++) {
                if(this.equipo ==1)
                System.out.print("-"); ////imprime de un color
                if(this.equipo ==2)
                System.out.print("-"); ////imprime de otro color
                if(this.equipo ==3)
                System.out.print("-"); ////imprime de otro color
            }
            if(this.equipo ==1)
            System.out.println(":v");////imprime de un color
            if(this.equipo ==2)
            System.out.println(":v");////imprime de otro color
            if(this.equipo ==3)
            System.out.println(":v");////imprime de otro color
            
              //  Thread.sleep(1000);
            //} catch (InterruptedException ex) {
              //  Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
    }

}
