package com.didi.dcrypto.model;

import java.io.Serializable;

public class BitcoinHistoryItemModel implements Serializable {
    public String client_order_id;
    public String created_at;
    public String instant_amount;
    public String instant_amount_executed;
    public String market_symbol;
    public String priceAve;
    public String quantity;
    public String quantity_executed;
    public String remark;
    public String side;

    /* renamed from: sn */
    public String f16482sn;
    public String state;
    public long timestamp;

    public BitcoinHistoryItemModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, long j) {
        this.f16482sn = str;
        this.client_order_id = str2;
        this.market_symbol = str3;
        this.side = str4;
        this.remark = str5;
        this.state = str6;
        this.priceAve = str7;
        this.quantity = str8;
        this.quantity_executed = str9;
        this.instant_amount = str10;
        this.instant_amount_executed = str11;
        this.created_at = str12;
        this.timestamp = j;
    }
}
