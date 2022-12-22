package com.didi.component.payentrance.model;

public class JumpableItem implements Jumpable {

    /* renamed from: a */
    private int f14901a;

    /* renamed from: b */
    private CharSequence f14902b;

    /* renamed from: c */
    private int f14903c;

    public JumpableItem(int i, CharSequence charSequence) {
        this.f14901a = i;
        this.f14902b = charSequence;
    }

    public JumpableItem(int i, int i2) {
        this.f14901a = i;
        this.f14903c = i2;
    }

    public int getId() {
        return this.f14901a;
    }

    public CharSequence getText() {
        return this.f14902b;
    }

    public int getTextRes() {
        return this.f14903c;
    }
}
