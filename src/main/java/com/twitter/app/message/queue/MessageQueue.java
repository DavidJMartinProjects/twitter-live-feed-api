package com.twitter.app.message.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david
 */
@Configuration
public class MessageQueue {

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

}
