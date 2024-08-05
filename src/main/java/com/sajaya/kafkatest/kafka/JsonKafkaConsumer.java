package com.sajaya.kafkatest.kafka;

import com.sajaya.kafkatest.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(topics = "student", groupId = "my-group")
    public void consume(Student student) {
        LOGGER.info(String.format("message recieved: %s", student.toString()));
    }
}
