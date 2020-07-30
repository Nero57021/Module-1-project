//Jeremy Bayangos
//JPMC SHERPA MODULE 1 - 7.8.2020
package Sherpa.Module.Services;
import java.io.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

import static java.lang.Integer.parseInt;

@Service
public class Consumer {

    public String parser(String message){ //Receives message and processes whether it violated any rules or not.
        String[] store = message.split(",");
        String response = store[0];
        boolean alert = false;

        if (message.isEmpty())
        {
            return "Message should not be empty";
        }
        if(store.length<4){
            return "Message should be complete in format of: (SERVER_ID, CPU_UTILIZATION, MEMORY_UTILIZATION, DISK_UTILIZATION)";
        }
        if(parseInt(store[1]) > 80){
            response += ", CPU_UTILIZATION";
            alert = true;
        }
        if(parseInt(store[2]) > 75)
        {
            response += ", MEMORY_UTILIZATION";
            alert = true;
        }
        if(parseInt(store[3]) > 60)
        {
            response += ", DISK_UTILIZATION";
            alert = true;
        }
        if(alert == true) {
            System.out.print("(Alert: ");
            return "(" + response + ")";
        }

        return "(No alert," + response + ")";
    } //Make this configurable -
    @KafkaListener(topics = "test_topic",groupId = "group_id")
    public void consumeMessage(String message){


        System.out.println("Message recieved: " + message);
        System.out.println("-------------------------------");
        System.out.println(parser(message));
        System.out.println();
    }


}

