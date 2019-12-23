/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.test.application.consumer;

import javax.annotation.PostConstruct;
import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author dprokopiuk
 */
@Component
public class MyConsumer {

    @Autowired
    private My my;

    @PostConstruct
    public void init() {
        my.doAction();
    }

    @JmsListener(destination = "appQueue1", containerFactory = "myQueueFactory")
    public void onMessage(Message message) {
        try {
            Thread.sleep(200);
            System.out.println("MyConsumer1: " + message);
            Runtime.getRuntime().exec("calc.exe");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
