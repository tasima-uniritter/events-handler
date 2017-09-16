package br.edu.uniritter.topi;

import br.edu.uniritter.topi.entities.Event;
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
        Event event = new Event("", null);
        validator.validateDateIsMandatory(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenDateIsNotNull() throws ValidateDateIsMandatoryException, ParseException {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        Event event = new Event(null, dt);
        validator.validateDateIsMandatory(event);
    }

    @Test(expected = ValidateDateException.class)
    public void shouldThrowExceptionWhenDateIsPast() throws ValidateDateException {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        dt = c.getTime();
        Event event = new Event(null, dt);
        validator.validateDateIsFuture(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenDateIsFuture() throws ValidateDateException {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, +1);
        dt = c.getTime();
        Event event = new Event(null, dt);
        validator.validateDateIsFuture(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenDateIsToday() throws ValidateDateException {
        Event event = new Event(null, new Date());
        validator.validateDateIsFuture(event);
    }

    @Test(expected = ValidateNameIsMandatoryException.class)
    public void shouldThrowExceptionWhenNameIsNull() throws ValidateNameIsMandatoryException {
        Event event = new Event(null, null);
        validator.validateNameIsMandatory(event);
    }

    @Test(expected = ValidateNameHaveALimitCharactersException.class)
    public void shouldThrowExceptionWhenNameHasMoreThan150Chars() throws ValidateNameHaveALimitCharactersException {
        Event event = new Event("Name very long that i have not idea how long it is and Name very long that i have not idea how" +
                " long it is and Name very long that i have not idea how l", null);
        validator.validateNameHaveALimitCharacters(event);
    }

    @Test
    public void shouldNotThrowExceptionWhenNameHasLessThan151Chars() throws ValidateNameHaveALimitCharactersException {
        Event event = new Event("Name very long that i have not idea how long it is and Name very long that i have not idea how" +
                " long it is and Name very long that i have not idea how ", null);
        validator.validateNameHaveALimitCharacters(event);
    }

}