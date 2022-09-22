package com.rajeshkawali.service;
/**
 * @author Rajesh_Kawali
 *
 */
public interface KafkaService {

	public void processMessage(String stringData) throws Exception;

}