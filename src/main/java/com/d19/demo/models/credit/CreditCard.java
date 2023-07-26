package com.d19.demo.models.credit;

import lombok.Data;

@Data
public class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private String expiredAt;
}
