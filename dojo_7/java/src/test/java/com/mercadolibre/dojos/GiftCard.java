package com.mercadolibre.dojos;

public class GiftCard extends AccountMoney implements PaymentMethod{

    public GiftCard(Money balance) {
        super(balance);
    }

    @Override
    public PaymentMethodType type() {
        return PaymentMethodType.GIFTCARD;
    }

    public String printContribution(Money leftToPayMoney) {
        return "GiftCard: " + this.contribution(leftToPayMoney).print();
    }

    @Override
    public int compareTo(PaymentMethod paymentMethod) {
        int comparator = 0;

        switch (paymentMethod.type()) {
            case ACCOUNT_MONEY:
                comparator = -1;
                break;
            case CARD:
                comparator = -1;
                break;
        }

        return comparator;
    }
}
