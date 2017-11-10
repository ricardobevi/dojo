package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class OnlyPuis extends Inconsistency {
    public OnlyPuis(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);
    }

    public Inconsistency happens() {
        if ( getCheckoutOptions().isPickupInStoreOnly() ) {
            return this;
        }

        return new NoneInconsitencia( getCheckoutOptions() );
    }

    public int getNumber() {
        return IInconsistency.ONLY_PUIS;
    }

}
