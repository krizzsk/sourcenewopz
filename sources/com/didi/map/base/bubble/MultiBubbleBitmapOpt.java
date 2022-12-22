package com.didi.map.base.bubble;

public class MultiBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f24592a;

    /* renamed from: b */
    private boolean f24593b;

    /* renamed from: c */
    private boolean f24594c;

    public MultiBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f24592a = str2;
    }

    public String getText() {
        return this.f24592a;
    }

    public boolean isShowIcon() {
        return this.f24593b;
    }

    public void setShowIcon(boolean z) {
        this.f24593b = z;
    }

    public boolean is2Dfullbrowser() {
        return this.f24594c;
    }

    public void set2Dfullbrowser(boolean z) {
        this.f24594c = z;
    }

    public String getResourcePaths() {
        return super.toString() + this.f24592a + "|";
    }
}
