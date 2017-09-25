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

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SalesPeriodRepository salesPeriodRepository;

    public List<EventWithSalesPeriodsDTO> all() {
        Iterable<EventEntity> events = eventRepository.findAll();
        ArrayList<EventWithSalesPeriodsDTO> eventsWithSalesPeriods = new ArrayList<EventWithSalesPeriodsDTO>();

        events.forEach(event -> {
            List<SalesPeriodEntity> salesPeriods = salesPeriodRepository.findByEvent(event.getId());
            EventWithSalesPeriodsDTO eventWithSalesPeriods = new EventWithSalesPeriodsDTO(event, salesPeriods);
            eventsWithSalesPeriods.add(eventWithSalesPeriods);
        });

        return eventsWithSalesPeriods;
    }

    public EventWithSalesPeriodsDTO save(EventWithSalesPeriodsDTO event) {
        EventEntity eventEntity;
        eventEntity = eventRepository.save(event.getEvent());

        List<SalesPeriodEntity> salesPeriods = event.getSalesPeriods();

        salesPeriods.forEach(salesPeriodEntity -> {
            salesPeriodEntity.setEvent(eventEntity.getId());
            salesPeriodRepository.save(salesPeriodEntity);
        });

        return event;
    }
}
