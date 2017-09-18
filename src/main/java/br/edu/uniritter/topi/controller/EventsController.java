package br.edu.uniritter.topi.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/events")
public class EventsController {

    @RequestMapping(method = RequestMethod.GET)
    String all() {
        return "Events";
    }
}