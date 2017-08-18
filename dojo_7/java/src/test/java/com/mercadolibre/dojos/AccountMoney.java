package com.mercadolibre.dojos;

public class AccountMoney implements PaymentMethod {
    public Money balance;

    public AccountMoney(Money balance) {
        this.balance = balance;
    }

    public Money contribution(Money maxContribution) {
        return this.balance.tryWithdraw(maxContribution);
    }

    public Money withdraw(Money amount) {
        Money money = new Money(this.balance);

        this.balance.minus(amount);

        return money;
    }

    public String print() {
        return "Dinero en cuenta: " + this.balance.print();
    }

    public Money balance() {
        return balance;
    }

}
