package com.didi.payment.creditcard.base.binrule;

public interface ICardBinRule {
    int getCardOrg(String str);

    int getCardType(String str);

    boolean isValid(String str);
}
