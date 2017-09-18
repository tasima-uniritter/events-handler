package br.edu.uniritter.topi.repository;

import br.edu.uniritter.topi.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
