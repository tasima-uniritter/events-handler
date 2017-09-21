package br.edu.uniritter.topi.service;

import br.edu.uniritter.topi.entity.ticket.TicketEntity;
import br.edu.uniritter.topi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Iterable<TicketEntity> all() {
        return ticketRepository.findAll();
    }
}
