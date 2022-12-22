package com.didi.map.base.bubble;

public class BlockBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f24578a;

    /* renamed from: b */
    private int f24579b = 0;
    public String thumbUrl;

    public BlockBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f24578a = str2;
    }

    public String getText() {
        return this.f24578a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f24578a + "|";
    }

    public int getBlockBubbleType() {
        return this.f24579b;
    }

    public void setBlockBubbleType(int i) {
        this.f24579b = i;
    }
}
