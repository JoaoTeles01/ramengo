package com.api.ramengo.service;

import jakarta.annotation.PostConstruct;

import java.util.UUID;

public class ApiKeyService {
    private String apiKey;

    @PostConstruct
    public void init(){
        this.apiKey = UUID.randomUUID().toString();
    }

    public String getApiKey(){
        return apiKey;
    }

    public String getApiUrl(){
        return "/api/";
    }
}
