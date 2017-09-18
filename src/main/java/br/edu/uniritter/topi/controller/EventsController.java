package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/events")
public class EventsController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    String all() {
        return eventRepository.findAll().toString();
    }
}