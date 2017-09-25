package br.edu.uniritter.topi.dto;

import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventWithSalesPeriodsDTO {
    @NotNull(message = "O evento não pode ser nulo.")
    @Valid
    private EventEntity event;

    @NotNull(message = "A lista de periodo de vendas não pode ser nula.")
    @Valid
    @Size(min = 1, message = "Deve conter pelo menos 1 periodo de vendas.")
    private List<SalesPeriodEntity> salesPeriods;
}
