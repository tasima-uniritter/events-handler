package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.entity.EventEntity;
import br.edu.uniritter.topi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    Iterable<EventEntity> index() {
        return eventRepository.findAll();
    }

    @PostMapping
    EventEntity store(@Valid @RequestBody EventEntity event) {
        return eventRepository.save(event);
    }
}