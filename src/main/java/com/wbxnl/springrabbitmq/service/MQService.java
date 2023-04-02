package com.wbxnl.springrabbitmq.service;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wansheng
 * @createDate 2023/3/31 5:11
 */
@Service
public class MQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue emailQueue;
    @Autowired
    private FanoutExchange fanoutExchange;

    public void sendEmailMessage(String message) {
        System.out.println("发送消息："+message);
        String routeKey="";
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),routeKey, message);
    }
    public void sendSmsMessage(String message) {
        System.out.println("发送消息："+message);
        String routeKey="";
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),routeKey, message);
    }
    public void sendPhoneMessage(String message) {
        System.out.println("发送消息："+message);
        String routeKey="";
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),routeKey, message);
    }
    public void sendPhoneByteMessage(byte[] message) {
        System.out.println("发送消息："+message);
        String routeKey="";
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),routeKey, message);
    }
}

