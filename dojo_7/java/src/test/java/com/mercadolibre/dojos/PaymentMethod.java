package com.mercadolibre.dojos;

public interface PaymentMethod extends Comparable<PaymentMethod>{

    public PaymentMethodType type();

    public Money contribution(Money maxContribution);
    public Money withdraw(Money amount);
    public String print();

    String printContribution(Money leftToPayMoney);

}
