package com.example.skenariolabs.service;


import com.example.skenariolabs.model.building.coordinates.dtaos.CoordinatesReadWrite;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Service
public class ExternalApiService {
    @Value("${geoapify.apikey}")
    private String apiKey;
    private final Duration REQUEST_TIMEOUT = Duration.ofSeconds(20);
    private final WebClient localApiClient;

    @Autowired
    public ExternalApiService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }
    // Method made to initiate first API call and reduce later delays
    public void firstApiCall() {
        try {
            localApiClient.get()
                    .uri("search?text=sas&apiKey=23f0a146cfcd4e2697662c57cbd85ff0")
                    .retrieve().bodyToMono(String.class).block(REQUEST_TIMEOUT);
        }
        catch (Exception e) {
            throw new IllegalCallerException("API failed to be called");
        }
    }

    public CoordinatesReadWrite getCoordinates(String address) {
        try {
            String strObject = localApiClient.get()
                    .uri(String.format("search?text=%s&lang=en&limit=5&apiKey=23f0a146cfcd4e2697662c57cbd85ff0", address))
                    .retrieve().bodyToMono(String.class).block(REQUEST_TIMEOUT);
            JSONObject parsedObject = new JSONObject(strObject);
            JSONObject properties = parsedObject.getJSONArray("features")
                    .getJSONObject(0).getJSONObject("properties");
            Double latitude = properties.getDouble("lat");
            Double longitude = properties.getDouble("lon");
            return new CoordinatesReadWrite(latitude, longitude);
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }






}
