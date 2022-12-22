package com.didi.dqr.qrcode.detector;

public final class FinderPatternInfo {

    /* renamed from: a */
    private FinderPattern f19068a;

    /* renamed from: b */
    private FinderPattern f19069b;

    /* renamed from: c */
    private FinderPattern f19070c;

    /* renamed from: d */
    private FinderPattern[] f19071d;
    public boolean success;

    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.f19068a = finderPatternArr[0];
        this.f19069b = finderPatternArr[1];
        this.f19070c = finderPatternArr[2];
        this.f19071d = finderPatternArr;
        this.success = true;
    }

    public FinderPatternInfo(FinderPattern[] finderPatternArr, boolean z) {
        this.success = z;
        if (z) {
            this.f19068a = finderPatternArr[0];
            this.f19069b = finderPatternArr[1];
            this.f19070c = finderPatternArr[2];
            this.f19071d = finderPatternArr;
            return;
        }
        this.f19071d = finderPatternArr;
    }

    public FinderPattern getBottomLeft() {
        return this.f19068a;
    }

    public FinderPattern getTopLeft() {
        return this.f19069b;
    }

    public FinderPattern getTopRight() {
        return this.f19070c;
    }

    public FinderPattern[] getPatternCenters() {
        return this.f19071d;
    }
}
