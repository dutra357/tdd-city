package com.devsuperior.demo.service;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repository.CityRepository;
import com.devsuperior.demo.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository repository;
    private final CityRepository cityRepository;
    public EventService(EventRepository repository, CityRepository cityRepository) {
        this.repository = repository;
        this.cityRepository = cityRepository;
    }

    public Page<EventDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(EventDTO::new);
    }

    public EventDTO insert(EventDTO eventDTO) {
        Event event = new Event();

        event.setName(eventDTO.getName());
        event.setUrl(eventDTO.getUrl());
        event.setDate(eventDTO.getDate());
        event.setCity(cityRepository.getReferenceById(eventDTO.getCityId()));

        return new EventDTO(repository.save(event));
    }
}
