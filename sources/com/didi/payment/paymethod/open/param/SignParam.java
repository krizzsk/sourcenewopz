package com.didi.payment.paymethod.open.param;

import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.feature.DidiAddCardData;
import com.didi.payment.paymethod.server.bean.SignInfo;
import java.io.Serializable;

public class SignParam implements Serializable {
    public String appId;
    public int bindType = 1;
    public int channelId;
    public int cmbParam = 0;
    public DidiAddCardData.Param creditCardParam;
    public SignInfo creditPayParam;
    public DidiGlobalAddCardData.AddCardParam globalCreditCardParam;
    public String returnUrl;
}
