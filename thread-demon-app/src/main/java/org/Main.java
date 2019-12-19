/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //Future future = Executors.newSingleThreadExecutor().submit(new MyCallable());
        //Thread.sleep(2000);
        //future.get(5, TimeUnit.SECONDS);
        long t = 60_000;
        System.out.println("t="+t);
    }
    
}
