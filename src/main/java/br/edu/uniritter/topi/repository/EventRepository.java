package br.edu.uniritter.topi.repository;

import br.edu.uniritter.topi.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {

}
