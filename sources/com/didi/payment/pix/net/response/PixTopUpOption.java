package com.didi.payment.pix.net.response;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixTopUpOption;", "Ljava/io/Serializable;", "()V", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "maxValue", "", "getMaxValue", "()Ljava/lang/Integer;", "setMaxValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "metadata", "getMetadata", "setMetadata", "minValue", "getMinValue", "setMinValue", "sku", "getSku", "setSku", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTopUpOption.kt */
public final class PixTopUpOption implements Serializable {
    private String currency;
    private Integer maxValue;
    private String metadata;
    private Integer minValue;
    private String sku;

    public final String getSku() {
        return this.sku;
    }

    public final void setSku(String str) {
        this.sku = str;
    }

    public final Integer getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(Integer num) {
        this.maxValue = num;
    }

    public final Integer getMinValue() {
        return this.minValue;
    }

    public final void setMinValue(Integer num) {
        this.minValue = num;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(String str) {
        this.metadata = str;
    }
}
