package br.edu.uniritter.topi;

import br.edu.uniritter.topi.dto.EventWithSalesPeriodsDTO;
import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import br.edu.uniritter.topi.service.EventService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.picocontainer.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = CucumberConfiguration.class)
public class EventStepDefs {
    @Autowired
    private EventService eventService;

    private static EventWithSalesPeriodsDTO eventWithSalesPeriods;

    @Given("^I want to create an event$")
    public void i_want_to_create_an_event() throws Exception {

    }

    @When("^I create an event$")
    public void i_create_an_event() throws Exception {
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
    }

    @Then("^the event was created$")
    public void the_event_was_created() throws Exception {
        EventWithSalesPeriodsDTO expected = eventService.save(eventWithSalesPeriods);
        assertThat(expected).isEqualTo(eventWithSalesPeriods);
        assertThat(eventService.all().size()).isEqualTo(1);
    }
}
