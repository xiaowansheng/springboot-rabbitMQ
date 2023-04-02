package com.wbxnl.springrabbitmq;

import com.wbxnl.springrabbitmq.service.MQService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRabbitMqApplicationTests {

    @Autowired
    MQService mqService;
    @Test
    void test01() {
        String message="邮件";
        mqService.sendEmailMessage(message);
    }
    @Test
    void test02() {
        String message="短信";
        mqService.sendSmsMessage(message);
    }

    @Test
    void test03() {
        String message="手机";
        mqService.sendPhoneByteMessage(message.getBytes());
    }
}
