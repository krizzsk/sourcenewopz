package com.didi.payment.creditcard.global.model;

import java.io.Serializable;

public class CancelCardParam implements Serializable {
    public String cardIndex;
    public String cardNo;
    public int expired;
    public String expiryDate;
    public String resourceId;
}
