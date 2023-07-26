package com.d19.demo.utils.validate;

import com.d19.demo.models.credit.CreditCard;

public class Validate {
    public static boolean validateCreditCard(CreditCard creditCard) {
        if (creditCard == null) {
            return false;
        }
        if (creditCard.getCardHolder().isEmpty() || creditCard.getCardNumber().isEmpty() || creditCard.getExpiredAt().isEmpty())
            return false;

        return true;
    }
}
