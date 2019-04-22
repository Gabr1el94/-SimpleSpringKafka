package com.gabrieldev.endpoint;

import com.gabrieldev.classes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabrieldev
 */
@RestController
public class StudentEndPoint {
       
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    private static final String TOPIC = "Kafka_Spring";
    
    @RequestMapping("/")
    public String home(){    
        return "Hello World";
    }
    
   @RequestMapping(method = RequestMethod.GET, path="/test/{message}")
   public String testKafka(@PathVariable("message") final String msg){
       Object msgObject = msg.toString();
       kafkaTemplate.send(TOPIC, msgObject);
       
        return "Text Published with successfully";
   }
    
    
   @RequestMapping(method = RequestMethod.GET, path="/{name}")
   public String producerKafka(@PathVariable("name") final String name){
       //Instance Class 
        Student s = new Student();
        s.setId(1);
        s.setNome("Gabriel Soares");
        Object objClass= s.toString();
        kafkaTemplate.send(TOPIC, objClass);
       
        return "Producer Published with successfully";
   }
   
//    @KafkaListener(groupId = "group_json" ,topics = "Kafka_Example_JSON",containerFactory="consumerFactory")
//    public void consumeJson(Student student){
//      System.out.println("Consumed JSON Message: " + student);
//    }
}
