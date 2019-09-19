/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevos;

/**
 *  Claee para los numeros de pasos que usa el corredor
 * @author Tatiana Moreno, Andres Chila
 */
public class Random {
    /**
     * Clase estatica que realiza el calculo random
     * @return el numero randomico que son los pasos que corre el corredor
     */
    public static int random(){
      
        return (int) Math.floor(Math.random()*(4*1));
     
    }
}
