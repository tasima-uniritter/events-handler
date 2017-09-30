package br.edu.uniritter.topi;

import br.edu.uniritter.topi.config.UserType;
import br.edu.uniritter.topi.dto.EventWithSalesPeriodsDTO;
import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import br.edu.uniritter.topi.service.EventService;
import br.edu.uniritter.topi.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EventTest {
    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    private static EventWithSalesPeriodsDTO eventWithSalesPeriods;

    @Test
    public void shouldSaveAnEvent() {
        EventEntity event = new EventEntity();
        event.setName("Test event");
        event.setDate(new GregorianCalendar(2017,10,1));

        List<SalesPeriodEntity> salesPeriods = new ArrayList<>();

        SalesPeriodEntity firstSalesPeriod = new SalesPeriodEntity();
        firstSalesPeriod.setTicket((long) 1);
        firstSalesPeriod.setStartsAt(new GregorianCalendar(2017,10,1));
        firstSalesPeriod.setEndsAt(new GregorianCalendar(2017,10,20));

        SalesPeriodEntity secondSalesPeriod = new SalesPeriodEntity();
        secondSalesPeriod.setTicket((long) 2);
        secondSalesPeriod.setStartsAt(new GregorianCalendar(2017,10,1));
        secondSalesPeriod.setEndsAt(new GregorianCalendar(2017,10,20));

        salesPeriods.add(secondSalesPeriod);

        eventWithSalesPeriods = new EventWithSalesPeriodsDTO();
        eventWithSalesPeriods.setEvent(event);
        eventWithSalesPeriods.setSalesPeriods(salesPeriods);

        EventWithSalesPeriodsDTO expected = eventService.save(eventWithSalesPeriods);
        assertThat(expected).isEqualTo(eventWithSalesPeriods);
        assertThat(eventService.all().size()).isEqualTo(1);
    }

    @Test
    public void shouldReturn1000WhenNormalUserGetVIPPrice() {
        assertThat(ticketService.findByName("VIP").getPrice()).isEqualTo(1000);
    }

    @Test
    public void shouldReturn500WheElderlyUserGetVIPPrice() {
        assertThat(ticketService.findByName("VIP", UserType.ELDERLY).getPrice()).isEqualTo(500);
    }

    @Test
    public void shouldReturn500WhenStudantUserGetVIPPrice() {
        assertThat(ticketService.findByName("VIP", UserType.STUDANT).getPrice()).isEqualTo(500);
    }

    @Test
    public void shouldReturn400WhenSilverUserGetVIPPrice() {
        assertThat(ticketService.findByName("VIP", UserType.SILVER).getPrice()).isEqualTo(400);
    }

    @Test
    public void shouldReturn250WhenGoldUserGetVIPPrice() {
        assertThat(ticketService.findByName("VIP", UserType.GOLD).getPrice()).isEqualTo(250);
    }

    @Test
    public void shouldReturn800WhenNormalUserGetBackstagePrice() {
        assertThat(ticketService.findByName("BACKSTAGE").getPrice()).isEqualTo(800);
    }

    @Test
    public void shouldReturn400WheElderlyUserGetBackstagePrice() {
        assertThat(ticketService.findByName("BACKSTAGE", UserType.ELDERLY).getPrice()).isEqualTo(400);
    }

    @Test
    public void shouldReturn400WheStudantUserGetBackstagePrice() {
        assertThat(ticketService.findByName("BACKSTAGE", UserType.STUDANT).getPrice()).isEqualTo(400);
    }

    @Test
    public void shouldReturn320WhenSilverUserGetBackstagePrice() {
        assertThat(ticketService.findByName("BACKSTAGE", UserType.SILVER).getPrice()).isEqualTo(320);
    }

    @Test
    public void shouldReturn250WhenGoldUserGetBackstagePrice() {
        assertThat(ticketService.findByName("VIP", UserType.GOLD).getPrice()).isEqualTo(250);
    }
}
