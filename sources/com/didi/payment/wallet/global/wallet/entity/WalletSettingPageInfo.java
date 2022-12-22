package com.didi.payment.wallet.global.wallet.entity;

import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletSettingPageInfo implements Serializable {
    public WalletPageQueryResp.AccountSectionItem accountSection;
    @SerializedName("freezeSection")
    public AccountFreezeData freezonData;
    public WalletPageQueryResp.PaymentMethodEntryItemBean paypalItem;
    public String serviceCenterUrl;
}
