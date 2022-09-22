
package com.rajeshkawali.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.rajeshkawali.config.ConsumerChannel;
import com.rajeshkawali.service.KafkaService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@EnableBinding(value = {
		ConsumerChannel.class
})
@Component
public class KafkaConsumer {

	public static final String CLASS_NAME = KafkaConsumer.class.getName();

	@Autowired
	private KafkaService kafkaService;

	@StreamListener(ConsumerChannel.CONSUME_MESSAGE)
    public void kafkaMessageListener(String message) throws Exception {
		String _function = ".kafkaMessageListener()"; 
		log.info(CLASS_NAME + _function + "::ENTER");
		try {
			log.info(CLASS_NAME + _function + "::message: {}", message);
			kafkaService.processMessage(message);
		} catch (Exception e) {
			log.error(CLASS_NAME + _function + "::Exception occurred while processing kafka message: " + e);
		}
		log.info(CLASS_NAME + _function + "::EXIT");
	}
}
