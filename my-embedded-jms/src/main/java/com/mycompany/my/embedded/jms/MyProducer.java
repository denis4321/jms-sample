/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.embedded.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 *
 * @author DProkopiuk
 */
public class MyProducer {
    
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection c = cf.createConnection();
        Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Message msg = session.createTextMessage("test msg");
        Destination destination = new ActiveMQQueue("myQueue");
        MessageProducer mp = session.createProducer(destination);
        mp.send(msg);
        c.close();
        System.out.println("---------Producer finish----------");        
    }
    
}
