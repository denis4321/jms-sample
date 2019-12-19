/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thread.demon.app;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DProkopiuk
 */
public class MyProducer extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("-------Producer started----------");
            Thread t1 = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("DoSomething; "+isDaemon()+"; "+getPriority());
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            t1.setDaemon(false);
            t1.start();
            Thread.sleep(10000);
            System.out.println("-------Producer ended----------");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
