package com.didichuxing.security.cardverify.model;

import java.io.Serializable;

public class CardVerifyInfo implements Serializable {
    public String currencyText;
    public String defaultText;
    public boolean isCurrencySuffix = false;
    public boolean isShowDecimal = true;
    public String pageContent;
}
