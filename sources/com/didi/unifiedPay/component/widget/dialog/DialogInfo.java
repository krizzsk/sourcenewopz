package com.didi.unifiedPay.component.widget.dialog;

public abstract class DialogInfo {

    /* renamed from: a */
    int f44475a;

    /* renamed from: b */
    boolean f44476b;

    protected DialogInfo(int i) {
        this.f44475a = i;
    }

    public int getDialogId() {
        return this.f44475a;
    }

    public void setDialogId(int i) {
        this.f44475a = i;
    }

    public DialogInfo setCancelable(boolean z) {
        this.f44476b = z;
        return this;
    }
}
