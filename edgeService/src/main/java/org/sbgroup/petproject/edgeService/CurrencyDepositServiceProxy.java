package org.sbgroup.petproject.edgeService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name="deposit-service", url="localhost:8200")
public interface CurrencyDepositServiceProxy
{
    @GetMapping("/currency-withdraw/userId/{userId}/currency/{currency}/amount/{amount}")
    public CurrencyConversionBean withdrawValue
        (@PathVariable("userId") Long userId, @PathVariable("currency") String currency,
         @PathVariable("amount") BigDecimal amount);
}