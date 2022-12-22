package com.didi.beatles.p099im.views.bottombar;

/* renamed from: com.didi.beatles.im.views.bottombar.IMSkinElement */
public class IMSkinElement {

    /* renamed from: a */
    private int f10005a;

    /* renamed from: b */
    private int f10006b;

    /* renamed from: c */
    private int f10007c;

    /* renamed from: d */
    private int f10008d;

    /* renamed from: e */
    private String f10009e;

    public IMSkinElement(int i) {
        this.f10007c = i;
    }

    public IMSkinElement(String str) {
        this.f10009e = str;
    }

    public IMSkinElement(int i, int i2, int i3, String str) {
        this.f10005a = i;
        this.f10006b = i2;
        this.f10008d = i3;
        this.f10009e = str;
    }

    public int getSrcDrawable() {
        return this.f10007c;
    }

    public void setSrcDrawable(int i) {
        this.f10007c = i;
    }

    public int getBgColor() {
        return this.f10005a;
    }

    public void setBgColor(int i) {
        this.f10005a = i;
    }

    public int getBgDrawable() {
        return this.f10006b;
    }

    public void setBgDrawable(int i) {
        this.f10006b = i;
    }

    public int getTextColor() {
        return this.f10008d;
    }

    public void setTextColor(int i) {
        this.f10008d = i;
    }

    public String getText() {
        return this.f10009e;
    }

    public void setText(String str) {
        this.f10009e = str;
    }
}
