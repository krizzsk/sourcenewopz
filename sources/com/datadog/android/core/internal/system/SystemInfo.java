package com.datadog.android.core.internal.system;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/datadog/android/core/internal/system/SystemInfo;", "", "batteryStatus", "Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "batteryLevel", "", "powerSaveMode", "", "(Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;IZ)V", "getBatteryLevel", "()I", "getBatteryStatus", "()Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "getPowerSaveMode", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "BatteryStatus", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SystemInfo.kt */
public final class SystemInfo {

    /* renamed from: a */
    private final BatteryStatus f3584a;

    /* renamed from: b */
    private final int f3585b;

    /* renamed from: c */
    private final boolean f3586c;

    public SystemInfo() {
        this((BatteryStatus) null, 0, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SystemInfo copy$default(SystemInfo systemInfo, BatteryStatus batteryStatus, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            batteryStatus = systemInfo.f3584a;
        }
        if ((i2 & 2) != 0) {
            i = systemInfo.f3585b;
        }
        if ((i2 & 4) != 0) {
            z = systemInfo.f3586c;
        }
        return systemInfo.copy(batteryStatus, i, z);
    }

    public final BatteryStatus component1() {
        return this.f3584a;
    }

    public final int component2() {
        return this.f3585b;
    }

    public final boolean component3() {
        return this.f3586c;
    }

    public final SystemInfo copy(BatteryStatus batteryStatus, int i, boolean z) {
        Intrinsics.checkNotNullParameter(batteryStatus, "batteryStatus");
        return new SystemInfo(batteryStatus, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemInfo)) {
            return false;
        }
        SystemInfo systemInfo = (SystemInfo) obj;
        return this.f3584a == systemInfo.f3584a && this.f3585b == systemInfo.f3585b && this.f3586c == systemInfo.f3586c;
    }

    public int hashCode() {
        int hashCode = ((this.f3584a.hashCode() * 31) + this.f3585b) * 31;
        boolean z = this.f3586c;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SystemInfo(batteryStatus=" + this.f3584a + ", batteryLevel=" + this.f3585b + ", powerSaveMode=" + this.f3586c + VersionRange.RIGHT_OPEN;
    }

    public SystemInfo(BatteryStatus batteryStatus, int i, boolean z) {
        Intrinsics.checkNotNullParameter(batteryStatus, "batteryStatus");
        this.f3584a = batteryStatus;
        this.f3585b = i;
        this.f3586c = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SystemInfo(BatteryStatus batteryStatus, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? BatteryStatus.UNKNOWN : batteryStatus, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? false : z);
    }

    public final BatteryStatus getBatteryStatus() {
        return this.f3584a;
    }

    public final int getBatteryLevel() {
        return this.f3585b;
    }

    public final boolean getPowerSaveMode() {
        return this.f3586c;
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "CHARGING", "DISCHARGING", "NOT_CHARGING", "FULL", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SystemInfo.kt */
    public enum BatteryStatus {
        UNKNOWN,
        CHARGING,
        DISCHARGING,
        NOT_CHARGING,
        FULL;
        
        public static final Companion Companion = null;

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus$Companion;", "", "()V", "fromAndroidStatus", "Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "status", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: SystemInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BatteryStatus fromAndroidStatus(int i) {
                if (i == 2) {
                    return BatteryStatus.CHARGING;
                }
                if (i == 3) {
                    return BatteryStatus.DISCHARGING;
                }
                if (i == 4) {
                    return BatteryStatus.NOT_CHARGING;
                }
                if (i != 5) {
                    return BatteryStatus.UNKNOWN;
                }
                return BatteryStatus.FULL;
            }
        }
    }
}
