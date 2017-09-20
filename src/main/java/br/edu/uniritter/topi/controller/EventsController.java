package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.entity.Event;
import br.edu.uniritter.topi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/events")
@ResponseBody
public class EventsController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Event> index() {
        return eventRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    Event store(@Valid @RequestBody Event event) {
        return eventRepository.save(event);
    }
}