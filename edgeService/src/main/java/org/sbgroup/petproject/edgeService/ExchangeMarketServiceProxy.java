package org.sbgroup.petproject.edgeService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name="exchange-service", url="localhost:8100")
public interface ExchangeMarketServiceProxy
{
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency
        (@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity);
}