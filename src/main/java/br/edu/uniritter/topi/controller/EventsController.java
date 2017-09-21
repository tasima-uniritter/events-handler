package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.dto.EventWithSalesPeriodsDTO;
import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventService eventService;

    @GetMapping
    Iterable<EventEntity> index() {
        return eventService.all();
    }

    @PostMapping
    EventWithSalesPeriodsDTO store(@Valid @RequestBody EventWithSalesPeriodsDTO eventWithSalesPeriods) {
        return eventService.save(eventWithSalesPeriods);
    }
}