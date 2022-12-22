package com.didi.unifiedPay.component.widget.dialog;

public class OneImageInfo extends DialogInfo {
    public String imageUrl;
    public String negativeBtnText;
    public String positiveBtnText;

    public OneImageInfo(int i) {
        super(i);
    }

    public OneImageInfo setImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public OneImageInfo setPositiveBtnText(String str) {
        this.positiveBtnText = str;
        return this;
    }

    public OneImageInfo setNegativeBtnText(String str) {
        this.negativeBtnText = str;
        return this;
    }
}
