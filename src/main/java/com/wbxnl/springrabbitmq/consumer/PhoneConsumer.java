package com.wbxnl.springrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wansheng
 * @createDate 2023/4/2 8:17
 */
@Component
public class PhoneConsumer {

    @RabbitListener(queues = "phoneQueue")
    public void receiveStringMessage(String message){
        System.out.println("接收到的电话信息："+message);
    }

}
