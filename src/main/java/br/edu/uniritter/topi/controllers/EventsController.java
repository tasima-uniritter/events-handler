package br.edu.uniritter.topi.controllers;

import org.springframework.web.bind.annotation.*;

@RestController("/events")
public class EventsController {

    @RequestMapping(method = RequestMethod.GET)
    String all() {
        return "Events";
    }

//    @GetMapping(value="/{nome}")
//    public ResponseEntity<Event> getEventsByName(@RequestParam("name") String name) {
//        Event event = new Event();
//        event.setName(name);
//        event.setDate(new Date());
//        return new ResponseEntity<Event>(event, HttpStatus.OK);
//    }
}