package com.example.testserviceA.service;

import com.example.testserviceA.bean.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class RemoteCallService {

    public List<Product> getRemoteProducts(String host, String port) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("http://"+host+":"+port+"/products")).GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = Arrays.asList(objectMapper.readValue(response.body(), Product[].class));

        System.out.println(response.body());

        return products;
    }

}

