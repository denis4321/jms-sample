/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jms.sample;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author denys.prokopiuk
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "ExpiryQueue")
    ,@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "java:/jms/queue/DLQ")
})
public class MyMDB implements MessageListener {
    
    
    @Override
    public void onMessage(Message message) {
        System.out.println("Consume:Message!!!!!"+message);
    }
    
}
