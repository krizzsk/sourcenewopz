package com.didi.payment.creditcard.global.model;

import com.didi.sdk.util.TextUtil;
import java.io.Serializable;

public class SignCardParam implements Serializable {
    private static final String VENDOR_AYDEN = "adyen";
    public static final String VENDOR_OTHER = "new";
    public String apolloName = "";
    public String appId;
    public int bindType = 1;
    public String blackCardApolloName = "";
    public String cardIndex;
    public String cardNo = "";
    public String didi_icon;
    public String discountContent;
    public String extOmegaAttrs;
    public boolean isSignAfterOrder = false;
    public boolean isSupportOcr = false;
    public boolean isSupportOcrVerify = false;
    public String noticeMsg = "";
    public String orderId = "";
    public String productId;
    public String productLine = "";
    public String resourceId;
    public String retainTips;
    public String successTips;
    public String successUrl;
    public String vendorType = "new";

    public boolean isAydenVendor() {
        String str = this.vendorType;
        return str != null && !TextUtil.isEmpty(str) && this.vendorType.equals(VENDOR_AYDEN);
    }

    public boolean isUpdateCard() {
        return !TextUtil.isEmpty(this.cardNo);
    }
}
