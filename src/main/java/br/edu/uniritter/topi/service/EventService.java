package br.edu.uniritter.topi.service;

import br.edu.uniritter.topi.dto.EventWithSalesPeriodsDTO;
import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import br.edu.uniritter.topi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Iterable<EventEntity> all() {
        return eventRepository.findAll();
    }

    public EventWithSalesPeriodsDTO save(EventWithSalesPeriodsDTO event) {
        EventEntity eventEntity = event.getEvent();
        List<SalesPeriodEntity> salesPeriods = event.getSalesPeriods();

        return event;
    }
}
