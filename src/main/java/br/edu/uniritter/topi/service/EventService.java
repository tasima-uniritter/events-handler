package br.edu.uniritter.topi.service;

import br.edu.uniritter.topi.dto.EventWithSalesPeriodsDTO;
import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import br.edu.uniritter.topi.repository.EventRepository;
import br.edu.uniritter.topi.repository.SalesPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SalesPeriodRepository salesPeriodRepository;

    public List<EventWithSalesPeriodsDTO> all() {
        List<EventEntity> events = (List<EventEntity>) eventRepository.findAll();

        return events.stream().map(event -> {
            List<SalesPeriodEntity> salesPeriods = salesPeriodRepository.findByEvent(event.getId());
            return new EventWithSalesPeriodsDTO(event, salesPeriods);
        }).collect(Collectors.toList());
    }

    public EventWithSalesPeriodsDTO save(EventWithSalesPeriodsDTO event) {
        EventEntity eventEntity = eventRepository.save(event.getEvent());

        event.getSalesPeriods().forEach(salesPeriodEntity -> {
            salesPeriodEntity.setEvent(eventEntity.getId());
            salesPeriodRepository.save(salesPeriodEntity);
        });

        return event;
    }
}
