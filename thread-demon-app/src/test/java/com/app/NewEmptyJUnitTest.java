package com.app;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DProkopiuk
 */
public class NewEmptyJUnitTest {
    
     @Test
     public void hello() throws InterruptedException {     
            Thread t = new Thread(()->{
                
                while(true){
                    
                }
                
            });
            t.setDaemon(false);
            t.start();
            Thread.sleep(5000);
     }
}
