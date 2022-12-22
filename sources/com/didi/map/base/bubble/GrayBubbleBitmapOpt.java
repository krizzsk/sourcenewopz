package com.didi.map.base.bubble;

public class GrayBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f24588a;

    public GrayBubbleBitmapOpt(long j, String str, String str2) {
        super(str, j);
        this.f24588a = str2;
    }

    public String getText() {
        return this.f24588a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f24588a + "|";
    }
}
