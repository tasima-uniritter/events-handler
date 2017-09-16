package br.edu.uniritter.topi;

import br.edu.uniritter.topi.entities.Event;
import br.edu.uniritter.topi.exceptions.ValidateDateException;
import br.edu.uniritter.topi.exceptions.ValidateDateIsMandatoryException;
import br.edu.uniritter.topi.exceptions.ValidateNameHaveALimitCharactersException;
import br.edu.uniritter.topi.exceptions.ValidateNameIsMandatoryException;

import java.util.Date;

public class Validator {

    public static final int MAX_NAME_SIZE = 150;

    public void validateDateIsMandatory(Event event) throws ValidateDateIsMandatoryException {
        if (event.getDate() == null) {
            throw new ValidateDateIsMandatoryException();
        }
    }

    public void validateDateIsFuture(Event event) throws ValidateDateException {
        if (event.getDate().before(new Date())) {
            throw new ValidateDateException("A data do evento deve ser igual ou maior que a de hoje");
        }
    }

    public void validateNameIsMandatory(Event event) throws ValidateNameIsMandatoryException {
        if(event.getName() == null) {
            throw new ValidateNameIsMandatoryException();
        }
    }

    public void validateNameHaveALimitCharacters(Event event) throws ValidateNameHaveALimitCharactersException {
        if(event.getName().length() > MAX_NAME_SIZE) {
            throw new ValidateNameHaveALimitCharactersException("O nome permite no máximo 150 caracteres");
        }
    }
}
