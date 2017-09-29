package br.edu.uniritter.topi.entity.ticket.decorators;

import br.edu.uniritter.topi.entity.ticket.TicketInterface;

public class GoldTicket implements TicketInterface {
    private TicketInterface ticket;

    public GoldTicket(TicketInterface ticket) {
        this.ticket = ticket;
    }

    @Override
    public Double getPrice() {
        return ticket.getPrice() - (ticket.getPrice() * 0.75);
    }
}
