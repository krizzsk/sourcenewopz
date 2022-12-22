package com.didi.universal.pay.sdk.model;

import java.io.Serializable;

public class UniversalPayParams implements Serializable {
    public static final int DOMAIN_CHINA = 1;
    public static final int DOMAIN_GLOBAL = 2;
    public static final int TERMINAL_CHINA = 1;
    public static final int TERMINAL_GLOBAL = 7;
    public int bid;
    public String bizContent;
    public int domain = 1;
    public boolean isOnline = true;
    public boolean isPrepay = false;
    public boolean isTrip = false;
    public String mOfflineURL;
    public String oid;
    public String outToken;
    public String outTradeId;
    public String sid;
    public String sign;
    public String signType;
    public int terminalId = 7;
    public String wxAppid;

    public String toString() {
        return "UniversalPayParams{isTrip=" + this.isTrip + ", domain=" + this.domain + ", terminalId=" + this.terminalId + ", oid='" + this.oid + '\'' + ", sid='" + this.sid + '\'' + ", bid=" + this.bid + ", outTradeId='" + this.outTradeId + '\'' + ", sign='" + this.sign + '\'' + ", signType='" + this.signType + '\'' + ", bizContent='" + this.bizContent + '\'' + ", outToken='" + this.outToken + '\'' + ", wxAppid='" + this.wxAppid + '\'' + ", isOnline=" + this.isOnline + ", mOfflineURL='" + this.mOfflineURL + '\'' + '}';
    }
}
