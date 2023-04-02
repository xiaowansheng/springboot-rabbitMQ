package com.wbxnl.springrabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wansheng
 * @createDate 2023/4/2 8:12
 */
@Component
@RabbitListener(queues = {"smsQueue"})
public class SmsConsumer implements MessageListener {


    @Override
    public void onMessage(Message message) {
        System.out.println("收到的短信信息："+new String(message.getBody()));
    }

}
