package com;

import com.config.AppConfig;
import com.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.producer.MessageReciever;

public class MessageConsumerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        try{
            Thread.sleep(6000000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

//        System.out.println("meessage sent successfully");
        ((AbstractApplicationContext) context).close();
    }
}
