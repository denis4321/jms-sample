/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.test.application;

import com.mycompany.simple.test.application.consumer.My;
import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author dprokopiuk
 */
@SpringBootApplication
public class TestConfig {

    @Bean
    public My person() {
        return new MyTestPerson();
    }
    
    @Bean
    public String urlConfig(){
        return "tcp://127.0.0.1:61616";        
    }
    
    @Bean
    public BrokerService broker() throws Exception {
        BrokerService brokerService = new BrokerService();        
        brokerService.addConnector(urlConfig());
        brokerService.start();
        return brokerService;
    }
    
    @Bean(name = "myDefaultConnectionFactory")
    public ConnectionFactory getConnectionFactory(){
        System.out.println("@Test config!!!");
        return new ActiveMQConnectionFactory(urlConfig());
    }

    
}
