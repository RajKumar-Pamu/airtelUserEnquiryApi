package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ApiService;
import com.example.demo.service.CustomResponse;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/users/{msisdn}")
    public CustomResponse fetchData(@PathVariable String msisdn) {
        try {
            return apiService.fetchData(msisdn);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }
}
