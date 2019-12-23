/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.test.application.consumer;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author dprokopiuk
 */
public class MyPerson implements My {
    
    @PostConstruct
    public void init(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!MyPerson!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        doAction();
    }
   
    @Override
    public int doAction(){
        System.out.println("DoAction");
        return 1;
    }
    
}
