package br.edu.uniritter.topi.repository;

import br.edu.uniritter.topi.entity.salesPeriod.SalesPeriodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalesPeriodRepository extends CrudRepository<SalesPeriodEntity, Long> {
    List<SalesPeriodEntity> findByEvent(Long event);
}
