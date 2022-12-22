package com.didi.payment.creditcard.global.model;

import java.io.Serializable;

public class GlobalCardVerifyInfo implements Serializable {
    public String cardIndex;
    public String currencyText;
    public String defaultText;
    public boolean isCurrencySuffix = false;
    public boolean isShowDecimal = true;
    public String pageContent;
    public String productId;
}
