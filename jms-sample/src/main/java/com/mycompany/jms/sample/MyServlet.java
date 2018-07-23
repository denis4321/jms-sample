/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jms.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denys.prokopiuk
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
    @Resource(name = "InVmConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "java:/jms/queue/DLQ")
    private Destination destination;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //make some logic
        System.out.println("Sender");
        sendLog("Test log");
    }
    
    
    private void sendLog(String text){
        try {
            Connection c = connectionFactory.createConnection();
            Session session = c.createSession();
            Message msg = session.createTextMessage(text);
            MessageProducer producer = session.createProducer(destination);
            producer.send(msg);
        } catch (JMSException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
