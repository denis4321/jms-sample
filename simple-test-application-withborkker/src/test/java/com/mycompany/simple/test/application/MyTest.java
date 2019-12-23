/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.test.application;

import com.mycompany.simple.test.application.consumer.My;
import com.mycompany.simple.test.application.consumer.MyPerson;
import java.util.Enumeration;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author dprokopiuk
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
@ContextConfiguration(classes = {TestConfig.class})
public class MyTest {
    
    @Autowired
    private My myPerson;
    @Autowired
    private String urlConfig;
    
    @Test
    public void simpleTest(){
        //assert(1>2);
        assertNotNull(myPerson);
        assertTrue(myPerson.doAction()==3);
    }    
    
    
    @Test
    public void producerTest() throws Exception {          
        String queueName = "appQueue1";
        //String queueName = "appQueue1TEST";
        ConnectionFactory cf = new ActiveMQConnectionFactory(urlConfig);        
        Connection c = cf.createConnection();
        Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = new ActiveMQQueue(queueName);
        MessageProducer mp = session.createProducer(destination);
        Message msg = session.createTextMessage("Hello");
        int res = browse(queueName);
        System.out.println("@Before res="+res);
        Thread.sleep(3000);
        mp.send(msg);                        
        Thread.sleep(3000);
        int res2 = browse(queueName);
        System.out.println("@After res2="+res2);        
    }    
    
    private int browse(String queueName) throws JMSException {
        ConnectionFactory cf = new ActiveMQConnectionFactory(urlConfig);
        Connection c = cf.createConnection();
        c.start();
        Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = new ActiveMQQueue(queueName);
        QueueBrowser browser = session.createBrowser(destination);
        Enumeration en = browser.getEnumeration();
        int count = 0;
        while(en.hasMoreElements()){
            en.nextElement();
            count++;
        }
        return count;
    }
    
}
