//Jeremy Bayangos
//JPMC SHERPA MODULE 1 - 7.8.2020
package Sherpa.Module.Services;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    //Temporary sender for earlier testing purposes.
    private static final String TOPIC = "test_topic";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){

        this.kafkaTemplate.send(TOPIC,message);
    }
    //create a single configuration class and mod this class as configuration.

    @Bean
    public NewTopic createTopic(){

        return new NewTopic(TOPIC,3,(short) 1);
    }



}
