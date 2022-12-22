package com.didi.sdk.sidebar.history.model;

import android.text.TextUtils;
import java.io.Serializable;

public class HistoryOrderCountryModel implements Serializable {
    private String countryCode = "";
    private String countryName = "";
    private int invoiceType = 1;
    private String invoiceUrl = "";

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    public void setInvoiceUrl(String str) {
        this.invoiceUrl = str;
    }

    public int getInvoiceType() {
        return this.invoiceType;
    }

    public void setInvoiceType(int i) {
        this.invoiceType = i;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof HistoryOrderCountryModel)) {
            return TextUtils.equals(this.countryCode, ((HistoryOrderCountryModel) obj).countryCode);
        }
        return false;
    }
}
