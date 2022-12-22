package com.datadog.android.rum.internal.vitals;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "", "sampleCount", "", "minValue", "", "maxValue", "meanValue", "(IDDD)V", "getMaxValue", "()D", "getMeanValue", "getMinValue", "getSampleCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VitalInfo.kt */
public final class VitalInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final VitalInfo f3913e = new VitalInfo(0, Double.MAX_VALUE, -1.7976931348623157E308d, 0.0d);

    /* renamed from: a */
    private final int f3914a;

    /* renamed from: b */
    private final double f3915b;

    /* renamed from: c */
    private final double f3916c;

    /* renamed from: d */
    private final double f3917d;

    public static /* synthetic */ VitalInfo copy$default(VitalInfo vitalInfo, int i, double d, double d2, double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vitalInfo.f3914a;
        }
        if ((i2 & 2) != 0) {
            d = vitalInfo.f3915b;
        }
        double d4 = d;
        if ((i2 & 4) != 0) {
            d2 = vitalInfo.f3916c;
        }
        double d5 = d2;
        if ((i2 & 8) != 0) {
            d3 = vitalInfo.f3917d;
        }
        return vitalInfo.copy(i, d4, d5, d3);
    }

    public final int component1() {
        return this.f3914a;
    }

    public final double component2() {
        return this.f3915b;
    }

    public final double component3() {
        return this.f3916c;
    }

    public final double component4() {
        return this.f3917d;
    }

    public final VitalInfo copy(int i, double d, double d2, double d3) {
        return new VitalInfo(i, d, d2, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VitalInfo)) {
            return false;
        }
        VitalInfo vitalInfo = (VitalInfo) obj;
        return this.f3914a == vitalInfo.f3914a && Intrinsics.areEqual((Object) Double.valueOf(this.f3915b), (Object) Double.valueOf(vitalInfo.f3915b)) && Intrinsics.areEqual((Object) Double.valueOf(this.f3916c), (Object) Double.valueOf(vitalInfo.f3916c)) && Intrinsics.areEqual((Object) Double.valueOf(this.f3917d), (Object) Double.valueOf(vitalInfo.f3917d));
    }

    public int hashCode() {
        return (((((this.f3914a * 31) + Double.doubleToLongBits(this.f3915b)) * 31) + Double.doubleToLongBits(this.f3916c)) * 31) + Double.doubleToLongBits(this.f3917d);
    }

    public String toString() {
        return "VitalInfo(sampleCount=" + this.f3914a + ", minValue=" + this.f3915b + ", maxValue=" + this.f3916c + ", meanValue=" + this.f3917d + VersionRange.RIGHT_OPEN;
    }

    public VitalInfo(int i, double d, double d2, double d3) {
        this.f3914a = i;
        this.f3915b = d;
        this.f3916c = d2;
        this.f3917d = d3;
    }

    public final int getSampleCount() {
        return this.f3914a;
    }

    public final double getMinValue() {
        return this.f3915b;
    }

    public final double getMaxValue() {
        return this.f3916c;
    }

    public final double getMeanValue() {
        return this.f3917d;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalInfo$Companion;", "", "()V", "EMPTY", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "getEMPTY", "()Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: VitalInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VitalInfo getEMPTY() {
            return VitalInfo.f3913e;
        }
    }
}
