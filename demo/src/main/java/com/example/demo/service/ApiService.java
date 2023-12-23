package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiService {

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.country}")
    private String country;

    @Value("${api.currency}")
    private String currency;

    @Value("${api.authToken}")
    private String authToken;

	public CustomResponse fetchData(String msisdn) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Country", country);
        headers.set("X-Currency", currency);
        headers.set("Authorization", "Bearer " + authToken);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    String.class,
                    msisdn
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseBody = responseEntity.getBody();
                System.out.println(responseBody);

                // Parse the response as needed
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                String fullName = jsonNode.path("data").path("first_name").asText() + " " + jsonNode.path("data").path("last_name").asText();
                String registrationStatus = jsonNode.path("data").path("registration").path("status").asText();
                CustomResponse customResponse = new CustomResponse();
                customResponse.setFullName(fullName);
                customResponse.setRegistrationStatus(registrationStatus);
                return customResponse;
            } else {
                return new CustomResponse("Error: " + responseEntity.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            return new CustomResponse("Error: " + e.getStatusCode() + " - " + e.getStatusText());
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse("Error processing the response: " + e.getMessage());
        }
    }

}
