package org.sbgroup.petproject.depositService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyDepositRepository extends
                                           JpaRepository<CurrencyDeposit, Long>
{
    CurrencyDeposit findByUserIdAndCurrency(Long userId, String currency);
    CurrencyDeposit findFirst1ByOrderByIdDesc();
}
