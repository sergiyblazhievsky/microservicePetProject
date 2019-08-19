package org.sbgroup.petproject.exchangeService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository
    extends JpaRepository<CurrencyConversionBean, Long>
{
    CurrencyConversionBean findByFromAndTo(String from, String to);
}
