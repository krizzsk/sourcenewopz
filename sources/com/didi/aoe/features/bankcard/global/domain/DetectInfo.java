package com.didi.aoe.features.bankcard.global.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000fHÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\r¨\u0006,"}, mo175978d2 = {"Lcom/didi/aoe/features/bankcard/global/domain/DetectInfo;", "", "label", "", "conf", "xmin", "ymin", "xmax", "ymax", "(FFFFFF)V", "getConf", "()F", "setConf", "(F)V", "<set-?>", "", "height", "getHeight", "()I", "getLabel", "setLabel", "width", "getWidth", "getXmax", "setXmax", "getXmin", "setXmin", "getYmax", "setYmax", "getYmin", "setYmin", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "global-ocr_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DetectInfo.kt */
public final class DetectInfo {
    private float conf;
    private int height;
    private float label;
    private int width;
    private float xmax;
    private float xmin;
    private float ymax;
    private float ymin;

    public DetectInfo() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, (DefaultConstructorMarker) null);
    }

    public DetectInfo(float f) {
        this(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 62, (DefaultConstructorMarker) null);
    }

    public DetectInfo(float f, float f2) {
        this(f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 60, (DefaultConstructorMarker) null);
    }

    public DetectInfo(float f, float f2, float f3) {
        this(f, f2, f3, 0.0f, 0.0f, 0.0f, 56, (DefaultConstructorMarker) null);
    }

    public DetectInfo(float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4, 0.0f, 0.0f, 48, (DefaultConstructorMarker) null);
    }

    public DetectInfo(float f, float f2, float f3, float f4, float f5) {
        this(f, f2, f3, f4, f5, 0.0f, 32, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DetectInfo copy$default(DetectInfo detectInfo, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = detectInfo.label;
        }
        if ((i & 2) != 0) {
            f2 = detectInfo.conf;
        }
        float f7 = f2;
        if ((i & 4) != 0) {
            f3 = detectInfo.xmin;
        }
        float f8 = f3;
        if ((i & 8) != 0) {
            f4 = detectInfo.ymin;
        }
        float f9 = f4;
        if ((i & 16) != 0) {
            f5 = detectInfo.xmax;
        }
        float f10 = f5;
        if ((i & 32) != 0) {
            f6 = detectInfo.ymax;
        }
        return detectInfo.copy(f, f7, f8, f9, f10, f6);
    }

    public final float component1() {
        return this.label;
    }

    public final float component2() {
        return this.conf;
    }

    public final float component3() {
        return this.xmin;
    }

    public final float component4() {
        return this.ymin;
    }

    public final float component5() {
        return this.xmax;
    }

    public final float component6() {
        return this.ymax;
    }

    public final DetectInfo copy(float f, float f2, float f3, float f4, float f5, float f6) {
        return new DetectInfo(f, f2, f3, f4, f5, f6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetectInfo)) {
            return false;
        }
        DetectInfo detectInfo = (DetectInfo) obj;
        return Float.compare(this.label, detectInfo.label) == 0 && Float.compare(this.conf, detectInfo.conf) == 0 && Float.compare(this.xmin, detectInfo.xmin) == 0 && Float.compare(this.ymin, detectInfo.ymin) == 0 && Float.compare(this.xmax, detectInfo.xmax) == 0 && Float.compare(this.ymax, detectInfo.ymax) == 0;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.label) * 31) + Float.floatToIntBits(this.conf)) * 31) + Float.floatToIntBits(this.xmin)) * 31) + Float.floatToIntBits(this.ymin)) * 31) + Float.floatToIntBits(this.xmax)) * 31) + Float.floatToIntBits(this.ymax);
    }

    public String toString() {
        return "DetectInfo(label=" + this.label + ", conf=" + this.conf + ", xmin=" + this.xmin + ", ymin=" + this.ymin + ", xmax=" + this.xmax + ", ymax=" + this.ymax + ")";
    }

    public DetectInfo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.label = f;
        this.conf = f2;
        this.xmin = f3;
        this.ymin = f4;
        this.xmax = f5;
        this.ymax = f6;
    }

    public final float getLabel() {
        return this.label;
    }

    public final void setLabel(float f) {
        this.label = f;
    }

    public final float getConf() {
        return this.conf;
    }

    public final void setConf(float f) {
        this.conf = f;
    }

    public final float getXmin() {
        return this.xmin;
    }

    public final void setXmin(float f) {
        this.xmin = f;
    }

    public final float getYmin() {
        return this.ymin;
    }

    public final void setYmin(float f) {
        this.ymin = f;
    }

    public final float getXmax() {
        return this.xmax;
    }

    public final void setXmax(float f) {
        this.xmax = f;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DetectInfo(float r6, float r7, float r8, float r9, float r10, float r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = 0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = 0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = 0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = 0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.features.bankcard.global.domain.DetectInfo.<init>(float, float, float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final float getYmax() {
        return this.ymax;
    }

    public final void setYmax(float f) {
        this.ymax = f;
    }

    public final int getWidth() {
        return ((int) this.xmax) - ((int) this.xmin);
    }

    public final int getHeight() {
        return ((int) this.ymax) - ((int) this.ymin);
    }
}
