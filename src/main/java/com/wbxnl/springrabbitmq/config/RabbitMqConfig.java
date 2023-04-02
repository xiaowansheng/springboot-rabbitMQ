package com.wbxnl.springrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author wansheng
 * @createDate 2023/3/31 5:12
 */
@Configuration
public class RabbitMqConfig {
    @Autowired
    private Environment env;

    @Bean
    public ConnectionFactory connectionFactory() {
        System.out.println("创建connectionFactory");
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(env.getProperty("spring.rabbitmq.host"));
        connectionFactory.setPort(env.getProperty("spring.rabbitmq.port", Integer.class));
        connectionFactory.setUsername(env.getProperty("spring.rabbitmq.username"));
        connectionFactory.setPassword(env.getProperty("spring.rabbitmq.password"));
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        System.out.println("创建rabbitTemplate");
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        System.out.println("创建fanoutExchange");
        String exchangeName="fanoutExchange";
        return new FanoutExchange(exchangeName,true,false);
    }
    @Bean
    public DirectExchange directExchange(){
        System.out.println("创建directExchange");
        String exchangeName="directExchange";
        return new DirectExchange(exchangeName,true,false);
    }
    @Bean
    public TopicExchange topicExchange(){
        System.out.println("创建topicExchange");
        String exchangeName="topicExchange";
        return new TopicExchange(exchangeName,true,false);
    }
    @Bean
    public HeadersExchange headersExchange(){
        System.out.println("创建headersExchange");
        String exchangeName="headersExchange";
        return new HeadersExchange(exchangeName,true,false);
    }

    @Bean
    public Queue emailQueue() {
        System.out.println("创建emailQueue");
        String name="emailQueue";
        boolean durable=true;
        boolean exclusive=true;
        return new Queue(name,durable);
    }
    @Bean
    public Queue smsQueue() {
        System.out.println("smsQueue");
        String name="smsQueue";
        boolean durable=true;
        boolean exclusive=true;
        return new Queue(name,durable);
    }
    @Bean
    public Queue phoneQueue() {
        System.out.println("phoneQueue");
        String name="phoneQueue";
        boolean durable=true;
        boolean exclusive=true;
        return new Queue(name,durable);
    }

    @Bean
    public Binding emailBinding(){
        System.out.println("绑定emailBinding");
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding smsBinding(){
        System.out.println("绑定smsBinding");
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding phoneBinding(){
        System.out.println("绑定phoneBinding");
        return BindingBuilder.bind(phoneQueue()).to(fanoutExchange());
    }
}
