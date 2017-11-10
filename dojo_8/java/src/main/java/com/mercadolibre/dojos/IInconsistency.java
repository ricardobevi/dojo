package com.mercadolibre.dojos;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
     * Defines the possible actions that the user can take in the screen
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IInconsistency {
        /**
         * Indicates that there is no inconsistency in the shipping options
         */
        int NONE = 0;

        /**
         * Indicates that we can't send the amount of units selected by the user
         */
        int CANT_SENT_X_UNITS = 1;

        /**
         * Indicates that the product can only be sent (no local pickup option) - update: it can
         * only be sent means that the item has custom shipping (no mercadoenvios)
         */
        int ONLY_CAN_BE_SENT = 2;

        /**
         * Indicates that the shipping can only be agreed.
         */
        int ONLY_TO_AGREE = 3;

        /**
         * Indicates that both the payment and the shipping can only be agreed.
         */
        int AGREE_AGREE = 4;

        /**
         * Indicates that the shipping can only be pickup in store.
         */
        int ONLY_PUIS = 5;
    }