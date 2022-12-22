package com.didi.payment.creditcard.open.feature;

import java.io.Serializable;

public class DidiAddCardData implements Serializable {
    public static final int BIND_TYPE_ESTIMATE = 8;
    public static final int BIND_TYPE_GUIDE = 5;
    public static final int BIND_TYPE_HIGH_RISK = 8;
    public static final int BIND_TYPE_SIDEBAR = 1;
    public static final int BIND_TYPE_UNIFIED_PAY = 4;
    public static final int DOMAIN_CHINA = 1;
    public static final int DOMAIN_DEFAULT = 0;
    public static final int DOMAIN_GLOBAL = 2;

    public static class Param implements Serializable {
        public int bindType = 5;
        public int channelId = 0;
        public int domain = 0;
        public boolean isNeedQueryResult = false;
        public boolean isSignAfterOrder = false;
        public String orderId = "";
        public String productLine = "";
    }
}
