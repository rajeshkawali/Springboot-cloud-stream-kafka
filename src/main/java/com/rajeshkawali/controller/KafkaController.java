package com.rajeshkawali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajeshkawali.producer.KafkaProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class KafkaController {

	public static final String CLASS_NAME = KafkaController.class.getName();
	
	@Autowired
	private KafkaProducer kafkaProducer;

	@PostMapping("/publish")
	public ResponseEntity<String> publishMessage(@RequestBody String message) {
		String _function = ".publishMessage()";
		log.info(CLASS_NAME + _function + "::ENTER");
		try {
			kafkaProducer.kafkaMessagePublisher(message);
		} catch (Exception e) {
			log.error(CLASS_NAME + _function + "::Exception occurred while sending message to producer: " + e);
		}
		log.info(CLASS_NAME + _function + "::EXIT");
		return ResponseEntity.ok(message);
	}

}