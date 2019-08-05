package org.sbgroup.petproject.depositService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CurrencyDepositRepository extends
                                           JpaRepository<CurrencyDeposit, Long>
{
    CurrencyDeposit findByUserIdAndCurrency(Long userId, String currency);
}
