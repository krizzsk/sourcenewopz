package com.didi.hawaii.mapsdkv2.core;

public final class RouteName {
    public final int color;
    public final int endIndex;
    private final byte[] roadNameBytes;
    public final int startIndex;

    public RouteName(int i, int i2, int i3, byte[] bArr) {
        this.startIndex = i;
        this.endIndex = i2;
        this.color = i3;
        this.roadNameBytes = bArr;
    }

    public byte[] getRoadNameBytes() {
        return this.roadNameBytes;
    }
}
