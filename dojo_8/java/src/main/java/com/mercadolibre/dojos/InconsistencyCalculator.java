package com.mercadolibre.dojos;


import com.mercadolibre.dojos.dto.*;
import com.mercadolibre.dojos.util.PaymentMethodType;
import com.mercadolibre.dojos.util.ShippingMethodType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Helper class that calculates the next step for the fallback shipping selection.
 * Created by jpperetti on 6/6/16.
 */
public final class InconsistencyCalculator {

    /**
     * Calculates the inconsistency (in case that there is one) related to the shipping
     * options and the quantity selected by the user.
     *
     * @param checkoutContext - the CheckoutContext that contains the base data to make the calculations.
     * @return an IInconsistency value that indicates the current case.
     */
    @IInconsistency
    public static int getInconsistencyValue(CheckoutContext checkoutContext) {
        CheckoutOptionsDto checkoutOptions = checkoutContext.getCheckoutOptionsDto();
        NoneInconsitencia none = new NoneInconsitencia( new CheckoutOptions(checkoutOptions));
        Inconsistency inconsistency = none;
        

        Inconsistency inconsistencies[] = {
                new OnlyCanBeSent( new CheckoutOptions(checkoutOptions)),
                new CantSentXunits(new CheckoutOptions(checkoutOptions)),
                new AgreeAgree( new CheckoutOptions(checkoutOptions)),
                new OnlyToAgree( new CheckoutOptions(checkoutOptions)),
                new OnlyPuis( new CheckoutOptions(checkoutOptions))
        };

        for( Inconsistency i : inconsistencies) {
            if ( !i.happens().equals( none ) ) {
                inconsistency = i;
                break;
            }
        };

        return inconsistency.getNumber();

    }


}

