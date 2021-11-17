package com.producer;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class MessageReciever {
    private static final String MESSAGE_QUEUE = "message_queue";

    @JmsListener(destination = MESSAGE_QUEUE)
    public void receiveMessage(final org.springframework.messaging.Message<Product> message) throws JMSException{
        MessageHeaders headers = message.getHeaders();
        System.out.println("headers : " + headers);

        Product product = message.getPayload();
        System.out.println("Product : " + product);
    }


    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Product product){
        jmsTemplate.send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(product);
                return objectMessage;
            }
        });
    }
}
