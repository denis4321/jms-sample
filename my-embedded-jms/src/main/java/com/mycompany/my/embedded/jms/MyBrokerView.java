/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.embedded.jms;

import java.util.Set;
import javax.management.openmbean.CompositeData;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.jmx.BrokerView;

/**
 *
 * @author DProkopiuk
 */
public class MyBrokerView {
    
    public static void main(String[] args) throws Exception {                
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616");
        broker.start();               
        System.out.println("After start!!!!!");              
        
        Thread.sleep(5000);
        BrokerView bw = broker.getAdminView();
        CompositeData[] array = bw.browseQueue("myQueue");
        CompositeData item = array[0]; 
        Set<String> keys = item.getCompositeType().keySet();
        for(String key: keys){
            System.out.println(key);
        }
        System.out.println("After start!!!!!");
    
    }
    
}
