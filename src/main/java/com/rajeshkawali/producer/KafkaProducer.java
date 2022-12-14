
package com.rajeshkawali.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.rajeshkawali.config.PublisherChannel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@EnableBinding(value = {
		PublisherChannel.class
})
@Component
public class KafkaProducer {

	public static final String CLASS_NAME = KafkaProducer.class.getName();

	@Autowired
	private PublisherChannel publisherChannel;
	
    public void kafkaMessagePublisher(String data) throws Exception {
    	String _function = ".kafkaMessagePublisher()"; 
		log.info(CLASS_NAME + _function + "::ENTER");
		try {
			boolean status = publisherChannel.getPublisherChannel().send(message(data));
			log.info(CLASS_NAME + _function + "::Message published to kafka topic:is message published: {}", status);
		} catch (Exception e) {
			log.error(CLASS_NAME + _function + "::Exception occurred while publishing kafka message: " + e);
		}
		log.info(CLASS_NAME + _function + "::EXIT");
	}
    
    private <T> Message<T> message (T t) {
        return MessageBuilder.withPayload(t).build();
    }
}
