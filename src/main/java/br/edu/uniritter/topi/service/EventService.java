package br.edu.uniritter.topi.service;

import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<EventEntity> all() {
        return eventRepository.findAll();
    }

    public EventEntity save(EventEntity event) {
        return eventRepository.save(event);
    }
}
