package org.sbgroup.petproject.depositService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CurrencyDeposit
{
    @Id
    private Long id;

    @Column(name="userId")
    private Long userId;

    @Column(name="currency")
    private String currency;

    @Column(name="amount")
    private BigDecimal amount;
    private int        port;

    public CurrencyDeposit()
    {
    }

    public CurrencyDeposit(Long id, Long userId, String currency, BigDecimal amount)
    {
        this.id = id;
        this.userId = userId;
        this.currency = currency;
        this.amount = amount;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }
}
