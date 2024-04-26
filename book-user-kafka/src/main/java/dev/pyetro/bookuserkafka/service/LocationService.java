package dev.pyetro.bookuserkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @KafkaListener(topics = "drive-location", groupId = "user-group")
    public void driverLocation(String location){
        System.out.println(location);
    }

}
