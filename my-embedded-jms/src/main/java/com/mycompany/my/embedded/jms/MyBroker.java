/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.embedded.jms;

import javax.management.openmbean.CompositeData;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.jmx.BrokerView;

/**
 *
 * @author DProkopiuk
 */
public class MyBroker {

    public static void main(String[] args) throws Exception {                
        BrokerService broker = new BrokerService();
        // configure the broker
        //broker.setBrokerName("fred");
        broker.addConnector("tcp://localhost:61616");
        broker.start();               
        System.out.println("After start!!!!!");        
    }

}
