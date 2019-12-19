/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.embedded.jms;

import java.util.Enumeration;
import javax.jms.Connection;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 *
 * @author DProkopiuk
 */
public class MyQueueBrowser {
    
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection c = cf.createConnection();
        c.start();
        Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = new ActiveMQQueue("myQueue");
        QueueBrowser queueBrowser = session.createBrowser(queue);
        Enumeration enumeration = queueBrowser.getEnumeration();
        int count=0;
        while(enumeration.hasMoreElements()){
            enumeration.nextElement();
            count++;
        }        
        c.stop();
        c.close();
        System.out.println("count="+count);
    }
    
}
