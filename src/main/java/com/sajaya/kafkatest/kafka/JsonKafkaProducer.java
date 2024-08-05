package com.sajaya.kafkatest.kafka;

import com.sajaya.kafkatest.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, Student> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Student data) {
        LOGGER.info(String.format("message sent : %s", data.toString()));
        Message<Student> message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "student")
                .build();
        kafkaTemplate.send(message);
    }
}
