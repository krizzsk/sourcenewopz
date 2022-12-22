package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.item;

@Deprecated
public abstract class BaseGroup {

    /* renamed from: a */
    private String f31932a;

    /* access modifiers changed from: protected */
    public abstract void generateGroup();

    public String getGroup() {
        if (this.f31932a == null) {
            generateGroup();
        }
        return this.f31932a;
    }

    public void setGroup(String str) {
        this.f31932a = str;
    }
}
