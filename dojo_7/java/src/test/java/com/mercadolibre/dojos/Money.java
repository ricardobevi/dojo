package com.mercadolibre.dojos;

public class Money {
    Double value;

    public Money(Double value) {
        this.value = value;
    }

    public Money(Money money) {
        this.value = money.value;
    }

    public Money minus(Money money) {
        this.value = this.value - money.value;
        return this;
    }

    public boolean eq(Money money) {
        return this.value.equals(money.value);
    }

    public void add(Money contribution) {
        this.value = this.value + contribution.value;
    }

    public String print() {
        return "$" + this.value.toString();
    }

    public Money tryWithdraw(Money maxContribution) {
        Double tryWithdrawValue;
        Double maxContributionValue = maxContribution.value;

        if ( this.value / maxContributionValue >= 1){
            tryWithdrawValue = maxContributionValue;
        } else {
            tryWithdrawValue = this.value;
        }

        return new Money(tryWithdrawValue);
    }

    public boolean zero(){
        return this.value.equals(0.0);
    }
}
