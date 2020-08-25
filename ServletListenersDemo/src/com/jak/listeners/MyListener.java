package com.jak.listeners;

import java.util.Date;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements HttpSessionListener, HttpSessionAttributeListener {


    public MyListener() {
        // TODO Auto-generated constructor stub
    }


    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Hello from listener. A session created at "+new Date(se.getSession().getCreationTime()));
    	
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Hello from listener. Session destroyed at "+new Date(se.getSession().getCreationTime()));
    }


    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Hello from listener. Session attribute added with key "+se.getName()+" and value "+se.getValue());
    }


    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("Hello from listener. Session attribute removed "+se.getName()+" and value "+se.getValue());
    }

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("Hello from listener. Session attribute modified "+se.getName()+" and value "+se.getValue());
    }
	
}
