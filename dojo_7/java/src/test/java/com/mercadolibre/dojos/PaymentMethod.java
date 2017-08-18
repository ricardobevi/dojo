package com.mercadolibre.dojos;

public interface PaymentMethod {

    public Money contribution(Money maxContribution);
    public Money withdraw(Money amount);
    public String print();
}
