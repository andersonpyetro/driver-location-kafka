package dev.pyetro.controller;

import dev.pyetro.service.DriverLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/location")
public class DriverLocationController {

    @Autowired
    private DriverLocationService driverLocationService;

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {

        /**
         * quando o método receber a request, ele vai mostrando a localização
         * randomicamente até chegar a distância do driver para o passageiro
         * ser zero.
         */
        int range = 100;
        while (range > 0) {
            driverLocationService.updateLocation(Math.random() + " , " + Math.random());
            Thread.sleep(1000);
            range --;
        }

        return new ResponseEntity<>(Map.of("message", "Location Updated"),
                HttpStatus.OK);
    }
}
