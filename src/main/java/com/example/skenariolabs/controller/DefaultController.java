package com.example.skenariolabs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController("/")
public class DefaultController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity defaultRoute() {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "SkenarioLabsAPI running." +
                        " For Documentation go to http://{host}:{port}/swagger-ui/index.html"));
    }

}
