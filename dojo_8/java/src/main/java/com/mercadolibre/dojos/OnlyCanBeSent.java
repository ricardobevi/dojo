package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class OnlyCanBeSent extends Inconsistency {

    private CheckoutOptions checkoutOptions;

    public OnlyCanBeSent(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);
    }

    public Inconsistency challenge(Inconsistency otherInconsistency) {
        return this;
    }

    public Inconsistency happens() {
        if ( checkoutOptions.itemCanOnlyBeSent() )
            return this;

        return new NoneInconsitencia(checkoutOptions);
    }

    public int getNumber() {
        return IInconsistency.ONLY_CAN_BE_SENT;
    }
}
