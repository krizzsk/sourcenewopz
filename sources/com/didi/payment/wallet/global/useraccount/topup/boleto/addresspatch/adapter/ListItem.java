package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter;

import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.item.BaseGroup;
import rui.config.RConfigConstants;

public class ListItem extends BaseGroup {

    /* renamed from: a */
    private String f31854a;

    /* renamed from: b */
    private String f31855b;

    /* renamed from: c */
    private String f31856c;

    public String getDisplayContent() {
        return this.f31855b;
    }

    public String getStateOrCity() {
        return this.f31854a;
    }

    public String getStateCode() {
        return this.f31856c;
    }

    public ListItem(String str, String str2, String str3) {
        this.f31854a = str;
        this.f31855b = str2;
        this.f31856c = str3;
    }

    /* access modifiers changed from: protected */
    public void generateGroup() {
        char c = this.f31855b.toCharArray()[0];
        if (String.valueOf(c).matches("[A-Za-z]")) {
            setGroup(String.valueOf(c).toUpperCase());
        } else {
            setGroup(RConfigConstants.KEYWORD_COLOR_SIGN);
        }
    }
}
