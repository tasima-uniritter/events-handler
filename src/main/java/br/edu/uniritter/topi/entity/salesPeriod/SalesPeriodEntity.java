package br.edu.uniritter.topi.entity.salesPeriod;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sales_periods")
public class SalesPeriodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O id do ticket não pode ser nulo.")
    private Long ticket;

    private Long event;

    @Column(name = "starts_at")
    @NotNull(message = "A data de início não pode ser nula.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Future(message = "A data do evento deve ser igual ou maior que a de hoje.")
    private Calendar startsAt;

    @AssertTrue(message = "A data de início não pode ser após ou igual a data de fim")
    private boolean isStartsAt() {
        if (startsAt == null || endsAt == null)
            return true;

        return startsAt.before(endsAt);
    }

    @Column(name = "ends_at")
    @NotNull(message = "A data de fim não pode ser nula.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Calendar endsAt;

    @AssertTrue(message = "A data de fim não pode ser anterior ou igual a data de início")
    private boolean isEndsAt() {
        if (endsAt == null || startsAt == null)
            return true;

        return endsAt.after(startsAt);
    }
}
