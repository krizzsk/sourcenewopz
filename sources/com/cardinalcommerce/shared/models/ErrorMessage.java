package com.cardinalcommerce.shared.models;

public class ErrorMessage {

    /* renamed from: a */
    private String f3272a;

    /* renamed from: b */
    private String f3273b;

    /* renamed from: c */
    private String f3274c;

    /* renamed from: d */
    private String f3275d;

    public ErrorMessage(String str, String str2, String str3, String str4) {
        this.f3273b = str2;
        this.f3274c = str3;
        this.f3275d = str4;
        this.f3272a = str;
    }

    public ErrorMessage() {
    }

    public String getTransactionID() {
        return this.f3272a;
    }

    public String getErrorCode() {
        return this.f3273b;
    }

    public String getErrorDescription() {
        return this.f3274c;
    }

    public String getErrorDetails() {
        return this.f3275d;
    }
}
