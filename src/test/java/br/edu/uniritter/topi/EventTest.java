package br.edu.uniritter.topi;

import br.edu.uniritter.topi.entity.Event;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

@Ignore
public class EventTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldReturnAnErrorWhenNameIsNull() {
        Event event = new Event("", new Date());

        Set<ConstraintViolation<Event>> constraintViolations = validator.validate(event);

        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

}