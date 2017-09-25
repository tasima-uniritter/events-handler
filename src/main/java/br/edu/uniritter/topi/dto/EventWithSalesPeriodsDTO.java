package br.edu.uniritter.topi.dto;

import br.edu.uniritter.topi.entity.event.EventEntity;
import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class EventWithSalesPeriodsDTO {
    @NotNull
    @Valid
    private EventEntity event;

    @NotNull
    @Valid
    @Size(min = 1, message = "Deve conter pelo menos 1 periodo de vendas")
    private List<SalesPeriodEntity> salesPeriods;
}
