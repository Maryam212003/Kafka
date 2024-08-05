package com.sajaya.kafkatest.controller;

import com.sajaya.kafkatest.kafka.JsonKafkaProducer;
import com.sajaya.kafkatest.payload.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka")
public class JsonKafkaController {
    JsonKafkaProducer jsonKafkaProducer;

    public JsonKafkaController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(Student student) {
        jsonKafkaProducer.sendMessage(student);
        return ResponseEntity.ok("message sent successfully");
    }
}
