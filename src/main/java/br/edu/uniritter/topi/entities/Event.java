package br.edu.uniritter.topi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class Event {

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(max = 150, message = "O nome permite no máximo 150 caracteres.")
    private String name;

    @NotNull
    private Date date;

}