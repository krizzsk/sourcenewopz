package com.didi.map.base.bubble;

public class IllegalParkBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f24590a;

    public IllegalParkBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f24590a = str2;
    }

    public String getText() {
        return this.f24590a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f24590a + "|";
    }
}
