package br.edu.uniritter.topi.entity.ticket.decorators;

import br.edu.uniritter.topi.entity.ticket.TicketInterface;

public class SilverTicket implements TicketInterface {
    private TicketInterface ticket;

    public SilverTicket(TicketInterface ticket) {
        this.ticket = ticket;
    }

    @Override
    public Double getPrice() {
        return ticket.getPrice() * 0.6;
    }
}
