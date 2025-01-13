package com.devsuperior.demo.service;

import com.devsuperior.demo.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository repository;
    public EventService(EventRepository repository) {
        this.repository = repository;
    }
}
