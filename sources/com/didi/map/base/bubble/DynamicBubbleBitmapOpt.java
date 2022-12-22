package com.didi.map.base.bubble;

public class DynamicBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f24584a;

    /* renamed from: b */
    private boolean f24585b;

    /* renamed from: c */
    private boolean f24586c;

    public DynamicBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f24584a = str2;
    }

    public String getText() {
        return this.f24584a;
    }

    public boolean isShowIcon() {
        return this.f24585b;
    }

    public void setShowIcon(boolean z) {
        this.f24585b = z;
    }

    public boolean is2Dfullbrowser() {
        return this.f24586c;
    }

    public void set2Dfullbrowser(boolean z) {
        this.f24586c = z;
    }

    public String getResourcePaths() {
        return super.toString() + this.f24584a + "|";
    }
}
