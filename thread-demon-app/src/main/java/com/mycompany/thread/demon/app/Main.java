/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thread.demon.app;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Thread myProducer = new MyProducer2();
        myProducer.setPriority(8);
        myProducer.setDaemon(true);
        myProducer.start();
        Thread.sleep(15000);
    }
    
}
