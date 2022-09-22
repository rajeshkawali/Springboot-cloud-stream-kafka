package com.rajeshkawali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeshkawali.producer.KafkaProducer;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {

	public static final String CLASS_NAME = KafkaServiceImpl.class.getName();

	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public void processMessage(String message) throws Exception {
		String _function = ".processMessage()";
		log.info(CLASS_NAME + _function + "::ENTER");
		try {
			log.info(CLASS_NAME + _function + "::Message recevied: {}", message);
			kafkaProducer.kafkaMessagePublisher(message);
		} catch (Exception e) {
			log.error(CLASS_NAME + _function + "::Exception occurred while process a message: " + e);
		}
		log.info(CLASS_NAME + _function + "::EXIT");
	}

}
