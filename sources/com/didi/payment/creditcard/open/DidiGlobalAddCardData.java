package com.didi.payment.creditcard.open;

import java.io.Serializable;

public class DidiGlobalAddCardData {
    public static final int BIND_TYPE_DEFAULT = 0;
    public static final int BIND_TYPE_EBIKE = 13;
    public static final int BIND_TYPE_ESTIMATE = 8;
    public static final int BIND_TYPE_GUIDE = 5;
    public static final int BIND_TYPE_HIGH_RISK = 15;
    public static final int BIND_TYPE_SIDEBAR = 1;
    public static final int BIND_TYPE_TAKEAWAY = 14;
    public static final int BIND_TYPE_UNIFIED_PAY = 4;
    public static final String RESP_EXTRA_CARD_INDEX = "card_index";

    public static class AddCardParam implements Serializable {
        public String appId;
        public int bindType;
        public String cardIndex;
        public String cardNo;
        public String discountContent;
        public String extOmegaAttrs;
        public boolean isShowLoading = true;
        public boolean isSignAfterOrder;
        public String orderId;
        public String productId;
        public String productLine;
        public String resourceId;
    }
}
