package br.edu.uniritter.topi;

import br.edu.uniritter.topi.exceptions.ValidateDateException;
import br.edu.uniritter.topi.exceptions.ValidateDateIsMandatoryException;
import br.edu.uniritter.topi.exceptions.ValidateNameHaveALimitCharactersException;
import br.edu.uniritter.topi.exceptions.ValidateNameIsMandatoryException;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ValidatorTest {

    private Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = new Validator();
    }

    @Test(expected = ValidateDateIsMandatoryException.class)
    public void shouldThrowExceptionWhenDateIsNull() throws ValidateDateIsMandatoryException {
        Event event = new Event();
        validator.validateDateIsMandatory(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenDateIsNotNull() throws ValidateDateIsMandatoryException, ParseException {
        Event event = new Event();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        event.setDate(dt);
        validator.validateDateIsMandatory(event);
    }

    @Test(expected = ValidateDateException.class)
    public void shouldThrowExceptionWhenDateIsPast() throws ValidateDateException {
        Event event = new Event();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        dt = c.getTime();
        event.setDate(dt);
        validator.validateDateIsFuture(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenDateIsFuture() throws ValidateDateException {
        Event event = new Event();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, +1);
        dt = c.getTime();
        event.setDate(dt);
        validator.validateDateIsFuture(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenDateIsToday() throws ValidateDateException {
        Event event = new Event();
        event.setDate(new Date());
        validator.validateDateIsFuture(event);
    }

    @Test(expected = ValidateNameIsMandatoryException.class)
    public void shouldThrowExceptionWhenNameIsNull() throws ValidateNameIsMandatoryException {
        Event event = new Event();
        validator.validateNameIsMandatory(event);
    }

    @Test(expected = ValidateNameHaveALimitCharactersException.class)
    public void shouldThrowExceptionWhenNameHasMoreThan150Chars() throws ValidateNameHaveALimitCharactersException {
        Event event = new Event();
        event.setName("Name very long that i have not idea how long it is and Name very long that i have not idea how" +
                " long it is and Name very long that i have not idea how l");
        validator.validateNameHaveALimitCharacters(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenNameHasLessThan151Chars() throws ValidateNameHaveALimitCharactersException {
        Event event = new Event();
        event.setName("Name very long that i have not idea how long it is and Name very long that i have not idea how" +
                " long it is and Name very long that i have not idea how ");
        validator.validateNameHaveALimitCharacters(event);
    }

}