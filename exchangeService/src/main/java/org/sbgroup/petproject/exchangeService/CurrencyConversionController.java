package org.sbgroup.petproject.exchangeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy ratesProxy;

    @Autowired
    private CurrencyDepositServiceProxy depositProxy;

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyConversionRepository repository;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}/multiply/{multiplier}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                                       @PathVariable BigDecimal quantity,
                                                       @PathVariable BigDecimal multiplier) {

        CurrencyConversionBean response = new CurrencyConversionBean(1l, from, to, multiplier, quantity,
                                   quantity.multiply(multiplier));

        repository.saveAndFlush(response);

        return response;
    }
}
