package br.edu.uniritter.topi.repository;

import br.edu.uniritter.topi.entity.ticket.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

}
