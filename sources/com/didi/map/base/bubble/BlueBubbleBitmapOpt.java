package com.didi.map.base.bubble;

public class BlueBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f24581a;

    public BlueBubbleBitmapOpt(long j, String str, String str2) {
        super(str, j);
        this.f24581a = str2;
    }

    public String getText() {
        return this.f24581a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f24581a + "|";
    }
}
