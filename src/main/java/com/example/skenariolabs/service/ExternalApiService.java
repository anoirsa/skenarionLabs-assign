package com.example.skenariolabs.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {
    @Value("${geoapify.apikey}")
    private String apiKey;





}
