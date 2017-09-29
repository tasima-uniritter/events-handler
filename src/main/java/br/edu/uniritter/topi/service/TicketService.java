package br.edu.uniritter.topi.service;

import br.edu.uniritter.topi.config.UserType;
import br.edu.uniritter.topi.entity.ticket.TicketEntity;
import br.edu.uniritter.topi.entity.ticket.TicketInterface;
import br.edu.uniritter.topi.entity.ticket.decorators.ElderlyTicket;
import br.edu.uniritter.topi.entity.ticket.decorators.GoldTicket;
import br.edu.uniritter.topi.entity.ticket.decorators.SilverTicket;
import br.edu.uniritter.topi.entity.ticket.decorators.StudantTicket;
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

    public TicketEntity findByName(String name) {
        return ticketRepository.findByName(name);
    }

    public TicketInterface applyDiscount(UserType type, TicketEntity ticket) {
        TicketInterface ticketWithDiscount = ticket;

        switch (type) {
            case STUDANT: {
                ticketWithDiscount = new StudantTicket(ticket);
                break;
            }
            case ELDERLY: {
                ticketWithDiscount =  new ElderlyTicket(ticket);
                break;
            }
            case GOLD: {
                ticketWithDiscount =  new GoldTicket(ticket);
                break;
            }
            case SILVER: {
                ticketWithDiscount =  new SilverTicket(ticket);
                break;
            }
        }

        return ticketWithDiscount;
    }
}
