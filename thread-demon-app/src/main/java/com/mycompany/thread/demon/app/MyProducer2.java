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
public class MyProducer2 extends Thread {
    
      @Override
    public void run() {
        try {
            System.out.println("-------Producer started----------");
            Thread t1 = new MySubThread();
            t1.setDaemon(false);
            t1.start();
            Thread.sleep(10000);
            System.out.println("-------Producer ended----------");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
