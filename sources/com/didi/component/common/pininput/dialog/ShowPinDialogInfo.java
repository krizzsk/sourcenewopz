package com.didi.component.common.pininput.dialog;

public class ShowPinDialogInfo {
    public static final int LAYOUT_CUSTOM = 2;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_WITH_CLOSE = 1;

    /* renamed from: a */
    int f11677a;

    /* renamed from: b */
    int f11678b;

    /* renamed from: c */
    private String f11679c;

    /* renamed from: d */
    private String f11680d;

    /* renamed from: e */
    private String f11681e;

    /* renamed from: f */
    private boolean f11682f;

    public ShowPinDialogInfo(int i) {
        this.f11677a = i;
    }

    public int getDialogId() {
        return this.f11677a;
    }

    public void setDialogId(int i) {
        this.f11677a = i;
    }

    public String getPin() {
        return this.f11679c;
    }

    public void setPin(String str) {
        this.f11679c = str;
    }

    public String getTitle() {
        return this.f11680d;
    }

    public void setTitle(String str) {
        this.f11680d = str;
    }

    public String getButton() {
        return this.f11681e;
    }

    public void setButton(String str) {
        this.f11681e = str;
    }

    public ShowPinDialogInfo setCancelable(boolean z) {
        this.f11682f = z;
        return this;
    }

    public boolean isCancelable() {
        return this.f11682f;
    }
}
