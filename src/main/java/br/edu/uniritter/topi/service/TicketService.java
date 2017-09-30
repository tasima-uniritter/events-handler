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

    public TicketInterface findByName(String name) {
        return ticketRepository.findByName(name);
    }

    public TicketInterface findByName(String name, UserType userType) {
        TicketInterface ticketWithDiscount = this.findByName(name);

        switch (userType) {
            case STUDANT: {
                ticketWithDiscount = new StudantTicket(ticketWithDiscount);
                break;
            }
            case ELDERLY: {
                ticketWithDiscount =  new ElderlyTicket(ticketWithDiscount);
                break;
            }
            case GOLD: {
                ticketWithDiscount =  new GoldTicket(ticketWithDiscount);
                break;
            }
            case SILVER: {
                ticketWithDiscount =  new SilverTicket(ticketWithDiscount);
                break;
            }
        }

        return ticketWithDiscount;
    }
}
