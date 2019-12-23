/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.test.application;

import com.mycompany.simple.test.application.consumer.My;

/**
 *
 * @author dprokopiuk
 */
public class MyTestPerson implements My {

    @Override
    public int doAction() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!MyPerson test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return 3;
    }
    
}
