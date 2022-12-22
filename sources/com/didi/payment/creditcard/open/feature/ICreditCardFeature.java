package com.didi.payment.creditcard.open.feature;

import com.didi.payment.creditcard.open.feature.DidiAddCardData;

public interface ICreditCardFeature {
    void startCreditCardActivity(Object obj, DidiAddCardData.Param param, int i);
}
