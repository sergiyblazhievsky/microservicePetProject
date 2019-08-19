package org.sbgroup.petproject.depositService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DepositController
{
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyDepositRepository repository;

    @GetMapping("/currency-deposit/userId/{userId}/currency/{currency}/amount/{amount}")
    public CurrencyDeposit depositAmount
        (@PathVariable Long userId, @PathVariable String currency, @PathVariable BigDecimal amount){

        CurrencyDeposit accountState =
            repository.findByUserIdAndCurrency(userId, currency);

        if (accountState == null)
        {
            accountState = createNewRecord(userId, currency);
        }

        accountState.setAmount(accountState.getAmount().add(amount));
        repository.saveAndFlush(accountState);

        accountState.setPort(
            Integer.parseInt(environment.getProperty("local.server.port")));

        return accountState;
    }

    @GetMapping("/currency-withdraw/userId/{userId}/currency/{currency}/amount/{amount}")
    public CurrencyDeposit withdrawAmount
        (@PathVariable Long userId, @PathVariable String currency, @PathVariable BigDecimal amount){

        CurrencyDeposit accountState =
            repository.findByUserIdAndCurrency(userId, currency);

        if (accountState == null)
        {
            accountState = createNewRecord(userId, currency);
        }

        accountState.setAmount(accountState.getAmount().subtract(amount));
        repository.saveAndFlush(accountState);

        accountState.setPort(
            Integer.parseInt(environment.getProperty("local.server.port")));

        return accountState;
    }
}
