package com.wbxnl.springrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wansheng
 * @createDate 2023/4/2 7:14
 */
@RabbitListener(queues = {"emailQueue"})
@Component
public class EmailConsumer {

    @RabbitHandler
    public void receiveStringMessage(String message){
        System.out.println("收到的邮件信息是："+message);
    }

    @RabbitHandler
    public void receiveByteMessage(byte[] message){
        System.out.println("收到的邮件信息是(byte)："+new String(message));
    }
}
