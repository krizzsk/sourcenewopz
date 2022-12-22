package com.didi.sdk.sidebar.account.model;

import java.io.Serializable;

public class Trade implements Serializable {
    public String tradeDesc;
    public String tradeId;

    public Trade(String str, String str2) {
        this.tradeId = str;
        this.tradeDesc = str2;
    }
}
