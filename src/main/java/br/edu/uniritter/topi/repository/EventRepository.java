package br.edu.uniritter.topi.repository;

import br.edu.uniritter.topi.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByName(String name);

}
