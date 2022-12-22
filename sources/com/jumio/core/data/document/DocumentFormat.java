package com.jumio.core.data.document;

public enum DocumentFormat {
    NONE(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d),
    ID1(0.136d, 0.136d, 0.0675d, 0.0675d, 1.585185185185185d, 0.24000000000000002d, 0.09546296296296297d),
    ID2(0.0936d, 0.0936d, 0.0675d, 0.0675d, 1.4189189189189189d, 0.17162162162162162d, 0.08412162162162162d),
    ID3(0.022d, 0.022d, 0.022d, 0.022d, 1.4119318181818181d, 0.2353181818181818d, 0.0d);
    

    /* renamed from: a */
    public final double f54673a;

    /* renamed from: b */
    public final double f54674b;

    /* renamed from: c */
    public final double f54675c;

    /* renamed from: d */
    public final double f54676d;

    /* renamed from: e */
    public final double f54677e;

    /* renamed from: f */
    public final double f54678f;

    /* renamed from: g */
    public final double f54679g;

    /* access modifiers changed from: public */
    DocumentFormat(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        this.f54673a = d;
        this.f54674b = d2;
        this.f54675c = d3;
        this.f54676d = d4;
        this.f54677e = d5;
        this.f54678f = d6;
        this.f54679g = d7;
    }

    public double getMarginBottom() {
        return this.f54679g;
    }

    public double getOverlayBottom() {
        return this.f54674b;
    }

    public int getOverlayBottomInPx(int i) {
        return (int) (((double) i) * this.f54674b);
    }

    public double getOverlayLeft() {
        return this.f54675c;
    }

    public int getOverlayLeftInPx(int i) {
        return (int) (((double) i) * this.f54675c);
    }

    public double getOverlayRatio() {
        return this.f54677e;
    }

    public double getOverlayRight() {
        return this.f54676d;
    }

    public int getOverlayRightInPx(int i) {
        return (int) (((double) i) * this.f54676d);
    }

    public double getOverlayTop() {
        return this.f54673a;
    }

    public int getOverlayTopInPx(int i) {
        return (int) (((double) i) * this.f54673a);
    }

    public double getRoiHeight() {
        return this.f54678f;
    }

    public int getRoiHeightInPx(int i) {
        return (int) (((double) (i - (getOverlayTopInPx(i) * 2))) * this.f54678f);
    }

    public int getRoiMarginBottomPx(int i) {
        return (int) (((double) (i - (getOverlayTopInPx(i) * 2))) * this.f54679g);
    }
}
