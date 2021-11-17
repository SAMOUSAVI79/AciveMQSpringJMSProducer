package com;

import com.config.AppConfig;
import com.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.producer.MessageSender;

public class MessageProducerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);
        Product product = new Product();
        product.setProductId(4);
        product.setName("ghazal");
        product.setQuantity(60000);

messageSender.sendMessage(product);


        System.out.println("meessage sent successfully ==>" + product.toString());
        ((AbstractApplicationContext) context).close();
    }
}
