package com.mercadolibre.dojos;

public class AccountMoney implements PaymentMethod{
    public Money balance;

    public AccountMoney(Money balance) {
        this.balance = balance;
    }

    public PaymentMethodType type() {
        return PaymentMethodType.ACCOUNT_MONEY;
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

    public String printContribution(Money leftToPayMoney) {
        return "Dinero en cuenta: " + this.contribution(leftToPayMoney).print();
    }


    public int compareTo(PaymentMethod paymentMethod) {
        int comparator = 0;

        switch (paymentMethod.type()) {
            case GIFTCARD:
                comparator = 1;
                break;
            case CARD:
                comparator = -1;
                break;
        }

        return comparator;
    }
}
