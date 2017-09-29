package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.config.UserType;
import br.edu.uniritter.topi.entity.ticket.TicketEntity;
import br.edu.uniritter.topi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    Iterable<TicketEntity> index() {
        return ticketService.all();
    }

    @GetMapping(value = "/{name}/price/{userType}")
    Double priceWithDiscounts(@PathVariable("name") String name, @PathVariable("userType") String userType) {
        return ticketService.findByName(name, UserType.valueOf(userType.toUpperCase())).getPrice();
    }

    @GetMapping(value = "{name}/price")
    Double price(@PathVariable("name") String name) {
        return ticketService.findByName(name).getPrice();
    }
}
