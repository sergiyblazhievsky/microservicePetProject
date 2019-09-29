package org.sbgroup.petproject.edgeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class EdgeController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy ratesProxy;

    @Autowired
    private CurrencyDepositServiceProxy depositProxy;

    @Autowired
    private ExchangeMarketServiceProxy exchangeProxy;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {

        CurrencyConversionBean conversionRequest = ratesProxy.retrieveExchangeValue(from, to);

        logger.info("{}", conversionRequest);

        Long userId = 1l;

        CurrencyConversionBean currencyWithdraw = depositProxy.withdrawValue(userId, from, quantity.multiply(conversionRequest.getConversionMultiple()));

        CurrencyConversionBean response = exchangeProxy.convertCurrency(from, to, currencyWithdraw.getQuantity());

        return response;
    }
}
