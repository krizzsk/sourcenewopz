package com.didi.dcrypto.model;

public class AccountInfoMulticoinBalance {

    /* renamed from: a */
    private String f16470a;

    /* renamed from: b */
    private String f16471b;

    /* renamed from: c */
    private String f16472c;

    /* renamed from: d */
    private String f16473d;

    /* renamed from: e */
    private String f16474e;

    /* renamed from: f */
    private String f16475f;

    /* renamed from: g */
    private String f16476g;

    /* renamed from: h */
    private String f16477h;

    /* renamed from: i */
    private String f16478i;

    /* renamed from: j */
    private int f16479j;

    /* renamed from: k */
    private String f16480k;

    /* renamed from: l */
    private String f16481l;

    public AccountInfoMulticoinBalance(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11) {
        this.f16470a = str;
        this.f16471b = str2;
        this.f16472c = str3;
        this.f16473d = str4;
        this.f16474e = str5;
        this.f16475f = str6;
        this.f16476g = str7;
        this.f16477h = str8;
        this.f16478i = str9;
        this.f16479j = i;
        this.f16480k = str10;
        this.f16481l = str11;
    }

    public String getBalance() {
        return this.f16470a;
    }

    public void setBalance(String str) {
        this.f16470a = str;
    }

    public String getCurrency_symbol() {
        return this.f16471b;
    }

    public void setCurrency_symbol(String str) {
        this.f16471b = str;
    }

    public String getBalance_available() {
        return this.f16472c;
    }

    public void setBalance_available(String str) {
        this.f16472c = str;
    }

    public String getBalance_locked() {
        return this.f16473d;
    }

    public void setBalance_locked(String str) {
        this.f16473d = str;
    }

    public String getAmount_brl() {
        return this.f16474e;
    }

    public void setAmount_brl(String str) {
        this.f16474e = str;
    }

    public String getPrice_ask() {
        return this.f16475f;
    }

    public void setPrice_ask(String str) {
        this.f16475f = str;
    }

    public String getPrice_bid() {
        return this.f16476g;
    }

    public void setPrice_bid(String str) {
        this.f16476g = str;
    }

    public String getMidnight_price() {
        return this.f16477h;
    }

    public void setMidnight_price(String str) {
        this.f16477h = str;
    }

    public String getDaily_profit_loss() {
        return this.f16478i;
    }

    public void setDaily_profit_loss(String str) {
        this.f16478i = str;
    }

    public int getHas_transaction() {
        return this.f16479j;
    }

    public void setHas_transaction(int i) {
        this.f16479j = i;
    }

    public String getIcon_url() {
        return this.f16480k;
    }

    public void setIcon_url(String str) {
        this.f16480k = str;
    }

    public String getCrypto_title() {
        return this.f16481l;
    }

    public void setCrypto_title(String str) {
        this.f16481l = str;
    }
}
