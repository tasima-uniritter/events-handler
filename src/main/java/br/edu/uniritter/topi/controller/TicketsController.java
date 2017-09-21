package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.entity.ticket.TicketEntity;
import br.edu.uniritter.topi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    Iterable<TicketEntity> index() {
        return ticketService.all();
    }
}
