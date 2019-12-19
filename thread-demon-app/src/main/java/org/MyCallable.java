/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.util.concurrent.Callable;

/**
 *
 * @author DProkopiuk
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(20000);
        return "Result";
    }
    
}
