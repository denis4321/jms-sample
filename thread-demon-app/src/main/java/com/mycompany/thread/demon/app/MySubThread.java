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
public class MySubThread extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("DoSomething; " + isDaemon() + "; " + getPriority());
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
