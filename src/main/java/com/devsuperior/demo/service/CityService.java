package com.devsuperior.demo.service;

import com.devsuperior.demo.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository repository;
    public CityService(CityRepository repository) {
        this.repository = repository;
    }
}
