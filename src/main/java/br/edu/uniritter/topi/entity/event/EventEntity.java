package br.edu.uniritter.topi.entity.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(max = 150, message = "O nome permite no máximo 150 caracteres.")
    private String name;

    @NotNull(message = "A data não pode ser nula.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Future(message = "A data do evento deve ser igual ou maior que a de hoje.")
    private Calendar date;
}